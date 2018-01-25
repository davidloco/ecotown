package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.TipoIdentificacion;

/**
 * Home object for domain model class TipoIdentificacion.
 * 
 * @see com.slack.ecotown.DAO.TipoIdentificacion
 * @author Hibernate Tools
 */
@Stateless
public class TipoIdentificacionHome {

	private static final Log log = LogFactory.getLog(TipoIdentificacionHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoIdentificacion transientInstance) {
		log.debug("persisting TipoIdentificacion instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoIdentificacion persistentInstance) {
		log.debug("removing TipoIdentificacion instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoIdentificacion merge(TipoIdentificacion detachedInstance) {
		log.debug("merging TipoIdentificacion instance");
		try {
			TipoIdentificacion result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoIdentificacion findById(int id) {
		log.debug("getting TipoIdentificacion instance with id: " + id);
		try {
			TipoIdentificacion instance = entityManager.find(TipoIdentificacion.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoIdentificacion> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM TipoIdentificacion e ORDER BY e.strnmbre");
			return (List<TipoIdentificacion>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
