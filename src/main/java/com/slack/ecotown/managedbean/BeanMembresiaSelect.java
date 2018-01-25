package com.slack.ecotown.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.slack.ecotown.DAO.MembresiaHome;
import com.slack.ecotown.model.Membresia;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "membresiaSelect")
@ViewScoped
public class BeanMembresiaSelect {

	private static final Logger log = Logger.getLogger(BeanMembresiaSelect.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private List<Membresia> listMembresias;

	@EJB
	private MembresiaHome membresiaHome;

	public List<Membresia> getListMembresias() {
		return listMembresias;
	}

	public void setListMembresias(List<Membresia> listMembresias) {
		this.listMembresias = listMembresias;
	}

	public BeanMembresiaSelect() {
	}

	@PostConstruct
	public void init() {
		inicializar();
	}

	public void inicializar() {
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
}
