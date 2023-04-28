package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.entities.EstadoEntity;

public final class EstadoAssembler 
		implements Assembler<EstadoDomain, EstadoDTO, EstadoEntity>{

	@Override
	public EstadoDTO toDtofromDomain(EstadoDomain domain) {
		return EstadoDTO.create().setIdentificador(domain.getIdentificador())
				.setNombre(domain.getNombre()).setTipoEstado(domain.getTipoEstado());
	}

	@Override
	public EstadoDomain toDomainFromDto(EstadoDTO dto) {
		return new EstadoDomain(dto.getIdentificador(), dto.getNombre(), dto.getTipoEstado());
	}

	@Override
	public EstadoEntity toEntityFromDomain(EstadoDomain domain) {
		return new EstadoEntity(domain.getIdentificador(), domain.getNombre(), domain.getTipoEstado());
	}

	@Override
	public EstadoDomain toDomainFromEntity(EstadoEntity entity) {
		return new EstadoDomain(entity.getIdentificador(),entity.getNombre(),entity.getTipoEstado());
	}
	
}