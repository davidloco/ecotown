package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Perfil;

/**
 * Home object for domain model class Perfil.
 * 
 * @see com.slack.ecotown.DAO.Perfil
 * @author Hibernate Tools
 */
@Stateless
public class PerfilHome {

	private static final Log log = LogFactory.getLog(PerfilHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Perfil transientInstance) {
		log.debug("persisting Perfil instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Perfil persistentInstance) {
		log.debug("removing Perfil instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Perfil merge(Perfil detachedInstance) {
		log.debug("merging Perfil instance");
		try {
			Perfil result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Perfil findById(int id) {
		log.debug("getting Perfil instance with id: " + id);
		try {
			Perfil instance = entityManager.find(Perfil.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Perfil> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Perfil e ORDER BY e.strnmbre");
			return (List<Perfil>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Perfil> findAllActivos() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Perfil e WHERE e.boolestdo = TRUE ORDER BY e.strnmbre");
			return (List<Perfil>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
