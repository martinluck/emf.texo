package org.eclipse.emf.texo.test.model.samples.schoollibrary;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.texo.model.AbstractModelFeatureMapEntry;
import org.eclipse.emf.texo.model.AbstractModelObject;
import org.eclipse.emf.texo.model.ModelFactory;
import org.eclipse.emf.texo.model.ModelFeatureMapEntry;
import org.eclipse.emf.texo.model.ModelObject;
import org.eclipse.emf.texo.model.ModelPackage;
import org.eclipse.emf.texo.test.model.samples.librarymodelclasses.model.LibraryModelFactory;

/**
 * The <b>{@link ModelFactory}</b> for the types of this model: schoollibrary.
 * It contains code to create instances {@link ModelObject} wrappers and instances for EClasses and convert objects back and forth from their String (XML) representation.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class SchoollibraryModelFactory implements ModelFactory {

  /**
   * Creates an instance for an {@link EClass}
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param eClass creates a Object instance for this EClass
   * @return an object representing the eClass
   * @generated
   */
  public Object create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case SchoollibraryModelPackage.ASSET_CLASSIFIER_ID:
      return createAsset();
    case SchoollibraryModelPackage.SCHOOLBOOK_CLASSIFIER_ID:
      return createSchoolBook();
    case SchoollibraryModelPackage.SCHOOLLIBRARY_CLASSIFIER_ID:
      return createSchoolLibrary();
    }
    throw new IllegalArgumentException("The EClass '" + eClass.getName() + "' is not a valid EClass for this EPackage");
  }

  /**
   * Wraps an object in a {@link ModelObject}.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   *
   * @param eClass
   *            the EClass of the object
   * @param adaptee
   *            the object being wrapped/adapted
   * @return the wrapper {@link ModelObject}
   * @generated
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public ModelObject createModelObject(EClass eClass, Object adaptee) {
    ModelObject<Object> modelObject = null;
    switch (eClass.getClassifierID()) {
    case SchoollibraryModelPackage.ASSET_CLASSIFIER_ID:
      modelObject = new AssetModelObject();
      break;
    case SchoollibraryModelPackage.SCHOOLBOOK_CLASSIFIER_ID:
      modelObject = new SchoolBookModelObject();
      break;
    case SchoollibraryModelPackage.SCHOOLLIBRARY_CLASSIFIER_ID:
      modelObject = new SchoolLibraryModelObject();
      break;
    default:
      throw new IllegalArgumentException("The EClass '" + eClass + "' is not defined in this EPackage");
    }
    modelObject.setTarget(adaptee);
    return modelObject;
  }

  /**
   * Creates a feature map entry instance for a certain EStructuralFeature.
   * 
   * @param eStructuralFeature
   *          the feature map feature
   * @return the pojo feature map entry
   * @generated
   */
  public Object createFeatureMapEntry(EStructuralFeature eFeature) {
    throw new IllegalArgumentException("The EStructuralFeature '" + eFeature
        + "' is not a valid feature map in this EPackage");
  }

  /**
   * Wraps a feature map entry pojo in a {@link AbstractModelFeatureMapEntry}. If the feature map
   * entry is null then a new one is created and <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param eStructuralFeature
   *          the feature map feature of the object
   * @param adaptee
   *          the pojo feature map entry being wrapped/adapted
   * @return the wrapper {@link ModelFeatureMapEntry}
   * @generated
   */
  public ModelFeatureMapEntry<?> createModelFeatureMapEntry(EStructuralFeature eFeature, Object adaptee) {
    throw new IllegalArgumentException("The EStructuralFeature '" + eFeature
        + "' is not a valid feature map in this EPackage");
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return an instance of the model object representing the EClass Asset
   * @generated
   */
  public Asset createAsset() {
    return new Asset();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return an instance of the model object representing the EClass SchoolBook
   * @generated
   */
  public SchoolBook createSchoolBook() {
    return new SchoolBook();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return an instance of the model object representing the EClass SchoolLibrary
   * @generated
   */
  public SchoolLibrary createSchoolLibrary() {
    return new SchoolLibrary();
  }

  /**
   * Converts an instance of an {@link EDataType} to a String.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param eDataType the {@link EDataType} defining the type
   * @param value the object to convert, if the value is null then null is returned.
   * @generated
   */
  public Object createFromString(EDataType eDataType, String value) {
    switch (eDataType.getClassifierID()) {
    }
    throw new IllegalArgumentException("The EDatatype '" + eDataType + "' is not defined in this EPackage");
  }

  /**
   * Converts an instance of an {@link EDataType} to a String.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param eDataType the {@link EDataType} defining the type
   * @param value the object to convert, if value == null then null is returned
   * @generated
   */
  public String convertToString(EDataType eDataType, Object value) {
    switch (eDataType.getClassifierID()) {
    }
    throw new IllegalArgumentException("The EDatatype '" + eDataType + "' is not defined in this EPackage.");
  }

  /** 
   * The adapter/wrapper for the EClass '<em><b>Asset</b></em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  public static class AssetModelObject<E extends Asset> extends AbstractModelObject<E> {
    /**
     * @generated
     */
    public EClass eClass() {
      return SchoollibraryModelPackage.INSTANCE.getAssetEClass();
    }

    /**
     * @generated
     */
    public ModelPackage getModelPackage() {
      return SchoollibraryModelPackage.INSTANCE;
    }

    /**
     * @generated
     */
    @Override
    public Object eGet(EStructuralFeature eStructuralFeature) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case SchoollibraryModelPackage.ASSET_VALUE_FEATURE_ID:
        return getTarget().getValue();
      }
      return super.eGet(eStructuralFeature);
    }

    /**
     * @generated
     */
    @Override
    public void eSet(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case SchoollibraryModelPackage.ASSET_VALUE_FEATURE_ID:
        getTarget().setValue((Float) value);
        return;
      }
      super.eSet(eStructuralFeature, value);
    }

    /**
     * @generated
     */
    @Override
    public void eAddTo(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {

      }
      super.eAddTo(eStructuralFeature, value);
    }

    /**
     * @generated
     */
    @Override
    public void eRemoveFrom(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {

      }
      super.eAddTo(eStructuralFeature, value);
    }
  }

  /** 
   * The adapter/wrapper for the EClass '<em><b>SchoolBook</b></em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  public static class SchoolBookModelObject<E extends SchoolBook> extends LibraryModelFactory.BookModelObject<E> {
    /**
     * @generated
     */
    @Override
    public EClass eClass() {
      return SchoollibraryModelPackage.INSTANCE.getSchoolBookEClass();
    }

    /**
     * @generated
     */
    @Override
    public ModelPackage getModelPackage() {
      return SchoollibraryModelPackage.INSTANCE;
    }

    /**
     * @generated
     */
    @Override
    public Object eGet(EStructuralFeature eStructuralFeature) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case SchoollibraryModelPackage.SCHOOLBOOK_VALUE_FEATURE_ID:
        return getTarget().getValue();
      }
      return super.eGet(eStructuralFeature);
    }

    /**
     * @generated
     */
    @Override
    public void eSet(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case SchoollibraryModelPackage.SCHOOLBOOK_VALUE_FEATURE_ID:
        getTarget().setValue((Float) value);
        return;
      }
      super.eSet(eStructuralFeature, value);
    }

    /**
     * @generated
     */
    @Override
    public void eAddTo(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {

      }
      super.eAddTo(eStructuralFeature, value);
    }

    /**
     * @generated
     */
    @Override
    public void eRemoveFrom(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {

      }
      super.eAddTo(eStructuralFeature, value);
    }
  }

  /** 
   * The adapter/wrapper for the EClass '<em><b>SchoolLibrary</b></em>'.
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  public static class SchoolLibraryModelObject<E extends SchoolLibrary> extends
      LibraryModelFactory.LibraryModelObject<E> {
    /**
     * @generated
     */
    @Override
    public EClass eClass() {
      return SchoollibraryModelPackage.INSTANCE.getSchoolLibraryEClass();
    }

    /**
     * @generated
     */
    @Override
    public ModelPackage getModelPackage() {
      return SchoollibraryModelPackage.INSTANCE;
    }

    /**
     * @generated
     */
    @Override
    public Object eGet(EStructuralFeature eStructuralFeature) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case SchoollibraryModelPackage.SCHOOLLIBRARY_LOCATION_FEATURE_ID:
        return getTarget().getLocation();
      }
      return super.eGet(eStructuralFeature);
    }

    /**
     * @generated
     */
    @Override
    public void eSet(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case SchoollibraryModelPackage.SCHOOLLIBRARY_LOCATION_FEATURE_ID:
        getTarget().setLocation((String) value);
        return;
      }
      super.eSet(eStructuralFeature, value);
    }

    /**
     * @generated
     */
    @Override
    public void eAddTo(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {

      }
      super.eAddTo(eStructuralFeature, value);
    }

    /**
     * @generated
     */
    @Override
    public void eRemoveFrom(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {

      }
      super.eAddTo(eStructuralFeature, value);
    }
  }

}