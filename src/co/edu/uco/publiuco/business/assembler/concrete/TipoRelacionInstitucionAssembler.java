package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

import java.util.List;

public final class TipoRelacionInstitucionAssembler implements Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO,TipoRelacionInstitucionEntity> {

    public static final TipoRelacionInstitucionAssembler INSTANCE = new TipoRelacionInstitucionAssembler();
    public static TipoRelacionInstitucionAssembler getInstance() { return INSTANCE; }
    private TipoRelacionInstitucionAssembler(){
        super();
    }
    @Override
    public TipoRelacionInstitucionDTO toDTOFromDomain(TipoRelacionInstitucionDomain domain) {
        return new TipoRelacionInstitucionDTO().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public TipoRelacionInstitucionDomain toDomainFromDTO(TipoRelacionInstitucionDTO dto) {
        return null;
    }

    @Override
    public TipoRelacionInstitucionEntity toEntityFromDomain(TipoRelacionInstitucionDomain domain) {
        return null;
    }

    @Override
    public TipoRelacionInstitucionDomain toDomainFromEntity(TipoRelacionInstitucionEntity entity) {
        return null;
    }

    @Override
    public List<TipoRelacionInstitucionDomain> toDomainFromEntityList(List<TipoRelacionInstitucionEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<TipoRelacionInstitucionDomain> toDomainFromDTOList(List<TipoRelacionInstitucionDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<TipoRelacionInstitucionDTO> toDTOFromDomainList(List<TipoRelacionInstitucionDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
