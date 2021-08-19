package seguridad.backing;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.jee.entity.listas.Administradora;
import com.jee.entity.listas.Barrios;
import com.jee.entity.listas.Comunas;
import com.jee.entity.listas.Genero;
import com.jee.entity.listas.InstitucionEducativa;
import com.jee.entity.listas.NivelEstudio;
import com.jee.entity.listas.TipoDocumento;
import com.jee.entity.seguridad.Usuario;
import com.jee.services.publico.PublicoSessionEJBBean;
import com.jee.services.seguridad.UsuarioSessionEJBBean;

@Named(value = "seguridadDelegate")
@ApplicationScoped
public class DelegateSeguridad {

	private @EJB UsuarioSessionEJBBean usuarioSessionEJBBean;
	
	private @EJB PublicoSessionEJBBean publicoSessionEJBBean;
	

	protected boolean validateUserSession(String usuario) {
		return this.usuarioSessionEJBBean.validateUserSession(usuario);
	}

	protected Usuario validateUserPasswordSession(String usuario, String password) {
		return this.usuarioSessionEJBBean.validateUserPasswordSession(usuario, password);
	}

	protected Usuario persistUsuario(Usuario usuario) throws Exception {
		return this.usuarioSessionEJBBean.persistUsuario(usuario);
	}
	
	protected List<Usuario> getUsuarioList() throws Exception {
		return this.usuarioSessionEJBBean.getUsuarioList();
	}
	
	protected List<Genero> getGeneroList() throws Exception {
		return this.publicoSessionEJBBean.getGeneroList();
	}
	
	protected List<TipoDocumento> getTipoDocumentoIdentificacionList() throws Exception {
		return this.publicoSessionEJBBean.getTipoDocumentoIdentificacionList();
	}
	
	protected List<Barrios> getBarriosList() throws Exception {
		return this.publicoSessionEJBBean.getBarriosList();
	}
	
	protected List<InstitucionEducativa> getInstitucionEducativaList() throws Exception {
		return this.publicoSessionEJBBean.getInstitucionEducativaList();
	}
	
	protected List<Administradora> getAdministradoraEpsList() throws Exception {
		return this.publicoSessionEJBBean.getAdministradoraEpsList();
	}
	
	protected List<Administradora> getAdministradoraAfpList() throws Exception {
		return this.publicoSessionEJBBean.getAdministradoraAfpList();
	}
	
	protected List<Administradora> getAdministradoraArlList() throws Exception {
		return this.publicoSessionEJBBean.getAdministradoraArlList();
	}
	
	protected List<NivelEstudio> getNivelEstudioList() throws Exception {
		return this.publicoSessionEJBBean.getNivelEstudioList();
	}
	
	

}