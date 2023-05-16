package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.PerfilDTO;

import java.util.List;
import java.util.UUID;

public interface PerfilFacade {
    void register(PerfilDTO dto);

    List<PerfilDTO> list(PerfilDTO dto);

    void modify(PerfilDTO dto);

    void drop(UUID dto);
}
