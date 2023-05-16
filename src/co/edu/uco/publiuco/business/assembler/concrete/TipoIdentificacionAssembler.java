package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoIdentificacionDomain;
import co.edu.uco.publiuco.dto.TipoIdentificacionDTO;
import co.edu.uco.publiuco.entities.TipoIdentificacionEntity;

import java.util.List;

public final class TipoIdentificacionAssembler implements Assembler<TipoIdentificacionDomain, TipoIdentificacionDTO, TipoIdentificacionEntity> {
    public static final TipoIdentificacionAssembler INSTANCE = new TipoIdentificacionAssembler();
    public static TipoIdentificacionAssembler getInstance() { return INSTANCE; }
    private TipoIdentificacionAssembler(){
        super();
    }
    @Override
    public TipoIdentificacionDTO toDTOFromDomain(TipoIdentificacionDomain domain) {
        return TipoIdentificacionDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion());
    }

    @Override
    public TipoIdentificacionDomain toDomainFromDTO(TipoIdentificacionDTO dto) {
        return new TipoIdentificacionDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion());
    }

    @Override
    public TipoIdentificacionEntity toEntityFromDomain(TipoIdentificacionDomain domain) {
        return new TipoIdentificacionEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion());
    }

    @Override
    public TipoIdentificacionDomain toDomainFromEntity(TipoIdentificacionEntity entity) {
        return new TipoIdentificacionDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion());
    }

    @Override
    public List<TipoIdentificacionDomain> toDomainFromEntityList(List<TipoIdentificacionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<TipoIdentificacionDomain> toDomainFromDTOList(List<TipoIdentificacionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<TipoIdentificacionDTO> toDTOFromDomainList(List<TipoIdentificacionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
