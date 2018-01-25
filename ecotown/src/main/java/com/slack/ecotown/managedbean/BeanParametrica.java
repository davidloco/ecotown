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

import com.slack.ecotown.DAO.ParametricaHome;
import com.slack.ecotown.model.Parametrica;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "parametrica")
@ViewScoped
public class BeanParametrica {

	private static final Logger log = Logger.getLogger(BeanParametrica.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Parametrica parametrica;
	private List<Parametrica> listParametricas;

	@EJB
	private ParametricaHome parametricaHome;

	public Parametrica getParametrica() {
		return parametrica;
	}

	public void setParametrica(Parametrica parametrica) {
		this.parametrica = parametrica;
	}

	public List<Parametrica> getListParametricas() {
		return listParametricas;
	}

	public void setListParametricas(List<Parametrica> listParametricas) {
		this.listParametricas = listParametricas;
	}

	public BeanParametrica() {
	}

	@PostConstruct
	public void init() {
		inicializar();
	}

	public void inicializar() {
		this.parametrica = new Parametrica();
		llenarParametricas();
	}

	public void llenarParametricas() {
		this.listParametricas = new ArrayList<Parametrica>();
		try {
			this.listParametricas = this.parametricaHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void eliminar(Parametrica parametrica) {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.parametricaHome.remove(parametrica);

			enunciado.append(bundle.getString("label3"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(parametrica.getStrnmbre());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
			log.info(bundle.getString("label3"));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr6"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label22"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr6"), e);
		}

		llenarParametricas();
	}

	public void guardar() {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.parametricaHome.persist(this.parametrica);

			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(parametrica.getStrnmbre());

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
