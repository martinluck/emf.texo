package org.eclipse.emf.texo.test.model.schemaconstructs.ecoreattrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;

/** 
 * A representation of the model object '<em><b>Mixed</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "Mixed")
public class Mixed {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  private List<MixedMixedFeatureGroup> mixed = new ArrayList<MixedMixedFeatureGroup>();

  /**
   * Returns the value of '<em><b>mixed</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>mixed</b></em>' feature
   * @generated
   */
  public List<MixedMixedFeatureGroup> getMixed() {
    return mixed;
  }

  /**
   * Sets the '{@link Mixed#getMixed() <em>mixed</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link Mixed#getMixed() mixed}' feature.
   * @generated
   */
  public void setMixed(List<MixedMixedFeatureGroup> newMixed) {
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
    return MixedMixedFeatureGroup.getSingleFeatureMapValue(getMixed(), MixedMixedFeatureGroup.Feature.NAME);
  }

  /**
   * Sets the '{@link Mixed#getName() <em>name</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link Mixed#getName() name}' feature.
   * @generated
   */
  public void setName(String newName) {
    setMixed(MixedMixedFeatureGroup.createFeatureGroupList(MixedMixedFeatureGroup.Feature.NAME,
        Collections.singletonList(newName)));
  }

  /**
   * Returns the value of '<em><b>value</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>value</b></em>' feature
   * @generated
   */
  public double getValue_() {
    return MixedMixedFeatureGroup.getSingleFeatureMapValue(getMixed(), MixedMixedFeatureGroup.Feature.VALUE_);
  }

  /**
   * Sets the '{@link Mixed#getValue_() <em>value</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link Mixed#getValue_() value}' feature.
   * @generated
   */
  public void setValue_(double newValue_) {
    setMixed(MixedMixedFeatureGroup.createFeatureGroupList(MixedMixedFeatureGroup.Feature.VALUE_,
        Collections.singletonList(newValue_)));
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "Mixed " + " [name: " + getName() + "]" + " [value_: " + getValue_() + "]";
  }
}