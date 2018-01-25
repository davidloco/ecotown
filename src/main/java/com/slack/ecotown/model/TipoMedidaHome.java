package com.slack.ecotown.model;

// Generated 29/12/2017 05:42:17 PM by Hibernate Tools 3.4.0.CR1

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class TipoMedida.
 * @see com.slack.ecotown.model.TipoMedida
 * @author Hibernate Tools
 */
@Stateless
public class TipoMedidaHome {

	private static final Log log = LogFactory.getLog(TipoMedidaHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoMedida transientInstance) {
		log.debug("persisting TipoMedida instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoMedida persistentInstance) {
		log.debug("removing TipoMedida instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoMedida merge(TipoMedida detachedInstance) {
		log.debug("merging TipoMedida instance");
		try {
			TipoMedida result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoMedida findById(int id) {
		log.debug("getting TipoMedida instance with id: " + id);
		try {
			TipoMedida instance = entityManager.find(TipoMedida.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
