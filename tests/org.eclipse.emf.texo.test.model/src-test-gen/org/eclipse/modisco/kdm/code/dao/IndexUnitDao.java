package org.eclipse.modisco.kdm.code.dao;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.texo.server.store.BaseDao;
import org.eclipse.modisco.kdm.code.CodeModelPackage;
import org.eclipse.modisco.kdm.code.IndexUnit;

/** 
 * The Dao implementation for the model object '<em><b>IndexUnit</b></em>'.
 * 
 * @generated 
 */
public class IndexUnitDao extends BaseDao<IndexUnit> {

  /**
   * @generated
   */
  @Override
  public Class<IndexUnit> getEntityClass() {
    return IndexUnit.class;
  }

  /**
   * @generated
   */
  @Override
  public EClass getEClass() {
    return CodeModelPackage.INSTANCE.getIndexUnitEClass();
  }
}
