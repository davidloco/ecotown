package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Favorito;

/**
 * Home object for domain model class Favorito.
 * @see com.slack.ecotown.DAO.Favorito
 * @author Hibernate Tools
 */
@Stateless
public class FavoritoHome {

	private static final Log log = LogFactory.getLog(FavoritoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Favorito transientInstance) {
		log.debug("persisting Favorito instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Favorito persistentInstance) {
		log.debug("removing Favorito instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Favorito merge(Favorito detachedInstance) {
		log.debug("merging Favorito instance");
		try {
			Favorito result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Favorito findById(int id) {
		log.debug("getting Favorito instance with id: " + id);
		try {
			Favorito instance = entityManager.find(Favorito.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
