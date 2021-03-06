package org.eclipse.emf.texo.test.model.issues.bz444321;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.texo.model.ModelFactory;
import org.eclipse.emf.texo.model.ModelPackage;
import org.eclipse.emf.texo.model.ModelResolver;
import org.eclipse.emf.texo.utils.ModelUtils;

/**
 * The <b>Package</b> for the model '<em><b>bz444321</b></em>'. It contains
 * initialization code and access to the Factory to instantiate types of this
 * package.
 *
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class Bz444321ModelPackage extends ModelPackage {

	/**
	 * Is set when the package has been initialized.
	 * 
	 * @generated
	 */
	private static boolean isInitialized = false;

	/**
	 * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String NS_URI = "http://www.eclipse.org/emf/texo/test/model/issues/bz444321";

	/**
	 * The {@link ModelFactory} for this package. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final Bz444321ModelFactory MODELFACTORY = new Bz444321ModelFactory();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int MAINELEMENT_CLASSIFIER_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int MAINELEMENT_SINGLE_FEATURE_ID = 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int MAINELEMENT_MULTI_FEATURE_ID = 1;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int MAINELEMENT_MULTINOORPHANREMOVAL_FEATURE_ID = 2;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int MAINELEMENT_MULTICONTAINMENT_FEATURE_ID = 3;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int MAINELEMENT_MULTICONTAINMENTNOORPHANREMOVAL_FEATURE_ID = 4;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final int SUBELEMENT_CLASSIFIER_ID = 1;

	/**
	 * The static member with the instance of this {@link ModelPackage}. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final Bz444321ModelPackage INSTANCE = initialize();

	/**
	 * Initializes this {@link ModelPackage}. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @return an initialized instance of this class
	 *
	 * @generated
	 */
	public static Bz444321ModelPackage initialize() {

		if (isInitialized) {
			return (Bz444321ModelPackage) ModelResolver.getInstance()
					.getModelPackage(NS_URI);
		}

		final Bz444321ModelPackage modelPackage = new Bz444321ModelPackage();

		ModelResolver.getInstance().registerModelPackage(modelPackage);

		// read the model from the ecore file, the EPackage is registered in the
		// EPackage.Registry
		// see the ModelResolver getEPackageRegistry method
		ModelUtils.readEPackagesFromFile(modelPackage);

		isInitialized = true;

		// force the initialization of the EFactory proxy
		modelPackage.getEPackage();

		// register the relation between a Class and its EClassifier
		ModelResolver.getInstance().registerClassModelMapping(
				MainElement.class, modelPackage.getMainElementEClass(),
				modelPackage);
		ModelResolver.getInstance().registerClassModelMapping(SubElement.class,
				modelPackage.getSubElementEClass(), modelPackage);

		// and return ourselves
		return modelPackage;
	}

	/**
	 * Returns the {@link ModelFactory} of this ModelPackage. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the {@link Bz444321ModelFactory} instance.
	 * @generated
	 */
	@Override
	public Bz444321ModelFactory getModelFactory() {
		return MODELFACTORY;
	}

	/**
	 * Returns the nsUri of the {@link EPackage} managed by this Package
	 * instance. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the nsUri of the EPackage
	 * @generated
	 */
	@Override
	public String getNsURI() {
		return NS_URI;
	}

	/**
	 * Returns the name of the ecore file containing the ecore model of the
	 * {@link EPackage} managed here. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @return the name of the ecore file
	 * @generated
	 */
	@Override
	public String getEcoreFileName() {
		return "bz444321.ecore";
	}

	/**
	 * Returns the {@link EClass} '<em><b>MainElement</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>MainElement</b></em>'
	 * @generated
	 */
	public EClass getMainElementEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				MAINELEMENT_CLASSIFIER_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>MainElement.single</b></em>'. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>MainElement.single</b></em>'.
	 * @generated
	 */
	public EReference getMainElement_Single() {
		return (EReference) getMainElementEClass().getEAllStructuralFeatures()
				.get(MAINELEMENT_SINGLE_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '<em><b>MainElement.multi</b></em>
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>MainElement.multi</b></em>'.
	 * @generated
	 */
	public EReference getMainElement_Multi() {
		return (EReference) getMainElementEClass().getEAllStructuralFeatures()
				.get(MAINELEMENT_MULTI_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>MainElement.multiNoOrphanRemoval</b></em>'. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>MainElement.multiNoOrphanRemoval</b></em>'.
	 * @generated
	 */
	public EReference getMainElement_MultiNoOrphanRemoval() {
		return (EReference) getMainElementEClass().getEAllStructuralFeatures()
				.get(MAINELEMENT_MULTINOORPHANREMOVAL_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>MainElement.multiContainment</b></em>'. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>MainElement.multiContainment</b></em>'.
	 * @generated
	 */
	public EReference getMainElement_MultiContainment() {
		return (EReference) getMainElementEClass().getEAllStructuralFeatures()
				.get(MAINELEMENT_MULTICONTAINMENT_FEATURE_ID);
	}

	/**
	 * Returns the {@link EStructuralFeature} '
	 * <em><b>MainElement.multiContainmentNoOrphanRemoval</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EStructuralFeature}: '
	 *         <em><b>MainElement.multiContainmentNoOrphanRemoval</b></em>'.
	 * @generated
	 */
	public EReference getMainElement_MultiContainmentNoOrphanRemoval() {
		return (EReference) getMainElementEClass().getEAllStructuralFeatures()
				.get(MAINELEMENT_MULTICONTAINMENTNOORPHANREMOVAL_FEATURE_ID);
	}

	/**
	 * Returns the {@link EClass} '<em><b>SubElement</b></em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return an instance of the {@link EClass} '<em><b>SubElement</b></em>'
	 * @generated
	 */
	public EClass getSubElementEClass() {
		return (EClass) getEPackage().getEClassifiers().get(
				SUBELEMENT_CLASSIFIER_ID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param eClassifier
	 *            the {@link EClassifier}
	 * @return the class implementing a specific {@link EClass}.
	 * @generated
	 */
	@Override
	public Class<?> getEClassifierClass(EClassifier eClassifier) {
		switch (eClassifier.getClassifierID()) {
		case MAINELEMENT_CLASSIFIER_ID:
			return MainElement.class;
		case SUBELEMENT_CLASSIFIER_ID:
			return SubElement.class;
		default:
			throw new IllegalArgumentException("The EClassifier '"
					+ eClassifier + "' is not defined in this EPackage");
		}
	}
}
