package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.TipoEscritorDTO;

import java.util.List;

public interface TipoEscritorFacade {
    void register(TipoEscritorDTO dto);

    List<TipoEscritorDTO> list(TipoEscritorDTO dto);

}
