package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.CalificacionAssembler;
import co.edu.uco.publiuco.business.business.CalificacionBusiness;
import co.edu.uco.publiuco.business.business.impl.CalificacionBusinessImpl;
import co.edu.uco.publiuco.business.domain.CalificacionDomain;
import co.edu.uco.publiuco.business.facade.CalificacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.CalificacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class CalificacionFacadeImpl implements CalificacionFacade {
    private final DAOFactory daoFactory;
    private final CalificacionBusiness business;

    public CalificacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new CalificacionBusinessImpl(daoFactory);
    }
    @Override
    public void register(CalificacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final CalificacionDomain domain = CalificacionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CalificacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.CalificacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<CalificacionDTO> list(CalificacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final CalificacionDomain domainList = CalificacionAssembler.getInstance().toDomainFromDTO(dto);

            List<CalificacionDomain> lista = business.list(domainList);

            return CalificacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CalificacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.CalificacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public void modify(CalificacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final CalificacionDomain domain = CalificacionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.CalificacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.CalificacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.CalificacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.CalificacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
