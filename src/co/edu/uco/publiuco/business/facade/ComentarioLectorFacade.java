package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.ComentarioLectorDTO;

import java.util.List;
import java.util.UUID;

public interface ComentarioLectorFacade {
    void register(ComentarioLectorDTO dto);

    List<ComentarioLectorDTO> list(ComentarioLectorDTO dto);

    void modify(ComentarioLectorDTO dto);

    void drop(UUID dto);
}
