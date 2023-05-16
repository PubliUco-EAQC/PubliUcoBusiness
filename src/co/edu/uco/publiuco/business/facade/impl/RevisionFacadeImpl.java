package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.RevisionAssembler;
import co.edu.uco.publiuco.business.business.RevisionBusiness;
import co.edu.uco.publiuco.business.business.impl.RevisionBusinessImpl;
import co.edu.uco.publiuco.business.domain.RevisionDomain;
import co.edu.uco.publiuco.business.facade.RevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RevisionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class RevisionFacadeImpl implements RevisionFacade {
    private final DAOFactory daoFactory;
    private final RevisionBusiness business;

    public RevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new RevisionBusinessImpl(daoFactory);
    }

    @Override
    public void register(RevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisionDomain domain = RevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.RevisionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<RevisionDTO> list(RevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisionDomain domainList = RevisionAssembler.getInstance().toDomainFromDTO(dto);

            List<RevisionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return RevisionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.RevisionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.RevisionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(RevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final RevisionDomain domain = RevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RevisionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.RevisionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.RevisionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.RevisionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
