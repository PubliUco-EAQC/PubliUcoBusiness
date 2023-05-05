package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.ComentarioLectorDomain;
import co.edu.uco.publiuco.dto.ComentarioLectorDTO;
import co.edu.uco.publiuco.entities.ComentarioLectorEntity;

public final class ComentarioLectorAssembler implements Assembler<ComentarioLectorDomain, ComentarioLectorDTO, ComentarioLectorEntity> {
    public static final ComentarioLectorAssembler INSTANCE = new ComentarioLectorAssembler();
    public static ComentarioLectorAssembler getInstance() { return INSTANCE; }
    private ComentarioLectorAssembler(){
        super();
    }
    @Override
    public ComentarioLectorDTO toDTOFromDomain(ComentarioLectorDomain domain) {
        return ComentarioLectorDTO.create().setIdentificador(domain.getIdentificador()).setLector(LectorAssembler.getInstance().toDTOFromDomain(domain.getLector()))
                .setComentarioPadre(ComentarioLectorAssembler.getInstance().toDTOFromDomain(domain.getComentarioPadre())).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setCotenido(domain.getCotenido()).setFechaCalificacion(domain.getFechaCalificacion()).setPublicacion(PublicacionAssembler.getInstance().toDTOFromDomain(domain.getPublicacion()));
    }

    @Override
    public ComentarioLectorDomain toDomainFromDTO(ComentarioLectorDTO dto) {
        return new ComentarioLectorDomain(dto.getIdentificador(),LectorAssembler.getInstance().toDomainFromDTO(dto.getLector()), PublicacionAssembler.getInstance().toDomainFromDTO(dto.getPublicacion()),
                ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto.getComentarioPadre()), dto.getCotenido(),dto.getFechaCalificacion(),EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public ComentarioLectorEntity toEntityFromDomain(ComentarioLectorDomain domain) {
        return new ComentarioLectorEntity(domain.getIdentificador(),LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),PublicacionAssembler.getInstance().toEntityFromDomain(domain.getPublicacion()),
                ComentarioLectorAssembler.getInstance().toEntityFromDomain(domain.getComentarioPadre()), domain.getCotenido(),domain.getFechaCalificacion(), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public ComentarioLectorDomain toDomainFromEntity(ComentarioLectorEntity entity) {
        return new ComentarioLectorDomain(entity.getIdentificador(),LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()), PublicacionAssembler.getInstance().toDomainFromEntity(entity.getPublicacion()),
                ComentarioLectorAssembler.getInstance().toDomainFromEntity(entity.getComentarioPadre()), entity.getCotenido(),entity.getFechaCalificacion(),
                EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }
	@Override
	public List<ComentarioLectorDomain> toDomainFromEntityList(List<ComentarioLectorEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
}
