package com.slack.ecotown.model;

// Generated 6/12/2017 11:05:32 PM by Hibernate Tools 3.4.0.CR1

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

/**
 * Recurso generated by hbm2java
 */
@Entity
@Table(name = "recurso", schema = "public")
public class Recurso implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int intpkrec;
	private Modulo modulo;
	private String strnmbre;
	private String strdscrpcn;
	private String stractn;
	private String stricno;

	public Recurso() {
	}

	public Recurso(int intpkrec) {
		this.intpkrec = intpkrec;
	}

	public Recurso(int intpkrec, Modulo modulo, String strnmbre, String strdscrpcn, String stractn, String stricno) {
		this.intpkrec = intpkrec;
		this.modulo = modulo;
		this.strnmbre = strnmbre;
		this.strdscrpcn = strdscrpcn;
		this.stractn = stractn;
		this.stricno = stricno;
	}

	@Id
	@SequenceGenerator(name = "recurso_intpkrec_seq", sequenceName = "public.recurso_intpkrec_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recurso_intpkrec_seq")
	@Column(name = "intpkrec", unique = true, nullable = false)
	public int getIntpkrec() {
		return this.intpkrec;
	}

	public void setIntpkrec(int intpkrec) {
		this.intpkrec = intpkrec;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "intpkmod")
	public Modulo getModulo() {
		return this.modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	@Column(name = "strnmbre", length = 50)
	public String getStrnmbre() {
		return this.strnmbre;
	}

	public void setStrnmbre(String strnmbre) {
		this.strnmbre = strnmbre;
	}

	@Column(name = "strdscrpcn", length = 150)
	public String getStrdscrpcn() {
		return this.strdscrpcn;
	}

	public void setStrdscrpcn(String strdscrpcn) {
		this.strdscrpcn = strdscrpcn;
	}

	@Column(name = "stractn", length = 50)
	public String getStractn() {
		return this.stractn;
	}

	public void setStractn(String stractn) {
		this.stractn = stractn;
	}

	@Column(name = "stricno", length = 50)
	public String getStricno() {
		return this.stricno;
	}

	public void setStricno(String stricno) {
		this.stricno = stricno;
	}

}
