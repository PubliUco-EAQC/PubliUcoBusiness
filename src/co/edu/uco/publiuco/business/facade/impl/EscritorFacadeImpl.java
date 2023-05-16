package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.EscritorAssembler;
import co.edu.uco.publiuco.business.business.EscritorBusiness;
import co.edu.uco.publiuco.business.business.impl.EscritorBusinessImpl;
import co.edu.uco.publiuco.business.domain.EscritorDomain;
import co.edu.uco.publiuco.business.facade.EscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EscritorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class EscritorFacadeImpl implements EscritorFacade {
    private final DAOFactory daoFactory;
    private final EscritorBusiness business;

    public EscritorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new EscritorBusinessImpl(daoFactory);
    }

    @Override
    public void register(EscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final EscritorDomain domain = EscritorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EscritorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.EscritorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<EscritorDTO> list(EscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final EscritorDomain domainList = EscritorAssembler.getInstance().toDomainFromDTO(dto);

            List<EscritorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return EscritorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.EscritorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.EscritorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(EscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final EscritorDomain domain = EscritorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.EscritorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.EscritorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.EscritorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.EscritorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
