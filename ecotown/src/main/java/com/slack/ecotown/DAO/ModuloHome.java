package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Modulo;
import com.slack.ecotown.model.Recurso;

/**
 * Home object for domain model class Modulo.
 * 
 * @see com.slack.ecotown.DAO.Modulo
 * @author Hibernate Tools
 */
@Stateless
public class ModuloHome {

	private static final Log log = LogFactory.getLog(ModuloHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Modulo transientInstance) {
		log.debug("persisting Modulo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Modulo persistentInstance) {
		log.debug("removing Modulo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Modulo merge(Modulo detachedInstance) {
		log.debug("merging Modulo instance");
		try {
			Modulo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Modulo findById(int id) {
		log.debug("getting Modulo instance with id: " + id);
		try {
			Modulo instance = entityManager.find(Modulo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Recurso> findByRecxMod(Modulo modulo) {
		try {
			Query query = entityManager.createQuery("SELECT m FROM Modulo e JOIN e.recursos m WHERE e.intpkmod = :modIdn");
			query.setParameter("modIdn", modulo.getIntpkmod());
			return (List<Recurso>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
