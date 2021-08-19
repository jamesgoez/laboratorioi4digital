package seguridad.backing;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.jee.entity.seguridad.Usuario;

import utils.EncodeController;
import utils.FacesUtils;
import utils.MessageController;
import lombok.Getter;
import lombok.Setter;

@RequestScoped
@Named()

public class SeguridadBean extends BaseBeanSeguridad {


	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private List<Usuario> usuarioList = null;
	@Getter
	@Setter
	private Usuario usuario;

	MessageController mensaje = new MessageController();

	private void preparateCrearUsuario() {

	}

	public void newUsuario() {
		try {
			if (this.usuario.getNewpassword().equals(this.usuario.getConfirmpassword())) {
				this.usuario.setPassword(EncodeController.encryptPassphrase(this.usuario.getConfirmpassword()));
				this.usuario.setChangePassword(Usuario.ChangePassword.SI);
				this.usuario = super.getSeguridadDelegate().persistUsuario(this.usuario);
				this.usuarioList.add(this.usuario);
				mensaje.addMessageInfo("msgMenu", "Correcto", "Usuario creado correctamente");
				this.usuario = new Usuario();

			} else {
				mensaje.addMessageWarn("msgMenu", "", "Las contraseñas ingresadas no coinciden");
			}
		} catch (Exception e) {
			mensaje.addMessageFatal("msgMenu", "Error en el Sistema", "newUsuario(): " + e.getMessage());
		}
	}
	
	public void goNuevoUsuario() throws Exception {
		
		
		this.usuarioList = super.getSeguridadDelegate().getUsuarioList();

	}
	
	public void closeNewUsuario() {
		try {
			
		} catch (Exception e) {
			mensaje.addMessageFatal("msgMenu", "Error en el Sistema", "closeNewUsuario(): " + e.getMessage());
		}
	}

	public void formatUsername() {

		if ((this.usuario.getPersona().getNombre1() != null && !this.usuario.getPersona().getNombre1().isEmpty())
				&& (this.usuario.getPersona().getApellido1() != null && !this.usuario.getPersona().getApellido1().isEmpty())
				&& (this.usuario.getPersona().getNumeroIdentificacion() != null && !this.usuario.getPersona().getNumeroIdentificacion().isEmpty())) {
			String primerNombre = this.usuario.getPersona().getNombre1().trim().split(" ")[0];
			String primerApellido = this.usuario.getPersona().getApellido1().trim().split(" ")[0];
			String digitosCedula = this.usuario.getPersona().getNumeroIdentificacion().substring(this.usuario.getPersona().getNumeroIdentificacion().length() - 2,
					this.usuario.getPersona().getNumeroIdentificacion().length());
			String username = FacesUtils.normalizeFileNameString(primerNombre + "." + primerApellido + digitosCedula);
			this.usuario.setUsername(username.toLowerCase());
		}
	}

	

}