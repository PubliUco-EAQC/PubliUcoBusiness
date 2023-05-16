package co.edu.uco.publiuco.business.business;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.domain.RespuestaDomain;

public interface RespuestaBusiness {

	void register(RespuestaDomain domain);

	List<RespuestaDomain> list(RespuestaDomain domain);
	void modify(RespuestaDomain domain);

	void drop(UUID domain);

}
