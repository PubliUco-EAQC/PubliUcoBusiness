package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.RevisorRevisionAssembler;
import co.edu.uco.publiuco.business.business.RevisorRevisionBusiness;
import co.edu.uco.publiuco.business.business.impl.RevisorRevisionBusinessImpl;
import co.edu.uco.publiuco.business.domain.RevisorRevisionDomain;
import co.edu.uco.publiuco.business.facade.RevisorRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RevisorRevisionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class RevisorRevisionFacadeImpl implements RevisorRevisionFacade {
    private final DAOFactory daoFactory;
    private final RevisorRevisionBusiness business;

    public RevisorRevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new RevisorRevisionBusinessImpl(daoFactory);
    }

    @Override
    public void register(RevisorRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorRevisionDomain domain = RevisorRevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisorRevisionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.RevisorRevisionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<RevisorRevisionDTO> list(RevisorRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorRevisionDomain domainList = RevisorRevisionAssembler.getInstance().toDomainFromDTO(dto);

            List<RevisorRevisionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return RevisorRevisionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.RevisorRevisionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.RevisorRevisionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(RevisorRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisorRevisionDomain domain = RevisorRevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisorRevisionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.RevisorRevisionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.RevisorRevisionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.RevisorRevisionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
