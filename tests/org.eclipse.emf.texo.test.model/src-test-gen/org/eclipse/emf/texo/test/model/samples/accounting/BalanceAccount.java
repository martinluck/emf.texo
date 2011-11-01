package org.eclipse.emf.texo.test.model.samples.accounting;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OrderColumn;

/** 
 * A representation of the model object '<em><b>BalanceAccount</b></em>'.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated 
 */
@Entity(name = "BalanceAccount")
public class BalanceAccount extends Account {

  /**
   * @generated
   */
  private static final long serialVersionUID = 1L;
  /** 
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @generated 
   */
  @ManyToMany(cascade = { CascadeType.ALL, CascadeType.PERSIST, CascadeType.REFRESH }, targetEntity = ReportGroup.class)
  @OrderColumn()
  @JoinTable(name = "BalanceAccount_report")
  private List<ReportGroup> report = new ArrayList<ReportGroup>();

  /**
   * Returns the value of '<em><b>report</b></em>' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @return the value of '<em><b>report</b></em>' feature
   * @generated
   */
  public List<ReportGroup> getReport() {
    return report;
  }

  /**
   * Adds to the <em>report</em> feature.
   * @generated
   */
  public void addToReport(ReportGroup reportValue) {
    if (!report.contains(reportValue)) {

      report.add(reportValue);
    }

  }

  /**			
   * Removes from the <em>report</em> feature.
   * @generated
   */
  public void removeFromReport(ReportGroup reportValue) {
    if (report.contains(reportValue)) {
      report.remove(reportValue);
    }
  }

  /**			
   * Clears the <em>report</em> feature.
   * @generated
   */
  public void clearReport() {
    for (ReportGroup reportElement : report) {
      removeFromReport(reportElement);
    }
  }

  /**
   * Sets the '{@link BalanceAccount#getReport() <em>report</em>}' feature.
   *
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * @param the new value of the '{@link BalanceAccount#getReport() report}' feature.
   * @generated
   */
  public void setReport(List<ReportGroup> newReport) {
    report = newReport;
  }

  /**
   * A toString method which prints the values of all EAttributes of this instance.
   * <!-- begin-user-doc --> <!--
   * end-user-doc -->
   * @generated
   */
  @Override
  public String toString() {
    return "BalanceAccount ";
  }
}