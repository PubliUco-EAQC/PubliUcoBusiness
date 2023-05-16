package co.edu.uco.publiuco.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.domain.EscritorDomain;

public interface EscritorBusiness {
	
	void register(EscritorDomain domain);

	List<EscritorDomain> list(EscritorDomain domain);

	void modify(EscritorDomain domain);

	void drop(UUID domain);

}
