package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoComentarioRevisorDomain;
import co.edu.uco.publiuco.dto.TipoComentarioRevisorDTO;
import co.edu.uco.publiuco.entities.TipoComentarioRevisorEntity;

import java.util.List;

public final class TipoComentarioRevisorAssembler implements Assembler<TipoComentarioRevisorDomain, TipoComentarioRevisorDTO, TipoComentarioRevisorEntity> {
    public static final TipoComentarioRevisorAssembler INSTANCE = new TipoComentarioRevisorAssembler();
    public static TipoComentarioRevisorAssembler getInstance() { return INSTANCE; }
    private TipoComentarioRevisorAssembler(){
        super();
    }
    @Override
    public TipoComentarioRevisorDTO toDTOFromDomain(TipoComentarioRevisorDomain domain) {
        return TipoComentarioRevisorDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoComentarioRevisorDomain toDomainFromDTO(TipoComentarioRevisorDTO dto) {
        return new TipoComentarioRevisorDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoComentarioRevisorEntity toEntityFromDomain(TipoComentarioRevisorDomain domain) {
        return new TipoComentarioRevisorEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoComentarioRevisorDomain toDomainFromEntity(TipoComentarioRevisorEntity entity) {
        return new TipoComentarioRevisorDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }

    @Override
    public List<TipoComentarioRevisorDomain> toDomainFromEntityList(List<TipoComentarioRevisorEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<TipoComentarioRevisorDomain> toDomainFromDTOList(List<TipoComentarioRevisorDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<TipoComentarioRevisorDTO> toDTOFromDomainList(List<TipoComentarioRevisorDomain> domainList) {
        return null;
    }
}
