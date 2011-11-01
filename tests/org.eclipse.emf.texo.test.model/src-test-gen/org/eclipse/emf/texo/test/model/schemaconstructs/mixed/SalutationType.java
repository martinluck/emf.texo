package org.eclipse.emf.texo.test.model.schemaconstructs.mixed;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;

/** 
 * A representation of the model object '<em><b>SalutationType</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "SalutationType")
public class SalutationType {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  private List<SalutationTypeMixedFeatureGroup> mixed = new ArrayList<SalutationTypeMixedFeatureGroup>();

  /**
   * Returns the value of '<em><b>mixed</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>mixed</b></em>' feature
   * @generated
   */
  public List<SalutationTypeMixedFeatureGroup> getMixed() {
    return mixed;
  }

  /**
   * Sets the '{@link SalutationType#getMixed() <em>mixed</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link SalutationType#getMixed() mixed}' feature.
   * @generated
   */
  public void setMixed(List<SalutationTypeMixedFeatureGroup> newMixed) {
    mixed = newMixed;
  }

  /**
   * Returns the value of '<em><b>name</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>name</b></em>' feature
   * @generated
   */
  public String getName() {
    return SalutationTypeMixedFeatureGroup.getSingleFeatureMapValue(getMixed(),
        SalutationTypeMixedFeatureGroup.Feature.NAME);
  }

  /**
   * Sets the '{@link SalutationType#getName() <em>name</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link SalutationType#getName() name}' feature.
   * @generated
   */
  public void setName(String newName) {
    setMixed(SalutationTypeMixedFeatureGroup.createFeatureGroupList(SalutationTypeMixedFeatureGroup.Feature.NAME,
        Collections.singletonList(newName)));
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "SalutationType " + " [name: " + getName() + "]";
  }
}