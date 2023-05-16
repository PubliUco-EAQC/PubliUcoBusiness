package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.CalificacionDTO;

import java.util.List;
import java.util.UUID;

public interface CalificacionFacade {
    void register(CalificacionDTO dto);

    List<CalificacionDTO> list(CalificacionDTO dto);

    void modify(CalificacionDTO dto);

    void drop(UUID dto);
}
