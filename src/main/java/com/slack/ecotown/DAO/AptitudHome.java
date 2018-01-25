package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Aptitud;

/**
 * Home object for domain model class Aptitud.
 * @see com.slack.ecotown.DAO.Aptitud
 * @author Hibernate Tools
 */
@Stateless
public class AptitudHome {

	private static final Log log = LogFactory.getLog(AptitudHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Aptitud transientInstance) {
		log.debug("persisting Aptitud instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Aptitud persistentInstance) {
		log.debug("removing Aptitud instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Aptitud merge(Aptitud detachedInstance) {
		log.debug("merging Aptitud instance");
		try {
			Aptitud result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Aptitud findById(int id) {
		log.debug("getting Aptitud instance with id: " + id);
		try {
			Aptitud instance = entityManager.find(Aptitud.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
