package com.slack.ecotown.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;

import com.slack.ecotown.DAO.ModuloHome;
import com.slack.ecotown.model.Modulo;
import com.slack.ecotown.model.Recurso;

/**
 * @author David Andres Betancourth Botero
 */
@ManagedBean(name = "beanModulo")
@SessionScoped
public class BeanModulo {

	private static final Logger log = Logger.getLogger(BeanModulo.class);
	private boolean adminitrarContrato = false;
	private List<Recurso> listRecursos;
	private Modulo modulos;

	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");

	@PostConstruct
	public void init() {
	}

	@EJB
	protected ModuloHome moduloHome;

	public BeanModulo() {
	}

	public Modulo getModulos() {
		return modulos;
	}

	public void setModulos(Modulo modulos) {
		this.modulos = modulos;
	}

	public List<Recurso> getListRecursos() {
		return listRecursos;
	}

	public void setListRecursos(List<Recurso> listRecursos) {
		this.listRecursos = listRecursos;
	}

	public boolean isAdminitrarContrato() {
		return adminitrarContrato;
	}

	public void setAdminitrarContrato(boolean adminitrarContrato) {
		this.adminitrarContrato = adminitrarContrato;
	}

	public ResourceBundle getBundle() {
		return bundle;
	}

	public void setBundle(ResourceBundle bundle) {
		this.bundle = bundle;
	}

	public static Logger getLog() {
		return log;
	}

	public String inicializarRecursos() {
		setModulos(new Modulo());
		setListRecursos(new ArrayList<Recurso>());
		return "inproyectoHome";
	}

	public List<Recurso> recursosList(Modulo modulos) {
		this.modulos = modulos;
		this.listRecursos = this.moduloHome.findByRecxMod(this.modulos);
		return this.listRecursos;
	}
}