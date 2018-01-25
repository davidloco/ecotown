package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Experiencia;

/**
 * Home object for domain model class Experiencia.
 * @see com.slack.ecotown.DAO.Experiencia
 * @author Hibernate Tools
 */
@Stateless
public class ExperienciaHome {

	private static final Log log = LogFactory.getLog(ExperienciaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Experiencia transientInstance) {
		log.debug("persisting Experiencia instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Experiencia persistentInstance) {
		log.debug("removing Experiencia instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Experiencia merge(Experiencia detachedInstance) {
		log.debug("merging Experiencia instance");
		try {
			Experiencia result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Experiencia findById(int id) {
		log.debug("getting Experiencia instance with id: " + id);
		try {
			Experiencia instance = entityManager.find(Experiencia.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
