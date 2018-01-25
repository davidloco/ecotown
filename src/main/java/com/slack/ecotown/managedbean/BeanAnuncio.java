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

import com.slack.ecotown.DAO.AnuncioHome;
import com.slack.ecotown.model.Anuncio;
import com.slack.ecotown.model.Tercero;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "anuncio")
@ViewScoped
public class BeanAnuncio {

	private static final Logger log = Logger.getLogger(BeanAnuncio.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Anuncio anuncio;
	private List<Anuncio> listAnuncios;

	@EJB
	private AnuncioHome anuncioHome;

	public Anuncio getAnuncio() {
		return anuncio;
	}

	public void setAnuncio(Anuncio anuncio) {
		this.anuncio = anuncio;
	}

	public List<Anuncio> getListAnuncios() {
		return listAnuncios;
	}

	public void setListAnuncios(List<Anuncio> listAnuncios) {
		this.listAnuncios = listAnuncios;
	}

	public BeanAnuncio() {
	}

	@PostConstruct
	public void init() {
		inicializarAnuncioXTercero();
	}

	public String entrarAnuncio() {
		return "inanuncio";
	}

	public void inicializar() {
		try {
			this.anuncio = new Anuncio();
			llenarAnuncios();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void inicializarAnuncioXTercero() {
		try {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			llenarAnunciosXTercero(((Tercero) session.getAttribute("datosLogin")));
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	/**
	 * 
	 */
	public void llenarAnuncios() {
		this.listAnuncios = new ArrayList<Anuncio>();
		try {
			this.listAnuncios = this.anuncioHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void llenarAnunciosXTercero(Tercero tercero) {
		this.listAnuncios = new ArrayList<Anuncio>();
		try {
			this.listAnuncios = this.anuncioHome.findAllXTercero(tercero);
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void eliminar(Anuncio anuncio) {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.anuncioHome.remove(anuncio);

			enunciado.append(bundle.getString("label3"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(anuncio.getIntpkanu());

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, enunciado.toString()));
			log.info(bundle.getString("label3"));
		} catch (Exception e) {

			enunciado.append(bundle.getString("IODErr6"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(bundle.getString("label22"));

			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, enunciado.toString()));
			log.error(bundle.getString("IODErr6"), e);
		}

		llenarAnuncios();
	}

	public void guardar() {
		StringBuilder enunciado = new StringBuilder();
		try {
			this.anuncioHome.persist(this.anuncio);

			enunciado.append(bundle.getString("label20"));
			enunciado.append(Constantes.VACIO);
			enunciado.append(anuncio.getIntpkanu());

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
