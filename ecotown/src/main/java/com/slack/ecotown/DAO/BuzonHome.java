package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Buzon;

/**
 * Home object for domain model class Buzon.
 * @see com.slack.ecotown.DAO.Buzon
 * @author Hibernate Tools
 */
@Stateless
public class BuzonHome {

	private static final Log log = LogFactory.getLog(BuzonHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Buzon transientInstance) {
		log.debug("persisting Buzon instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Buzon persistentInstance) {
		log.debug("removing Buzon instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Buzon merge(Buzon detachedInstance) {
		log.debug("merging Buzon instance");
		try {
			Buzon result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Buzon findById(int id) {
		log.debug("getting Buzon instance with id: " + id);
		try {
			Buzon instance = entityManager.find(Buzon.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
