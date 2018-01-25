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

import com.slack.ecotown.DAO.MembresiaHome;
import com.slack.ecotown.model.Membresia;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "membresia")
@ViewScoped
public class BeanMembresia {

	private static final Logger log = Logger.getLogger(BeanMembresia.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Membresia membresia;
	private List<Membresia> listMembresias;

	@EJB
	private MembresiaHome membresiaHome;

	public Membresia getMembresia() {
		return membresia;
	}

	public void setMembresia(Membresia membresia) {
		this.membresia = membresia;
	}

	public List<Membresia> getListMembresias() {
		return listMembresias;
	}

	public void setListMembresias(List<Membresia> listMembresias) {
		this.listMembresias = listMembresias;
	}

	public BeanMembresia() {
	}

	@PostConstruct
	public void init() {
		inicializar();
	}

	public void inicializar() {
		this.membresia = new Membresia();
		llenarMembresias();
	}

	public void llenarMembresias() {
		this.listMembresias = new ArrayList<Membresia>();
		try {
			this.listMembresias = this.membresiaHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void eliminar(Membresia membresia) {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.membresiaHome.remove(membresia);

			enunciado.append(bundle.getString("label3"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(membresia.getStrnombre());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
			log.info(bundle.getString("label3"));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr6"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label22"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr6"), e);
		}

		llenarMembresias();
	}

	public void guardar() {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.membresiaHome.persist(this.membresia);

			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(membresia.getStrnombre());

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
