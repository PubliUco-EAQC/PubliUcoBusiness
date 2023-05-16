package co.edu.uco.publiuco.business.facade;


import co.edu.uco.publiuco.dto.ReporteDTO;

import java.util.List;
import java.util.UUID;

public interface ReporteFacade {
    void register(ReporteDTO dto);

    List<ReporteDTO> list(ReporteDTO dto);

    void modify(ReporteDTO dto);

    void drop(UUID dto);
}
