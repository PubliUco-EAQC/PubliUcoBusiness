package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PreferenciaCategoriaAssembler;
import co.edu.uco.publiuco.business.business.PreferenciaCategoriaBusiness;
import co.edu.uco.publiuco.business.business.impl.PreferenciaCategoriaBusinessImpl;
import co.edu.uco.publiuco.business.domain.PreferenciaCategoriaDomain;
import co.edu.uco.publiuco.business.facade.PreferenciaCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PreferenciaCategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PreferenciaCategoriaFacadeImpl implements PreferenciaCategoriaFacade {
    private final DAOFactory daoFactory;
    private final PreferenciaCategoriaBusiness business;

    public PreferenciaCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PreferenciaCategoriaBusinessImpl(daoFactory);
    }


    @Override
    public void register(PreferenciaCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaCategoriaDomain domain = PreferenciaCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PreferenciaCategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PreferenciaCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PreferenciaCategoriaDTO> list(PreferenciaCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaCategoriaDomain domainList = PreferenciaCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<PreferenciaCategoriaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PreferenciaCategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PreferenciaCategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PreferenciaCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PreferenciaCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PreferenciaCategoriaDomain domain = PreferenciaCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PreferenciaCategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PreferenciaCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PreferenciaCategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PreferenciaCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
