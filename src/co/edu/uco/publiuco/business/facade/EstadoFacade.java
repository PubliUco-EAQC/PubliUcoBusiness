package co.edu.uco.publiuco.business.facade;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.dto.EstadoDTO;

public interface EstadoFacade {
	
	void register(EstadoDTO dto);
	
	List<EstadoDTO> list(EstadoDTO dto);
	
	void modify(EstadoDTO dto);
	
	void drop(UUID dto);
}
