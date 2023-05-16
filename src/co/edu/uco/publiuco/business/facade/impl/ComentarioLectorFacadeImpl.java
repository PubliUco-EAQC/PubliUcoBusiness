package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.ComentarioLectorAssembler;
import co.edu.uco.publiuco.business.business.ComentarioLectorBusiness;
import co.edu.uco.publiuco.business.business.impl.ComentarioLectorBusinessImpl;
import co.edu.uco.publiuco.business.domain.ComentarioLectorDomain;
import co.edu.uco.publiuco.business.facade.ComentarioLectorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.ComentarioLectorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class ComentarioLectorFacadeImpl implements ComentarioLectorFacade {
    private final DAOFactory daoFactory;
    private final ComentarioLectorBusiness business;

    public ComentarioLectorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new ComentarioLectorBusinessImpl(daoFactory);
    }

    @Override
    public void register(ComentarioLectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioLectorDomain domain = ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioLectorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.ComentarioLectorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<ComentarioLectorDTO> list(ComentarioLectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioLectorDomain domainList = ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto);

            List<ComentarioLectorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return ComentarioLectorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.ComentarioLectorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.ComentarioLectorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public void modify(ComentarioLectorDTO dto) {
        try {
            daoFactory.initTransaction();
            final ComentarioLectorDomain domain = ComentarioLectorAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.ComentarioLectorFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.ComentarioLectorFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.ComentarioLectorFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.ComentarioLectorFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
