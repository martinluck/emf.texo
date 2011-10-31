package org.eclipse.modisco.kdm.code.dao;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.texo.server.store.BaseDao;
import org.eclipse.modisco.kdm.code.CodeModelPackage;
import org.eclipse.modisco.kdm.code.HasValue;

/** 
 * The Dao implementation for the model object '<em><b>HasValue</b></em>'.
 * 
 * @generated 
 */
public class HasValueDao extends BaseDao<HasValue> {

  /**
   * @generated
   */
  @Override
  public Class<HasValue> getEntityClass() {
    return HasValue.class;
  }

  /**
   * @generated
   */
  @Override
  public EClass getEClass() {
    return CodeModelPackage.INSTANCE.getHasValueEClass();
  }
}
