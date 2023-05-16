package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.VersionDTO;

import java.util.List;
import java.util.UUID;

public interface VersionFacade {
    void register(VersionDTO dto);

    List<VersionDTO> list(VersionDTO dto);

    void modify(VersionDTO dto);

    void drop(UUID dto);
}
