package org.eclipse.graphiti.mm.pictograms.dao;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.texo.server.store.BaseDao;
import org.eclipse.graphiti.mm.pictograms.Anchor;
import org.eclipse.graphiti.mm.pictograms.PictogramsModelPackage;

/**
 * The Dao implementation for the model object '<em><b>Anchor</b></em>'.
 * 
 * @generated
 */
public class AnchorDao extends BaseDao<Anchor> {

  /**
   * @generated
   */
  @Override
  public Class<Anchor> getEntityClass() {
    return Anchor.class;
  }

  /**
   * @generated
   */
  @Override
  public EClass getEClass() {
    return PictogramsModelPackage.INSTANCE.getAnchorEClass();
  }
}
