package com.slack.ecotown.managedbean;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.slack.ecotown.DAO.PerfilHome;
import com.slack.ecotown.DAO.TerceroHome;
import com.slack.ecotown.model.Modulo;
import com.slack.ecotown.model.Perfil;
import com.slack.ecotown.model.Tercero;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "login")
@SessionScoped
public class Login {

	private static final Logger log = Logger.getLogger(Login.class);
	private StringBuilder userDatos = new StringBuilder();
	private List<Modulo> listModulo;
	private Datos datos = new Datos();
	private Tercero tercero;
	private Perfil perfil;
	private MessageDigest md;
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");

	@EJB
	protected TerceroHome terceroHome;

	@EJB
	protected PerfilHome perfilHome;

	public MessageDigest getMd() {
		return md;
	}

	public void setMd(MessageDigest md) {
		this.md = md;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public List<Modulo> getListModulo() {
		return listModulo;
	}

	public void setListModulo(List<Modulo> listModulo) {
		this.listModulo = listModulo;
	}

	public Tercero getTercero() {
		return tercero;
	}

	public void setTercero(Tercero tercero) {
		this.tercero = tercero;
	}

	public StringBuilder getUserDatos() {
		return userDatos;
	}

	public void setUserDatos(StringBuilder userDatos) {
		this.userDatos = userDatos;
	}

	public Login() {
	}

	public Datos getDatos() {
		return datos;
	}

	public void setDatos(Datos datos) {
		this.datos = datos;
	}

	@PostConstruct
	public void init() {
	}

	public String autenticarUsuario() {

		List<Tercero> listTerceros = this.terceroHome.findByLogin(datos.getUsername());

		if (!listTerceros.isEmpty()) {
			try {
				System.out.println(encrypt(this.datos.getPassword()));

				if (listTerceros.get(0).getStrcntrsna().equals(encrypt(datos.getPassword()))) {
					this.tercero = listTerceros.get(0);

					HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
					session.setAttribute("datosLogin", this.tercero);

					this.perfil = new Perfil();
					this.perfil = this.perfilHome.findById(this.terceroHome.findByPerxTer(this.tercero));

					this.listModulo = new ArrayList<Modulo>();
					this.listModulo = this.terceroHome.findByModxPer(this.perfil.getIntpkper());

					this.userDatos = new StringBuilder();

					this.userDatos.append(bundle.getString("label4"));
					this.userDatos.append(" ");
					this.userDatos.append(this.tercero.getStrcrrlctrnco());
					this.userDatos.append(", ");
					this.userDatos.append(bundle.getString("label6"));
					this.userDatos.append(this.tercero.getIntpkter());

					log.info(userDatos.toString());

					return "inproyectoHome";

				} else {
					FacesContext.getCurrentInstance().addMessage(null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verificar Usuario", "Contrasena Icorrecta"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "";
		} else {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Verificar Usuario", "Usuario no encontrado"));
		}
		return "";
	}

	public String encrypt(String input) throws Exception {
		md = MessageDigest.getInstance("SHA1");
		byte[] result = md.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	public void getUserPrincipal() {
		if (this.tercero == null) {
			ExternalContext lExternalContext = FacesContext.getCurrentInstance().getExternalContext();

			HttpSession lHttpSession = (HttpSession) lExternalContext.getSession(false);

			this.tercero = (Tercero) lHttpSession.getAttribute("datosLogin");

			try {
				FacesContext.getCurrentInstance().getExternalContext().redirect("/ecotown/index.xhtml");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String logout() {
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

		userDatos = new StringBuilder();

		userDatos.append(bundle.getString("label5"));
		userDatos.append(" ");
		userDatos.append(((Tercero) session.getAttribute("datosLogin")).getStrcrrlctrnco());
		userDatos.append(", ");
		userDatos.append(bundle.getString("label6"));
		userDatos.append(((Tercero) session.getAttribute("datosLogin")).getIntpkter());
		log.info(userDatos.toString());

		session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		datos = new Datos();

		return "salir";
	}
}
