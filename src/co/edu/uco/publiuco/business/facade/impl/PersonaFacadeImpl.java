package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PersonaAssembler;
import co.edu.uco.publiuco.business.business.PersonaBusiness;
import co.edu.uco.publiuco.business.business.impl.PersonaBusinessImpl;
import co.edu.uco.publiuco.business.domain.PersonaDomain;
import co.edu.uco.publiuco.business.facade.PersonaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PersonaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PersonaFacadeImpl implements PersonaFacade {
    private final DAOFactory daoFactory;
    private final PersonaBusiness business;

    public PersonaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PersonaBusinessImpl(daoFactory);
    }

    @Override
    public void register(PersonaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PersonaDomain domain = PersonaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PersonaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<PersonaDTO> list(PersonaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PersonaDomain domainList = PersonaAssembler.getInstance().toDomainFromDTO(dto);

            List<PersonaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PersonaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PersonaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(PersonaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PersonaDomain domain = PersonaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PersonaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public void drop(UUID dto) {
        try {
            daoFactory.initTransaction();

            business.drop(dto);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PersonaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PersonaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
