package co.edu.uco.publiuco.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.domain.HistorialAccesoPublicacionDomain;

public interface HistorialAccesoPublicacionBusiness {
	
	void register(HistorialAccesoPublicacionDomain domain);

	List<HistorialAccesoPublicacionDomain> list(HistorialAccesoPublicacionDomain domain);

	void modify(HistorialAccesoPublicacionDomain domain);

	void drop(UUID domain);
}
