package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Recurso;

/**
 * Home object for domain model class Recurso.
 * 
 * @see com.slack.ecotown.DAO.Recurso
 * @author Hibernate Tools
 */
@Stateless
public class RecursoHome {

	private static final Log log = LogFactory.getLog(RecursoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Recurso transientInstance) {
		log.debug("persisting Recurso instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Recurso persistentInstance) {
		log.debug("removing Recurso instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Recurso merge(Recurso detachedInstance) {
		log.debug("merging Recurso instance");
		try {
			Recurso result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Recurso findById(int id) {
		log.debug("getting Recurso instance with id: " + id);
		try {
			Recurso instance = entityManager.find(Recurso.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
