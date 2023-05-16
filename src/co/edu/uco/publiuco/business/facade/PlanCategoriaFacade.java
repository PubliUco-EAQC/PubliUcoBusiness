package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.PlanCategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface PlanCategoriaFacade {
    void register(PlanCategoriaDTO dto);

    List<PlanCategoriaDTO> list(PlanCategoriaDTO dto);

    void modify(PlanCategoriaDTO dto);

    void drop(UUID dto);
}
