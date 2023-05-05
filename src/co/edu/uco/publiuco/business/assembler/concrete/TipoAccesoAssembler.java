package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoAccesoDomain;
import co.edu.uco.publiuco.dto.TipoAccesoDTO;
import co.edu.uco.publiuco.entities.TipoAccesoEntity;

public final class TipoAccesoAssembler implements Assembler<TipoAccesoDomain, TipoAccesoDTO, TipoAccesoEntity> {
    public static final TipoAccesoAssembler INSTANCE = new TipoAccesoAssembler();
    public static TipoAccesoAssembler getInstance() { return INSTANCE; }
    private TipoAccesoAssembler(){
        super();
    }
    @Override
    public TipoAccesoDTO toDTOFromDomain(TipoAccesoDomain domain) {
        return TipoAccesoDTO.create().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre())
                .setDescripcion(domain.getDescripcion()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public TipoAccesoDomain toDomainFromDTO(TipoAccesoDTO dto) {
        return new TipoAccesoDomain(dto.getIdentificador(),dto.getNombre(),dto.getDescripcion(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public TipoAccesoEntity toEntityFromDomain(TipoAccesoDomain domain) {
        return new TipoAccesoEntity(domain.getIdentificador(),domain.getNombre(),domain.getDescripcion(), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public TipoAccesoDomain toDomainFromEntity(TipoAccesoEntity entity) {
        return new TipoAccesoDomain(entity.getIdentificador(),entity.getNombre(),entity.getDescripcion(),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
	@Override
	public List<TipoAccesoDomain> toDomainFromEntityList(List<TipoAccesoEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
}
