package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PlanCategoriaDomain;
import co.edu.uco.publiuco.dto.PlanCategoriaDTO;
import co.edu.uco.publiuco.entities.PlanCategoriaEntity;

public final class PlanCategoriaAssembler implements Assembler<PlanCategoriaDomain, PlanCategoriaDTO, PlanCategoriaEntity> {
    public static final PlanCategoriaAssembler INSTANCE = new PlanCategoriaAssembler();
    public static PlanCategoriaAssembler getInstance() { return INSTANCE; }
    private PlanCategoriaAssembler(){
        super();
    }
    @Override
    public PlanCategoriaDTO toDTOFromDomain(PlanCategoriaDomain domain) {
        return PlanCategoriaDTO.create().setIdentificador(domain.getIdentificador()).setCategoria(CategoriaAssembler.getInstance().toDTOFromDomain(domain.getCategoria()))
                .setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado())).setPrecio(domain.getPrecio())
                .setFechaDesde(domain.getFechaDesde()).setFechaHasta(domain.getFechaHasta());
    }

    @Override
    public PlanCategoriaDomain toDomainFromDTO(PlanCategoriaDTO dto) {
        return new PlanCategoriaDomain(dto.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromDTO(dto.getCategoria()),
                dto.getPrecio(),dto.getFechaDesde(),dto.getFechaHasta(), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public PlanCategoriaEntity toEntityFromDomain(PlanCategoriaDomain domain) {
        return new PlanCategoriaEntity(domain.getIdentificador(), CategoriaAssembler.getInstance().toEntityFromDomain(domain.getCategoria()),
                domain.getPrecio(),domain.getFechaDesde(),domain.getFechaHasta(),EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public PlanCategoriaDomain toDomainFromEntity(PlanCategoriaEntity entity) {
        return new PlanCategoriaDomain(entity.getIdentificador(),CategoriaAssembler.getInstance().toDomainFromEntity(entity.getCategoria()),
                entity.getPrecio(),entity.getFechaDesde(),entity.getFechaHasta(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
}
