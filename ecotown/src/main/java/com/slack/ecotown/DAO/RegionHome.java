package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Region;

/**
 * Home object for domain model class Region.
 * 
 * @see com.slack.ecotown.DAO.Region
 * @author Hibernate Tools
 */
@Stateless
public class RegionHome {

	private static final Log log = LogFactory.getLog(RegionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Region transientInstance) {
		log.debug("persisting Region instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Region persistentInstance) {
		log.debug("removing Region instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Region merge(Region detachedInstance) {
		log.debug("merging Region instance");
		try {
			Region result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Region findById(int id) {
		log.debug("getting Region instance with id: " + id);
		try {
			Region instance = entityManager.find(Region.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
