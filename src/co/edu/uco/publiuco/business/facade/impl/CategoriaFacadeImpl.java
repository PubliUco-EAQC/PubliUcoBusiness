package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.CategoriaAssembler;
import co.edu.uco.publiuco.business.business.CategoriaBusiness;
import co.edu.uco.publiuco.business.business.impl.CategoriaBusinessImpl;
import co.edu.uco.publiuco.business.domain.CategoriaDomain;
import co.edu.uco.publiuco.business.facade.CategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.CategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class CategoriaFacadeImpl implements CategoriaFacade {
    private final DAOFactory daoFactory;
    private final CategoriaBusiness business;

    public CategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new CategoriaBusinessImpl(daoFactory);
    }

    @Override
    public void register(CategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final CategoriaDomain domain = CategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.CategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<CategoriaDTO> list(CategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final CategoriaDomain domain = CategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<CategoriaDomain> lista = business.list(domain);

            return CategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.CategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void modify(CategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final CategoriaDomain domain = CategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.CategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.CategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.CategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
