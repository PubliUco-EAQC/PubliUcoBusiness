package co.edu.uco.publiuco.business.business.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.AdministradorCategoriaAssembler;
import co.edu.uco.publiuco.business.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.business.business.AdministradorCategoriaBusiness;
import co.edu.uco.publiuco.business.domain.AdministradorCategoriaDomain;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.EstadoEntity;

public final class AdministradorCategoriaBusinessImpl implements AdministradorCategoriaBusiness {
	DAOFactory daoFactory;

	public AdministradorCategoriaBusinessImpl(final DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
    public final List<AdministradorCategoriaDomain> list(final AdministradorCategoriaDomain domain) {

        final EstadoEntity entity = EstadoAssembler.getInstance()
                .toEntityFromDomain(domain);

        List<EstadoEntity> resultEntityList = daoFactory.getEstado()
                .read(entity);

        return AdministradorCategoriaAssembler.getInstance().toDomainFromEntityList(resultEntityList);
    }

	@Override
	public final List<AdministradorCategoriaDomain> list(AdministradorCategoriaDomain domain) {
		final AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);

		final List<AdministradorCategoriaEntity> result = daoFactory.getAdministradorCategoriaDAO().read(entity);

		return null;
	}

	@Override
	public final void modify(AdministradorCategoriaDomain domain) {
		final AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().update(entity);

	}

	@Override
	public final void drop(AdministradorCategoriaDomain domain) {
		final AdministradorCategoriaEntity entity = AdministradorCategoriaAssembler.getInstance()
				.toEntityFromDomain(domain);
		daoFactory.getAdministradorCategoriaDAO().delete(entity);

	}
}
