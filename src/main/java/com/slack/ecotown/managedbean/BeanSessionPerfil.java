package com.slack.ecotown.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.slack.ecotown.DAO.PerfilHome;
import com.slack.ecotown.DAO.SectorProductivoHome;
import com.slack.ecotown.DAO.TerceroHome;
import com.slack.ecotown.DAO.TipoIdentificacionHome;
import com.slack.ecotown.model.Perfil;
import com.slack.ecotown.model.SectorProductivo;
import com.slack.ecotown.model.Tercero;
import com.slack.ecotown.model.TipoIdentificacion;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "sessionTercero")
@ViewScoped
public class BeanSessionPerfil {

	private static final Logger log = Logger.getLogger(BeanSessionPerfil.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Tercero tercero;
	private List<Perfil> listPerfil;
	private List<SectorProductivo> listSectorProductivo;
	private List<TipoIdentificacion> listTipoIdentificacion;

	@EJB
	private TerceroHome terceroHome;

	@EJB
	private PerfilHome perfilHome;

	@EJB
	private SectorProductivoHome sectorProductivoHome;

	@EJB
	private TipoIdentificacionHome tipoIdentificacionHome;

	public List<TipoIdentificacion> getListTipoIdentificacion() {
		return listTipoIdentificacion;
	}

	public void setListTipoIdentificacion(List<TipoIdentificacion> listTipoIdentificacion) {
		this.listTipoIdentificacion = listTipoIdentificacion;
	}

	public List<SectorProductivo> getListSectorProductivo() {
		return listSectorProductivo;
	}

	public void setListSectorProductivo(List<SectorProductivo> listSectorProductivo) {
		this.listSectorProductivo = listSectorProductivo;
	}

	public Tercero getTercero() {
		return tercero;
	}

	public List<Perfil> getListPerfil() {
		return listPerfil;
	}

	public void setListPerfil(List<Perfil> listPerfil) {
		this.listPerfil = listPerfil;
	}

	public void setTercero(Tercero tercero) {
		this.tercero = tercero;
	}

	public BeanSessionPerfil() {
	}

	@PostConstruct
	public void init() {
		try {
			inicializarTercero();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void inicializarTercero() {
		try {
			this.tercero = new Tercero();
			HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
			this.tercero = ((Tercero) session.getAttribute("datosLogin"));

			llenarListPerfil();
			llenarListSectorProductivo();
			llenarListTipoIdentificacion();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	private void llenarListPerfil() {
		try {
			this.listPerfil = new ArrayList<Perfil>();
			this.listPerfil = this.perfilHome.findAllActivos();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	private void llenarListSectorProductivo() {
		try {
			this.listSectorProductivo = new ArrayList<SectorProductivo>();
			this.listSectorProductivo = this.sectorProductivoHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	private void llenarListTipoIdentificacion() {
		try {
			this.listTipoIdentificacion = new ArrayList<TipoIdentificacion>();
			this.listTipoIdentificacion = this.tipoIdentificacionHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public String entrarSessionTercero() {
		return "interceroperfil";
	}

	public String actualizar() {
		System.out.println("sdasdk");
		return "";
	}
}
