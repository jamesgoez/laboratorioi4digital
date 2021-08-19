package seguridad.backing;
import java.io.Serializable;

import javax.inject.Inject;

public class BaseBeanSeguridad implements Serializable {

	private static final long serialVersionUID = -5122984115115957530L;

	public BaseBeanSeguridad() {

	}

	public DelegateSeguridad getSeguridadDelegate() {
		return seguridadDelegate;
	}

	public void setSeguridadDelegate(DelegateSeguridad seguridadDelegate) {
		this.seguridadDelegate = seguridadDelegate;
	}

	@Inject
	private DelegateSeguridad seguridadDelegate;

}
