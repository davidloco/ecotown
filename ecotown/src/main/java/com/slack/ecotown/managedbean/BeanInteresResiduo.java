package com.slack.ecotown.managedbean;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import com.slack.ecotown.DAO.TipoMaterialGrupoHome;
import com.slack.ecotown.model.TipoMaterialGrupo;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "interesResiduo")
@ViewScoped
public class BeanInteresResiduo {

	private static final Logger log = Logger.getLogger(BeanInteresResiduo.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private List<TipoMaterialGrupo> listTipoMaterialGrupos;

	@EJB
	private TipoMaterialGrupoHome tipoMaterialGrupoHome;

	public List<TipoMaterialGrupo> getListTipoMaterialGrupos() {
		return listTipoMaterialGrupos;
	}

	public void setListTipoMaterialGrupos(List<TipoMaterialGrupo> listTipoMaterialGrupos) {
		this.listTipoMaterialGrupos = listTipoMaterialGrupos;
	}

	public BeanInteresResiduo() {
	}

	@PostConstruct
	public void init() {
		try {
			inicializar();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void inicializar() {
		try {
			llenarTipoMaterialGrupo();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void llenarTipoMaterialGrupo() {
		try {
			this.listTipoMaterialGrupos = new ArrayList<TipoMaterialGrupo>();
			this.listTipoMaterialGrupos = this.tipoMaterialGrupoHome.findAll();
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public String entrarInteresResiduo() {
		return "ininteresresiduo";
	}

}
