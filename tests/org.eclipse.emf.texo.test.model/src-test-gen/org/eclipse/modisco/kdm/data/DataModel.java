package org.eclipse.modisco.kdm.data;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import org.eclipse.modisco.kdm.kdm.KDMModel;

/** 
 * A representation of the model object '<em><b>DataModel</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "DataModel")
public class DataModel extends KDMModel {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true, targetEntity = AbstractDataElement.class)
  @JoinColumns({ @JoinColumn() })
  private Set<AbstractDataElement> dataElement = new HashSet<AbstractDataElement>();

  /**
   * Returns the value of '<em><b>dataElement</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>dataElement</b></em>' feature
   * @generated
   */
  public Set<AbstractDataElement> getDataElement() {
    return dataElement;
  }

  /**
   * Adds to the <em>dataElement</em> feature.
   * @generated
   */
  public void addToDataElement(AbstractDataElement dataElementValue) {
    if (!dataElement.contains(dataElementValue)) {

      dataElement.add(dataElementValue);
    }

  }

  /**			
   * Removes from the <em>dataElement</em> feature.
   * @generated
   */
  public void removeFromDataElement(AbstractDataElement dataElementValue) {
    if (dataElement.contains(dataElementValue)) {
      dataElement.remove(dataElementValue);
    }
  }

  /**			
   * Clears the <em>dataElement</em> feature.
   * @generated
   */
  public void clearDataElement() {
    for (AbstractDataElement dataElementElement : dataElement) {
      removeFromDataElement(dataElementElement);
    }
  }

  /**
   * Sets the '{@link DataModel#getDataElement() <em>dataElement</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link DataModel#getDataElement() dataElement}' feature.
   * @generated
   */
  public void setDataElement(Set<AbstractDataElement> newDataElement) {
    dataElement = newDataElement;
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "DataModel ";
  }
}