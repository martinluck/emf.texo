package org.eclipse.modisco.kdm.conceptual;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;
import org.eclipse.modisco.kdm.kdm.KDMModel;

/** 
 * A representation of the model object '<em><b>ConceptualModel</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "ConceptualModel")
public class ConceptualModel extends KDMModel {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @OneToMany(cascade = { CascadeType.ALL }, orphanRemoval = true, targetEntity = AbstractConceptualElement.class)
  @JoinColumns({ @JoinColumn() })
  private Set<AbstractConceptualElement> conceptualElement = new HashSet<AbstractConceptualElement>();

  /**
   * Returns the value of '<em><b>conceptualElement</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>conceptualElement</b></em>' feature
   * @generated
   */
  public Set<AbstractConceptualElement> getConceptualElement() {
    return conceptualElement;
  }

  /**
   * Adds to the <em>conceptualElement</em> feature.
   * @generated
   */
  public void addToConceptualElement(AbstractConceptualElement conceptualElementValue) {
    if (!conceptualElement.contains(conceptualElementValue)) {

      conceptualElement.add(conceptualElementValue);
    }

  }

  /**			
   * Removes from the <em>conceptualElement</em> feature.
   * @generated
   */
  public void removeFromConceptualElement(AbstractConceptualElement conceptualElementValue) {
    if (conceptualElement.contains(conceptualElementValue)) {
      conceptualElement.remove(conceptualElementValue);
    }
  }

  /**			
   * Clears the <em>conceptualElement</em> feature.
   * @generated
   */
  public void clearConceptualElement() {
    for (AbstractConceptualElement conceptualElementElement : conceptualElement) {
      removeFromConceptualElement(conceptualElementElement);
    }
  }

  /**
   * Sets the '{@link ConceptualModel#getConceptualElement() <em>conceptualElement</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link ConceptualModel#getConceptualElement() conceptualElement}' feature.
   * @generated
   */
  public void setConceptualElement(Set<AbstractConceptualElement> newConceptualElement) {
    conceptualElement = newConceptualElement;
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "ConceptualModel ";
  }
}
