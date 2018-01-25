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

import com.slack.ecotown.DAO.TipoMaterialHome;
import com.slack.ecotown.model.TipoMaterial;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "tipoMaterial")
@ViewScoped
public class BeanTipoMaterial {

	private static final Logger log = Logger.getLogger(BeanTipoMaterial.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private TipoMaterial tipoMaterial;
	private List<TipoMaterial> listTipoMaterials;

	@EJB
	private TipoMaterialHome tipoMaterialHome;

	public TipoMaterial getTipoMaterial() {
		return tipoMaterial;
	}

	public void setTipoMaterial(TipoMaterial tipoMaterial) {
		this.tipoMaterial = tipoMaterial;
	}

	public List<TipoMaterial> getListTipoMaterials() {
		return listTipoMaterials;
	}

	public void setListTipoMaterials(List<TipoMaterial> listTipoMaterials) {
		this.listTipoMaterials = listTipoMaterials;
	}

	public BeanTipoMaterial() {
	}

	@PostConstruct
	public void init() {
		inicializar();
	}

	public void inicializar() {
		this.tipoMaterial = new TipoMaterial();
		llenarTipoMaterials();
	}

	public void llenarTipoMaterials() {
		this.listTipoMaterials = new ArrayList<TipoMaterial>();
		try {
			this.listTipoMaterials = this.tipoMaterialHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void eliminar(TipoMaterial tipoMaterial) {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.tipoMaterialHome.remove(tipoMaterial);

			enunciado.append(bundle.getString("label3"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(tipoMaterial.getStrnmbre());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
			log.info(bundle.getString("label3"));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr6"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label22"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr6"), e);
		}

		llenarTipoMaterials();
	}

	public void guardar() {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.tipoMaterialHome.persist(this.tipoMaterial);

			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(tipoMaterial.getStrnmbre());

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
