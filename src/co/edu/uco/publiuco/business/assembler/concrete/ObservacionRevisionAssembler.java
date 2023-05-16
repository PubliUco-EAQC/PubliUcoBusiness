package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.ObservacionRevisionDomain;
import co.edu.uco.publiuco.dto.ObservacionRevisionDTO;
import co.edu.uco.publiuco.entities.ObservacionRevisionEntity;

import java.util.List;

public final class ObservacionRevisionAssembler implements Assembler<ObservacionRevisionDomain, ObservacionRevisionDTO, ObservacionRevisionEntity> {
    public static final ObservacionRevisionAssembler INSTANCE = new ObservacionRevisionAssembler();
    public static ObservacionRevisionAssembler getInstance() { return INSTANCE; }
    private ObservacionRevisionAssembler(){
        super();
    }
    @Override
    public ObservacionRevisionDTO toDTOFromDomain(ObservacionRevisionDomain domain) {
        return ObservacionRevisionDTO.create().setIdentificador(domain.getIdentificador()).setObservacion(domain.getObservacion())
                .setFechaRevisionObservacion(domain.getFechaRevisionObservacion()).setFechaReportePublicacion(domain.getFechaReportePublicacion())
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setComentarioRevisor(ComentarioRevisorAssembler.getInstance().toDTOFromDomain(domain.getComentarioRevisor()))
                .setEscritorPublicacion(EscritorPublicacionAssembler.getInstance().toDTOFromDomain(domain.getEscritorPublicacion()));
    }

    @Override
    public ObservacionRevisionDomain toDomainFromDTO(ObservacionRevisionDTO dto) {
        return new ObservacionRevisionDomain(dto.getIdentificador(),EscritorPublicacionAssembler.getInstance().toDomainFromDTO(dto.getEscritorPublicacion()), ComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto.getComentarioRevisor()), dto.getFechaReportePublicacion(),dto.getFechaRevisionObservacion(),
                dto.getObservacion(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public ObservacionRevisionEntity toEntityFromDomain(ObservacionRevisionDomain domain) {
        return new ObservacionRevisionEntity(domain.getIdentificador(),EscritorPublicacionAssembler.getInstance().toEntityFromDomain(domain.getEscritorPublicacion()),
                ComentarioRevisorAssembler.getInstance().toEntityFromDomain(domain.getComentarioRevisor()),domain.getFechaReportePublicacion(),
                domain.getFechaRevisionObservacion(),domain.getObservacion(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public ObservacionRevisionDomain toDomainFromEntity(ObservacionRevisionEntity entity) {
        return new ObservacionRevisionDomain(entity.getIdentificador(),EscritorPublicacionAssembler.getInstance().toDomainFromEntity(entity.getEscritorPublicacion()),
                ComentarioRevisorAssembler.getInstance().toDomainFromEntity(entity.getComentarioRevisor()), entity.getFechaReportePublicacion(),
                entity.getFechaRevisionObservacion(),entity.getObservacion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<ObservacionRevisionDomain> toDomainFromEntityList(List<ObservacionRevisionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<ObservacionRevisionDomain> toDomainFromDTOList(List<ObservacionRevisionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<ObservacionRevisionDTO> toDTOFromDomainList(List<ObservacionRevisionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
