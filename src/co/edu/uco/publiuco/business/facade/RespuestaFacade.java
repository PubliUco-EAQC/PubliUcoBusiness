package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.RespuestaDTO;

import java.util.List;
import java.util.UUID;

public interface RespuestaFacade {
    void register(RespuestaDTO dto);

    List<RespuestaDTO> list(RespuestaDTO dto);

    void modify(RespuestaDTO dto);

    void drop(UUID dto);
}
