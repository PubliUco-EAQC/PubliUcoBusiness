package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.ReporteAssembler;
import co.edu.uco.publiuco.business.assembler.concrete.RespuestaAssembler;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.business.RespuestaBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoBusinessImpl;
import co.edu.uco.publiuco.business.business.impl.RespuestaBusinessImpl;
import co.edu.uco.publiuco.business.domain.ReporteDomain;
import co.edu.uco.publiuco.business.domain.RespuestaDomain;
import co.edu.uco.publiuco.business.facade.RespuestaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.RespuestaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class RespuestaFacadeImpl implements RespuestaFacade {
    private final DAOFactory daoFactory;
    private final RespuestaBusiness business;

    public RespuestaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new RespuestaBusinessImpl(daoFactory);
    }


    @Override
    public void register(RespuestaDTO dto) {
        try {
            daoFactory.initTransaction();
            final RespuestaDomain domain = RespuestaAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RespuestaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.RespuestaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<RespuestaDTO> list(RespuestaDTO dto) {
        try {
            daoFactory.initTransaction();
            final RespuestaDomain domainList = RespuestaAssembler.getInstance().toDomainFromDTO(dto);

            List<RespuestaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return RespuestaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.RespuestaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.RespuestaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(RespuestaDTO dto) {
        try {
            daoFactory.initTransaction();
            final RespuestaDomain domain = RespuestaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.RespuestaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.RespuestaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.RespuestaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.RespuestaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
