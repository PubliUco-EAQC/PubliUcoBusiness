package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.TipoEscritorAssembler;
import co.edu.uco.publiuco.business.business.TipoEscritorBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoEscritorBusinessImpl;
import co.edu.uco.publiuco.business.domain.TipoEscritorDomain;
import co.edu.uco.publiuco.business.facade.TipoEscritorFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoEscritorDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoEscritorFacadeImpl implements TipoEscritorFacade {
    private final DAOFactory daoFactory;
    private final TipoEscritorBusiness business;

    public TipoEscritorFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoEscritorBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoEscritorDomain domain = TipoEscritorAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.TipoEscritorFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.TipoEscritorFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();
        }
    }

    @Override
    public List<TipoEscritorDTO> list(TipoEscritorDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoEscritorDomain domainList = TipoEscritorAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoEscritorDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoEscritorAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoEscritorFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoEscritorFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConection();

        }
    }
}
