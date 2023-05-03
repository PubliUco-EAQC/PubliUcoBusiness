package co.edu.uco.publiuco.business.business;

import java.util.List;

import co.edu.uco.publiuco.business.domain.EstadoDomain;

public interface EstadoBusiness {
	
	void register(EstadoDomain domain);
	
	List<EstadoDomain> list(EstadoDomain domain);
	
	void modify(EstadoDomain domain);
	
	void drop(EstadoDomain domain);
	
}
