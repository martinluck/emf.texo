package org.eclipse.emf.texo.test.model.samples.inventory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import org.eclipse.emf.texo.test.model.base.identifiable.Identifiable;

/** 
 * A representation of the model object '<em><b>PType</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "PType")
public class PType extends Identifiable {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = true)
  private long id = 0;

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = true)
  private String name = null;

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @ManyToOne(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH }, optional = true, targetEntity = PType.class)
  @JoinTable(name = "PType_base")
  private PType base = null;

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @OneToMany(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH }, mappedBy = "base", targetEntity = PType.class)
  private Set<PType> subTypes = new HashSet<PType>();

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @ManyToMany(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH }, targetEntity = PType.class)
  @JoinTable(name = "PType_subNOTypes")
  private Set<PType> subNOTypes = new HashSet<PType>();

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @ManyToMany(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH }, targetEntity = PDeclaration.class)
  @OrderColumn()
  @JoinTable(name = "PType_infoReferences")
  private List<PDeclaration> infoReferences = new ArrayList<PDeclaration>();

  /**
   * Returns the value of '<em><b>id</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>id</b></em>' feature
   * @generated
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the '{@link PType#getId() <em>id</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link PType#getId() id}' feature.
   * @generated
   */
  public void setId(long newId) {
    id = newId;
  }

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
   * Sets the '{@link PType#getName() <em>name</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link PType#getName() name}' feature.
   * @generated
   */
  public void setName(String newName) {
    name = newName;
  }

  /**
   * Returns the value of '<em><b>base</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>base</b></em>' feature
   * @generated
   */
  public PType getBase() {
    return base;
  }

  /**
   * Sets the '{@link PType#getBase() <em>base</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link PType#getBase() base}' feature.
   * @generated
   */
  public void setBase(PType newBase) {
    base = newBase;
  }

  /**
   * Returns the value of '<em><b>subTypes</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>subTypes</b></em>' feature
   * @generated
   */
  public Set<PType> getSubTypes() {
    return subTypes;
  }

  /**
   * Adds to the <em>subTypes</em> feature.
   * @generated
   */
  public void addToSubTypes(PType subTypesValue) {

    subTypes.add(subTypesValue);

  }

  /**			
   * Removes from the <em>subTypes</em> feature.
   * @generated
   */
  public void removeFromSubTypes(PType subTypesValue) {
    if (subTypes.contains(subTypesValue)) {
      subTypes.remove(subTypesValue);
    }
  }

  /**			
   * Clears the <em>subTypes</em> feature.
   * @generated
   */
  public void clearSubTypes() {
    for (PType subTypesElement : subTypes) {
      removeFromSubTypes(subTypesElement);
    }
  }

  /**
   * Sets the '{@link PType#getSubTypes() <em>subTypes</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link PType#getSubTypes() subTypes}' feature.
   * @generated
   */
  public void setSubTypes(Set<PType> newSubTypes) {
    subTypes = newSubTypes;
  }

  /**
   * Returns the value of '<em><b>subNOTypes</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>subNOTypes</b></em>' feature
   * @generated
   */
  public Set<PType> getSubNOTypes() {
    return subNOTypes;
  }

  /**
   * Adds to the <em>subNOTypes</em> feature.
   * @generated
   */
  public void addToSubNOTypes(PType subNOTypesValue) {

    subNOTypes.add(subNOTypesValue);

  }

  /**			
   * Removes from the <em>subNOTypes</em> feature.
   * @generated
   */
  public void removeFromSubNOTypes(PType subNOTypesValue) {
    if (subNOTypes.contains(subNOTypesValue)) {
      subNOTypes.remove(subNOTypesValue);
    }
  }

  /**			
   * Clears the <em>subNOTypes</em> feature.
   * @generated
   */
  public void clearSubNOTypes() {
    for (PType subNOTypesElement : subNOTypes) {
      removeFromSubNOTypes(subNOTypesElement);
    }
  }

  /**
   * Sets the '{@link PType#getSubNOTypes() <em>subNOTypes</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link PType#getSubNOTypes() subNOTypes}' feature.
   * @generated
   */
  public void setSubNOTypes(Set<PType> newSubNOTypes) {
    subNOTypes = newSubNOTypes;
  }

  /**
   * Returns the value of '<em><b>infoReferences</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>infoReferences</b></em>' feature
   * @generated
   */
  public List<PDeclaration> getInfoReferences() {
    return infoReferences;
  }

  /**
   * Adds to the <em>infoReferences</em> feature.
   * @generated
   */
  public void addToInfoReferences(PDeclaration infoReferencesValue) {

    infoReferences.add(infoReferencesValue);

  }

  /**			
   * Removes from the <em>infoReferences</em> feature.
   * @generated
   */
  public void removeFromInfoReferences(PDeclaration infoReferencesValue) {
    if (infoReferences.contains(infoReferencesValue)) {
      infoReferences.remove(infoReferencesValue);
    }
  }

  /**			
   * Clears the <em>infoReferences</em> feature.
   * @generated
   */
  public void clearInfoReferences() {
    for (PDeclaration infoReferencesElement : infoReferences) {
      removeFromInfoReferences(infoReferencesElement);
    }
  }

  /**
   * Sets the '{@link PType#getInfoReferences() <em>infoReferences</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link PType#getInfoReferences() infoReferences}' feature.
   * @generated
   */
  public void setInfoReferences(List<PDeclaration> newInfoReferences) {
    infoReferences = newInfoReferences;
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "PType " + " [id: " + getId() + "]" + " [name: " + getName() + "]";
  }
}