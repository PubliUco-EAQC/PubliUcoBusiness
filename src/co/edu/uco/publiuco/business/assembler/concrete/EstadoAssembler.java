package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.entities.EstadoEntity;


public final class EstadoAssembler implements Assembler<EstadoDomain, EstadoDTO, EstadoEntity> {
    public static final EstadoAssembler INSTANCE = new EstadoAssembler();
    public static EstadoAssembler getInstance() { return INSTANCE; }
    private EstadoAssembler(){
        super();
    }
    @Override
    public EstadoDTO toDTOFromDomain(EstadoDomain domain) {
        return EstadoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).
                setTipoEstado(TipoEstadoAssembler.getInstance().toDTOFromDomain(domain.getTipoEstado()));
    }

    @Override
    public EstadoDomain toDomainFromDTO(EstadoDTO dto) {
        return new EstadoDomain(dto.getIdentificador(),dto.getNombre(), TipoEstadoAssembler.getInstance().toDomainFromDTO(dto.getTipoEstado()));
    }

    @Override
    public EstadoEntity toEntityFromDomain(EstadoDomain domain) {
        return new EstadoEntity(domain.getIdentificador(),domain.getNombre(), TipoEstadoAssembler.getInstance().toEntityFromDomain(domain.getTipoEstado()));
    }

    @Override
    public EstadoDomain toDomainFromEntity(EstadoEntity entity) {
        return new EstadoDomain(entity.getIdentificador(), entity.getNombre(), TipoEstadoAssembler.getInstance().toDomainFromEntity(entity.getTipoEstado()));
    }
}
