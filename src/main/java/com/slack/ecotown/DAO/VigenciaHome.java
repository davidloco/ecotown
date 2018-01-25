package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Vigencia;

/**
 * Home object for domain model class Vigencia.
 * @see com.slack.ecotown.DAO.Vigencia
 * @author Hibernate Tools
 */
@Stateless
public class VigenciaHome {

	private static final Log log = LogFactory.getLog(VigenciaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Vigencia transientInstance) {
		log.debug("persisting Vigencia instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Vigencia persistentInstance) {
		log.debug("removing Vigencia instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Vigencia merge(Vigencia detachedInstance) {
		log.debug("merging Vigencia instance");
		try {
			Vigencia result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Vigencia findById(int id) {
		log.debug("getting Vigencia instance with id: " + id);
		try {
			Vigencia instance = entityManager.find(Vigencia.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
