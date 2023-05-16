package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.ObservacionRevisionAssembler;
import co.edu.uco.publiuco.business.business.ObservacionRevisionBusiness;
import co.edu.uco.publiuco.business.business.impl.ObservacionRevisionBusinessImpl;
import co.edu.uco.publiuco.business.domain.ObservacionRevisionDomain;
import co.edu.uco.publiuco.business.facade.ObservacionRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.ObservacionRevisionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class ObservacionRevisionFacadeImpl implements ObservacionRevisionFacade {
    private final DAOFactory daoFactory;
    private final ObservacionRevisionBusiness business;

    public ObservacionRevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new ObservacionRevisionBusinessImpl(daoFactory);
    }

    @Override
    public void register(ObservacionRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final ObservacionRevisionDomain domain = ObservacionRevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ObservacionRevisionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.ObservacionRevisionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<ObservacionRevisionDTO> list(ObservacionRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final ObservacionRevisionDomain domainList = ObservacionRevisionAssembler.getInstance().toDomainFromDTO(dto);

            List<ObservacionRevisionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return ObservacionRevisionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.ObservacionRevisionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.ObservacionRevisionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(ObservacionRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final ObservacionRevisionDomain domain = ObservacionRevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ObservacionRevisionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.ObservacionRevisionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.ObservacionRevisionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.ObservacionRevisionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
