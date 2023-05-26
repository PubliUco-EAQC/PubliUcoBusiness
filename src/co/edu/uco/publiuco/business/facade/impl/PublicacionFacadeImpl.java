package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PublicacionAssembler;
import co.edu.uco.publiuco.business.business.PublicacionBusiness;
import co.edu.uco.publiuco.business.business.impl.PublicacionBusinessImpl;
import co.edu.uco.publiuco.business.domain.PublicacionDomain;
import co.edu.uco.publiuco.business.facade.PublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PublicacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PublicacionFacadeImpl implements PublicacionFacade {
    private final DAOFactory daoFactory;
    private final PublicacionBusiness business;

    public PublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PublicacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domain = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PlanPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PublicacionDTO> list(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domainList = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<PublicacionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PublicacionDomain domain = PublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PublicacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
