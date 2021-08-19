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
@Table(name = "barrios", schema = "sigipeep")
public class Barrios implements Serializable, BaseEntity{

	private static final long serialVersionUID = -1949213760259983520L;
	
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
    @JoinColumn(name = "id_comuna")
    @Getter @Setter 
    private Comunas comunas;

	@Column(length = 100)
	@Getter
	@Setter
	private String nombre;
	
	@Column(nullable = false, length = 20)
	@Enumerated(EnumType.STRING)
	@Getter
	@Setter
	private Barrios.Estado estado;
	
	
	@Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Barrios)) {
            return false;
        }
        final Barrios other = (Barrios) object;
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
