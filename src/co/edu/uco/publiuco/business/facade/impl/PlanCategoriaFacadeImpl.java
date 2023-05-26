package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PlanCategoriaAssembler;
import co.edu.uco.publiuco.business.business.PlanCategoriaBusiness;
import co.edu.uco.publiuco.business.business.impl.PlanCategoriaBusinessImpl;
import co.edu.uco.publiuco.business.domain.PlanCategoriaDomain;
import co.edu.uco.publiuco.business.facade.PlanCategoriaFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PlanCategoriaDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;
import java.util.UUID;

public final class PlanCategoriaFacadeImpl implements PlanCategoriaFacade {
    private final DAOFactory daoFactory;
    private final PlanCategoriaBusiness business;

    public PlanCategoriaFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PlanCategoriaBusinessImpl(daoFactory);
    }


    @Override
    public void register(PlanCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanCategoriaDomain domain = PlanCategoriaAssembler.getInstance().toDomainFromDTO(dto);

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
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<PlanCategoriaDTO> list(PlanCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanCategoriaDomain domainList = PlanCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            List<PlanCategoriaDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PlanCategoriaAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PlanCategoriaFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PlanCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

    @Override
    public void modify(PlanCategoriaDTO dto) {
        try {
            daoFactory.initTransaction();
            final PlanCategoriaDomain domain = PlanCategoriaAssembler.getInstance().toDomainFromDTO(dto);

            business.modify(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.PlanCategoriaFacadeImplMessages.USER_MESSAGE_MODIFY;
            var technicalMessage = Messages.PlanCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;

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
            var userMessage = Messages.PlanCategoriaFacadeImplMessages.USER_MESSAGE_DROP;
            var technicalMessage = Messages.PlanCategoriaFacadeImplMessages.TECHNICAL_MESSAGE_DROP;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }
}
