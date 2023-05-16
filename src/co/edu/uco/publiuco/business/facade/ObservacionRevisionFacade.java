package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.ObservacionRevisionDTO;

import java.util.List;
import java.util.UUID;

public interface ObservacionRevisionFacade {
    void register(ObservacionRevisionDTO dto);

    List<ObservacionRevisionDTO> list(ObservacionRevisionDTO dto);

    void modify(ObservacionRevisionDTO dto);

    void drop(UUID dto);
}
