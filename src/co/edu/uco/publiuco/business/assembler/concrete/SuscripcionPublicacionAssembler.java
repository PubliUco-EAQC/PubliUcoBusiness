package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.SuscripcionPublicacionDomain;
import co.edu.uco.publiuco.dto.SuscripcionPublicacionDTO;
import co.edu.uco.publiuco.entities.SuscripcionPublicacionEntity;

public final class SuscripcionPublicacionAssembler implements Assembler<SuscripcionPublicacionDomain, SuscripcionPublicacionDTO, SuscripcionPublicacionEntity> {
    public static final SuscripcionPublicacionAssembler INSTANCE = new SuscripcionPublicacionAssembler();
    public static SuscripcionPublicacionAssembler getInstance() { return INSTANCE; }
    private SuscripcionPublicacionAssembler(){
        super();
    }
    @Override
    public SuscripcionPublicacionDTO toDTOFromDomain(SuscripcionPublicacionDomain domain) {
        return SuscripcionPublicacionDTO.create().setIdentificador(domain.getIdentificador()).setPerfil(PerfilAssembler.getInstance().toDTOFromDomain(domain.getPerfil()))
                .setPlanPublicacion(PlanPublicacionAssembler.getInstance().toDTOFromDomain(domain.getPlanPublicacion()));
    }

    @Override
    public SuscripcionPublicacionDomain toDomainFromDTO(SuscripcionPublicacionDTO dto) {
        return new SuscripcionPublicacionDomain(dto.getIdentificador(), PerfilAssembler.getInstance().toDomainFromDTO(dto.getPerfil()),
                PlanPublicacionAssembler.getInstance().toDomainFromDTO(dto.getPlanPublicacion()));
    }

    @Override
    public SuscripcionPublicacionEntity toEntityFromDomain(SuscripcionPublicacionDomain domain) {
        return new SuscripcionPublicacionEntity(domain.getIdentificador(), PerfilAssembler.getInstance().toEntityFromDomain(domain.getPerfil()),
                PlanPublicacionAssembler.getInstance().toEntityFromDomain(domain.getPlanPublicacion()));
    }

    @Override
    public SuscripcionPublicacionDomain toDomainFromEntity(SuscripcionPublicacionEntity entity) {
        return new SuscripcionPublicacionDomain(entity.getIdentificador(),PerfilAssembler.getInstance().toDomainFromEntity(entity.getPerfil()),
                PlanPublicacionAssembler.getInstance().toDomainFromEntity(entity.getPlanPublicacion()));
    }
	@Override
	public List<SuscripcionPublicacionDomain> toDomainFromEntityList(List<SuscripcionPublicacionEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
}
