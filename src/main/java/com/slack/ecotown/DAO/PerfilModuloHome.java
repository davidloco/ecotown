package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.PerfilModulo;

/**
 * Home object for domain model class PerfilModulo.
 * 
 * @see com.slack.ecotown.DAO.PerfilModulo
 * @author Hibernate Tools
 */
@Stateless
public class PerfilModuloHome {

	private static final Log log = LogFactory.getLog(PerfilModuloHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(PerfilModulo transientInstance) {
		log.debug("persisting PerfilModulo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(PerfilModulo persistentInstance) {
		log.debug("removing PerfilModulo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public PerfilModulo merge(PerfilModulo detachedInstance) {
		log.debug("merging PerfilModulo instance");
		try {
			PerfilModulo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PerfilModulo findById(int id) {
		log.debug("getting PerfilModulo instance with id: " + id);
		try {
			PerfilModulo instance = entityManager.find(PerfilModulo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
