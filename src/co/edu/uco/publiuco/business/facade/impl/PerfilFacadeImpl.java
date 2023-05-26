package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PerfilAssembler;
import co.edu.uco.publiuco.business.business.PerfilBusiness;
import co.edu.uco.publiuco.business.business.impl.PerfilBusinessImpl;
import co.edu.uco.publiuco.business.domain.PerfilDomain;
import co.edu.uco.publiuco.business.facade.PerfilFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PerfilDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PerfilFacadeImpl implements PerfilFacade {
    private final DAOFactory daoFactory;
    private final PerfilBusiness business;

    public PerfilFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PerfilBusinessImpl(daoFactory);
    }

    @Override
    public void register(PerfilDTO dto) {
        try {
            daoFactory.initTransaction();
            final PerfilDomain domain = PerfilAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PerfilFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PerfilFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PerfilDTO> list(PerfilDTO dto) {
        try {
            daoFactory.initTransaction();
            final PerfilDomain domainList = PerfilAssembler.getInstance().toDomainFromDTO(dto);

            List<PerfilDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PerfilAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PerfilFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PerfilFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PerfilDTO dto) {
        try {
            daoFactory.initTransaction();
            final PerfilDomain domain = PerfilAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PerfilFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PerfilFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
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
            var userMessage = Messages.PerfilFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PerfilFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
