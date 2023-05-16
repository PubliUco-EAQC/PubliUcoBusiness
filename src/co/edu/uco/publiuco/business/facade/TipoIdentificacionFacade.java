package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;

import java.util.List;

public interface TipoIdentificacionFacade {
    void register(TipoIdentificacionDTO dto);

    List<TipoIdentificacionDTO> list(TipoIdentificacionDTO dto);

}
