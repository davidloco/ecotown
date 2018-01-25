package com.slack.ecotown.DAO;

// Generated 7/12/2017 01:39:57 AM by Hibernate Tools 3.4.0.CR1

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.slack.ecotown.model.Residuo;
import com.slack.ecotown.model.Tercero;
import com.slack.ecotown.model.view.ViewTerceroResiduo;

/**
 * Home object for domain model class Residuo.
 * 
 * @see com.slack.ecotown.DAO.Residuo
 * @author Hibernate Tools
 */
@Stateless
public class ResiduoHome {

	private static final Log log = LogFactory.getLog(ResiduoHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Residuo transientInstance) {
		log.debug("persisting Residuo instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Residuo persistentInstance) {
		log.debug("removing Residuo instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Residuo merge(Residuo detachedInstance) {
		log.debug("merging Residuo instance");
		try {
			Residuo result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Residuo findById(int id) {
		log.debug("getting Residuo instance with id: " + id);
		try {
			Residuo instance = entityManager.find(Residuo.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Residuo> findAll() {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Residuo");
			return (List<Residuo>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Residuo> findAllXTercero(Tercero tercero) {
		try {
			Query query = entityManager.createQuery("SELECT e FROM Residuo e JOIN e.tercero t JOIN e.localidad l WHERE t.intpkter = :idTercero");
			query.setParameter("idTercero", tercero.getIntpkter());
			return (List<Residuo>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ViewTerceroResiduo> findByPerxTer(Tercero tercero) throws NoResultException {
		log.debug("getting Tercero instance with id: ");
		try {
			Query query = entityManager.createQuery("SELECT e FROM ViewTerceroResiduo e WHERE e.id.intpkter = :pkter");
			query.setParameter("pkter", tercero.getIntpkter());
			return (List<ViewTerceroResiduo>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ViewTerceroResiduo> findAllActivos() throws NoResultException {
		log.debug("getting Tercero instance with id: ");
		try {
			Query query = entityManager.createQuery("SELECT e FROM ViewTerceroResiduo e");
			return (List<ViewTerceroResiduo>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
