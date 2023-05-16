package co.edu.uco.publiuco.business.facade;

import co.edu.uco.publiuco.dto.HistorialAccesoPublicacionDTO;

import java.util.List;
import java.util.UUID;

public interface HistorialAccesoPublicacionFacade {
    void register(HistorialAccesoPublicacionDTO dto);

    List<HistorialAccesoPublicacionDTO> list(HistorialAccesoPublicacionDTO dto);

    void modify(HistorialAccesoPublicacionDTO dto);

    void drop(UUID dto);
}
