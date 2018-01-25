package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Educacion;

/**
 * Home object for domain model class Educacion.
 * @see com.slack.ecotown.DAO.Educacion
 * @author Hibernate Tools
 */
@Stateless
public class EducacionHome {

	private static final Log log = LogFactory.getLog(EducacionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Educacion transientInstance) {
		log.debug("persisting Educacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Educacion persistentInstance) {
		log.debug("removing Educacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Educacion merge(Educacion detachedInstance) {
		log.debug("merging Educacion instance");
		try {
			Educacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Educacion findById(int id) {
		log.debug("getting Educacion instance with id: " + id);
		try {
			Educacion instance = entityManager.find(Educacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
