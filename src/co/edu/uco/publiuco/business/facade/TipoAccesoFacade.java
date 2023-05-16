package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.TipoAccesoDTO;

import java.util.List;

public interface TipoAccesoFacade {
    void register(TipoAccesoDTO dto);

    List<TipoAccesoDTO> list(TipoAccesoDTO dto);

}
