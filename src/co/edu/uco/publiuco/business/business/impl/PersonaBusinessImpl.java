package co.edu.uco.publiuco.business.business.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PerfilAssembler;
import co.edu.uco.publiuco.business.assembler.concrete.PersonaAssembler;
import co.edu.uco.publiuco.business.business.PersonaBusiness;
import co.edu.uco.publiuco.business.domain.PersonaDomain;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.entities.PerfilEntity;
import co.edu.uco.publiuco.entities.PersonaEntity;

import java.util.List;
import java.util.UUID;

public class PersonaBusinessImpl implements PersonaBusiness {
    DAOFactory daoFactory;

    public PersonaBusinessImpl(final DAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void register(PersonaDomain domain) {
        final PersonaEntity entity = PersonaAssembler.getInstance().toEntityFromDomain(domain);

        daoFactory.getPersonaDAO().create(entity);
    }

    @Override
    public List<PersonaDomain> list(PersonaDomain domain) {
        final PersonaEntity entity = PersonaAssembler.getInstance().toEntityFromDomain(domain);

        final List<PersonaEntity> result = daoFactory.getPersonaDAO().read(entity);

        return null;
    }

    @Override
    public void modify(PersonaDomain domain) {
        final PersonaEntity entity = PersonaAssembler.getInstance().toEntityFromDomain(domain);

        daoFactory.getPersonaDAO().update(entity);
    }

    @Override
    public void drop(UUID domain) {
        daoFactory.getPersonaDAO().delete(domain);
    }
}
