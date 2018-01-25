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
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.slack.ecotown.DAO.ResiduoHome;
import com.slack.ecotown.model.Residuo;
import com.slack.ecotown.model.view.ViewTerceroResiduo;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "publicacion")
@ViewScoped
public class BeanPublicacion {

	private static final Logger log = Logger.getLogger(BeanPublicacion.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Residuo residuo;
	private ViewTerceroResiduo viewTerceroResiduo;
	private List<ViewTerceroResiduo> listPublicaciones;

	@EJB
	private ResiduoHome residuoHome;

	public ViewTerceroResiduo getViewTerceroResiduo() {
		return viewTerceroResiduo;
	}

	public void setViewTerceroResiduo(ViewTerceroResiduo viewTerceroResiduo) {
		this.viewTerceroResiduo = viewTerceroResiduo;
	}

	public Residuo getResiduo() {
		return residuo;
	}

	public void setResiduo(Residuo residuo) {
		this.residuo = residuo;
	}

	public List<ViewTerceroResiduo> getListPublicaciones() {
		return listPublicaciones;
	}

	public void setListPublicaciones(List<ViewTerceroResiduo> listPublicaciones) {
		this.listPublicaciones = listPublicaciones;
	}

	public BeanPublicacion() {
	}

	@PostConstruct
	public void init() {
		inicializar();
	}

	public String entrarPublicacionResiduo() {
		return "inproyectoHome";
	}

	public void inicializar() {
		try {
			llenarPublicaciones();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void llenarPublicaciones() {
		try {
			this.listPublicaciones = new ArrayList<ViewTerceroResiduo>();
			this.listPublicaciones = this.residuoHome.findAllActivos();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public String verPublicacion(ViewTerceroResiduo viewTerceroResiduo) {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
		session.setAttribute("viewTerceroResiduo", viewTerceroResiduo);
		return "inpublicacionresiduover";
	}

	public void eliminar(Residuo residuo) {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.residuoHome.remove(residuo);

			enunciado.append(bundle.getString("label3"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(residuo.getIntpkres());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
			log.info(bundle.getString("label3"));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr6"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label22"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr6"), e);
		}

		inicializar();
	}

	public void guardar() {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.residuoHome.persist(this.residuo);

			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(residuo.getIntpkres());

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
