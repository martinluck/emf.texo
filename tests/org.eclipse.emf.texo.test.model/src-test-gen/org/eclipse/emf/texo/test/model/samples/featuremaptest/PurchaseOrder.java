package org.eclipse.emf.texo.test.model.samples.featuremaptest;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.emf.texo.test.model.base.identifiable.Identifiable;

/** 
 * A representation of the model object '<em><b>PurchaseOrder</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "PurchaseOrder")
@Table(name = "PUR_ORDER")
public class PurchaseOrder extends Identifiable {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = false)
  private String name = null;

  /**
   * Returns the value of '<em><b>name</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>name</b></em>' feature
   * @generated
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the '{@link PurchaseOrder#getName() <em>name</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link PurchaseOrder#getName() name}' feature.
   * @generated
   */
  public void setName(String newName) {
    name = newName;
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "PurchaseOrder " + " [name: " + getName() + "]";
  }
}
