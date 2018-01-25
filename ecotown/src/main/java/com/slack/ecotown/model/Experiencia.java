package com.slack.ecotown.model;

// Generated 6/12/2017 11:05:32 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Experiencia generated by hbm2java
 */
@Entity
@Table(name = "experiencia", schema = "public")
public class Experiencia implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int intpkexp;
	private Tercero tercero;
	private Localidad localidad;
	private String strcrgo;
	private String stremprsa;
	private Date dateinco;
	private Date datefn;
	private String strdscrpcn;

	public Experiencia() {
	}

	public Experiencia(int intpkexp) {
		this.intpkexp = intpkexp;
	}

	public Experiencia(int intpkexp, Tercero tercero, Localidad localidad, String strcrgo, String stremprsa, Date dateinco, Date datefn,
			String strdscrpcn) {
		this.intpkexp = intpkexp;
		this.tercero = tercero;
		this.localidad = localidad;
		this.strcrgo = strcrgo;
		this.stremprsa = stremprsa;
		this.dateinco = dateinco;
		this.datefn = datefn;
		this.strdscrpcn = strdscrpcn;
	}

	@Id
	@SequenceGenerator(name = "experiencia_intpkexp_seq", sequenceName = "public.experiencia_intpkexp_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "experiencia_intpkexp_seq")
	@Column(name = "intpkexp", unique = true, nullable = false)
	public int getIntpkexp() {
		return this.intpkexp;
	}

	public void setIntpkexp(int intpkexp) {
		this.intpkexp = intpkexp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "intpkter")
	public Tercero getTercero() {
		return this.tercero;
	}

	public void setTercero(Tercero tercero) {
		this.tercero = tercero;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "strpkloc")
	public Localidad getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	@Column(name = "strcrgo", length = 100)
	public String getStrcrgo() {
		return this.strcrgo;
	}

	public void setStrcrgo(String strcrgo) {
		this.strcrgo = strcrgo;
	}

	@Column(name = "stremprsa", length = 100)
	public String getStremprsa() {
		return this.stremprsa;
	}

	public void setStremprsa(String stremprsa) {
		this.stremprsa = stremprsa;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dateinco", length = 13)
	public Date getDateinco() {
		return this.dateinco;
	}

	public void setDateinco(Date dateinco) {
		this.dateinco = dateinco;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "datefn", length = 13)
	public Date getDatefn() {
		return this.datefn;
	}

	public void setDatefn(Date datefn) {
		this.datefn = datefn;
	}

	@Column(name = "strdscrpcn", length = 200)
	public String getStrdscrpcn() {
		return this.strdscrpcn;
	}

	public void setStrdscrpcn(String strdscrpcn) {
		this.strdscrpcn = strdscrpcn;
	}

}
