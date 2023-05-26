package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.SuscripcionCategoriaAssembler;
import co.edu.uco.publiuco.business.business.SuscripcionCategoriaBusiness;
import co.edu.uco.publiuco.business.business.impl.SuscripcionCategoriaBusinessImpl;
import co.edu.uco.publiuco.business.domain.SuscripcionCategoriaDomain;
import co.edu.uco.publiuco.business.facade.SuscripcionCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.SuscripcionCategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class SuscripcionCategoriaFacadeImpl implements SuscripcionCategoriaFacade {
    private final DAOFactory daoFactory;
    private final SuscripcionCategoriaBusiness business;

    public SuscripcionCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new SuscripcionCategoriaBusinessImpl(daoFactory);
    }

    @Override
    public void register(SuscripcionCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionCategoriaDomain domain = SuscripcionCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.SuscripcionCategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.SuscripcionCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<SuscripcionCategoriaDTO> list(SuscripcionCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionCategoriaDomain domainList = SuscripcionCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<SuscripcionCategoriaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return SuscripcionCategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.SuscripcionCategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.SuscripcionCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(SuscripcionCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final SuscripcionCategoriaDomain domain = SuscripcionCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.SuscripcionCategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.SuscripcionCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.SuscripcionCategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.SuscripcionCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
