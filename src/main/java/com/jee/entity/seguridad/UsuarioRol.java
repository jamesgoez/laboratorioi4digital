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
@Table(name = "usuariorol", schema = "sigipeep")
public class UsuarioRol implements Serializable {

	private static final long serialVersionUID = 6341249852258105734L;

	public enum Estado {
		ACTIVO, INACTIVO
	}

    @Id
    @Column(nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_rol", nullable = false)
    private Rol rol;

    @Column(nullable = false)
    private Long orden;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    private UsuarioRol.Estado estado;



    public UsuarioRol() {
    }


}
