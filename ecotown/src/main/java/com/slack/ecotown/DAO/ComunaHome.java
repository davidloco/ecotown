package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Comuna;

/**
 * Home object for domain model class Comuna.
 * @see com.slack.ecotown.DAO.Comuna
 * @author Hibernate Tools
 */
@Stateless
public class ComunaHome {

	private static final Log log = LogFactory.getLog(ComunaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Comuna transientInstance) {
		log.debug("persisting Comuna instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Comuna persistentInstance) {
		log.debug("removing Comuna instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Comuna merge(Comuna detachedInstance) {
		log.debug("merging Comuna instance");
		try {
			Comuna result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Comuna findById(int id) {
		log.debug("getting Comuna instance with id: " + id);
		try {
			Comuna instance = entityManager.find(Comuna.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
