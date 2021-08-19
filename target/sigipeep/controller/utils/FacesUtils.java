package utils;

import java.text.Normalizer;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public class FacesUtils {

	public static String normalizeFileNameString(String cadena) {
		String cadenaNormalize = Normalizer.normalize(cadena.toUpperCase(), Normalizer.Form.NFD);
		return cadenaNormalize.replaceAll("[^\\p{ASCII}]", "").replaceAll(" ", "_");
	}
	
	 public static ExternalContext getExternalContext() {
	        FacesContext fc = FacesContext.getCurrentInstance();
	        return fc.getExternalContext();
	    }

}