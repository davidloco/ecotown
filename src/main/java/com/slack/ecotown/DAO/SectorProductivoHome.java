package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.SectorProductivo;

/**
 * Home object for domain model class SectorProductivo.
 * 
 * @see com.slack.ecotown.DAO.SectorProductivo
 * @author Hibernate Tools
 */
@Stateless
public class SectorProductivoHome {

	private static final Log log = LogFactory.getLog(SectorProductivoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SectorProductivo transientInstance) {
		log.debug("persisting SectorProductivo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SectorProductivo persistentInstance) {
		log.debug("removing SectorProductivo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SectorProductivo merge(SectorProductivo detachedInstance) {
		log.debug("merging SectorProductivo instance");
		try {
			SectorProductivo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SectorProductivo findById(int id) {
		log.debug("getting SectorProductivo instance with id: " + id);
		try {
			SectorProductivo instance = entityManager.find(SectorProductivo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<SectorProductivo> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM SectorProductivo e ORDER BY e.strnmbre");
			return (List<SectorProductivo>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
