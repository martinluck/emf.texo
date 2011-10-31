package org.eclipse.emf.texo.test.model.samples.extlibrary;

import javax.persistence.Basic;
import javax.persistence.Entity;

/** 
 * A representation of the model object '<em><b>Periodical</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "Periodical")
public abstract class Periodical extends Item {

  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = true)
  private String title = null;
  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @Basic(optional = false)
  private int issuesPerYear = 0;

  /**
   * Returns the value of '<em><b>title</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>title</b></em>' feature
   * @generated
   */
  public String getTitle() {
    return title;
  }

  /**
   * Sets the '{@link Periodical#getTitle() <em>title</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link Periodical#getTitle() title}' feature.
   * @generated
   */
  public void setTitle(String newTitle) {
    title = newTitle;
  }

  /**
   * Returns the value of '<em><b>issuesPerYear</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>issuesPerYear</b></em>' feature
   * @generated
   */
  public int getIssuesPerYear() {
    return issuesPerYear;
  }

  /**
   * Sets the '{@link Periodical#getIssuesPerYear() <em>issuesPerYear</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link Periodical#getIssuesPerYear() issuesPerYear}' feature.
   * @generated
   */
  public void setIssuesPerYear(int newIssuesPerYear) {
    issuesPerYear = newIssuesPerYear;
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "Periodical " + " [title: " + getTitle() + "]" + " [issuesPerYear: " + getIssuesPerYear() + "]";
  }
}
