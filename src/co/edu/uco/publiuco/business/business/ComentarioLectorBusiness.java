package co.edu.uco.publiuco.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.domain.ComentarioLectorDomain;

public interface ComentarioLectorBusiness {

	void register(ComentarioLectorDomain domain);

	List<ComentarioLectorDomain> list(ComentarioLectorDomain domain);

	void modify(ComentarioLectorDomain domain);

	void drop(UUID domain);

}
