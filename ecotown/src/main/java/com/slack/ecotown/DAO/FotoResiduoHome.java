package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.FotoResiduo;

/**
 * Home object for domain model class FotoResiduo.
 * @see com.slack.ecotown.DAO.FotoResiduo
 * @author Hibernate Tools
 */
@Stateless
public class FotoResiduoHome {

	private static final Log log = LogFactory.getLog(FotoResiduoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(FotoResiduo transientInstance) {
		log.debug("persisting FotoResiduo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(FotoResiduo persistentInstance) {
		log.debug("removing FotoResiduo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public FotoResiduo merge(FotoResiduo detachedInstance) {
		log.debug("merging FotoResiduo instance");
		try {
			FotoResiduo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FotoResiduo findById(int id) {
		log.debug("getting FotoResiduo instance with id: " + id);
		try {
			FotoResiduo instance = entityManager.find(FotoResiduo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
