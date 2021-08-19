package com.jee.services.publico;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.jee.entity.listas.Administradora;
import com.jee.entity.listas.Barrios;
import com.jee.entity.listas.Comunas;
import com.jee.entity.listas.Genero;
import com.jee.entity.listas.InstitucionEducativa;
import com.jee.entity.listas.NivelEstudio;
import com.jee.entity.listas.TipoDocumento;
import com.jee.entity.seguridad.Usuario;
import com.jee.entity.utils.ConstantesPublico;

@Stateless
@Local
public class PublicoSessionEJBBean {

	@PersistenceContext(unitName = "Model")
	private EntityManager em;

	@Resource
	SessionContext ctx;

	public List<Genero> getGeneroList() throws Exception {
		List<Genero> list = null;
		StringBuilder ejbql = new StringBuilder("select o from Genero o ");
		ejbql.append("where o.estado = :estado  order by o.id asc");

		Query query = this.em.createQuery(ejbql.toString());
		query.setParameter("estado", Genero.Estado.ACTIVO);
		list = query.getResultList();
		return list;
	}

	public List<Comunas> getComunasList() throws Exception {
		
		List<Comunas> list = null;
		StringBuilder ejbql = new StringBuilder("select o from Comunas o ");
		ejbql.append("where o.estado = :estado  order by o.id asc");

		Query query = this.em.createQuery(ejbql.toString());
		query.setParameter("estado", Comunas.Estado.ACTIVO);
		list = query.getResultList();
		return list;
	}
	
public List<Barrios> getBarriosList() throws Exception {
		
		List<Barrios> list = null;
		StringBuilder ejbql = new StringBuilder("select o from Barrios o ");
		ejbql.append("where o.estado = :estado  order by o.id asc");

		Query query = this.em.createQuery(ejbql.toString());
		query.setParameter("estado", Barrios.Estado.ACTIVO);
		list = query.getResultList();
		return list;
	}


	public List<TipoDocumento> getTipoDocumentoIdentificacionList() throws Exception {
		List<TipoDocumento> list = null;
		StringBuilder ejbql = new StringBuilder("select o from TipoDocumentoIdentificacion o ");
		ejbql.append("where o.estado = :estado  order by o.id asc");
		
		Query query = this.em.createQuery(ejbql.toString());
		query.setParameter("estado", TipoDocumento.Estado.ACTIVO);
		list = query.getResultList();
		return list;
	}
	
	public List<InstitucionEducativa> getInstitucionEducativaList() throws Exception {
		List<InstitucionEducativa> list = null;
		StringBuilder ejbql = new StringBuilder("select o from InstitucionEducativa o ");
		//ejbql.append("where o.estado = :estado  order by o.id asc");
		
		Query query = this.em.createQuery(ejbql.toString());
		//query.setParameter("estado", InstitucionEducativa.Estado.ACTIVO);
		list = query.getResultList();
		return list;
	}
	
	public List<Administradora> getAdministradoraEpsList() throws Exception {
		List<Administradora> list = null;
		StringBuilder ejbql = new StringBuilder("select o from Administradora o ");
		ejbql.append("where o.tipoAdministradora = :tipoadministradora ");
		ejbql.append("and o.estado = :estado  order by o.id asc");
		
		Query query = this.em.createQuery(ejbql.toString());
		query.setParameter("estado", Administradora.Estado.ACTIVO);
		query.setParameter("tipoadministradora", ConstantesPublico.ADMINISTRADORA_EPS);
		list = query.getResultList();
		return list;
	}
	
	public List<Administradora> getAdministradoraAfpList() throws Exception {
		List<Administradora> list = null;
		StringBuilder ejbql = new StringBuilder("select o from Administradora o ");
		ejbql.append("where o.tipoAdministradora = :tipoadministradora ");
		ejbql.append("and o.estado = :estado  order by o.id asc");
		
		Query query = this.em.createQuery(ejbql.toString());
		query.setParameter("estado", Administradora.Estado.ACTIVO);
		query.setParameter("tipoadministradora", ConstantesPublico.ADMINISTRADORA_AFP);
		list = query.getResultList();
		return list;
	}
	
	public List<Administradora> getAdministradoraArlList() throws Exception {
		List<Administradora> list = null;
		StringBuilder ejbql = new StringBuilder("select o from Administradora o ");
		ejbql.append("where o.tipoAdministradora = :tipoadministradora ");
		ejbql.append("and o.estado = :estado  order by o.id asc");
		
		Query query = this.em.createQuery(ejbql.toString());
		query.setParameter("estado", Administradora.Estado.ACTIVO);
		query.setParameter("tipoadministradora", ConstantesPublico.ADMINISTRADORA_ARL);
		list = query.getResultList();
		return list;
	}
	
	public List<NivelEstudio> getNivelEstudioList() throws Exception {
		List<NivelEstudio> list = null;
		StringBuilder ejbql = new StringBuilder("select o from NivelEstudio o ");
		ejbql.append("where o.estado = :estado  order by o.id asc");
		
		Query query = this.em.createQuery(ejbql.toString());
		query.setParameter("estado", NivelEstudio.Estado.ACTIVO);
		list = query.getResultList();
		return list;
	}

}
