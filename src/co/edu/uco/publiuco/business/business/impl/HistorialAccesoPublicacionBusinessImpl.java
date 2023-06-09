package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.HistorialAccesoPublicacionAssembler;
import co.edu.uco.publiuco.business.business.HistorialAccesoPublicacionBusiness;
import co.edu.uco.publiuco.business.domain.HistorialAccesoPublicacionDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.HistorialAccesoPublicacionEntity;

public class HistorialAccesoPublicacionBusinessImpl implements HistorialAccesoPublicacionBusiness {

	DAOFactory daoFactory;

	public HistorialAccesoPublicacionBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(HistorialAccesoPublicacionDomain domain) {
		final HistorialAccesoPublicacionEntity entity = HistorialAccesoPublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getHistorialAccesoPublicacionDAO().create(entity);

	}

	@Override
	public List<HistorialAccesoPublicacionDomain> list(HistorialAccesoPublicacionDomain domain) {
		final HistorialAccesoPublicacionEntity entity = HistorialAccesoPublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<HistorialAccesoPublicacionEntity> result = daoFactory.getHistorialAccesoPublicacionDAO()
				.read(entity);

		return null;
	}

	@Override
	public void modify(HistorialAccesoPublicacionDomain domain) {
		final HistorialAccesoPublicacionEntity entity = HistorialAccesoPublicacionAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getHistorialAccesoPublicacionDAO().update(entity);

	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getHistorialAccesoPublicacionDAO().delete(domain);

	}

}
