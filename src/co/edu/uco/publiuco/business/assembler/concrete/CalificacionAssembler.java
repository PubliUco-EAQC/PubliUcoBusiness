package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.CalificacionDomain;
import co.edu.uco.publiuco.dto.CalificacionDTO;
import co.edu.uco.publiuco.entities.CalificacionEntity;

public final class CalificacionAssembler implements Assembler<CalificacionDomain, CalificacionDTO, CalificacionEntity> {
    public static final CalificacionAssembler INSTANCE = new CalificacionAssembler();
    public static CalificacionAssembler getInstance() { return INSTANCE; }
    private CalificacionAssembler(){
        super();
    }
    @Override
    public CalificacionDTO toDTOFromDomain(CalificacionDomain domain) {
        return CalificacionDTO.create().setCalificacion(domain.getCalificacion()).setFechaCalificacion(domain.getFechaCalificacion()).setLector(LectorAssembler.getInstance().toDTOFromDomain(domain.getLector()))
                .setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion())).setCalificacion(domain.getCalificacion());
    }

    @Override
    public CalificacionDomain toDomainFromDTO(CalificacionDTO dto) {
        return new CalificacionDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()), LectorAssembler.getInstance().toDomainFromDTO(dto.getLector()), dto.getFechaCalificacion(),
                dto.getCalificacion());
    }

    @Override
    public CalificacionEntity toEntityFromDomain(CalificacionDomain domain) {
        return new CalificacionEntity(domain.getIdentificador(),PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()), LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()), domain.getFechaCalificacion(), domain.getCalificacion());
    }

    @Override
    public CalificacionDomain toDomainFromEntity(CalificacionEntity entity) {
        return new CalificacionDomain(entity.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()), LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()),entity.getFechaCalificacion(), entity.getCalificacion());
    }
}
