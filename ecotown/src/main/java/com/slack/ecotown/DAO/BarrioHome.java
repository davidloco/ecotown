package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Barrio;

/**
 * Home object for domain model class Barrio.
 * @see com.slack.ecotown.DAO.Barrio
 * @author Hibernate Tools
 */
@Stateless
public class BarrioHome {

	private static final Log log = LogFactory.getLog(BarrioHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Barrio transientInstance) {
		log.debug("persisting Barrio instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Barrio persistentInstance) {
		log.debug("removing Barrio instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Barrio merge(Barrio detachedInstance) {
		log.debug("merging Barrio instance");
		try {
			Barrio result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Barrio findById(int id) {
		log.debug("getting Barrio instance with id: " + id);
		try {
			Barrio instance = entityManager.find(Barrio.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
