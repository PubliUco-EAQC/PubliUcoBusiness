package co.edu.uco.publiuco.business.business.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PaisAssembler;
import co.edu.uco.publiuco.business.business.PaisBusiness;
import co.edu.uco.publiuco.business.domain.PaisDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PaisEntity;


import java.util.List;

public class PaisBusinessImpl implements PaisBusiness {
    DAOFactory daoFactory;

    public PaisBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public List<PaisDomain> list(PaisDomain domain) {
        final PaisEntity entity = PaisAssembler.getInstance()
                .toEntityFromDomain(domain);

        final List<PaisEntity> result = daoFactory.getPaisDAO().read(entity);
        return null;
    }
}
