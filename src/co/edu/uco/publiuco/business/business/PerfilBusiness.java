package co.edu.uco.publiuco.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.domain.PerfilDomain;

public interface PerfilBusiness {

	void register(PerfilDomain domain);

	List<PerfilDomain> list(PerfilDomain domain);

	void modify(PerfilDomain domain);

	void drop(UUID domain);

}
