package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.TipoRevisionAssembler;
import co.edu.uco.publiuco.business.business.TipoRevisionBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoRevisionBusinessImpl;
import co.edu.uco.publiuco.business.domain.TipoRevisionDomain;
import co.edu.uco.publiuco.business.facade.TipoRevisionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoRevisionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoRevisionFacadeImpl implements TipoRevisionFacade {
    private final DAOFactory daoFactory;
    private final TipoRevisionBusiness business;

    public TipoRevisionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoRevisionBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoRevisionDomain domain = TipoRevisionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.TipoRevisionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.TipoRevisionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<TipoRevisionDTO> list(TipoRevisionDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoRevisionDomain domainList = TipoRevisionAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoRevisionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoRevisionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoRevisionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoRevisionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }
}
