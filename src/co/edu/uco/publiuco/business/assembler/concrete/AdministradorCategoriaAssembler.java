package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.AdministradorCategoriaDomain;
import co.edu.uco.publiuco.dto.AdministradorCategoriaDTO;
import co.edu.uco.publiuco.entities.AdministradorCategoriaEntity;

import java.util.List;

public final class AdministradorCategoriaAssembler implements Assembler<AdministradorCategoriaDomain, AdministradorCategoriaDTO, AdministradorCategoriaEntity> {
    public static final AdministradorCategoriaAssembler INSTANCE = new AdministradorCategoriaAssembler();
    public static AdministradorCategoriaAssembler getInstance() { return INSTANCE; }
    private AdministradorCategoriaAssembler(){
        super();
    }
    @Override
    public AdministradorCategoriaDTO toDTOFromDomain(AdministradorCategoriaDomain domain) {
        return AdministradorCategoriaDTO.create().setIdentificador(domain.getIdentificador()).setPersona(PersonaAssembler.getInstance().toDTOFromDomain(domain.getPersona()));
    }

    @Override
    public AdministradorCategoriaDomain toDomainFromDTO(AdministradorCategoriaDTO dto) {
        return new AdministradorCategoriaDomain(dto.getIdentificador(), PersonaAssembler.getInstance().toDomainFromDTO(dto.getPersona()), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public AdministradorCategoriaEntity toEntityFromDomain(AdministradorCategoriaDomain domain) {
        return new AdministradorCategoriaEntity(domain.getIdentificador(), PersonaAssembler.getInstance().toEntityFromDomain(domain.getPersona()),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public AdministradorCategoriaDomain toDomainFromEntity(AdministradorCategoriaEntity entity) {
        return new AdministradorCategoriaDomain(entity.getIdentificador(),PersonaAssembler.getInstance().toDomainFromEntity(entity.getPersona()), EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<AdministradorCategoriaDomain> toDomainFromEntityList(List<AdministradorCategoriaEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();
    }

    @Override
    public List<AdministradorCategoriaDomain> toDomainFromDTOList(List<AdministradorCategoriaDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<AdministradorCategoriaDTO> toDTOFromDomainList(List<AdministradorCategoriaDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();
    }
}
