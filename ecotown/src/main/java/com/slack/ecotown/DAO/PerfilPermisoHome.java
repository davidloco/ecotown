package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.PerfilPermiso;

/**
 * Home object for domain model class PerfilPermiso.
 * 
 * @see com.slack.ecotown.DAO.PerfilPermiso
 * @author Hibernate Tools
 */
@Stateless
public class PerfilPermisoHome {

	private static final Log log = LogFactory.getLog(PerfilPermisoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PerfilPermiso transientInstance) {
		log.debug("persisting PerfilPermiso instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PerfilPermiso persistentInstance) {
		log.debug("removing PerfilPermiso instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PerfilPermiso merge(PerfilPermiso detachedInstance) {
		log.debug("merging PerfilPermiso instance");
		try {
			PerfilPermiso result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PerfilPermiso findById(int id) {
		log.debug("getting PerfilPermiso instance with id: " + id);
		try {
			PerfilPermiso instance = entityManager.find(PerfilPermiso.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
