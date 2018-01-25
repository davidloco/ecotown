package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Permiso;

/**
 * Home object for domain model class Permiso.
 * 
 * @see com.slack.ecotown.DAO.Permiso
 * @author Hibernate Tools
 */
@Stateless
public class PermisoHome {

	private static final Log log = LogFactory.getLog(PermisoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Permiso transientInstance) {
		log.debug("persisting Permiso instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Permiso persistentInstance) {
		log.debug("removing Permiso instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Permiso merge(Permiso detachedInstance) {
		log.debug("merging Permiso instance");
		try {
			Permiso result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Permiso findById(int id) {
		log.debug("getting Permiso instance with id: " + id);
		try {
			Permiso instance = entityManager.find(Permiso.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
