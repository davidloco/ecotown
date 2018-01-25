package com.slack.ecotown.managedbean;

import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.slack.ecotown.model.view.ViewTerceroResiduo;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "publicacionVer")
@ViewScoped
public class BeanPublicacionVer {

	private static final Logger log = Logger.getLogger(BeanPublicacionVer.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private ViewTerceroResiduo viewTerceroResiduo;

	public ViewTerceroResiduo getViewTerceroResiduo() {
		return viewTerceroResiduo;
	}

	public void setViewTerceroResiduo(ViewTerceroResiduo viewTerceroResiduo) {
		this.viewTerceroResiduo = viewTerceroResiduo;
	}

	public BeanPublicacionVer() {
	}

	@PostConstruct
	public void init() {
		inicializar();
	}

	public void inicializar() {
		try {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			this.viewTerceroResiduo = (ViewTerceroResiduo) session.getAttribute("viewTerceroResiduo");
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}
}
