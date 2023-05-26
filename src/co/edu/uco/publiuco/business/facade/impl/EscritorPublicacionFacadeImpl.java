package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.EscritorPublicacionAssembler;
import co.edu.uco.publiuco.business.business.EscritorPublicacionBusiness;
import co.edu.uco.publiuco.business.business.impl.EscritorPublicacionBusinessImpl;
import co.edu.uco.publiuco.business.domain.EscritorPublicacionDomain;
import co.edu.uco.publiuco.business.facade.EscritorPublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EscritorPublicacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class EscritorPublicacionFacadeImpl implements EscritorPublicacionFacade {
    private final DAOFactory daoFactory;
    private final EscritorPublicacionBusiness business;

    public EscritorPublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new EscritorPublicacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(EscritorPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final EscritorPublicacionDomain domain = EscritorPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EscritorPublicacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.EscritorPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<EscritorPublicacionDTO> list(EscritorPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final EscritorPublicacionDomain domainList = EscritorPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<EscritorPublicacionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return EscritorPublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.EscritorPublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.EscritorPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(EscritorPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final EscritorPublicacionDomain domain = EscritorPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EscritorPublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.EscritorPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.EscritorPublicacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.EscritorPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
