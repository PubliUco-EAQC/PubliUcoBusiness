package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.TipoRevisionDTO;

import java.util.List;

public interface TipoRevisionFacade {
    void register(TipoRevisionDTO dto);

    List<TipoRevisionDTO> list(TipoRevisionDTO dto);

}
