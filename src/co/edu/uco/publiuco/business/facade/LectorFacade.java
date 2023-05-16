package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.LectorDTO;

import java.util.List;
import java.util.UUID;

public interface LectorFacade {
    void register(LectorDTO dto);

    List<LectorDTO> list(LectorDTO dto);

    void modify(LectorDTO dto);

    void drop(UUID dto);
}
