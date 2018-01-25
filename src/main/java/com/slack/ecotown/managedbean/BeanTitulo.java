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

import com.slack.ecotown.DAO.TituloHome;
import com.slack.ecotown.model.Titulo;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "titulo")
@ViewScoped
public class BeanTitulo {

	private static final Logger log = Logger.getLogger(BeanTitulo.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Titulo titulo;
	private List<Titulo> listTitulos;

	@EJB
	private TituloHome tituloHome;

	public Titulo getTitulo() {
		return titulo;
	}

	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}

	public List<Titulo> getListTitulos() {
		return listTitulos;
	}

	public void setListTitulos(List<Titulo> listTitulos) {
		this.listTitulos = listTitulos;
	}

	public BeanTitulo() {
	}

	@PostConstruct
	public void init() {
		inicializar();
	}

	public void inicializar() {
		this.titulo = new Titulo();
		llenarTitulos();
	}

	public void llenarTitulos() {
		this.listTitulos = new ArrayList<Titulo>();
		try {
			this.listTitulos = this.tituloHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void eliminar(Titulo titulo) {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.tituloHome.remove(titulo);

			enunciado.append(bundle.getString("label3"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(titulo.getStrnmbre());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
			log.info(bundle.getString("label3"));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr6"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label22"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr6"), e);
		}

		llenarTitulos();
	}

	public void guardar() {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.tituloHome.persist(this.titulo);

			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(titulo.getStrnmbre());

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
