package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Localidad;

/**
 * Home object for domain model class Localidad.
 * @see com.slack.ecotown.DAO.Localidad
 * @author Hibernate Tools
 */
@Stateless
public class LocalidadHome {

	private static final Log log = LogFactory.getLog(LocalidadHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Localidad transientInstance) {
		log.debug("persisting Localidad instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Localidad persistentInstance) {
		log.debug("removing Localidad instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Localidad merge(Localidad detachedInstance) {
		log.debug("merging Localidad instance");
		try {
			Localidad result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Localidad findById(String id) {
		log.debug("getting Localidad instance with id: " + id);
		try {
			Localidad instance = entityManager.find(Localidad.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
