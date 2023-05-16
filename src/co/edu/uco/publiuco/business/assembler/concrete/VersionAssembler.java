package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.VersionDomain;
import co.edu.uco.publiuco.dto.VersionDTO;
import co.edu.uco.publiuco.entities.VersionEntity;

import java.util.List;

public final class VersionAssembler implements Assembler<VersionDomain, VersionDTO, VersionEntity> {
    public static final VersionAssembler INSTANCE = new VersionAssembler();
    public static VersionAssembler getInstance() { return INSTANCE; }
    private VersionAssembler(){
        super();
    }
    @Override
    public VersionDTO toDTOFromDomain(VersionDomain domain) {
        return VersionDTO.create().setIdentificador(domain.getIdentificador()).setNumeroVersion(domain.getNumeroVersion())
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setCuerpo(domain.getCuerpo())
                .setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion())).setFechaCreacion(domain.getFechaCreacion())
                .setResumen(domain.getResumen()).setTitulo(domain.getTitulo()).setUltimaFechaModificacion(domain.getUltimaFechaModificacion()).setVersionAnterior(VersionAssembler.getInstance().toDTOFromDomain(domain.getVersionAnterior()));
    }

    @Override
    public VersionDomain toDomainFromDTO(VersionDTO dto) {
        return new VersionDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),VersionAssembler.getInstance().toDomainFromDTO(dto.getVersionAnterior()),
                dto.getNumeroVersion(),dto.getFechaCreacion(),dto.getUltimaFechaModificacion(),dto.getTitulo(),dto.getResumen(),dto.getCuerpo(),
                EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public VersionEntity toEntityFromDomain(VersionDomain domain) {
        return new VersionEntity(domain.getIdentificador(),PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),VersionAssembler.getInstance().toEntityFromDomain(domain.getVersionAnterior()),
                domain.getNumeroVersion(),domain.getFechaCreacion(),domain.getUltimaFechaModificacion(),domain.getTitulo(),domain.getResumen(),domain.getCuerpo(),
                EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public VersionDomain toDomainFromEntity(VersionEntity entity) {
        return new VersionDomain(entity.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()), VersionAssembler.getInstance().toDomainFromEntity(entity.getVersionAnterior()),
                entity.getNumeroVersion(),entity.getFechaCreacion(),entity.getUltimaFechaModificacion(),entity.getTitulo(), entity.getResumen(),entity.getCuerpo(),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<VersionDomain> toDomainFromEntityList(List<VersionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<VersionDomain> toDomainFromDTOList(List<VersionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<VersionDTO> toDTOFromDomainList(List<VersionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
