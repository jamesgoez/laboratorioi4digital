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
@Table(name = "menuitem", schema = "sigipeep")
public class MenuItem implements Serializable {

	private static final long serialVersionUID = -6062428918552010197L;
	
	public enum Estado {
		ACTIVO, INACTIVO
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 1000)
    private String command;

    @Column(length = 2000)
    private String descryption;

    @Column(length = 100)
    private String menuitem;
    
    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private MenuItem.Estado estado;

    public MenuItem() {

    }

}
