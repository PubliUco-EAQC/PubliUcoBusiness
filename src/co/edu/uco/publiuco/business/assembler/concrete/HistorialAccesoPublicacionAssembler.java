package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.HistorialAccesoPublicacionDomain;
import co.edu.uco.publiuco.dto.HistorialAccesoPublicacionDTO;
import co.edu.uco.publiuco.entities.HistorialAccesoPublicacionEntity;

import java.util.List;

public final class HistorialAccesoPublicacionAssembler implements Assembler<HistorialAccesoPublicacionDomain, HistorialAccesoPublicacionDTO, HistorialAccesoPublicacionEntity> {
    public static final HistorialAccesoPublicacionAssembler INSTANCE = new HistorialAccesoPublicacionAssembler();
    public static HistorialAccesoPublicacionAssembler getInstance() { return INSTANCE; }
    private HistorialAccesoPublicacionAssembler(){
        super();
    }
    @Override
    public HistorialAccesoPublicacionDTO toDTOFromDomain(HistorialAccesoPublicacionDomain domain) {
        return HistorialAccesoPublicacionDTO.create().setIdentificador(domain.getIdentificador()).setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()))
                .setFechaAcceso(domain.getFechaAcceso()).setLector(LectorAssembler.getInstance().toDTOFromDomain(domain.getLector()));
    }

    @Override
    public HistorialAccesoPublicacionDomain toDomainFromDTO(HistorialAccesoPublicacionDTO dto) {
        return new HistorialAccesoPublicacionDomain(dto.getIdentificador(),LectorAssembler.getInstance().toDomainFromDTO(dto.getLector()),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
                dto.getFechaAcceso());
    }

    @Override
    public HistorialAccesoPublicacionEntity toEntityFromDomain(HistorialAccesoPublicacionDomain domain) {
        return new HistorialAccesoPublicacionEntity(domain.getIdentificador(), LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),
                PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()), domain.getFechaAcceso());
    }

    @Override
    public HistorialAccesoPublicacionDomain toDomainFromEntity(HistorialAccesoPublicacionEntity entity) {
        return new HistorialAccesoPublicacionDomain(entity.getIdentificador(), LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()),
                PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()), entity.getFechaAcceso());
    }

    @Override
    public List<HistorialAccesoPublicacionDomain> toDomainFromEntityList(List<HistorialAccesoPublicacionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<HistorialAccesoPublicacionDomain> toDomainFromDTOList(List<HistorialAccesoPublicacionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<HistorialAccesoPublicacionDTO> toDTOFromDomainList(List<HistorialAccesoPublicacionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
