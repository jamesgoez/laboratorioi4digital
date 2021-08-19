package seguridad.backing.publico;

import java.io.Serializable;
import javax.inject.Inject;


public class BaseBeanPublico  implements Serializable{

	private static final long serialVersionUID = -8067898228251523991L;
	
	@Inject
	private DelegatePublico publicoDelegate;

	public DelegatePublico getPublicoDelegate() {
		return publicoDelegate;
	}

	public void setPublicoDelegate(DelegatePublico publicoDelegate) {
		this.publicoDelegate = publicoDelegate;
	}

}
