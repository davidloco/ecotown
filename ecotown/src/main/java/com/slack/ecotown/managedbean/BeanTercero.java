package com.slack.ecotown.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;

import com.slack.ecotown.DAO.PerfilHome;
import com.slack.ecotown.DAO.SectorProductivoHome;
import com.slack.ecotown.DAO.TerceroHome;
import com.slack.ecotown.DAO.TipoIdentificacionHome;
import com.slack.ecotown.model.Perfil;
import com.slack.ecotown.model.SectorProductivo;
import com.slack.ecotown.model.Tercero;
import com.slack.ecotown.model.TipoIdentificacion;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "tercero")
@ViewScoped
public class BeanTercero {

	private static final Logger log = Logger.getLogger(BeanTercero.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Tercero tercero;
	private List<Tercero> listTerceros;
	private List<Perfil> listPerfil;
	private List<SectorProductivo> listSectorProductivo;
	private List<TipoIdentificacion> listTipoIdentificacion;

	@EJB
	private TerceroHome terceroHome;

	@EJB
	private PerfilHome perfilHome;

	@EJB
	private SectorProductivoHome sectorProductivoHome;

	@EJB
	private TipoIdentificacionHome tipoIdentificacionHome;

	public List<TipoIdentificacion> getListTipoIdentificacion() {
		return listTipoIdentificacion;
	}

	public void setListTipoIdentificacion(List<TipoIdentificacion> listTipoIdentificacion) {
		this.listTipoIdentificacion = listTipoIdentificacion;
	}

	public List<SectorProductivo> getListSectorProductivo() {
		return listSectorProductivo;
	}

	public void setListSectorProductivo(List<SectorProductivo> listSectorProductivo) {
		this.listSectorProductivo = listSectorProductivo;
	}

	public Tercero getTercero() {
		return tercero;
	}

	public List<Perfil> getListPerfil() {
		return listPerfil;
	}

	public void setListPerfil(List<Perfil> listPerfil) {
		this.listPerfil = listPerfil;
	}

	public void setTercero(Tercero tercero) {
		this.tercero = tercero;
	}

	public List<Tercero> getListTerceros() {
		return listTerceros;
	}

	public void setListTerceros(List<Tercero> listTerceros) {
		this.listTerceros = listTerceros;
	}

	public BeanTercero() {
	}

	@PostConstruct
	public void init() {
		try {
			inicializar();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void inicializar() {
		try {
			inicializarTercero();
			llenarTerceros();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void inicializarTercero() {
		try {
			this.tercero = new Tercero();
			this.tercero.setPerfil(new Perfil());
			this.tercero.setSectorProductivo(new SectorProductivo());
			this.tercero.setTipoIdentificacion(new TipoIdentificacion());

			llenarListPerfil();
			llenarListSectorProductivo();
			llenarListTipoIdentificacion();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	private void llenarListPerfil() {
		this.listPerfil = new ArrayList<Perfil>();
		try {
			this.listPerfil = this.perfilHome.findAllActivos();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	private void llenarListSectorProductivo() {
		this.listSectorProductivo = new ArrayList<SectorProductivo>();
		try {
			this.listSectorProductivo = this.sectorProductivoHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	private void llenarListTipoIdentificacion() {
		this.listTipoIdentificacion = new ArrayList<TipoIdentificacion>();
		try {
			this.listTipoIdentificacion = this.tipoIdentificacionHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void llenarTerceros() {
		this.listTerceros = new ArrayList<Tercero>();
		try {
			this.listTerceros = this.terceroHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void crear() {
		try {
			inicializarTercero();
			RequestContext context = RequestContext.getCurrentInstance();
			context.update("tercero");
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void ver(Tercero tercero) {
		try {
			this.tercero = tercero;
			RequestContext context = RequestContext.getCurrentInstance();
			context.update("terceroVer");
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void eliminar(Tercero tercero) {
		StringBuilder enunciado = new StringBuilder();
		try {
			tercero.setBoolactvo(Boolean.FALSE);
			this.terceroHome.merge(tercero);

			enunciado.append(bundle.getString("label3"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(tercero.getStrnmbre());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
			log.info(bundle.getString("label3"));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr6"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label22"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr6"), e);
		} finally {
			llenarTerceros();
			RequestContext context = RequestContext.getCurrentInstance();
			context.update("tableTercero");
		}
	}

	public void guardar() {
		StringBuilder enunciado = new StringBuilder();
		try {

			this.tercero.setBoolactvo(Boolean.TRUE);

			// Reputacion: Promedio Original 3
			this.tercero.setIntrptcn(Constantes.TRES);
			this.terceroHome.persist(this.tercero);

			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(tercero.getStrnmbre());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr4"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("IODErr7"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr4"), e);
		} finally {
			llenarTerceros();
			RequestContext context = RequestContext.getCurrentInstance();
			context.update("tableTercero");
		}
	}
}
