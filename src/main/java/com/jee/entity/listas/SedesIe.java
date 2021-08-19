package com.jee.entity.listas;

import java.io.Serializable;

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

import com.jee.entity.utils.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "sedesie", schema = "sigipeep")
public class SedesIe implements Serializable, BaseEntity {

	private static final long serialVersionUID = -3771643661822824619L;

	public enum Estado {
		ACTIVO, INACTIVO
	}

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_institucioneducativa")
	@Getter
	@Setter
	private InstitucionEducativa institucionEducativa;
	
	@ManyToOne
	@JoinColumn(name = "id_nucleos")
	@Getter
	@Setter
	private Nucleos nucleo;
	
	@ManyToOne
	@JoinColumn(name = "id_naturalezajuridica")
	@Getter
	@Setter
	private NaturalezaJuridica naturalezaJuridica;
	
	@ManyToOne
	@JoinColumn(name = "id_barrios")
	@Getter
	@Setter
	private Barrios barrio;
	
	@Column(length = 100)
	@Getter
	@Setter
	private String nombre;
	
	@Column(length = 500)
	@Getter
	@Setter
	private String nombrerector;
	
	@Column(length = 500)
	@Getter
	@Setter
	private String nombrecoordinador;
	
	@Column(length = 500)
	@Getter
	@Setter
	private String nombresecretaria;
	
	@Column(length = 500)
	@Getter
	@Setter
	private String direccion;
	
	@Column(length = 500)
	@Getter
	@Setter
	private String telefonos;
	
	@Column(length = 200)
	@Getter
	@Setter
	private String correo;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private SedesIe.Estado estado;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof SedesIe)) {
			return false;
		}
		final SedesIe other = (SedesIe) object;
		if (!(id == null ? other.id == null : id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int PRIME = 37;
		int result = 1;
		result = PRIME * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String getItemLabel() {
		return this.nombre;
	}

}
