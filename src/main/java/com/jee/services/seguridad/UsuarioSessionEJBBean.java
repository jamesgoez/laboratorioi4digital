package com.jee.services.seguridad;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jee.entity.seguridad.Usuario;
import com.jee.entity.Persona;

@Stateless
@Local
public class UsuarioSessionEJBBean {

	@PersistenceContext(unitName = "Model")
	private EntityManager em;

	@Resource
	SessionContext ctx;

	public List<Usuario> getUsuarioList() throws Exception {
		List<Usuario> usuarioList = null;
		String ejbql = "select o from Usuario o ";
		Query query = this.em.createQuery(ejbql);
		usuarioList = query.getResultList();
		return usuarioList;
	}

	public boolean validateUserSession(String usuario) {
		try {
			Usuario user = null;
			StringBuilder ejbl = new StringBuilder(
					"select u from Usuario u where u.username = :usuario and u.activo = :activo");
			Query query = this.em.createQuery(ejbl.toString());
			query.setParameter("usuario", usuario);
			query.setParameter("activo", Usuario.Estado.ACTIVO);
			user = (Usuario) query.getSingleResult();
			boolean validateUser = false;
			if (user != null) {
				validateUser = true;
			} else {
				validateUser = false;
			}
			return validateUser;
		} catch (NoResultException e) {
			return false;
		}
	}

	public Usuario validateUserPasswordSession(String usuario, String password) {
		try {
			Usuario user = null;
			StringBuilder ejbl = new StringBuilder(
					"select u from Usuario u where u.username = :usuario and u.password = :password and u.activo = :activo");
			Query query = this.em.createQuery(ejbl.toString());
			query.setParameter("usuario", usuario);
			query.setParameter("password", password);
			query.setParameter("activo", Usuario.Estado.ACTIVO);
			user = (Usuario) query.getSingleResult();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

	private void validateUserDulicate(Usuario usuario) throws Exception {
		String ejbql = "select o from Usuario o where o.persona.numeroIdentificacion=:numeroidentificacion ";
		Query query = this.em.createQuery(ejbql);
		query.setParameter("numeroidentificacion", usuario.getPersona().getNumeroIdentificacion());

		if (query.getResultList().size() > 0) {
			Usuario usuarioResult = (Usuario) query.getSingleResult();
			throw new Exception(
					"Ya existe el usuario con identificación " + usuarioResult.getPersona().getNumeroIdentificacion()
							+ " registrado en el sistema en estado " + usuarioResult.getEstado());
		}
	}

	private Usuario preparatePersistUsuario(Usuario usuario) throws Exception {

		usuario.setEstado(Usuario.Estado.ACTIVO);
		usuario.getPersona().setEstado(Persona.Estado.ACTIVO);

		usuario.getPersona().setNumeroIdentificacion(usuario.getPersona().getNumeroIdentificacion().toUpperCase());
		usuario.getPersona().setNombre1(usuario.getPersona().getNombre1().toUpperCase());
		usuario.getPersona().setNombre2(usuario.getPersona().getNombre2().toUpperCase());
		usuario.getPersona().setApellido1(usuario.getPersona().getApellido1().toUpperCase());
		usuario.getPersona().setApellido2(usuario.getPersona().getApellido2().toUpperCase());
		usuario.getPersona().setCorreoPersonal(usuario.getPersona().getCorreoPersonal().toLowerCase());
		usuario.getPersona().setCorreoInstitucional(usuario.getPersona().getCorreoInstitucional().toLowerCase());

		return usuario;

	}

	public Usuario persistUsuario(Usuario usuario) throws Exception {
		this.validateUserDulicate(usuario);
		usuario = preparatePersistUsuario(usuario);

		em.persist(usuario.getPersona());
		usuario.setPersona(usuario.getPersona());
		em.persist(usuario);

		return usuario;
	}

}
