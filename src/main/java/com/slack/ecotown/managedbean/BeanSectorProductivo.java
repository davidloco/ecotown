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

import com.slack.ecotown.DAO.SectorProductivoHome;
import com.slack.ecotown.model.SectorProductivo;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "sectorProductivo")
@ViewScoped
public class BeanSectorProductivo {

	private static final Logger log = Logger.getLogger(BeanSectorProductivo.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private SectorProductivo sectorProductivo;
	private List<SectorProductivo> listSectorProductivos;

	@EJB
	private SectorProductivoHome sectorProductivoHome;

	public SectorProductivo getSectorProductivo() {
		return sectorProductivo;
	}

	public void setSectorProductivo(SectorProductivo sectorProductivo) {
		this.sectorProductivo = sectorProductivo;
	}

	public List<SectorProductivo> getListSectorProductivos() {
		return listSectorProductivos;
	}

	public void setListSectorProductivos(List<SectorProductivo> listSectorProductivos) {
		this.listSectorProductivos = listSectorProductivos;
	}

	public BeanSectorProductivo() {
	}

	@PostConstruct
	public void init() {
		inicializar();
	}

	public void inicializar() {
		this.sectorProductivo = new SectorProductivo();
		llenarSectorProductivo();
	}

	public void llenarSectorProductivo() {
		this.listSectorProductivos = new ArrayList<SectorProductivo>();
		try {
			this.listSectorProductivos = this.sectorProductivoHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void eliminar(SectorProductivo sectorProductivo) {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.sectorProductivoHome.remove(sectorProductivo);

			enunciado.append(bundle.getString("label3"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(sectorProductivo.getStrnmbre());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
			log.info(bundle.getString("label3"));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr6"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label22"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr6"), e);
		}

		llenarSectorProductivo();
	}

	public void guardar() {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.sectorProductivoHome.persist(this.sectorProductivo);

			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(sectorProductivo.getStrnmbre());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr4"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("IODErr7"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr4"), e);
		}

		inicializar();
	}
}
