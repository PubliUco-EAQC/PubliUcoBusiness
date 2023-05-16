package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.CategoriaAdministradorCategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface CategoriaAdministradorCategoriaFacade {
    void register(CategoriaAdministradorCategoriaDTO dto);

    List<CategoriaAdministradorCategoriaDTO> list(CategoriaAdministradorCategoriaDTO dto);

    void modify(CategoriaAdministradorCategoriaDTO dto);

    void drop(UUID dto);
}
