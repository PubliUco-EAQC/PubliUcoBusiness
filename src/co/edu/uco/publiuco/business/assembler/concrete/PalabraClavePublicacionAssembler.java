package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PalabraClavePublicacionDomain;
import co.edu.uco.publiuco.dto.PalabraClavePublicacionDTO;
import co.edu.uco.publiuco.entities.PalabraClavePublicacionEntity;

import java.util.List;

public final class PalabraClavePublicacionAssembler implements Assembler<PalabraClavePublicacionDomain, PalabraClavePublicacionDTO, PalabraClavePublicacionEntity> {
    public static final PalabraClavePublicacionAssembler INSTANCE = new PalabraClavePublicacionAssembler();
    public static PalabraClavePublicacionAssembler getInstance() { return INSTANCE; }
    private PalabraClavePublicacionAssembler(){
        super();
    }
    @Override
    public PalabraClavePublicacionDTO toDTOFromDomain(PalabraClavePublicacionDomain domain) {
        return PalabraClavePublicacionDTO.create().setIdentificador(domain.getIdentificador()).setPalabraClave(domain.getPalabraClave())
                .setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()));
    }

    @Override
    public PalabraClavePublicacionDomain toDomainFromDTO(PalabraClavePublicacionDTO dto) {
        return new PalabraClavePublicacionDomain(dto.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
                dto.getPalabraClave());
    }

    @Override
    public PalabraClavePublicacionEntity toEntityFromDomain(PalabraClavePublicacionDomain domain) {
        return new PalabraClavePublicacionEntity(domain.getIdentificador(), PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),
                domain.getPalabraClave());
    }

    @Override
    public PalabraClavePublicacionDomain toDomainFromEntity(PalabraClavePublicacionEntity entity) {
        return new PalabraClavePublicacionDomain(entity.getIdentificador(),PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),entity.getPalabraClave() );
    }

    @Override
    public List<PalabraClavePublicacionDomain> toDomainFromEntityList(List<PalabraClavePublicacionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<PalabraClavePublicacionDomain> toDomainFromDTOList(List<PalabraClavePublicacionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<PalabraClavePublicacionDTO> toDTOFromDomainList(List<PalabraClavePublicacionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
