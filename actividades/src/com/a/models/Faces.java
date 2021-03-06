package com.a.models;
// Generated 12-12-2019 01:17:38 PM by Hibernate Tools 5.2.12.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Faces generated by hbm2java
 */
@Entity
@SuppressWarnings("serial")
@Table(name = "faces", catalog = "gestion_atv")
public class Faces implements java.io.Serializable {

	private int idFace;
	private Actividades actividades;
	private TipoFace tipoFace;
	private Date fechaActu;

	public Faces() {
	}

	public Faces(int idFace, Actividades actividades, TipoFace tipoFace, Date fechaActu) {
		this.idFace = idFace;
		this.actividades = actividades;
		this.tipoFace = tipoFace;
		this.fechaActu = fechaActu;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id_face", unique = true, nullable = false)
	public int getIdFace() {
		return this.idFace;
	}

	public void setIdFace(int idFace) {
		this.idFace = idFace;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "act", nullable = false)
	public Actividades getActividades() {
		return this.actividades;
	}

	public void setActividades(Actividades actividades) {
		this.actividades = actividades;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_face", nullable = false)
	public TipoFace getTipoFace() {
		return this.tipoFace;
	}

	public void setTipoFace(TipoFace tipoFace) {
		this.tipoFace = tipoFace;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_actu", nullable = false, length = 10)
	public Date getFechaActu() {
		return this.fechaActu;
	}

	public void setFechaActu(Date fechaActu) {
		this.fechaActu = fechaActu;
	}

}
