package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.TipoEstadoDomain;

public interface TipoEstadoBusiness {

	void register(TipoEstadoDomain domain);
	
	List<TipoEstadoDomain> list(TipoEstadoDomain domain);

}
