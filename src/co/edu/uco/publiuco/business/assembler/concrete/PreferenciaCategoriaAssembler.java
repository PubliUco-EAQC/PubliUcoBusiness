package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PreferenciaCategoriaDomain;
import co.edu.uco.publiuco.dto.PreferenciaCategoriaDTO;
import co.edu.uco.publiuco.entities.PreferenciaCategoriaEntity;

import java.util.List;

public final class PreferenciaCategoriaAssembler implements Assembler<PreferenciaCategoriaDomain, PreferenciaCategoriaDTO, PreferenciaCategoriaEntity> {
    public static final PreferenciaCategoriaAssembler INSTANCE = new PreferenciaCategoriaAssembler();
    public static PreferenciaCategoriaAssembler getInstance() { return INSTANCE; }
    private PreferenciaCategoriaAssembler(){
        super();
    }
    @Override
    public PreferenciaCategoriaDTO toDTOFromDomain(PreferenciaCategoriaDomain domain) {
        return PreferenciaCategoriaDTO.create().setIdentificador(domain.getIdentificador()).setCategoria(CategoriaAssembler.getInstance().toDTOFromDomain(domain.getCategoria()))
                .setPerfil(PerfilAssembler.getInstance().toDTOFromDomain(domain.getPerfil()));
    }

    @Override
    public PreferenciaCategoriaDomain toDomainFromDTO(PreferenciaCategoriaDTO dto) {
        return new PreferenciaCategoriaDomain(dto.getIdentificador(), PerfilAssembler.getInstance().toDomainFromDTO(dto.getPerfil()),
                CategoriaAssembler.getInstance().toDomainFromDTO(dto.getCategoria()));
    }

    @Override
    public PreferenciaCategoriaEntity toEntityFromDomain(PreferenciaCategoriaDomain domain) {
        return new PreferenciaCategoriaEntity(domain.getIdentificador(), PerfilAssembler.getInstance().toEntityFromDomain(domain.getPerfil()),
                CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()));
    }

    @Override
    public PreferenciaCategoriaDomain toDomainFromEntity(PreferenciaCategoriaEntity entity) {
        return new PreferenciaCategoriaDomain(entity.getIdentificador(),PerfilAssembler.getInstance().toDomainFromEntity(entity.getPerfil()),
                CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()));
    }

    @Override
    public List<PreferenciaCategoriaDomain> toDomainFromEntityList(List<PreferenciaCategoriaEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<PreferenciaCategoriaDomain> toDomainFromDTOList(List<PreferenciaCategoriaDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<PreferenciaCategoriaDTO> toDTOFromDomainList(List<PreferenciaCategoriaDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
