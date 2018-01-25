package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Anuncio;
import com.slack.ecotown.model.Tercero;

/**
 * Home object for domain model class Anuncio.
 * 
 * @see com.slack.ecotown.DAO.Anuncio
 * @author Hibernate Tools
 */
@Stateless
public class AnuncioHome {

	private static final Log log = LogFactory.getLog(AnuncioHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Anuncio transientInstance) {
		log.debug("persisting Anuncio instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Anuncio persistentInstance) {
		log.debug("removing Anuncio instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Anuncio merge(Anuncio detachedInstance) {
		log.debug("merging Anuncio instance");
		try {
			Anuncio result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Anuncio findById(int id) {
		log.debug("getting Anuncio instance with id: " + id);
		try {
			Anuncio instance = entityManager.find(Anuncio.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Anuncio> findAllXTercero(Tercero tercero) {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Anuncio e JOIN e.tercero t WHERE t.intpkter = :idTercero");
			query.setParameter("idTercero", tercero.getIntpkter());
			return (List<Anuncio>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Anuncio> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Anuncio e");
			return (List<Anuncio>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
