package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PlanCategoriaAssembler;
import co.edu.uco.publiuco.business.assembler.concrete.PlanPublicacionAssembler;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.business.PlanPublicacionBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoBusinessImpl;
import co.edu.uco.publiuco.business.business.impl.PlanPublicacionBusinessImpl;
import co.edu.uco.publiuco.business.domain.PlanCategoriaDomain;
import co.edu.uco.publiuco.business.domain.PlanPublicacionDomain;
import co.edu.uco.publiuco.business.facade.PlanPublicacionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PlanPublicacionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PlanPublicacionFacadeImpl implements PlanPublicacionFacade {
    private final DAOFactory daoFactory;
    private final PlanPublicacionBusiness business;

    public PlanPublicacionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PlanPublicacionBusinessImpl(daoFactory);
    }

    @Override
    public void register(PlanPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanPublicacionDomain domain = PlanPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PlanCategoriaFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.PlanCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<PlanPublicacionDTO> list(PlanPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanPublicacionDomain domainList = PlanPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            List<PlanPublicacionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PlanPublicacionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PlanPublicacionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PlanPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }

    @Override
    public void modify(PlanPublicacionDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanPublicacionDomain domain = PlanPublicacionAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PlanPublicacionFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PlanPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PlanPublicacionFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PlanPublicacionFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }
}
