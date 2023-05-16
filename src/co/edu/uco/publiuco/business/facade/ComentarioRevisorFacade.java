package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.ComentarioRevisorDTO;

import java.util.List;
import java.util.UUID;

public interface ComentarioRevisorFacade {
    void register(ComentarioRevisorDTO dto);

    List<ComentarioRevisorDTO> list(ComentarioRevisorDTO dto);

    void modify(ComentarioRevisorDTO dto);

    void drop(UUID dto);
}
