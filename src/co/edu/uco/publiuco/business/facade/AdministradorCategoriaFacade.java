package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface AdministradorCategoriaFacade {
    void register(AdministradorCategoriaDTO dto);

    List<AdministradorCategoriaDTO> list(AdministradorCategoriaDTO dto);

    void modify(AdministradorCategoriaDTO dto);

    void drop(UUID dto);
}
