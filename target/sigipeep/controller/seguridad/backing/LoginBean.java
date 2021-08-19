package seguridad.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import com.jee.entity.seguridad.Usuario;

import lombok.Getter;
import lombok.Setter;
import utils.MessageController;
import utils.EncodeController;

@RequestScoped
@Named()
public class LoginBean extends BaseBeanSeguridad {

	private static final long serialVersionUID = 7565953441998035080L;

	@Getter
	@Setter
	private Usuario usuario;

	@Getter
	@Setter
	private String username;
	@Getter
	@Setter
	private String password;

	@Getter
	@Setter
	private boolean renderedValidateUser = false;

	MessageController mensaje = new MessageController();

	
	public void validateUsuario() {
		try {

			if (!username.equals("")) {
				boolean validateusuario = super.getSeguridadDelegate()
						.validateUserSession(username.trim().toLowerCase());

				if (validateusuario == true) {
					this.renderedValidateUser = true;
				} else {
					this.renderedValidateUser = false;
					this.mensaje.addMessageFatal("", "",
							"El usuario no es valido para ingresar al sistema o esta inactivo.");
				}
			}
		} catch (Exception e) {
			this.mensaje.addMessageFatal("", "Error en el sistema validateUsuario(): ", e.getMessage());
		}
	}

	public void cancelValidateUsuario() {
		try {

			renderedValidateUser = false;
			setUsername("");

			PrimeFaces.current().ajax().update(":iniciarSesion:panelLogin");
		} catch (Exception e) {
			mensaje.addMessageFatal("", "Error en el sistema cancelValidateUsuario(): ", e.getMessage());
		}
	}

	public void validateUsuarioPassword() {
		try {

			this.usuario = null;

			if (!username.equals("") && !password.equals("")) {

				this.usuario = super.getSeguridadDelegate().validateUserPasswordSession(username.trim().toLowerCase(),
						EncodeController.encryptPassphrase(password));

				if (this.usuario != null) {

				} else {
					this.usuario = null;
					mensaje.addMessageFatal("", "", "La contraseña no es válida para ingresar al sistema");
				}

			} else {
				this.usuario = null;
			}
		} catch (Exception e) {
			mensaje.addMessageFatal("", "Error en el sistema validateUsuarioPassword(): ", e.getMessage());
		}
	}

}
