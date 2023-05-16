package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoEntity;

public class EstadoBusinessImpl implements EstadoBusiness {
	DAOFactory daoFactory;
	
	public EstadoBusinessImpl (final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	@Override
	public void register(EstadoDomain domain) {
		final EstadoEntity entity = EstadoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoDAO().create(entity);
		
	}

	@Override
	public List<EstadoDomain> list(EstadoDomain domain) {
		final EstadoEntity entity = EstadoAssembler.getInstance().toEntityFromDomain(domain);

		final List<EstadoEntity> resultEntityList = daoFactory.getEstadoDAO().read(entity);

		return EstadoAssembler.getInstance().toDomainFromEntityList(resultEntityList);
	}

	@Override
	public void modify(EstadoDomain domain) {
		final EstadoEntity entity = EstadoAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEstadoDAO().update(entity);
	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getEstadoDAO().delete(domain);
	}

}
