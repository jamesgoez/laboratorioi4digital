package com.jee.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jee.entity.listas.ProcesosTransversales;
import com.jee.entity.matriz.Acciones;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "p_acciones", schema = "sigipeep")

public class P_Acciones implements Serializable {

	private static final long serialVersionUID = -30565047101706844L;

	public enum Estado {
		ACTIVO, INACTIVO
	}
	
	public enum ConsentimientoInformado {
		SI, NO
	}

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_p_persona")
	@Getter
	@Setter
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name = "id_procesostransversales")
	@Getter
	@Setter
	private ProcesosTransversales procesosTransversales;
	
	@ManyToOne
	@JoinColumn(name = "id_acciones")
	@Getter
	@Setter
	private Acciones acciones;
	
	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecharegistro;
	
	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaaccion;
	

}
