package org.eclipse.emf.texo.test.model.samples.extendedpo2;

import javax.persistence.Basic;
import javax.persistence.Entity;
import org.eclipse.emf.texo.test.model.base.identifiable.Identifiable;

/** 
 * A representation of the model object '<em><b>GlobalLocation</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "GlobalLocation")
public class GlobalLocation extends Identifiable {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = true)
  private int countryCode = 0;

  /**
   * Returns the value of '<em><b>countryCode</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>countryCode</b></em>' feature
   * @generated
   */
  public int getCountryCode() {
    return countryCode;
  }

  /**
   * Sets the '{@link GlobalLocation#getCountryCode() <em>countryCode</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link GlobalLocation#getCountryCode() countryCode}' feature.
   * @generated
   */
  public void setCountryCode(int newCountryCode) {
    countryCode = newCountryCode;
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "GlobalLocation " + " [countryCode: " + getCountryCode() + "]";
  }
}