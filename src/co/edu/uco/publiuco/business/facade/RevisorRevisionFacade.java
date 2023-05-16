package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.RevisorRevisionDTO;

import java.util.List;
import java.util.UUID;

public interface RevisorRevisionFacade {
    void register(RevisorRevisionDTO dto);

    List<RevisorRevisionDTO> list(RevisorRevisionDTO dto);

    void modify(RevisorRevisionDTO dto);

    void drop(UUID dto);
}
