package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.EscritorDTO;

import java.util.List;
import java.util.UUID;

public interface EscritorFacade {
    void register(EscritorDTO dto);

    List<EscritorDTO> list(EscritorDTO dto);

    void modify(EscritorDTO dto);

    void drop(UUID dto);
}
