package org.eclipse.emf.texo.test.model.samples.extlibrary;

import javax.persistence.Access;
import javax.persistence.AccessType;
import org.eclipse.emf.texo.test.model.base.identifiable.IdentifiableInterface;

/** 
 * A representation of the model object '<em><b>Addressable</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Access(AccessType.PROPERTY)
public interface Addressable extends IdentifiableInterface {

  /**
   * Returns the value of '<em><b>address</em></b>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>address</b></em>' feature
   * @generated
   */
  public String getAddress();

  /**
   * Sets the '{@link Addressable#getAddress() <em>address</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link Addressable#getAddress() <em>address</em>}' feature.
   * @generated
   */
  public void setAddress(String newAddress);

}
