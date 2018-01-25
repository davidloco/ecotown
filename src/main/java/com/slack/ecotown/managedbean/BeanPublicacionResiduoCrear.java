package com.slack.ecotown.managedbean;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.primefaces.event.FileUploadEvent;

import com.slack.ecotown.DAO.ResiduoHome;
import com.slack.ecotown.DAO.TipoMaterialGrupoHome;
import com.slack.ecotown.DAO.TipoMaterialHome;
import com.slack.ecotown.model.Residuo;
import com.slack.ecotown.model.TipoMaterial;
import com.slack.ecotown.model.TipoMaterialGrupo;
import com.slack.ecotown.util.Constantes;

/**
 * 
 * @author David Andres Betancourth Botero
 * 
 */
@ManagedBean(name = "publicacionResiduoCrear")
@ViewScoped
public class BeanPublicacionResiduoCrear {

	private static final Logger log = Logger.getLogger(BeanPublicacionResiduoCrear.class);
	private ResourceBundle bundle = ResourceBundle.getBundle("com.slack.ecotown.util.bundle");
	private Residuo residuo;
	private Integer tipoMaterialGrupo;
	private List<TipoMaterialGrupo> listTipoMaterialGrupos;
	private List<TipoMaterial> listTipoMaterial;

	@EJB
	private ResiduoHome residuoHome;

	@EJB
	private TipoMaterialHome tipoMaterialHome;

	@EJB
	private TipoMaterialGrupoHome tipoMaterialGrupoHome;

	public Integer getTipoMaterialGrupo() {
		return tipoMaterialGrupo;
	}

	public void setTipoMaterialGrupo(Integer tipoMaterialGrupo) {
		this.tipoMaterialGrupo = tipoMaterialGrupo;
	}

	public List<TipoMaterial> getListTipoMaterial() {
		return listTipoMaterial;
	}

	public void setListTipoMaterial(List<TipoMaterial> listTipoMaterial) {
		this.listTipoMaterial = listTipoMaterial;
	}

	public List<TipoMaterialGrupo> getListTipoMaterialGrupos() {
		return listTipoMaterialGrupos;
	}

	public void setListTipoMaterialGrupos(List<TipoMaterialGrupo> listTipoMaterialGrupos) {
		this.listTipoMaterialGrupos = listTipoMaterialGrupos;
	}

	public Residuo getResiduo() {
		return residuo;
	}

	public void setResiduo(Residuo residuo) {
		this.residuo = residuo;
	}

	public BeanPublicacionResiduoCrear() {
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
			this.residuo = new Residuo();
			this.listTipoMaterial = new ArrayList<TipoMaterial>();
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

	public void llenarTipoMaterial() {
		try {
			this.listTipoMaterial = new ArrayList<TipoMaterial>();
			this.listTipoMaterial = this.tipoMaterialHome.findAllXTmg(this.tipoMaterialGrupo);
		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void crearResiduo() {
		try {
			ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			String realPath = ctx.getRealPath(Constantes.SLASH);

			File archivoOld = new File(realPath + Constantes.SEPARADOR_CARPETAS_SRV + Constantes.PATH_DOCUMENTS + Constantes.SEPARADOR_CARPETAS_SRV
					+ Constantes.TMP + Constantes.SEPARADOR_CARPETAS_SRV + this.residuo.getStrnmbre());

			File archivoNew = new File(realPath + Constantes.SEPARADOR_CARPETAS_SRV + Constantes.PATH_DOCUMENTS + Constantes.SEPARADOR_CARPETAS_SRV
					+ "Prueba" + Constantes.SEPARADOR_CARPETAS_SRV);

			archivoNew.mkdir();
			FileUtils.copyFileToDirectory(archivoOld, archivoNew);
			archivoOld.delete();

			this.residuo.setDatefchpblccn(new Date());
			this.residuo.setStrrta(Constantes.SLASH + Constantes.PATH_DOCUMENTS + Constantes.SLASH + "Prueba" + Constantes.SLASH
					+ this.residuo.getStrnmbre());

		} catch (Exception e) {
			log.error(bundle.getString("IODErr4"), e);
		}
	}

	public void upload(FileUploadEvent event) {
		try {
			copyFile(event.getFile().getFileName(), event.getFile().getInputstream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void copyFile(String fileName, InputStream in) {
		try {
			ServletContext ctx = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			String realPath = ctx.getRealPath(Constantes.SLASH);

			this.residuo.setStrnmbre(fileName);

			OutputStream out = new FileOutputStream(new File(realPath + Constantes.SEPARADOR_CARPETAS_SRV + Constantes.PATH_DOCUMENTS
					+ Constantes.SEPARADOR_CARPETAS_SRV + Constantes.TMP + Constantes.SEPARADOR_CARPETAS_SRV + fileName));

			int read = 0;
			byte[] bytes = new byte[2024];

			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}

			in.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
