/**
 * <copyright>
 *
 * Copyright (c) 2009, 2010 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: ORMNamingStrategy.java,v 1.9 2011/08/26 05:34:12 mtaal Exp $
 */

package org.eclipse.emf.texo.orm.annotator;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.impl.ExtensibleURIConverterImpl;
import org.eclipse.emf.texo.generator.GeneratorUtils;
import org.eclipse.emf.texo.orm.ormannotations.EPackageORMAnnotation;

/**
 * The default naming strategy for entity and database schema naming.
 * 
 * @author <a href="mtaal@elver.org">Martin Taal</a>
 */
public class ORMNamingStrategy {

  private static String[] removables = new String[] { "u", "o", "a", "e", "i" }; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$

  private EPackageORMAnnotation ePackageORMAnnotation = null;
  private Properties nameDictionary = null;

  /**
   * @return true if the orm generation should fill in table and column names
   */
  public boolean isGenerateAllDBSchemaNames() {
    return getePackageORMAnnotation().isGenerateFullDbSchemaNames();
  }

  /**
   * Create a (unique) entity name for an eclass.
   * 
   * @param eClass
   *          the eClass for which to generate a unique name
   * @return as a default the eClass name is returned, possibly prefixed with the EPackage name space prefix
   * @see EPackageORMAnnotation#isEnforceUniqueNames()
   * @see EPackage#getNsPrefix()
   */
  public String getEntityName(EClass eClass) {
    return getUniqueMakingPrefix(eClass) + eClass.getName();
  }

  /**
   * Computes the join column name for a subclass table to its parent table. As a default the name parent_id is used.
   * 
   * @param eClass
   *          the EClass for which to generate the join column name.
   * @return the name of the join column
   * @see EPackageORMAnnotation#getColumnNamePrefix()
   */
  public String getPrimaryKeyJoinColumn(EClass eClass) {
    String localName = getDictionariedName(eClass, "parent"); //$NON-NLS-1$
    if (localName == null) {
      localName = "parent_id"; //$NON-NLS-1$
    }
    return processName(localName, ePackageORMAnnotation.getColumnNamePrefix());
  }

  /**
   * Computes the table name for the table which stores this EClass.
   * 
   * @param eClass
   * @return as a default the entity name is returned.
   * @see #getEntityName(EClass)
   */
  public String getTableName(EClass eClass) {
    String localName = getDictionariedName(eClass, null);
    if (localName == null) {
      localName = getEntityName(eClass);
    }
    return processName(localName, ePackageORMAnnotation.getTableNamePrefix());
  }

  /**
   * Computes the name of the element column in a collection element table.
   * 
   * @param eFeature
   *          the EStructuralFeature which has a collection table
   * @return the name of the element column, as a default the term 'element' is returned.
   * @see EPackageORMAnnotation#getColumnNamePrefix()
   */
  public String getCollectionElementColumnName(EStructuralFeature eFeature) {
    String localName = getDictionariedName(eFeature, "element"); //$NON-NLS-1$
    if (localName == null) {
      localName = "element"; //$NON-NLS-1$
    }
    return processName(localName, ePackageORMAnnotation.getColumnNamePrefix());
  }

  /**
   * Returns the name of the index or order column used in join tables to model lists and maps.
   * 
   * @param eFeature
   *          the EStructuralFeature which contains the name
   * @return the name of the index/order column, possibly prefixed with the column name prefix
   * @see EPackageORMAnnotation#getColumnNamePrefix()
   */
  public String getIndexColumnName(EStructuralFeature eFeature) {
    String localName = getDictionariedName(eFeature, "index"); //$NON-NLS-1$
    if (localName == null) {
      localName = "ind"; //$NON-NLS-1$
    }
    return processName(localName, ePackageORMAnnotation.getColumnNamePrefix());
  }

  /**
   * Computes the name of the join table used to model the EStructuralFeature in the relational db.
   * 
   * @param eFeature
   * @return the concatenation of the entity name and the EStructuralFeature's name
   * @see EPackageORMAnnotation#getTableNamePrefix()
   */
  public String getJoinTableName(EStructuralFeature eFeature) {
    String localName = getDictionariedName(eFeature, "joinTable"); //$NON-NLS-1$
    if (localName == null) {
      localName = getEntityName(eFeature.getEContainingClass()) + "_" + eFeature.getName(); //$NON-NLS-1$
    }
    return processName(localName, ePackageORMAnnotation.getTableNamePrefix());
  }

  /**
   * Used to compute the join column of a many-to-one association.
   * 
   * @param eFeature
   *          the many-to-one association
   * @return the column name of the foreign key column
   * @see EPackageORMAnnotation#getColumnNamePrefix()
   */
  public String getForeignKeyColumnName(EStructuralFeature eFeature) {
    String localName = getDictionariedName(eFeature, "foreignKeyColumn"); //$NON-NLS-1$
    if (localName == null) {
      localName = eFeature.getName();
    }
    return processName(localName, ePackageORMAnnotation.getColumnNamePrefix());
  }

  /**
   * Used to compute the join column name in a join table. The join column points to the owning entity of the
   * association.
   * 
   * @param eFeature
   *          the EStructuralFeature which models the one-to-many or many-to-many association
   * @return the column name
   * @see EPackageORMAnnotation#getColumnNamePrefix()
   */
  public String getJoinColumnName(EStructuralFeature eFeature) {
    String localName = getDictionariedName(eFeature, "joinColumn"); //$NON-NLS-1$
    if (localName == null) {
      localName = getEntityName(eFeature.getEContainingClass()) + "_id"; //$NON-NLS-1$
    }
    return processName(localName, ePackageORMAnnotation.getColumnNamePrefix());
  }

  /**
   * Used to compute the inverse join column name in a join table. The inverse join column points to the non-owning
   * entity of the association.
   * 
   * @param eReference
   *          the EReference which models the one-to-many or many-to-many association
   * @return the column name
   * @see EPackageORMAnnotation#getColumnNamePrefix()
   */
  public String getInverseJoinColumnName(EReference eReference) {
    String localName = getDictionariedName(eReference, "inverseJoinColumn"); //$NON-NLS-1$
    if (localName == null) {
      localName = getEntityName(eReference.getEReferenceType()) + "_id"; //$NON-NLS-1$
    }
    return processName(localName, ePackageORMAnnotation.getColumnNamePrefix());
  }

  /**
   * @param eAttribute
   * @return the entity name of the feature map mapping.
   */
  public String getFeatureMapEntityName(EAttribute eAttribute) {
    return getUniqueMakingPrefix(eAttribute.getEContainingClass()) + eAttribute.getEContainingClass().getName()
        + "_" + eAttribute.getName(); //$NON-NLS-1$
  }

  /**
   * Compute the column name for a standard primitive type column.
   * 
   * @param eFeature
   * @return the column name of the basic column
   * @see EPackageORMAnnotation#getColumnNamePrefix()
   */
  public String getColumnName(EStructuralFeature eFeature) {
    String localName = getDictionariedName(eFeature, null);
    if (localName == null) {
      localName = eFeature.getName();
    }
    return processName(localName, ePackageORMAnnotation.getColumnNamePrefix());
  }

  private String getUniqueMakingPrefix(EClass eClass) {
    if (ePackageORMAnnotation.isEnforceUniqueNames()) {
      return eClass.getEPackage().getNsPrefix() + "_"; //$NON-NLS-1$
    }
    return ""; //$NON-NLS-1$
  }

  public EPackageORMAnnotation getePackageORMAnnotation() {
    return ePackageORMAnnotation;
  }

  public void setePackageORMAnnotation(EPackageORMAnnotation ePackageORMAnnotation) {
    this.ePackageORMAnnotation = ePackageORMAnnotation;
  }

  private String getSafePrefixStr(String value) {
    if (value == null) {
      return ""; //$NON-NLS-1$
    }
    return value;
  }

  protected String getDictionariedName(ENamedElement eNamedElement, String qualifier) {
    final String dictionaryName = getNameDictionary().getProperty(getPropertyName(eNamedElement, qualifier));
    if (GeneratorUtils.isNotEmptyAndNotNull(dictionaryName)) {
      return dictionaryName;
    }
    return null;
  }

  private Properties getNameDictionary() {
    if (nameDictionary != null) {
      return nameDictionary;
    }
    nameDictionary = new Properties();
    if (GeneratorUtils.isNotEmptyAndNotNull(getePackageORMAnnotation().getNameDictionaryPropertyFile())
        && getePackageORMAnnotation().getNameDictionaryPropertyFile().trim().length() > 0) {
      URI uri = getePackageORMAnnotation().getEPackage().eResource().getURI();
      uri = uri.trimSegments(1);
      uri = uri.appendSegment(getePackageORMAnnotation().getNameDictionaryPropertyFile());
      try {
        final InputStream is = new ExtensibleURIConverterImpl().createInputStream(uri);
        if (is != null) {
          nameDictionary.load(is);
          is.close();
        }
      } catch (IOException e) {
        // just ignore
        System.err.println(e);
        ;
      }
    }
    return nameDictionary;
  }

  protected String getPropertyName(ENamedElement eNamedElement, String qualifier) {
    String searchName = eNamedElement.getName();
    if (eNamedElement instanceof EStructuralFeature) {
      searchName = ((EStructuralFeature) eNamedElement).getEContainingClass().getName() + "." + searchName; //$NON-NLS-1$
    }
    if (GeneratorUtils.isNotEmptyAndNotNull(qualifier)) {
      searchName += "." + qualifier; //$NON-NLS-1$
    }
    if (GeneratorUtils.isNotEmptyAndNotNull(searchName)) {
      if (searchName.length() == 1) {
        return searchName.toLowerCase();
      }
      return searchName.substring(0, 1).toLowerCase() + searchName.substring(1);
    }
    return searchName;
  }

  protected String processName(String name, String prefix) {
    String localPrefix = getSafePrefixStr(prefix);
    String localName = name;
    if (getePackageORMAnnotation().isLowerCasedNames()) {
      localName = localName.toLowerCase();
      localPrefix = localPrefix.toLowerCase();
    } else if (getePackageORMAnnotation().isUpperCasedNames()) {
      localName = localName.toUpperCase();
      localPrefix = localPrefix.toUpperCase();
    }
    final int maxSqlLength = getePackageORMAnnotation().getMaximumSqlNameLength();
    if (localName.length() > maxSqlLength - localPrefix.length()) {
      localName = trunc(localName, maxSqlLength - localPrefix.length());
    }
    return localPrefix + localName;
  }

  protected String trunc(String name, int targetLength) {
    String correctedName = name;
    // now do vowel truncation preserving the first character
    char correctedNameFirstChar = correctedName.charAt(0);
    String correctedNameTail = correctedName.substring(1);
    for (String vowel : getRemovableCharacters()) {
      while (correctedNameTail.indexOf(vowel) != -1 || correctedNameTail.indexOf(vowel.toUpperCase()) != -1) {
        if (correctedNameTail.indexOf(vowel) != -1) {
          correctedNameTail = correctedNameTail.replaceFirst(vowel, ""); //$NON-NLS-1$
        } else {
          correctedNameTail = correctedNameTail.replaceFirst(vowel.toUpperCase(), ""); //$NON-NLS-1$
        }
        correctedNameTail = correctedNameTail.replaceAll("__", "_"); //$NON-NLS-1$ //$NON-NLS-2$
        if (correctedNameTail.length() + 1 <= targetLength) {
          return correctedNameFirstChar + correctedNameTail;
        }
      }
    }

    // still failed do length truncation
    return doLengthTruncation(correctedNameFirstChar + correctedNameTail, targetLength);
  }

  protected String doLengthTruncation(String correctedName, int targetLength) {
    // failed do length truncation with the remainder
    final int underscore = correctedName.lastIndexOf('_');
    if (underscore == -1) {
      return correctedName.substring(0, targetLength);
    }

    // now do the complex logic to truncate different parts
    final String[] parts = correctedName.split("_"); //$NON-NLS-1$
    int maxLength = -1;
    for (String part : parts) {
      if (part.length() > maxLength && part.length() > 0) {
        maxLength = part.length();
      }
    }

    // can this ever happen
    int totalLength = correctedName.length();
    while (maxLength > 1 && totalLength > targetLength) {
      totalLength = 0;
      int newMax = 0;
      for (int i = 0; i < parts.length; i++) {
        if (parts[i].length() == maxLength) {
          parts[i] = parts[i].substring(0, maxLength - 1);
        }
        if (parts[i].length() > newMax) {
          newMax = parts[i].length();
        }
        totalLength += parts[i].length();
      }
      totalLength += parts.length - 1; // count the underscores
      maxLength = newMax;
    }

    final StringBuffer result = new StringBuffer();
    for (String part : parts) {
      if (result.length() > 0) {
        result.append("_"); //$NON-NLS-1$
      }
      result.append(part);
    }

    return result.toString();
  }

  /**
   * Return the characters to remove, the character removal is done in order of the returned array. This method is
   * provided to be overridden to pass a custom set of removable characters.
   */
  protected String[] getRemovableCharacters() {
    return removables;
  }
}