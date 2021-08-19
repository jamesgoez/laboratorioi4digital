package seguridad.backing.publico;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.jee.entity.listas.Genero;
import com.jee.services.publico.PublicoSessionEJBBean;

@Named(value = "publicoDelegate")
@ApplicationScoped
public class DelegatePublico {

	private @EJB PublicoSessionEJBBean publicoSessionEJBBean;


}
