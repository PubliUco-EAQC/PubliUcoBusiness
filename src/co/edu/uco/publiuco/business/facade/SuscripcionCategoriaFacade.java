package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.SuscripcionCategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface SuscripcionCategoriaFacade {
    void register(SuscripcionCategoriaDTO dto);

    List<SuscripcionCategoriaDTO> list(SuscripcionCategoriaDTO dto);

    void modify(SuscripcionCategoriaDTO dto);

    void drop(UUID dto);
}
