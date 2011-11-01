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
 * $Id: ORMGenerator.java,v 1.14 2011/10/25 22:49:04 mtaal Exp $
 */

package org.eclipse.emf.texo.orm.annotator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.texo.annotations.annotationsmodel.AnnotatedEClass;
import org.eclipse.emf.texo.annotations.annotationsmodel.AnnotatedEClassifier;
import org.eclipse.emf.texo.annotations.annotationsmodel.AnnotatedEPackage;
import org.eclipse.emf.texo.annotations.annotationsmodel.AnnotatedModel;
import org.eclipse.emf.texo.annotations.annotationsmodel.AnnotationsmodelFactory;
import org.eclipse.emf.texo.annotations.annotationsmodel.EClassAnnotation;
import org.eclipse.emf.texo.eclipse.popup.actions.BaseGenerateAction;
import org.eclipse.emf.texo.generator.AnnotationManager;
import org.eclipse.emf.texo.generator.GeneratorUtils;
import org.eclipse.emf.texo.generator.ModelAnnotatorRegistry;
import org.eclipse.emf.texo.generator.ModelController;
import org.eclipse.emf.texo.modelgenerator.modelannotations.EAttributeModelGenAnnotation;
import org.eclipse.emf.texo.modelgenerator.modelannotations.EReferenceModelGenAnnotation;
import org.eclipse.emf.texo.modelgenerator.modelannotations.EStructuralFeatureModelGenAnnotation;
import org.eclipse.emf.texo.modelgenerator.modelannotations.ModelcodegeneratorPackage;
import org.eclipse.emf.texo.orm.annotations.model.orm.AccessType;
import org.eclipse.emf.texo.orm.annotations.model.orm.Attributes;
import org.eclipse.emf.texo.orm.annotations.model.orm.DocumentRoot;
import org.eclipse.emf.texo.orm.annotations.model.orm.Entity;
import org.eclipse.emf.texo.orm.annotations.model.orm.EntityMappingsType;
import org.eclipse.emf.texo.orm.annotations.model.orm.OrmFactory;
import org.eclipse.emf.texo.orm.annotations.model.orm.OrmPackage;
import org.eclipse.emf.texo.orm.annotations.model.orm.Transient;
import org.eclipse.emf.texo.orm.annotations.model.orm.util.OrmResourceFactoryImpl;
import org.eclipse.emf.texo.orm.ormannotations.EAttributeORMAnnotation;
import org.eclipse.emf.texo.orm.ormannotations.EClassORMAnnotation;
import org.eclipse.emf.texo.orm.ormannotations.EPackageORMAnnotation;
import org.eclipse.emf.texo.orm.ormannotations.EReferenceORMAnnotation;
import org.eclipse.emf.texo.orm.ormannotations.OrmannotationsPackage;
import org.eclipse.emf.texo.utils.ModelUtils;

/**
 * Generates an ORM model on the basis of an annotated model
 * 
 * @author <a href="mtaal@elver.org">Martin Taal</a>
 */
public class ORMGenerator extends BaseGenerateAction {

  private static final ThreadLocal<Boolean> inStandardsCompliantMode = new ThreadLocal<Boolean>();

  private static final String ORM_FILE_NAME = "orm.xml"; //$NON-NLS-1$

  public static boolean areInStandardsCompliantMode() {
    return inStandardsCompliantMode.get() != null && inStandardsCompliantMode.get();
  }

  public static void setInStandardsCompliantMode(Boolean complianceMode) {
    inStandardsCompliantMode.set(complianceMode);
  }

  /**
   * Generate java annotations for a set of annotations of the annotationOwner.
   * 
   * The annotationOwner is an instance of the {@link OrmannotationsPackage} eclasses.
   * 
   * @param annotationOwner
   * @return
   */
  public static String generateJavaAnnotations(EObject annotationOwner) {
    final StringBuilder sb = new StringBuilder();
    for (EReference eReference : annotationOwner.eClass().getEAllReferences()) {
      final Object value = annotationOwner.eGet(eReference);
      if (value instanceof BaseOrmAnnotation) {
        if (sb.length() > 0) {
          sb.append("\n"); //$NON-NLS-1$
        }
        sb.append(((BaseOrmAnnotation) value).getJavaAnnotation());
      }
    }
    return sb.toString();
  }

  @Override
  protected void generateFromUris(IProgressMonitor monitor, IProject project, List<java.net.URI> uris) {
    for (java.net.URI uri : uris) {
      generateFromURI(monitor, project, uri);
    }
  }

  protected void generateFromURI(IProgressMonitor monitor, IProject project, java.net.URI uri) {
    // always start with a fresh epackage registry
    final List<EPackage> ePackages = GeneratorUtils.readEPackages(Collections.singletonList(uri),
        GeneratorUtils.createEPackageRegistry());

    final URI parentUri = URI.createURI(uri.toString()).trimSegments(1);
    final URI ormUri = parentUri.appendSegment(ORM_FILE_NAME);
    generateStoreORM(ePackages, ormUri);
  }

  public void generateStoreORM(List<EPackage> ePackages, URI ormUri) {
    final AnnotatedModel aModel = AnnotationsmodelFactory.eINSTANCE.createAnnotatedModel();
    final ModelController modelController = new ModelController();
    modelController.setEPackages(ePackages);
    modelController.getAnnotationManager().setAnnotatedModel(aModel);
    modelController.annotate(Collections.singletonList(ModelAnnotatorRegistry.getInstance().getModelAnnotator(
        ModelORMAnnotator.class)));

    final EntityMappingsType entityMappings = createEntityMappings(ePackages, aModel,
        modelController.getAnnotationManager());
    storeORM(ormUri, aModel, modelController.getAnnotationManager(), entityMappings);
  }

  protected void storeORM(URI fileUri, AnnotatedModel annotatedModel, AnnotationManager annotationManager,
      EntityMappingsType entityMappings) {

    final Resource ormResource = new OrmResourceFactoryImpl().createResource(fileUri);
    try {
      final File file = new File(fileUri.toFileString());
      if (file.exists()) {
        file.delete();
      }
      ormResource.getContents().clear();
      final DocumentRoot docRoot = OrmFactory.eINSTANCE.createDocumentRoot();
      docRoot.setEntityMappings(entityMappings);
      ormResource.getContents().add(docRoot);
      ormResource.save(Collections.emptyMap());
    } catch (IOException e) {
      throw new IllegalStateException(e);
    }
  }

  protected EntityMappingsType createEntityMappings(List<EPackage> ePackages, AnnotatedModel annotatedModel,
      AnnotationManager annotationManager) {
    // create a new EntityMappings and copy the values over from the
    // entity mappings defined in the EPackages.
    final EntityMappingsType entityMappings = OrmFactory.eINSTANCE.createEntityMappingsType();
    for (EPackage ePackage : ePackages) {
      final EPackageORMAnnotation ePackageORMAnnotation = (EPackageORMAnnotation) annotationManager.getAnnotation(
          ePackage, OrmannotationsPackage.eINSTANCE.getEPackageORMAnnotation());
      if (ePackageORMAnnotation.getEntityMappings() != null) {
        mergeManyFeatures(entityMappings, ePackageORMAnnotation.getEntityMappings());
      }
    }

    entityMappings.setVersion("2.1"); //$NON-NLS-1$

    entityMappings.setAccess(AccessType.FIELD);
    for (EPackage ePackage : ePackages) {
      final AnnotatedEPackage aPackage = annotatedModel.getAnnotatedEPackage(ePackage, false);
      for (AnnotatedEClassifier aClassifier : aPackage.getAnnotatedEClassifiers()) {
        if (aClassifier instanceof AnnotatedEClass) {
          final AnnotatedEClass aClass = (AnnotatedEClass) aClassifier;
          for (EClassAnnotation eClassAnnotation : aClass.getEClassAnnotations()) {
            if (eClassAnnotation instanceof EClassORMAnnotation) {
              final EClassORMAnnotation eClassORMAnnotation = (EClassORMAnnotation) eClassAnnotation;
              if (eClassORMAnnotation.getTransient() != null) {
                continue;
              }

              if (ModelUtils.isEMap(aClass.getEClass())) {
                continue;
              }

              if (eClassORMAnnotation.getMappedSuperclass() != null) {
                eClassORMAnnotation.getMappedSuperclass().setAttributes(
                    collectAttributes(entityMappings, annotationManager, aClass.getEClass()));
                entityMappings.getMappedSuperclass().add(EcoreUtil.copy(eClassORMAnnotation.getMappedSuperclass()));
              } else if (eClassORMAnnotation.getEmbeddable() != null) {
                eClassORMAnnotation.getEmbeddable().setAttributes(
                    collectAttributes(entityMappings, annotationManager, aClass.getEClass()));
                entityMappings.getEmbeddable().add(EcoreUtil.copy(eClassORMAnnotation.getEmbeddable()));
              } else if (eClassORMAnnotation.getEntity() != null) {
                eClassORMAnnotation.getEntity().setAttributes(
                    collectAttributes(entityMappings, annotationManager, aClass.getEClass()));
                entityMappings.getEntity().add(EcoreUtil.copy(eClassORMAnnotation.getEntity()));
              }
            }
          }
        }
      }
    }
    return entityMappings;
  }

  private Attributes collectAttributes(EntityMappingsType entityMappings, AnnotationManager annotationManager,
      EClass eClass) {
    final Attributes attributes = OrmFactory.eINSTANCE.createAttributes();
    collectAttributes(entityMappings, annotationManager, eClass, attributes);
    return attributes;
  }

  private void collectAttributes(EntityMappingsType entityMappings, AnnotationManager annotationManager, EClass eClass,
      Attributes attributes) {
    for (EClass eSuperType : eClass.getESuperTypes()) {
      if (eSuperType.isInterface()) {
        collectAttributes(entityMappings, annotationManager, eSuperType, attributes);
      }
    }
    collectAttributes(entityMappings, annotationManager, eClass.getEReferences(), eClass.getEAttributes(), false,
        attributes);
  }

  private void collectAttributes(EntityMappingsType entityMappings, AnnotationManager annotationManager,
      List<EReference> eReferences, List<EAttribute> eAttributes, boolean mapFeatureMapFeatures, Attributes attributes) {
    for (EAttribute eAttribute : eAttributes) {

      // ignore volatile features
      if (!mapFeatureMapFeatures && eAttribute.isVolatile()) {
        continue;
      }

      if (FeatureMapUtil.isFeatureMap(eAttribute)) {
        mapFeatureMap(entityMappings, annotationManager, eAttribute);
      }

      final EAttributeORMAnnotation ormAnnotation = (EAttributeORMAnnotation) annotationManager.getAnnotation(
          eAttribute, OrmannotationsPackage.eINSTANCE.getEAttributeORMAnnotation());

      final EAttributeModelGenAnnotation genAnnotation = (EAttributeModelGenAnnotation) annotationManager
          .getAnnotation(eAttribute, ModelcodegeneratorPackage.eINSTANCE.getEAttributeModelGenAnnotation());

      // map features which are part of a featureMap as Transient
      // these are mapped later again see the mapFeatureMap method
      if (!mapFeatureMapFeatures && genAnnotation.getFeatureMapFeature() != null) {
        final Transient trsnt = OrmFactory.eINSTANCE.createTransient();
        trsnt.setName(genAnnotation.getValidJavaMemberName());
        attributes.getTransient().add(trsnt);
        continue;
      }

      copyFeatures(ormAnnotation, attributes);
    }

    for (EReference eReference : eReferences) {

      // ignore volatile features
      if (!mapFeatureMapFeatures && eReference.isVolatile()) {
        continue;
      }

      final EReferenceORMAnnotation ormAnnotation = (EReferenceORMAnnotation) annotationManager.getAnnotation(
          eReference, OrmannotationsPackage.eINSTANCE.getEReferenceORMAnnotation());

      final EReferenceModelGenAnnotation genAnnotation = (EReferenceModelGenAnnotation) annotationManager
          .getAnnotation(eReference, ModelcodegeneratorPackage.eINSTANCE.getEReferenceModelGenAnnotation());

      // map features which are part of a featureMap as Transient
      // these are mapped later again see the mapFeatureMap method
      if (!mapFeatureMapFeatures && genAnnotation.getFeatureMapFeature() != null) {
        final Transient trsnt = OrmFactory.eINSTANCE.createTransient();
        trsnt.setName(genAnnotation.getValidJavaMemberName());
        attributes.getTransient().add(trsnt);
        continue;
      }

      copyFeatures(ormAnnotation, attributes);
    }
  }

  private void copyFeatures(EObject sourceEObject, EObject targetEObject) {
    for (EReference eSourceReference : sourceEObject.eClass().getEAllReferences()) {
      if (eSourceReference.isContainment() && sourceEObject.eIsSet(eSourceReference)) {
        final EReference targetFeature = getTargetFeature(eSourceReference);
        if (targetFeature == null) {
          continue;
        }
        if (targetFeature.isMany()) {
          if (eSourceReference.isMany()) {
            @SuppressWarnings("unchecked")
            final Collection<EObject> values = (Collection<EObject>) sourceEObject.eGet(eSourceReference);
            @SuppressWarnings("unchecked")
            final Collection<Object> targetCollection = (Collection<Object>) targetEObject.eGet(targetFeature);
            targetCollection.addAll(EcoreUtil.copyAll(values));
          } else {
            final Object value = sourceEObject.eGet(eSourceReference);
            @SuppressWarnings("unchecked")
            final Collection<Object> targetCollection = (Collection<Object>) targetEObject.eGet(targetFeature);
            targetCollection.add(EcoreUtil.copy((EObject) value));
          }
        } else {
          final Object value = sourceEObject.eGet(eSourceReference);
          targetEObject.eSet(targetFeature, EcoreUtil.copy((EObject) value));
        }
      }
    }
  }

  private EReference getTargetFeature(EReference sourceFeature) {
    for (EReference eTargetFeature : OrmPackage.eINSTANCE.getAttributes().getEAllReferences()) {
      if (eTargetFeature.getEReferenceType() == sourceFeature.getEReferenceType()) {
        return eTargetFeature;
      }
    }
    return null;
  }

  private void mapFeatureMap(EntityMappingsType entityMappings, AnnotationManager annotationManager,
      EAttribute eAttribute) {
    final EAttributeModelGenAnnotation genAnnotation = (EAttributeModelGenAnnotation) annotationManager.getAnnotation(
        eAttribute, ModelcodegeneratorPackage.eINSTANCE.getEAttributeModelGenAnnotation());

    final EAttributeORMAnnotation ormAnnotation = (EAttributeORMAnnotation) annotationManager.getAnnotation(eAttribute,
        OrmannotationsPackage.eINSTANCE.getEAttributeORMAnnotation());

    final List<EStructuralFeatureModelGenAnnotation> modelGenFeatures = genAnnotation.getAllMemberFeatureMapFeatures();
    final List<EAttribute> eAttributes = new ArrayList<EAttribute>();
    final List<EReference> eReferences = new ArrayList<EReference>();
    for (EStructuralFeatureModelGenAnnotation modelGenFeature : modelGenFeatures) {
      if (modelGenFeature.getEStructuralFeature() instanceof EAttribute) {
        eAttributes.add((EAttribute) modelGenFeature.getEStructuralFeature());
      } else {
        eReferences.add((EReference) modelGenFeature.getEStructuralFeature());
      }
    }

    final Entity entity = ormAnnotation.getFeatureMapEntity();

    final Attributes attributes = OrmFactory.eINSTANCE.createAttributes();
    collectAttributes(entityMappings, annotationManager, eReferences, eAttributes, true, attributes);
    entity.setAttributes(attributes);

    entityMappings.getEntity().add(EcoreUtil.copy(entity));
  }

  private void mergeManyFeatures(EObject o1, EObject o2) {
    for (EStructuralFeature eFeature : o1.eClass().getEAllStructuralFeatures()) {
      if (eFeature.isMany()) {
        if (eFeature instanceof EAttribute) {
          final EAttribute eAttribute = (EAttribute) eFeature;
          @SuppressWarnings("unchecked")
          final List<Object> o1Values = (List<Object>) o1.eGet(eAttribute);
          final List<?> o2Values = (List<?>) o2.eGet(eAttribute);
          o1Values.addAll(o2Values);
        } else {
          final EReference eReference = (EReference) eFeature;
          @SuppressWarnings("unchecked")
          final List<EObject> o1Values = (List<EObject>) o1.eGet(eReference);
          @SuppressWarnings("unchecked")
          final List<EObject> o2Values = (List<EObject>) o2.eGet(eReference);
          for (EObject o2Value : o2Values) {
            o1Values.add(EcoreUtil.copy(o2Value));
          }
        }
      }
    }
  }
}