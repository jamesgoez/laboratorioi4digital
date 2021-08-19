package com.jee.entity.seguridad;

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

@Entity
@Table(name = "rolmenuitem", schema = "sigipeep")
public class RolMenuItem implements Serializable {

	private static final long serialVersionUID = -4596105587443899701L;
	
	public enum Estado {
		ACTIVO, INACTIVO
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_rol", nullable = false)
	private Rol rol;

	@ManyToOne
	@JoinColumn(name = "id_menuitem", nullable = false)
	private MenuItem menuItem;

    @Column(nullable = false)
	private Long orden;

	@Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
	private RolMenuItem.Estado estado;

	public RolMenuItem() {
	}


}
