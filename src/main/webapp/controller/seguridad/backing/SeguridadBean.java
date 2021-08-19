package seguridad.backing;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.jee.entity.Persona;
import com.jee.entity.listas.Administradora;
import com.jee.entity.listas.Barrios;
import com.jee.entity.listas.Comunas;
import com.jee.entity.listas.Genero;
import com.jee.entity.listas.InstitucionEducativa;
import com.jee.entity.listas.NivelEstudio;
import com.jee.entity.listas.Pais;
import com.jee.entity.listas.TipoDocumento;
import com.jee.entity.seguridad.Usuario;

import utils.EncodeController;
import utils.FacesUtils;
import utils.MessageController;
import lombok.Getter;
import lombok.Setter;

@SessionScoped
@Named(value = "seguridadBean")

public class SeguridadBean extends BaseBeanSeguridad {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private List<Usuario> usuarioList = null;
	@Getter
	@Setter
	private List<Genero> generoList = null;
	@Getter
	private List<Comunas> comunasList = null;
	@Getter
	private List<Barrios> barrriosList = null;
	@Getter
	private List<TipoDocumento> tipoDocumentoIdentificacionList = null;
	@Getter
	@Setter
	private List<InstitucionEducativa> institucionEducativaList = null;
	@Getter
	@Setter
	private List<NivelEstudio> nivelEstudioList = null;
	@Getter
	@Setter
	private List<Administradora> administradoraEpsList = null;
	@Getter
	@Setter
	private List<Administradora> administradoraArlList = null;
	@Getter
	@Setter
	private List<Administradora> administradoraAfpList = null;
	@Getter
	@Setter
	private Usuario usuario;
	@Getter
	@Setter
	private Usuario selectedUsuario;

	private Pais pais;

	MessageController mensaje = new MessageController();

	public void goModuleUsuario() throws Exception {

		this.selectedUsuario = null;
		this.usuarioList = super.getSeguridadDelegate().getUsuarioList();

		FacesUtils.getExternalContext()
				.redirect(FacesUtils.getExternalContext().getRequestContextPath() + "/usuarios/index.jsf");

	}

	public void goModuleLlamadas() throws Exception {

		FacesUtils.getExternalContext()
				.redirect(FacesUtils.getExternalContext().getRequestContextPath() + "/llamadas/index.jsf");

	}

	public void goNewLlamada() throws Exception {
		this.preparateGoNewUsuario();
		this.usuario = new Usuario();
		this.usuario.setPersona(new Persona());
		FacesUtils.getExternalContext()
				.redirect(FacesUtils.getExternalContext().getRequestContextPath() + "/llamadas/view/newLlamada.jsf");
	}

	public void closeNewLlamada() throws Exception {

		FacesUtils.getExternalContext()
				.redirect(FacesUtils.getExternalContext().getRequestContextPath() + "/llamadas/index.jsf");

	}

	public void closeModuleUsuario() throws Exception {

		FacesUtils.getExternalContext()
				.redirect(FacesUtils.getExternalContext().getRequestContextPath() + "/index.jsf");

	}

	public void saveUsuario() {
		try {
			if (this.usuario.getNewpassword().equals(this.usuario.getConfirmpassword())) {
				this.usuario.setPassword(EncodeController.encryptPassphrase(this.usuario.getConfirmpassword()));
				this.usuario.setChangePassword(Usuario.ChangePassword.SI);
				this.usuario = super.getSeguridadDelegate().persistUsuario(this.usuario);
				this.usuarioList.add(this.usuario);
				mensaje.addMessageInfo("", "Correcto", "Usuario creado correctamente");
				this.usuario = new Usuario();

			} else {
				mensaje.addMessageWarn("", "", "Las contraseñas ingresadas no coinciden");
			}
		} catch (Exception e) {
			mensaje.addMessageFatal("", "Error en el Sistema", "newUsuario(): " + e.getMessage());
		}
	}

	private void preparateGoNewUsuario() throws Exception {
		try {
			this.generoList = super.getSeguridadDelegate().getGeneroList();
			this.barrriosList = super.getSeguridadDelegate().getBarriosList();
			this.institucionEducativaList = super.getSeguridadDelegate().getInstitucionEducativaList();
			this.nivelEstudioList = super.getSeguridadDelegate().getNivelEstudioList();
			this.administradoraEpsList = super.getSeguridadDelegate().getAdministradoraEpsList();
			this.administradoraAfpList = super.getSeguridadDelegate().getAdministradoraAfpList();
			this.administradoraArlList = super.getSeguridadDelegate().getAdministradoraArlList();

			this.tipoDocumentoIdentificacionList = super.getSeguridadDelegate().getTipoDocumentoIdentificacionList();
		} catch (Exception e) {
			mensaje.addMessageFatal("", "Error en el Sistema", "preparateGoNewUsuario(): " + e.getMessage());
		}

	}

	public void goNewUsuario() throws Exception {
		this.preparateGoNewUsuario();
		this.usuario = new Usuario();
		this.usuario.setPersona(new Persona());
		
	
		FacesUtils.getExternalContext()
				.redirect(FacesUtils.getExternalContext().getRequestContextPath() + "/usuarios/view/nuevoUsuario.jsf");

	}

	public void closeNewUsuario() throws Exception {

		FacesUtils.getExternalContext()
				.redirect(FacesUtils.getExternalContext().getRequestContextPath() + "/usuarios/index.jsf");

	}

	public void formatUserName() {

		if ((this.usuario.getPersona().getNombre1() != null && !this.usuario.getPersona().getNombre1().isEmpty())
				&& (this.usuario.getPersona().getApellido1() != null
						&& !this.usuario.getPersona().getApellido1().isEmpty())
				&& (this.usuario.getPersona().getNumeroIdentificacion() != null
						&& !this.usuario.getPersona().getNumeroIdentificacion().isEmpty())) {
			String primerNombre = this.usuario.getPersona().getNombre1().trim().split(" ")[0];
			String primerApellido = this.usuario.getPersona().getApellido1().trim().split(" ")[0];
			String digitosCedula = this.usuario.getPersona().getNumeroIdentificacion().substring(
					this.usuario.getPersona().getNumeroIdentificacion().length() - 2,
					this.usuario.getPersona().getNumeroIdentificacion().length());
			String username = FacesUtils.normalizeFileNameString(primerNombre + "." + primerApellido + digitosCedula);
			this.usuario.setUsername(username.toLowerCase());
		}
	}

}