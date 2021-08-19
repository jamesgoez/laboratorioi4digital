package com.jee.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jee.entity.listas.Administradora;
import com.jee.entity.listas.Barrios;
import com.jee.entity.listas.Genero;
import com.jee.entity.listas.InstitucionEducativa;
import com.jee.entity.listas.NivelEstudio;
import com.jee.entity.listas.TipoDocumento;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "p_persona", schema = "sigipeep")

public class Persona implements Serializable {

	private static final long serialVersionUID = -449792970742396865L;

	public enum Estado {
		ACTIVO, INACTIVO
	}

	public enum ChangePassword {
		SI, NO
	}
	
	public Persona () {
		this.setGenero(new Genero());
		this.setBarrrio(new Barrios());
		this.setInstitucionEducativa(new InstitucionEducativa());
		this.setEps(new Administradora());
		this.setAfp(new Administradora());
		this.setArl(new Administradora());
		this.setNivelEstudio(new NivelEstudio());
	}

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_tipodocumentoidentificacion")
	@Getter
	@Setter
	private TipoDocumento tipoDocumentoIdentificacion;

	@ManyToOne
	@JoinColumn(name = "id_genero")
	@Getter
	@Setter
	private Genero genero;

	@ManyToOne
	@JoinColumn(name = "id_barrio")
	@Getter
	@Setter
	private Barrios barrrio;
	
	@ManyToOne
	@JoinColumn(name = "id_institucioneducativa")
	@Getter
	@Setter
	private InstitucionEducativa institucionEducativa;
	
	@ManyToOne
	@JoinColumn(name = "id_administradoraeps")
	@Getter
	@Setter
	private Administradora eps;
	
	@ManyToOne
	@JoinColumn(name = "id_administradoraafp")
	@Getter
	@Setter
	private Administradora afp;
	
	@ManyToOne
	@JoinColumn(name = "id_administradoraarl")
	@Getter
	@Setter
	private Administradora arl;
	
	@ManyToOne
	@JoinColumn(name = "id_nivelestudio")
	@Getter
	@Setter
	private NivelEstudio nivelEstudio;
	
	
	@Column(length = 100)
	@Getter
	@Setter
	private String numeroIdentificacion;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaExpedicionIdentificacion;

	@Column(nullable = false, length = 100)
	@Getter
	@Setter
	private String nombre1;

	@Column(length = 100)
	@Getter
	@Setter
	private String nombre2;

	@Column(nullable = false,length = 100)
	@Getter
	@Setter
	private String apellido1;

	@Column(length = 100)
	@Getter
	@Setter
	private String apellido2;

	@Column(length = 100)
	@Getter
	@Setter
	private String tituloProfesion;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;

	@Column(length = 100)
	@Getter
	@Setter
	private String correoPersonal;

	@Column(length = 100)
	@Getter
	@Setter
	private String correoInstitucional;

	@Column(length = 30)
	@Getter
	@Setter
	private String celular;

	@Column(length = 50)
	@Getter
	@Setter
	private String direccion;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaIngreso;

	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaRetiro;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private Persona.Estado estado;

	public String getNombreCompleto() {
		return this.nombre1 + " " + (this.nombre2 != null ? this.nombre2 + " " : "") + apellido1 + " "
				+ (this.apellido2 != null ? this.apellido2 + " " : "");
	}

}
