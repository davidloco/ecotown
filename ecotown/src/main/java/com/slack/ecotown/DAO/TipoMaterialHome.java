package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.TipoMaterial;

/**
 * Home object for domain model class TipoMaterial.
 * 
 * @see com.slack.ecotown.DAO.TipoMaterial
 * @author Hibernate Tools
 */
@Stateless
public class TipoMaterialHome {

	private static final Log log = LogFactory.getLog(TipoMaterialHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoMaterial transientInstance) {
		log.debug("persisting TipoMaterial instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoMaterial persistentInstance) {
		log.debug("removing TipoMaterial instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoMaterial merge(TipoMaterial detachedInstance) {
		log.debug("merging TipoMaterial instance");
		try {
			TipoMaterial result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoMaterial findById(int id) {
		log.debug("getting TipoMaterial instance with id: " + id);
		try {
			TipoMaterial instance = entityManager.find(TipoMaterial.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoMaterial> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT tm FROM TipoMaterial tm ORDER BY tm.strnmbre");
			return (List<TipoMaterial>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<TipoMaterial> findAllXTmg(Integer tipoMaterialGrupo) {
		try {
			Query query = entityManager.createQuery("SELECT tm FROM TipoMaterial tm JOIN tm.tipoMaterialGrupo tmg WHERE tmg.intpktipmatgru = :tipoMG ORDER BY tm.strnmbre");
			query.setParameter("tipoMG", tipoMaterialGrupo);
			return (List<TipoMaterial>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
