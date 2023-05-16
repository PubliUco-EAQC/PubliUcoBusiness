package co.edu.uco.publiuco.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.domain.VersionDomain;

public interface VersionBusiness {

	void register(VersionDomain domain);

	List<VersionDomain> list(VersionDomain domain);

	void modify(VersionDomain domain);

	void drop(UUID domain);

}
