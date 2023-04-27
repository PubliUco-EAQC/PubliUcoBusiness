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
		return EstadoDomain.create();
	}

	@Override
	public EstadoEntity toEntityFromDomain(EstadoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EstadoDomain toDomainFromEntity(EstadoEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}
	
}