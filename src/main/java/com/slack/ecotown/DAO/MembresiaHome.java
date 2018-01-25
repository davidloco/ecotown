package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Membresia;

/**
 * Home object for domain model class Membresia.
 * 
 * @see com.slack.ecotown.DAO.Membresia
 * @author Hibernate Tools
 */
@Stateless
public class MembresiaHome {

	private static final Log log = LogFactory.getLog(MembresiaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Membresia transientInstance) {
		log.debug("persisting Membresia instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Membresia persistentInstance) {
		log.debug("removing Membresia instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Membresia merge(Membresia detachedInstance) {
		log.debug("merging Membresia instance");
		try {
			Membresia result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Membresia findById(int id) {
		log.debug("getting Membresia instance with id: " + id);
		try {
			Membresia instance = entityManager.find(Membresia.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Membresia> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Membresia e ORDER BY e.strnombre");
			return (List<Membresia>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
