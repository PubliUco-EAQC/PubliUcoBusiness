package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.VersionAssembler;

import co.edu.uco.publiuco.business.business.VersionBusiness;
import co.edu.uco.publiuco.business.business.impl.VersionBusinessImpl;
import co.edu.uco.publiuco.business.domain.VersionDomain;
import co.edu.uco.publiuco.business.facade.VersionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.VersionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class VersionFacadeImpl implements VersionFacade {
    private final DAOFactory daoFactory;
    private final VersionBusiness business;

    public VersionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new VersionBusinessImpl(daoFactory);
    }

    @Override
    public void register(VersionDTO dto) {
        try {
            daoFactory.initTransaction();
            final VersionDomain domain = VersionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.VersionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.VersionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<VersionDTO> list(VersionDTO dto) {
        try {
            daoFactory.initTransaction();
            final VersionDomain domainList = VersionAssembler.getInstance().toDomainFromDTO(dto);

            List<VersionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return VersionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.VersionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.VersionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(VersionDTO dto) {
        try {
            daoFactory.initTransaction();
            final VersionDomain domain = VersionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.VersionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.VersionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.VersionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.VersionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
