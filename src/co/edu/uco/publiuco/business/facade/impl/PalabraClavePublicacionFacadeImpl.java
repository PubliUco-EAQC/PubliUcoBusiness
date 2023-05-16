package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PalabraClavePublicacionAssembler;
import co.edu.uco.publiuco.business.business.PalabraClavePublicacionBusiness;
import co.edu.uco.publiuco.business.business.impl.PalabraClavePublicacionBusinessImpl;
import co.edu.uco.publiuco.business.domain.PalabraClavePublicacionDomain;
import co.edu.uco.publiuco.business.facade.PalabraClavePublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PalabraClavePublicacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PalabraClavePublicacionFacadeImpl implements PalabraClavePublicacionFacade {
    private final DAOFactory daoFactory;
    private final PalabraClavePublicacionBusiness business;

    public PalabraClavePublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PalabraClavePublicacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(PalabraClavePublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PalabraClavePublicacionDomain domain = PalabraClavePublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PalabraClavePublicacionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PalabraClavePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<PalabraClavePublicacionDTO> list(PalabraClavePublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PalabraClavePublicacionDomain domainList = PalabraClavePublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<PalabraClavePublicacionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PalabraClavePublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PalabraClavePublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PalabraClavePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(PalabraClavePublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PalabraClavePublicacionDomain domain = PalabraClavePublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PalabraClavePublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PalabraClavePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PalabraClavePublicacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PalabraClavePublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
