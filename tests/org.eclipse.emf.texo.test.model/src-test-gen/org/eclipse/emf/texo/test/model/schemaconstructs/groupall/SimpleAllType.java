package org.eclipse.emf.texo.test.model.schemaconstructs.groupall;

import javax.persistence.Basic;
import javax.persistence.Entity;

/** 
 * A representation of the model object '<em><b>SimpleAllType</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "SimpleAllType")
public class SimpleAllType {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = false)
  private String aaa = null;

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = false)
  private String bbb = null;

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = false)
  private String ccc = null;

  /**
   * Returns the value of '<em><b>aaa</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>aaa</b></em>' feature
   * @generated
   */
  public String getAaa() {
    return aaa;
  }

  /**
   * Sets the '{@link SimpleAllType#getAaa() <em>aaa</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link SimpleAllType#getAaa() aaa}' feature.
   * @generated
   */
  public void setAaa(String newAaa) {
    aaa = newAaa;
  }

  /**
   * Returns the value of '<em><b>bbb</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>bbb</b></em>' feature
   * @generated
   */
  public String getBbb() {
    return bbb;
  }

  /**
   * Sets the '{@link SimpleAllType#getBbb() <em>bbb</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link SimpleAllType#getBbb() bbb}' feature.
   * @generated
   */
  public void setBbb(String newBbb) {
    bbb = newBbb;
  }

  /**
   * Returns the value of '<em><b>ccc</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>ccc</b></em>' feature
   * @generated
   */
  public String getCcc() {
    return ccc;
  }

  /**
   * Sets the '{@link SimpleAllType#getCcc() <em>ccc</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link SimpleAllType#getCcc() ccc}' feature.
   * @generated
   */
  public void setCcc(String newCcc) {
    ccc = newCcc;
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "SimpleAllType " + " [aaa: " + getAaa() + "]" + " [bbb: " + getBbb() + "]" + " [ccc: " + getCcc() + "]";
  }
}