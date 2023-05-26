package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.ComentarioRevisorAssembler;
import co.edu.uco.publiuco.business.business.ComentarioRevisorBusiness;
import co.edu.uco.publiuco.business.business.impl.ComentarioRevisorBusinessImpl;
import co.edu.uco.publiuco.business.domain.ComentarioRevisorDomain;
import co.edu.uco.publiuco.business.facade.ComentarioRevisorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.ComentarioRevisorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class ComentarioRevisorFacadeImpl implements ComentarioRevisorFacade {
    private final DAOFactory daoFactory;
    private final ComentarioRevisorBusiness business;

    public ComentarioRevisorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new ComentarioRevisorBusinessImpl(daoFactory);
    }


    @Override
    public void register(ComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioRevisorDomain domain = ComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioRevisorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.ComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<ComentarioRevisorDTO> list(ComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioRevisorDomain domainList = ComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            List<ComentarioRevisorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return ComentarioRevisorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.ComentarioRevisorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.ComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void modify(ComentarioRevisorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioRevisorDomain domain = ComentarioRevisorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioRevisorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.ComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.ComentarioRevisorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.ComentarioRevisorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
