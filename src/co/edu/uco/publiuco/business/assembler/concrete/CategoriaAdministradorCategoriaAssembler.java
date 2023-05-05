package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.CategoriaAdministradorCategoriaDomain;
import co.edu.uco.publiuco.dto.CategoriaAdministradorCategoriaDTO;
import co.edu.uco.publiuco.entities.CategoriaAdministradorCategoriaEntity;

public final class CategoriaAdministradorCategoriaAssembler implements Assembler<CategoriaAdministradorCategoriaDomain, CategoriaAdministradorCategoriaDTO, CategoriaAdministradorCategoriaEntity> {
    public static final CategoriaAdministradorCategoriaAssembler INSTANCE = new CategoriaAdministradorCategoriaAssembler();
    public static CategoriaAdministradorCategoriaAssembler getInstance() { return INSTANCE; }
    private CategoriaAdministradorCategoriaAssembler(){
        super();
    }
    @Override
    public CategoriaAdministradorCategoriaDTO toDTOFromDomain(CategoriaAdministradorCategoriaDomain domain) {
        return CategoriaAdministradorCategoriaDTO.create().setIdentificador(domain.getIdentificador()).setAdministradorCategoria(AdministradorCategoriaAssembler.getInstance().toDTOFromDomain(domain.getAdministradorCategoria()))
                .setCategoria(CategoriaAssembler.getInstance().toDTOFromDomain(domain.getCategoria()));
    }

    @Override
    public CategoriaAdministradorCategoriaDomain toDomainFromDTO(CategoriaAdministradorCategoriaDTO dto) {
        return new CategoriaAdministradorCategoriaDomain(dto.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromDTO(dto.getCategoria()), AdministradorCategoriaAssembler.getInstance().toDomainFromDTO(dto.getAdministradorCategoria()));
    }

    @Override
    public CategoriaAdministradorCategoriaEntity toEntityFromDomain(CategoriaAdministradorCategoriaDomain domain) {
        return new CategoriaAdministradorCategoriaEntity(domain.getIdentificador(), CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()), AdministradorCategoriaAssembler.getInstance().toEntityFromDomain(domain.getAdministradorCategoria()));
    }

    @Override
    public CategoriaAdministradorCategoriaDomain toDomainFromEntity(CategoriaAdministradorCategoriaEntity entity) {
        return new CategoriaAdministradorCategoriaDomain(entity.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()), AdministradorCategoriaAssembler.getInstance().toDomainFromEntity(entity.getAdministradorCategoria()));
    }
	@Override
	public List<CategoriaAdministradorCategoriaDomain> toDomainFromEntityList(
			List<CategoriaAdministradorCategoriaEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
}
