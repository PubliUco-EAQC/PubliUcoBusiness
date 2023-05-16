package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.RespuestaDomain;
import co.edu.uco.publiuco.dto.RespuestaDTO;
import co.edu.uco.publiuco.entities.RespuestaEntity;

import java.util.List;

public final class RespuestaAssembler implements Assembler<RespuestaDomain, RespuestaDTO, RespuestaEntity> {
    public static final RespuestaAssembler INSTANCE = new RespuestaAssembler();
    public static RespuestaAssembler getInstance() { return INSTANCE; }
    private RespuestaAssembler(){
        super();
    }
    @Override
    public RespuestaDTO toDTOFromDomain(RespuestaDomain domain) {
        return RespuestaDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public RespuestaDomain toDomainFromDTO(RespuestaDTO dto) {
        return new RespuestaDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public RespuestaEntity toEntityFromDomain(RespuestaDomain domain) {
        return new RespuestaEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public RespuestaDomain toDomainFromEntity(RespuestaEntity entity) {
        return new RespuestaDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }

    @Override
    public List<RespuestaDomain> toDomainFromEntityList(List<RespuestaEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<RespuestaDomain> toDomainFromDTOList(List<RespuestaDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<RespuestaDTO> toDTOFromDomainList(List<RespuestaDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
