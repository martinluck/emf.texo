package org.eclipse.emf.texo.test.model.issues.bz331009.dao;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.texo.server.store.BaseDao;
import org.eclipse.emf.texo.test.model.issues.bz331009.CarPassport;
import org.eclipse.emf.texo.test.model.issues.bz331009.ModelModelPackage;

/** 
 * The Dao implementation for the model object '<em><b>CarPassport</b></em>'.
 * 
 * @generated 
 */
public class CarPassportDao extends BaseDao<CarPassport> {

  /**
   * @generated
   */
  @Override
  public Class<CarPassport> getEntityClass() {
    return CarPassport.class;
  }

  /**
   * @generated
   */
  @Override
  public EClass getEClass() {
    return ModelModelPackage.INSTANCE.getCarPassportEClass();
  }
}
