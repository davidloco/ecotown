package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.TipoPago;

/**
 * Home object for domain model class TipoPago.
 * 
 * @see com.slack.ecotown.DAO.TipoPago
 * @author Hibernate Tools
 */
@Stateless
public class TipoPagoHome {

	private static final Log log = LogFactory.getLog(TipoPagoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoPago transientInstance) {
		log.debug("persisting TipoPago instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoPago persistentInstance) {
		log.debug("removing TipoPago instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoPago merge(TipoPago detachedInstance) {
		log.debug("merging TipoPago instance");
		try {
			TipoPago result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoPago findById(int id) {
		log.debug("getting TipoPago instance with id: " + id);
		try {
			TipoPago instance = entityManager.find(TipoPago.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
