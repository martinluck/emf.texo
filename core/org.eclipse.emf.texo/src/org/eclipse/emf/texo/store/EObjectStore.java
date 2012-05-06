/**
 * <copyright>
 *
 * Copyright (c) 2012 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal - Initial API and implementation
 * </copyright>
 *
 * $Id: DaoRegistry.java,v 1.1 2011/09/24 04:00:25 mtaal Exp $
 */
package org.eclipse.emf.texo.store;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.texo.model.ModelConstants;
import org.eclipse.emf.texo.provider.IdProvider;
import org.eclipse.emf.texo.utils.ModelUtils;

/**
 * Implements query and persistence methods for usage on the RCP client side and within {@link TexoResource} instances.
 * One {@link EObjectStore} maybe used by several texo resources.
 * 
 * @author <a href="mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.1 $
 */
public abstract class EObjectStore {

  private URI uri;

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.emf.texo.store.EObjectStore#getFromQualifiedIdString(java.lang.String)
   */
  public EObject getFromQualifiedIdString(String qualifiedIdString) {
    final int separatorIndex = qualifiedIdString.indexOf(ModelConstants.FRAGMENTSEPARATOR);
    if (separatorIndex == -1) {
      throw new IllegalArgumentException("Fragment format not supported for fragment: " + qualifiedIdString); //$NON-NLS-1$
    }

    final EClass eClass = ModelUtils.getEClassFromQualifiedName(qualifiedIdString.substring(0, separatorIndex));
    final String idString = qualifiedIdString.substring(separatorIndex + ModelConstants.FRAGMENTSEPARATOR_LENGTH);
    final EObject eObject = loadEObject(eClass, idString);
    if (eObject == null) {
      return null;
    }
    // not a proxy anymore
    ((InternalEObject) eObject).eSetProxyURI(null);
    return eObject;
  }

  /**
   * Load the eobject from the underlying store using the id string.
   */
  protected abstract EObject loadEObject(EClass eClass, String idString);

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.emf.texo.store.EObjectStore#getQualifiedIdString(org.eclipse.emf.ecore.EObject)
   */
  public String getQualifiedIdString(EObject eObject) {
    final EAttribute eAttribute = IdProvider.getInstance().getIdEAttribute(eObject.eClass());
    if (eObject.eGet(eAttribute) != null) {
      final EDataType eDataType = eAttribute.getEAttributeType();
      final String idString = eDataType.getEPackage().getEFactoryInstance()
          .convertToString(eDataType, eObject.eGet(eAttribute));

      final String result = ModelUtils.getQualifiedNameFromEClass(eObject.eClass()) + ModelConstants.FRAGMENTSEPARATOR
          + idString;
      return result;
    }
    return null;
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.emf.texo.store.EObjectStore#persist(java.util.List, java.util.List)
   */
  public abstract void persist(List<EObject> toInsertUpdate, List<EObject> toDelete);

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.emf.texo.store.EObjectStore#query(java.lang.String, java.util.Map, int, int)
   */
  public abstract List<EObject> query(String qryStr, Map<String, Object> namedParameters, int firstResult,
      int maxResults);

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.emf.texo.store.EObjectStore#refresh(org.eclipse.emf.ecore.EObject)
   */
  public abstract void refresh(EObject eObject);

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.emf.texo.store.EObjectStore#getReferingObjects(T, int, boolean)
   */
  public abstract List<EObject> getReferingObjects(EObject target, int maxResult, boolean includeContainmentReferences);

  /**
   * Should be called when an object gets deleted.
   */
  protected void deleted(EObject deletedEObject) {
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.eclipse.emf.texo.store.EObjectStore#close()
   */
  public void close() {
  }

  public URI getUri() {
    if (uri == null) {
      uri = URI.createURI("jpa://org.eclipse.emf.texo/"); //$NON-NLS-1$
    }
    return uri;
  }

  public void setUri(URI uri) {
    this.uri = uri;
  }
}
