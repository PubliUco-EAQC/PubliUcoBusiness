package co.edu.uco.publiuco.business.business.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.EscritorAssembler;
import co.edu.uco.publiuco.business.business.EscritorBusiness;
import co.edu.uco.publiuco.business.domain.EscritorDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EscritorEntity;

public class EscritorBusinessImpl implements EscritorBusiness {

	DAOFactory daoFactory;

	public EscritorBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void register(EscritorDomain domain) {
		final EscritorEntity entity = EscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEscritorDAO().create(entity);

	}

	@Override
	public List<EscritorDomain> list(EscritorDomain domain) {
		final EscritorEntity entity = EscritorAssembler.getInstance().toEntityFromDomain(domain);

		final List<EscritorEntity> result = daoFactory.getEscritorDAO().read(entity);

		return null;
	}

	@Override
	public void modify(EscritorDomain domain) {
		final EscritorEntity entity = EscritorAssembler.getInstance().toEntityFromDomain(domain);
		daoFactory.getEscritorDAO().update(entity);

	}

	@Override
	public void drop(UUID domain) {
		daoFactory.getEscritorDAO().delete(domain);

	}

}
