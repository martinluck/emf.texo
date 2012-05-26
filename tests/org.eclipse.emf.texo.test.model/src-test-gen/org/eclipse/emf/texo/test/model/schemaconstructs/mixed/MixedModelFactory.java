package org.eclipse.emf.texo.test.model.schemaconstructs.mixed;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.texo.model.AbstractModelFeatureMapEntry;
import org.eclipse.emf.texo.model.ModelFactory;
import org.eclipse.emf.texo.model.ModelFeatureMapEntry;
import org.eclipse.emf.texo.model.ModelObject;
import org.eclipse.emf.texo.model.ModelPackage;
import org.eclipse.emf.texo.test.model.base.identifiable.IdentifiableModelFactory;

/**
 * The <b>{@link ModelFactory}</b> for the types of this model: org.eclipse.emf.texo.test.model.schemaconstructs.mixed.
 * It contains code to create instances {@link ModelObject} wrappers and instances for EClasses and convert objects back
 * and forth from their String (XML) representation. <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class MixedModelFactory implements ModelFactory {

  /**
   * Creates an instance for an {@link EClass} <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param eClass
   *          creates a Object instance for this EClass
   * @return an object representing the eClass
   * @generated
   */
  public Object create(EClass eClass) {
    switch (eClass.getClassifierID()) {
    case MixedModelPackage.DOCUMENTROOT_CLASSIFIER_ID:
      return createDocumentRoot();
    case MixedModelPackage.LETTERBODYTYPE_CLASSIFIER_ID:
      return createLetterBodyType();
    case MixedModelPackage.SALUTATIONTYPE_CLASSIFIER_ID:
      return createSalutationType();
    }
    throw new IllegalArgumentException("The EClass '" + eClass.getName() + "' is not a valid EClass for this EPackage");
  }

  /**
   * Wraps an object in a {@link ModelObject}. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param eClass
   *          the EClass of the object
   * @param adaptee
   *          the object being wrapped/adapted
   * @return the wrapper {@link ModelObject}
   * @generated
   */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  public ModelObject createModelObject(EClass eClass, Object adaptee) {
    ModelObject<Object> modelObject = null;
    switch (eClass.getClassifierID()) {
    case MixedModelPackage.DOCUMENTROOT_CLASSIFIER_ID:
      modelObject = new DocumentRootModelObject();
      break;
    case MixedModelPackage.LETTERBODYTYPE_CLASSIFIER_ID:
      modelObject = new LetterBodyTypeModelObject();
      break;
    case MixedModelPackage.SALUTATIONTYPE_CLASSIFIER_ID:
      modelObject = new SalutationTypeModelObject();
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
    if (eFeature == MixedModelPackage.INSTANCE.getDocumentRoot_Mixed()) {
      return new DocumentRootMixedFeatureGroup();
    }
    if (eFeature == MixedModelPackage.INSTANCE.getLetterBodyType_Mixed()) {
      return new LetterBodyTypeMixedFeatureGroup();
    }
    if (eFeature == MixedModelPackage.INSTANCE.getSalutationType_Mixed()) {
      return new SalutationTypeMixedFeatureGroup();
    }
    throw new IllegalArgumentException("The EStructuralFeature '" + eFeature
        + "' is not a valid feature map in this EPackage");
  }

  /**
   * Wraps a feature map entry pojo in a {@link AbstractModelFeatureMapEntry}. If the feature map entry is null then a
   * new one is created and <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param eStructuralFeature
   *          the feature map feature of the object
   * @param adaptee
   *          the pojo feature map entry being wrapped/adapted
   * @return the wrapper {@link ModelFeatureMapEntry}
   * @generated
   */
  public ModelFeatureMapEntry<?> createModelFeatureMapEntry(EStructuralFeature eFeature, Object adaptee) {
    if (eFeature == MixedModelPackage.INSTANCE.getDocumentRoot_Mixed()) {
      final DocumentRootMixedFeatureGroupModelFeatureMapEntry<DocumentRootMixedFeatureGroup> entry = new DocumentRootMixedFeatureGroupModelFeatureMapEntry<DocumentRootMixedFeatureGroup>();
      entry.setTarget((DocumentRootMixedFeatureGroup) adaptee);
      return entry;
    }
    if (eFeature == MixedModelPackage.INSTANCE.getLetterBodyType_Mixed()) {
      final LetterBodyTypeMixedFeatureGroupModelFeatureMapEntry<LetterBodyTypeMixedFeatureGroup> entry = new LetterBodyTypeMixedFeatureGroupModelFeatureMapEntry<LetterBodyTypeMixedFeatureGroup>();
      entry.setTarget((LetterBodyTypeMixedFeatureGroup) adaptee);
      return entry;
    }
    if (eFeature == MixedModelPackage.INSTANCE.getSalutationType_Mixed()) {
      final SalutationTypeMixedFeatureGroupModelFeatureMapEntry<SalutationTypeMixedFeatureGroup> entry = new SalutationTypeMixedFeatureGroupModelFeatureMapEntry<SalutationTypeMixedFeatureGroup>();
      entry.setTarget((SalutationTypeMixedFeatureGroup) adaptee);
      return entry;
    }
    throw new IllegalArgumentException("The EStructuralFeature '" + eFeature
        + "' is not a valid feature map in this EPackage");
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return an instance of the model object representing the EClass DocumentRoot
   * @generated
   */
  public DocumentRoot createDocumentRoot() {
    return new DocumentRoot();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return an instance of the model object representing the EClass LetterBodyType
   * @generated
   */
  public LetterBodyType createLetterBodyType() {
    return new LetterBodyType();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @return an instance of the model object representing the EClass SalutationType
   * @generated
   */
  public SalutationType createSalutationType() {
    return new SalutationType();
  }

  /**
   * Converts an instance of an {@link EDataType} to a String. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param eDataType
   *          the {@link EDataType} defining the type
   * @param value
   *          the object to convert, if the value is null then null is returned.
   * @generated
   */
  public Object createFromString(EDataType eDataType, String value) {
    switch (eDataType.getClassifierID()) {
    }
    throw new IllegalArgumentException("The EDatatype '" + eDataType + "' is not defined in this EPackage");
  }

  /**
   * Converts an instance of an {@link EDataType} to a String. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @param eDataType
   *          the {@link EDataType} defining the type
   * @param value
   *          the object to convert, if value == null then null is returned
   * @generated
   */
  public String convertToString(EDataType eDataType, Object value) {
    switch (eDataType.getClassifierID()) {
    }
    throw new IllegalArgumentException("The EDatatype '" + eDataType + "' is not defined in this EPackage.");
  }

  /**
   * The adapter/wrapper for the EClass '<em><b>DocumentRoot</b></em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static class DocumentRootModelObject<E extends DocumentRoot> extends
      IdentifiableModelFactory.IdentifiableModelObject<E> {
    /**
     * @generated
     */
    @Override
    public EClass eClass() {
      return MixedModelPackage.INSTANCE.getDocumentRootEClass();
    }

    /**
     * @generated
     */
    @Override
    public ModelPackage getModelPackage() {
      return MixedModelPackage.INSTANCE;
    }

    /**
     * @generated
     */
    @Override
    public Object eGet(EStructuralFeature eStructuralFeature) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case MixedModelPackage.DOCUMENTROOT_MIXED_FEATURE_ID:
        return getTarget().getMixed();
      case MixedModelPackage.DOCUMENTROOT_XMLNSPREFIXMAP_FEATURE_ID:
        return getTarget().getXMLNSPrefixMap();
      case MixedModelPackage.DOCUMENTROOT_XSISCHEMALOCATION_FEATURE_ID:
        return getTarget().getXSISchemaLocation();
      case MixedModelPackage.DOCUMENTROOT_LETTERBODY_FEATURE_ID:
        return getTarget().getLetterBody();
      }
      return super.eGet(eStructuralFeature);
    }

    /**
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case MixedModelPackage.DOCUMENTROOT_MIXED_FEATURE_ID:
        getTarget().setMixed((List<DocumentRootMixedFeatureGroup>) value);
        return;
      case MixedModelPackage.DOCUMENTROOT_XMLNSPREFIXMAP_FEATURE_ID:
        getTarget().setXMLNSPrefixMap((Map<String, String>) value);
        return;
      case MixedModelPackage.DOCUMENTROOT_XSISCHEMALOCATION_FEATURE_ID:
        getTarget().setXSISchemaLocation((Map<String, String>) value);
        return;
      case MixedModelPackage.DOCUMENTROOT_LETTERBODY_FEATURE_ID:
        getTarget().setLetterBody((LetterBodyType) value);
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

      case MixedModelPackage.DOCUMENTROOT_MIXED_FEATURE_ID:
        getTarget().getMixed().add((DocumentRootMixedFeatureGroup) value);
        return;

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

      case MixedModelPackage.DOCUMENTROOT_MIXED_FEATURE_ID:
        getTarget().getMixed().remove(value);
        return;

      }
      super.eRemoveFrom(eStructuralFeature, value);
    }
  }

  /**
   * The adapter/wrapper for the EClass '<em><b>LetterBodyType</b></em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static class LetterBodyTypeModelObject<E extends LetterBodyType> extends
      IdentifiableModelFactory.IdentifiableModelObject<E> {
    /**
     * @generated
     */
    @Override
    public EClass eClass() {
      return MixedModelPackage.INSTANCE.getLetterBodyTypeEClass();
    }

    /**
     * @generated
     */
    @Override
    public ModelPackage getModelPackage() {
      return MixedModelPackage.INSTANCE;
    }

    /**
     * @generated
     */
    @Override
    public Object eGet(EStructuralFeature eStructuralFeature) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case MixedModelPackage.LETTERBODYTYPE_MIXED_FEATURE_ID:
        return getTarget().getMixed();
      case MixedModelPackage.LETTERBODYTYPE_SALUTATION_FEATURE_ID:
        return getTarget().getSalutation();
      case MixedModelPackage.LETTERBODYTYPE_QUANTITY_FEATURE_ID:
        return getTarget().getQuantity();
      case MixedModelPackage.LETTERBODYTYPE_PRODUCTNAME_FEATURE_ID:
        return getTarget().getProductName();
      case MixedModelPackage.LETTERBODYTYPE_SHIPDATE_FEATURE_ID:
        return getTarget().getShipDate();
      }
      return super.eGet(eStructuralFeature);
    }

    /**
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case MixedModelPackage.LETTERBODYTYPE_MIXED_FEATURE_ID:
        getTarget().setMixed((List<LetterBodyTypeMixedFeatureGroup>) value);
        return;
      case MixedModelPackage.LETTERBODYTYPE_SALUTATION_FEATURE_ID:
        getTarget().setSalutation((SalutationType) value);
        return;
      case MixedModelPackage.LETTERBODYTYPE_QUANTITY_FEATURE_ID:
        getTarget().setQuantity((BigInteger) value);
        return;
      case MixedModelPackage.LETTERBODYTYPE_PRODUCTNAME_FEATURE_ID:
        getTarget().setProductName((String) value);
        return;
      case MixedModelPackage.LETTERBODYTYPE_SHIPDATE_FEATURE_ID:
        getTarget().setShipDate((Date) value);
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

      case MixedModelPackage.LETTERBODYTYPE_MIXED_FEATURE_ID:
        getTarget().getMixed().add((LetterBodyTypeMixedFeatureGroup) value);
        return;

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

      case MixedModelPackage.LETTERBODYTYPE_MIXED_FEATURE_ID:
        getTarget().getMixed().remove(value);
        return;

      }
      super.eRemoveFrom(eStructuralFeature, value);
    }
  }

  /**
   * The adapter/wrapper for the EClass '<em><b>SalutationType</b></em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static class SalutationTypeModelObject<E extends SalutationType> extends
      IdentifiableModelFactory.IdentifiableModelObject<E> {
    /**
     * @generated
     */
    @Override
    public EClass eClass() {
      return MixedModelPackage.INSTANCE.getSalutationTypeEClass();
    }

    /**
     * @generated
     */
    @Override
    public ModelPackage getModelPackage() {
      return MixedModelPackage.INSTANCE;
    }

    /**
     * @generated
     */
    @Override
    public Object eGet(EStructuralFeature eStructuralFeature) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case MixedModelPackage.SALUTATIONTYPE_MIXED_FEATURE_ID:
        return getTarget().getMixed();
      case MixedModelPackage.SALUTATIONTYPE_NAME_FEATURE_ID:
        return getTarget().getName();
      }
      return super.eGet(eStructuralFeature);
    }

    /**
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(EStructuralFeature eStructuralFeature, Object value) {
      final int featureID = eClass().getFeatureID(eStructuralFeature);
      switch (featureID) {
      case MixedModelPackage.SALUTATIONTYPE_MIXED_FEATURE_ID:
        getTarget().setMixed((List<SalutationTypeMixedFeatureGroup>) value);
        return;
      case MixedModelPackage.SALUTATIONTYPE_NAME_FEATURE_ID:
        getTarget().setName((String) value);
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

      case MixedModelPackage.SALUTATIONTYPE_MIXED_FEATURE_ID:
        getTarget().getMixed().add((SalutationTypeMixedFeatureGroup) value);
        return;

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

      case MixedModelPackage.SALUTATIONTYPE_MIXED_FEATURE_ID:
        getTarget().getMixed().remove(value);
        return;

      }
      super.eRemoveFrom(eStructuralFeature, value);
    }
  }

  /**
   * The wrapper/adapter for the Feature Group '<em><b>DocumentRoot.mixed</b></em>'.
   * 
   * @generated
   */
  public static class DocumentRootMixedFeatureGroupModelFeatureMapEntry<E extends DocumentRootMixedFeatureGroup>
      extends AbstractModelFeatureMapEntry<DocumentRootMixedFeatureGroup> {

    /**
     * @generated
     */
    public EStructuralFeature getEStructuralFeature() {
      switch (getTarget().getFeature()) {
      case TEXT:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text();
      case CDATA:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA();
      case COMMENT:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Comment();
      case LETTERBODY:
        return MixedModelPackage.INSTANCE.getDocumentRoot_LetterBody();
      }
      throw new IllegalArgumentException("No eStructuralFeature for feature kind " + getTarget().getFeature());
    }

    /**
     * @generated
     */
    public void setEStructuralFeature(final EStructuralFeature eStructuralFeature) {
      if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text()) {
        getTarget().setFeature(DocumentRootMixedFeatureGroup.Feature.TEXT);
        return;
      } else if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA()) {
        getTarget().setFeature(DocumentRootMixedFeatureGroup.Feature.CDATA);
        return;
      } else if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Comment()) {
        getTarget().setFeature(DocumentRootMixedFeatureGroup.Feature.COMMENT);
        return;
      }

      final EClass eClass = MixedModelPackage.INSTANCE.getDocumentRootEClass();
      switch (eClass.getFeatureID(eStructuralFeature)) {
      case MixedModelPackage.DOCUMENTROOT_LETTERBODY_FEATURE_ID:
        getTarget().setFeature(DocumentRootMixedFeatureGroup.Feature.LETTERBODY);
        return;
      }
      throw new IllegalArgumentException("EStructuralFeature " + eStructuralFeature + " not supported here");
    }

    /**
     * @generated
     */
    public Object getValue() {
      return getTarget().getValue();
    }

    /**
     * @generated
     */
    public void setValue(final Object value) {
      getTarget().setValue(getTarget().getFeature(), value);
    }
  }

  /**
   * The wrapper/adapter for the Feature Group '<em><b>LetterBodyType.mixed</b></em>'.
   * 
   * @generated
   */
  public static class LetterBodyTypeMixedFeatureGroupModelFeatureMapEntry<E extends LetterBodyTypeMixedFeatureGroup>
      extends AbstractModelFeatureMapEntry<LetterBodyTypeMixedFeatureGroup> {

    /**
     * @generated
     */
    public EStructuralFeature getEStructuralFeature() {
      switch (getTarget().getFeature()) {
      case TEXT:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text();
      case CDATA:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA();
      case COMMENT:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Comment();
      case SALUTATION:
        return MixedModelPackage.INSTANCE.getLetterBodyType_Salutation();
      case QUANTITY:
        return MixedModelPackage.INSTANCE.getLetterBodyType_Quantity();
      case PRODUCTNAME:
        return MixedModelPackage.INSTANCE.getLetterBodyType_ProductName();
      case SHIPDATE:
        return MixedModelPackage.INSTANCE.getLetterBodyType_ShipDate();
      }
      throw new IllegalArgumentException("No eStructuralFeature for feature kind " + getTarget().getFeature());
    }

    /**
     * @generated
     */
    public void setEStructuralFeature(final EStructuralFeature eStructuralFeature) {
      if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text()) {
        getTarget().setFeature(LetterBodyTypeMixedFeatureGroup.Feature.TEXT);
        return;
      } else if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA()) {
        getTarget().setFeature(LetterBodyTypeMixedFeatureGroup.Feature.CDATA);
        return;
      } else if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Comment()) {
        getTarget().setFeature(LetterBodyTypeMixedFeatureGroup.Feature.COMMENT);
        return;
      }

      final EClass eClass = MixedModelPackage.INSTANCE.getLetterBodyTypeEClass();
      switch (eClass.getFeatureID(eStructuralFeature)) {
      case MixedModelPackage.LETTERBODYTYPE_SALUTATION_FEATURE_ID:
        getTarget().setFeature(LetterBodyTypeMixedFeatureGroup.Feature.SALUTATION);
        return;
      case MixedModelPackage.LETTERBODYTYPE_QUANTITY_FEATURE_ID:
        getTarget().setFeature(LetterBodyTypeMixedFeatureGroup.Feature.QUANTITY);
        return;
      case MixedModelPackage.LETTERBODYTYPE_PRODUCTNAME_FEATURE_ID:
        getTarget().setFeature(LetterBodyTypeMixedFeatureGroup.Feature.PRODUCTNAME);
        return;
      case MixedModelPackage.LETTERBODYTYPE_SHIPDATE_FEATURE_ID:
        getTarget().setFeature(LetterBodyTypeMixedFeatureGroup.Feature.SHIPDATE);
        return;
      }
      throw new IllegalArgumentException("EStructuralFeature " + eStructuralFeature + " not supported here");
    }

    /**
     * @generated
     */
    public Object getValue() {
      return getTarget().getValue();
    }

    /**
     * @generated
     */
    public void setValue(final Object value) {
      getTarget().setValue(getTarget().getFeature(), value);
    }
  }

  /**
   * The wrapper/adapter for the Feature Group '<em><b>SalutationType.mixed</b></em>'.
   * 
   * @generated
   */
  public static class SalutationTypeMixedFeatureGroupModelFeatureMapEntry<E extends SalutationTypeMixedFeatureGroup>
      extends AbstractModelFeatureMapEntry<SalutationTypeMixedFeatureGroup> {

    /**
     * @generated
     */
    public EStructuralFeature getEStructuralFeature() {
      switch (getTarget().getFeature()) {
      case TEXT:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text();
      case CDATA:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA();
      case COMMENT:
        return XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Comment();
      case NAME:
        return MixedModelPackage.INSTANCE.getSalutationType_Name();
      }
      throw new IllegalArgumentException("No eStructuralFeature for feature kind " + getTarget().getFeature());
    }

    /**
     * @generated
     */
    public void setEStructuralFeature(final EStructuralFeature eStructuralFeature) {
      if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Text()) {
        getTarget().setFeature(SalutationTypeMixedFeatureGroup.Feature.TEXT);
        return;
      } else if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_CDATA()) {
        getTarget().setFeature(SalutationTypeMixedFeatureGroup.Feature.CDATA);
        return;
      } else if (eStructuralFeature == XMLTypePackage.eINSTANCE.getXMLTypeDocumentRoot_Comment()) {
        getTarget().setFeature(SalutationTypeMixedFeatureGroup.Feature.COMMENT);
        return;
      }

      final EClass eClass = MixedModelPackage.INSTANCE.getSalutationTypeEClass();
      switch (eClass.getFeatureID(eStructuralFeature)) {
      case MixedModelPackage.SALUTATIONTYPE_NAME_FEATURE_ID:
        getTarget().setFeature(SalutationTypeMixedFeatureGroup.Feature.NAME);
        return;
      }
      throw new IllegalArgumentException("EStructuralFeature " + eStructuralFeature + " not supported here");
    }

    /**
     * @generated
     */
    public Object getValue() {
      return getTarget().getValue();
    }

    /**
     * @generated
     */
    public void setValue(final Object value) {
      getTarget().setValue(getTarget().getFeature(), value);
    }
  }

}
