package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PreferenciaEscritorAssembler;
import co.edu.uco.publiuco.business.business.PreferenciaEscritorBusiness;
import co.edu.uco.publiuco.business.business.impl.PreferenciaEscritorBusinessImpl;
import co.edu.uco.publiuco.business.domain.PreferenciaEscritorDomain;
import co.edu.uco.publiuco.business.facade.PreferenciaEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PreferenciaEscritorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PreferenciaEscritorFacadeImpl implements PreferenciaEscritorFacade {
    private final DAOFactory daoFactory;
    private final PreferenciaEscritorBusiness business;

    public PreferenciaEscritorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PreferenciaEscritorBusinessImpl(daoFactory);
    }

    @Override
    public void register(PreferenciaEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaEscritorDomain domain = PreferenciaEscritorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PreferenciaEscritorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PreferenciaEscritorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PreferenciaEscritorDTO> list(PreferenciaEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaEscritorDomain domainList = PreferenciaEscritorAssembler.getInstance().toDomainFromDTO(dto);

            List<PreferenciaEscritorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PreferenciaEscritorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PreferenciaEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaEscritorDomain domain = PreferenciaEscritorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PreferenciaEscritorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PreferenciaEscritorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PreferenciaEscritorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PreferenciaEscritorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
