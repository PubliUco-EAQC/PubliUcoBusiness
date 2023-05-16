package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.SuscripcionPublicacionDTO;

import java.util.List;
import java.util.UUID;

public interface SuscripcionPublicacionFacade {
    void register(SuscripcionPublicacionDTO dto);

    List<SuscripcionPublicacionDTO> list(SuscripcionPublicacionDTO dto);

    void modify(SuscripcionPublicacionDTO dto);

    void drop(UUID dto);
}
