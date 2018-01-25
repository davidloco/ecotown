package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Calificacion;

/**
 * Home object for domain model class Calificacion.
 * @see com.slack.ecotown.DAO.Calificacion
 * @author Hibernate Tools
 */
@Stateless
public class CalificacionHome {

	private static final Log log = LogFactory.getLog(CalificacionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Calificacion transientInstance) {
		log.debug("persisting Calificacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Calificacion persistentInstance) {
		log.debug("removing Calificacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Calificacion merge(Calificacion detachedInstance) {
		log.debug("merging Calificacion instance");
		try {
			Calificacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Calificacion findById(int id) {
		log.debug("getting Calificacion instance with id: " + id);
		try {
			Calificacion instance = entityManager.find(Calificacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
