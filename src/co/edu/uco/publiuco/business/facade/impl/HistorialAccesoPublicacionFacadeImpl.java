package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.HistorialAccesoPublicacionAssembler;
import co.edu.uco.publiuco.business.business.HistorialAccesoPublicacionBusiness;
import co.edu.uco.publiuco.business.business.impl.HistorialAccesoPublicacionBusinessImpl;
import co.edu.uco.publiuco.business.domain.HistorialAccesoPublicacionDomain;
import co.edu.uco.publiuco.business.facade.HistorialAccesoPublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.HistorialAccesoPublicacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class HistorialAccesoPublicacionFacadeImpl implements HistorialAccesoPublicacionFacade {
    private final DAOFactory daoFactory;
    private final HistorialAccesoPublicacionBusiness business;

    public HistorialAccesoPublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new HistorialAccesoPublicacionBusinessImpl(daoFactory);
    }


    @Override
    public void register(HistorialAccesoPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final HistorialAccesoPublicacionDomain domain = HistorialAccesoPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.HistorialAccesoPublicacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.HistorialAccesoPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<HistorialAccesoPublicacionDTO> list(HistorialAccesoPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final HistorialAccesoPublicacionDomain domainList = HistorialAccesoPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<HistorialAccesoPublicacionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return HistorialAccesoPublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.HistorialAccesoPublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.HistorialAccesoPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(HistorialAccesoPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final HistorialAccesoPublicacionDomain domain = HistorialAccesoPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.HistorialAccesoPublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.HistorialAccesoPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.HistorialAccesoPublicacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.HistorialAccesoPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
