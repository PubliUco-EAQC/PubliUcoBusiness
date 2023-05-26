package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.CategoriaAdministradorCategoriaAssembler;
import co.edu.uco.publiuco.business.business.CategoriaAdministradorCategoriaBusiness;
import co.edu.uco.publiuco.business.business.impl.CategoriaAdministradorCategoriaBusinessImpl;
import co.edu.uco.publiuco.business.domain.CategoriaAdministradorCategoriaDomain;
import co.edu.uco.publiuco.business.facade.CategoriaAdministradorCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.CategoriaAdministradorCategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class CategoriaAdministradorCategoriaFacadeImpl implements CategoriaAdministradorCategoriaFacade {
    private final DAOFactory daoFactory;
    private final CategoriaAdministradorCategoriaBusiness business;

    public CategoriaAdministradorCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new CategoriaAdministradorCategoriaBusinessImpl(daoFactory);
    }

    @Override
    public void register(CategoriaAdministradorCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final CategoriaAdministradorCategoriaDomain domain = CategoriaAdministradorCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CategoriaAdministradorCategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.CategoriaAdministradorCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<CategoriaAdministradorCategoriaDTO> list(CategoriaAdministradorCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final CategoriaAdministradorCategoriaDomain domain = CategoriaAdministradorCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<CategoriaAdministradorCategoriaDomain> lista = business.list(domain);

            return CategoriaAdministradorCategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CategoriaAdministradorCategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.CategoriaAdministradorCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public void modify(CategoriaAdministradorCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final CategoriaAdministradorCategoriaDomain domain = CategoriaAdministradorCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CategoriaAdministradorCategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.CategoriaAdministradorCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.CategoriaAdministradorCategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.CategoriaAdministradorCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
