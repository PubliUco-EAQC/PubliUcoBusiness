package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.PreferenciaCategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface PreferenciaCategoriaFacade {
    void register(PreferenciaCategoriaDTO dto);

    List<PreferenciaCategoriaDTO> list(PreferenciaCategoriaDTO dto);

    void modify(PreferenciaCategoriaDTO dto);

    void drop(UUID dto);
}
