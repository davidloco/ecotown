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

import com.slack.ecotown.model.Modulo;
import com.slack.ecotown.model.Tercero;

/**
 * Home object for domain model class Tercero.
 * 
 * @see com.slack.ecotown.DAO.Tercero
 * @author Hibernate Tools
 */
@Stateless
public class TerceroHome {

	private static final Log log = LogFactory.getLog(TerceroHome.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Tercero transientInstance) {
		log.debug("persisting Tercero instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Tercero persistentInstance) {
		log.debug("removing Tercero instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Tercero merge(Tercero detachedInstance) {
		log.debug("merging Tercero instance");
		try {
			Tercero result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Tercero findById(int id) {
		log.debug("getting Tercero instance with id: " + id);
		try {
			Tercero instance = entityManager.find(Tercero.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tercero> findAll() throws NoResultException {
		log.debug("getting Tercero instance with id: ");
		try {
			Query query = entityManager.createQuery("SELECT e FROM Tercero e JOIN e.perfil p JOIN e.tipoIdentificacion ti");
			return (List<Tercero>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Tercero> findByLogin(String login) throws NoResultException {
		log.debug("getting Tercero instance with id: " + login);
		try {
			Query query = entityManager.createQuery("SELECT e FROM Tercero e WHERE e.strcrrlctrnco = :usuLogin");
			query.setParameter("usuLogin", login);
			return (List<Tercero>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public Integer findByPerxTer(Tercero tercero) throws NoResultException {
		log.debug("getting Tercero instance with id: ");
		try {
			Query query = entityManager.createQuery("SELECT e.id.intpkper FROM ViewTerceroPerfil e WHERE e.id.intpkter = :pkter");
			query.setParameter("pkter", tercero.getIntpkter());
			return (Integer) query.getSingleResult();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Modulo> findByModxPer(Integer perfil) throws NoResultException {
		log.debug("getting Tercero instance with id: ");
		try {
			Query query = entityManager.createQuery("SELECT m FROM PerfilModulo pm JOIN pm.modulo m WHERE pm.perfil.intpkper = :idPerfil");
			query.setParameter("idPerfil", perfil);
			return (List<Modulo>) query.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

}
