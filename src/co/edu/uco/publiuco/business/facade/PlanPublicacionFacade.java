package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.PlanPublicacionDTO;

import java.util.List;
import java.util.UUID;

public interface PlanPublicacionFacade {
    void register(PlanPublicacionDTO dto);

    List<PlanPublicacionDTO> list(PlanPublicacionDTO dto);

    void modify(PlanPublicacionDTO dto);

    void drop(UUID dto);
}
