package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.LectorAssembler;
import co.edu.uco.publiuco.business.business.LectorBusiness;
import co.edu.uco.publiuco.business.business.impl.LectorBusinessImpl;
import co.edu.uco.publiuco.business.domain.LectorDomain;
import co.edu.uco.publiuco.business.facade.LectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.LectorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class LectorFacadeImpl implements LectorFacade {
    private final DAOFactory daoFactory;
    private final LectorBusiness business;

    public LectorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new LectorBusinessImpl(daoFactory);
    }

    @Override
    public void register(LectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final LectorDomain domain = LectorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<LectorDTO> list(LectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final LectorDomain domainList = LectorAssembler.getInstance().toDomainFromDTO(dto);

            List<LectorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return LectorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(LectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final LectorDomain domain = LectorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.LectorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.LectorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
