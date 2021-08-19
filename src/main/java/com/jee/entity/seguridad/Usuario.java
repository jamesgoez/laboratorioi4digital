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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.jee.entity.Persona;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "usuario", schema = "sigipeep")
@NamedQueries({ @NamedQuery(name = "Usuario.findAll", query = "select o from Usuario o") })

public class Usuario implements Serializable {

	private static final long serialVersionUID = -1544807416845657079L;

	public enum Estado {
		ACTIVO, INACTIVO
	}
	
    public enum ChangePassword{
        SI,NO
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(nullable = false)
    @Getter private Long id;
    
    @OneToOne
    @JoinColumn(name = "id_persona")
    @Getter @Setter private Persona persona;

    @Column(length = 100)
    @Getter @Setter private String username;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    @Getter @Setter private Usuario.Estado estado;

    @Column(name = "STR_PASSWORD", length = 100)
    @Setter private String password;

    @Column(length = 2)
    @Enumerated(EnumType.STRING)
    @Getter @Setter private Usuario.ChangePassword changePassword;

    @Transient
    @Getter @Setter private String passwordold;

    @Transient
    @Getter @Setter private String newpassword;

    @Transient
    @Getter @Setter private String confirmpassword;

    public Usuario() {
    }

}
