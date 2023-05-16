package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.TipoEstadoDTO;

import java.util.List;

public interface TipoEstadoFacade {
    void register(TipoEstadoDTO dto);

    List<TipoEstadoDTO> list(TipoEstadoDTO dto);

}
