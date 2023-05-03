package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;

public final class EstadoBusinessImpl implements EstadoBusiness{
	
	private DAOFactory daoFactory;
	
	public EstadoBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
		
	}

	@Override
	public final void register(final EstadoDomain domain) {
		EstadoEntity entity = EstadoAssembler.getInstace().toEntityFromDomain(domain);
		daoFactory.getEstadoDAO().create(entity);
	}

	@Override
	public final List<EstadoDomain> list(final EstadoDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public final void modify(final EstadoDomain domain) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void drop(final EstadoDomain domain) {
		// TODO Auto-generated method stub
		
	}

}
