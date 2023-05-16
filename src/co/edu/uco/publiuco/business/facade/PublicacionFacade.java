package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.PublicacionDTO;

import java.util.List;
import java.util.UUID;

public interface PublicacionFacade {
    void register(PublicacionDTO dto);

    List<PublicacionDTO> list(PublicacionDTO dto);

    void modify(PublicacionDTO dto);

    void drop(UUID dto);
}
