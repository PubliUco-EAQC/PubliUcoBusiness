package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.CategoriaDTO;

import java.util.List;
import java.util.UUID;

public interface CategoriaFacade {
    void register(CategoriaDTO dto);

    List<CategoriaDTO> list(CategoriaDTO dto);

    void modify(CategoriaDTO dto);

    void drop(UUID dto);
}
