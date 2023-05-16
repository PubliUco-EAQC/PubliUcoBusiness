package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.TipoReporteDTO;

import java.util.List;

public interface TipoReporteFacade {
    void register(TipoReporteDTO dto);

    List<TipoReporteDTO> list(TipoReporteDTO dto);

}
