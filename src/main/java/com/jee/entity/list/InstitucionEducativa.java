package com.jee.entity.listas;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "institucioneducativa", schema = "sigipeep")
public class InstitucionEducativa implements Serializable, BaseEntity {

	private static final long serialVersionUID = 5552074997269732198L;

	public enum Estado {
		ACTIVO, INACTIVO
	}

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_barrios")
	@Getter
	@Setter
	private Barrios barrio;
	
	@ManyToOne
	@JoinColumn(name = "id_nucleos")
	@Getter
	@Setter
	private Nucleos nucleo;
	
	
	@Column(length = 100)
	@Getter
	@Setter
	private String nombre;
	
	
	
	@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof InstitucionEducativa)) {
            return false;
        }
        final InstitucionEducativa other = (InstitucionEducativa) object;
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
