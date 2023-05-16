package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.EscritorPublicacionDTO;

import java.util.List;
import java.util.UUID;

public interface EscritorPublicacionFacade {
    void register(EscritorPublicacionDTO dto);

    List<EscritorPublicacionDTO> list(EscritorPublicacionDTO dto);

    void modify(EscritorPublicacionDTO dto);

    void drop(UUID dto);
}
