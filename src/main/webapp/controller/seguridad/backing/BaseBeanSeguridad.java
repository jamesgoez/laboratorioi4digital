package seguridad.backing;
import java.io.Serializable;

import javax.inject.Inject;

import seguridad.backing.publico.DelegatePublico;

public class BaseBeanSeguridad implements Serializable {

	private static final long serialVersionUID = -5122984115115957530L;

	public BaseBeanSeguridad() {

	}
	
	@Inject
	private DelegateSeguridad seguridadDelegate;
	

	public DelegateSeguridad getSeguridadDelegate() {
		return seguridadDelegate;
	}

	public void setSeguridadDelegate(DelegateSeguridad seguridadDelegate) {
		this.seguridadDelegate = seguridadDelegate;
	}

}
