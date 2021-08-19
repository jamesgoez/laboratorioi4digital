package com.jee.entity.seguridad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rol", schema = "sigipeep")
public class Rol implements Serializable {

	private static final long serialVersionUID = -6916798911091753138L;
	
	public enum Estado {
		ACTIVO, INACTIVO
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 100)
    private String nombre;

    @Column(length = 100)
    private String descripcion;

    @Column(length = 2)
    private String tipo;

    @Column(length = 50)
    private String modulo;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private Rol.Estado estado;

    public Rol() {
    }

}
