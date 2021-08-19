package seguridad.backing;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.jee.entity.seguridad.Usuario;
import com.jee.services.seguridad.UsuarioSessionEJBBean;

@Named(value = "seguridadDelegate")
@ApplicationScoped
public class DelegateSeguridad {

	private @EJB UsuarioSessionEJBBean usuarioSessionEJBBean;

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

}