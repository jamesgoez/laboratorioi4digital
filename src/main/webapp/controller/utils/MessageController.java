package utils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageController {

	private String getComponente(String componente) {
		if (componente.isBlank()) {
			return "msgGrowl";
		} else {
			return null;
		}

	}
	
	private String getTitulo_Info(String titulo) {
		if (titulo.isBlank()) {
			return "Confirmación:";
		} else {
			return titulo;
		}

	}
	private String getTitulo_Fatal(String titulo) {
		if (titulo.isBlank()) {
			return "Error:";
		} else {
			return titulo;
		}

	}
	private String getTitulo_Warn(String titulo) {
		if (titulo.isBlank()) {
			return "Advertencia:";
		} else {
			return titulo;
		}

	}

	public void addMessageInfo(String componente, String titulo, String mensaje) {
		FacesContext.getCurrentInstance().addMessage(this.getComponente(componente), new FacesMessage(FacesMessage.SEVERITY_INFO, this.getTitulo_Info(titulo), mensaje));

	}

	public void addMessageFatal(String componente, String titulo, String mensaje) {
		FacesContext.getCurrentInstance().addMessage(this.getComponente(componente), new FacesMessage(FacesMessage.SEVERITY_FATAL, this.getTitulo_Fatal(titulo), mensaje));

	}

	public void addMessageWarn(String componente, String titulo, String mensaje) {
		FacesContext.getCurrentInstance().addMessage(this.getComponente(componente), new FacesMessage(FacesMessage.SEVERITY_WARN, this.getTitulo_Warn(titulo), mensaje));

	}

}
