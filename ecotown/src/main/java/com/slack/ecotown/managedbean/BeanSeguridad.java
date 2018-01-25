package com.slack.ecotown.managedbean;

import java.security.MessageDigest;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.slack.ecotown.DAO.TerceroHome;
import com.slack.ecotown.model.Tercero;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "seguridad")
@ViewScoped
public class BeanSeguridad {

	private static final Logger log = Logger.getLogger(BeanSeguridad.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Tercero tercero;
	private Seguridad seguridad;
	private MessageDigest md;

	@EJB
	private TerceroHome terceroHome;

	public Seguridad getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(Seguridad seguridad) {
		this.seguridad = seguridad;
	}

	public Tercero getTercero() {
		return tercero;
	}

	public void setTercero(Tercero tercero) {
		this.tercero = tercero;
	}

	public BeanSeguridad() {
	}

	@PostConstruct
	public void init() {
		try {
			this.seguridad = new Seguridad();
			cargarTerceroPerfil();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void cargarTerceroPerfil() {
		try {
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			this.tercero = new Tercero();
			this.tercero = ((Tercero) session.getAttribute("datosLogin"));
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void verificarUsuario() {
		try {
			if (this.tercero.getStrcntrsna().equals(encrypt(this.seguridad.getPasswordOld()))) {
				guardarTercero(encrypt(this.seguridad.getPasswordNewTwo()));
			} else {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, Constantes.VACIO, bundle.getString("IODErr9")));
			}
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void guardarTercero(String passwordNew) {
		try {
			this.tercero.setStrcntrsna(passwordNew);
			this.terceroHome.merge(this.tercero);

			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, Constantes.VACIO, bundle.getString("label16")));
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public String encrypt(String input) throws Exception {
		this.md = MessageDigest.getInstance("SHA1");
		byte[] result = this.md.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public String entrarSeguridad() {
		return "inseguridad";
	}
}
