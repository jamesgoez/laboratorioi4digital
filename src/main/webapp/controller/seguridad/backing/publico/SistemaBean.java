package seguridad.backing.publico;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import lombok.Getter;

import java.io.Serializable;

@SessionScoped
@Named

public class SistemaBean implements Serializable {

	private static final long serialVersionUID = -8896961417213153383L;
	@Getter
	private String dateTimePattern = "dd/MM/yyyy HH:mm";
	@Getter
	private String datePattern = "dd/MM/yyyy";

	@Getter
	private String requiredMessage = "Campo obligatorio *.";

}
