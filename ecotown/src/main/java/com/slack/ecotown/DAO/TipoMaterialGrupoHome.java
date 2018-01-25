package com.slack.ecotown.DAO;

// Generated 23/01/2018 03:56:23 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.TipoMaterialGrupo;

/**
 * Home object for domain model class TipoMaterialGrupo.
 * 
 * @see com.slack.ecotown.model.TipoMaterialGrupo
 * @author Hibernate Tools
 */
@Stateless
public class TipoMaterialGrupoHome {

	private static final Log log = LogFactory.getLog(TipoMaterialGrupoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TipoMaterialGrupo transientInstance) {
		log.debug("persisting TipoMaterialGrupo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TipoMaterialGrupo persistentInstance) {
		log.debug("removing TipoMaterialGrupo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TipoMaterialGrupo merge(TipoMaterialGrupo detachedInstance) {
		log.debug("merging TipoMaterialGrupo instance");
		try {
			TipoMaterialGrupo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TipoMaterialGrupo findById(int id) {
		log.debug("getting TipoMaterialGrupo instance with id: " + id);
		try {
			TipoMaterialGrupo instance = entityManager.find(TipoMaterialGrupo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<TipoMaterialGrupo> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM TipoMaterialGrupo e ORDER BY e.strnmbre");
			return (List<TipoMaterialGrupo>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
