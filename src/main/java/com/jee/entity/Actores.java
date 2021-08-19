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

import com.jee.entity.listas.Discapacidades;
import com.jee.entity.listas.Genero;
import com.jee.entity.listas.Grados;
import com.jee.entity.listas.GrupoEtnico;
import com.jee.entity.listas.IdentidadGenero;
import com.jee.entity.listas.InstitucionEducativa;
import com.jee.entity.listas.Jornadas;
import com.jee.entity.listas.NivelSisben;
import com.jee.entity.listas.SedesIe;
import com.jee.entity.listas.TipoActor;
import com.jee.entity.listas.TipoDocumento;
import com.jee.entity.listas.VictimasConflicto;
import com.jee.entity.listas.Vinculo;
import com.jee.entity.listas.Zona;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "p_actores", schema = "sigipeep")

public class Actores implements Serializable {

	private static final long serialVersionUID = 9027092765179814864L;

	public enum Estado {
		ACTIVO, INACTIVO
	}
	
	public enum VictimaConflicto {
		SI, NO
	}

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_tipodocumento")
	@Getter
	@Setter
	private TipoDocumento tipoDocumento;
	
	@ManyToOne
	@JoinColumn(name = "id_genero")
	@Getter
	@Setter
	private Genero genero;
	
	@ManyToOne
	@JoinColumn(name = "id_identidadgenero")
	@Getter
	@Setter
	private IdentidadGenero identidadGenero;
	
	@ManyToOne
	@JoinColumn(name = "id_grupoetnico")
	@Getter
	@Setter
	private GrupoEtnico grupoEtnico;
	
	@ManyToOne
	@JoinColumn(name = "id_tipoactor")
	@Getter
	@Setter
	private TipoActor tipoActor;
	
	@ManyToOne
	@JoinColumn(name = "id_discapacidades")
	@Getter
	@Setter
	private Discapacidades discapacidad;
	
	@ManyToOne
	@JoinColumn(name = "id_nivelsisben")
	@Getter
	@Setter
	private NivelSisben nivelSisben;
	
	@ManyToOne
	@JoinColumn(name = "id_actores")
	@Getter
	@Setter
	private Actores actor;
	
	@ManyToOne
	@JoinColumn(name = "id_vinculo")
	@Getter
	@Setter
	private Vinculo vinculo;
	
	@ManyToOne
	@JoinColumn(name = "id_institucioneducativa")
	@Getter
	@Setter
	private InstitucionEducativa institucionEducativa;
	
	@ManyToOne
	@JoinColumn(name = "id_sedesie")
	@Getter
	@Setter
	private SedesIe sedesIe;
	
	@ManyToOne
	@JoinColumn(name = "id_grados")
	@Getter
	@Setter
	private Grados grado;
	
	@ManyToOne
	@JoinColumn(name = "id_jornadas")
	@Getter
	@Setter
	private Jornadas jornada;
	
	@ManyToOne
	@JoinColumn(name = "id_victimasconflicto")
	@Getter
	@Setter
	private VictimasConflicto victimasConflicto;
	
	@ManyToOne
	@JoinColumn(name = "id_zona")
	@Getter
	@Setter
	private Zona zona;
	
	@Column(nullable = false, length = 2)
	@Getter
	@Setter
	private String discapacitado;
	
	@Column(length = 50)
	@Getter
	@Setter
	private String numeroIdentificacion;

	@Column(nullable = false, length = 50)
	@Getter
	@Setter
	private String nombre1;

	@Column(length = 50)
	@Getter
	@Setter
	private String nombre2;

	@Column(nullable = false,length = 50)
	@Getter
	@Setter
	private String apellido1;

	@Column(length = 5)
	@Getter
	@Setter
	private String apellido2;
	
	@Getter
	@Setter
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaNacimiento;
	
	@Column(nullable = false, length = 2)
	@Getter
	@Setter
	private String encuestadoSisben;

	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private Actores.VictimaConflicto victimaConflicto;
	
	@Column(length = 50)
	@Getter
	@Setter
	private String direccion;
	
	@Column(length = 100)
	@Getter
	@Setter
	private String telefonos;
	
	@Column(length = 50)
	@Getter
	@Setter
	private String correo;
	
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private Actores.Estado estado;
	

}
