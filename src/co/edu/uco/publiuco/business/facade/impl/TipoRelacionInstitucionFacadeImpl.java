package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.TipoRelacionInstitucionAssembler;
import co.edu.uco.publiuco.business.business.TipoRelacionInstitucionBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoRelacionInstitucionBusinessImpl;
import co.edu.uco.publiuco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.business.facade.TipoRelacionInstitucionFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoRelacionInstitucionFacadeImpl implements TipoRelacionInstitucionFacade {
    private final DAOFactory daoFactory;
    private final TipoRelacionInstitucionBusiness business;

    public TipoRelacionInstitucionFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoRelacionInstitucionBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoRelacionInstitucionDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoRelacionInstitucionDomain domain = TipoRelacionInstitucionAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.TipoRelacionInstitucionFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.TipoRelacionInstitucionFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<TipoRelacionInstitucionDTO> list(TipoRelacionInstitucionDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoRelacionInstitucionDomain domainList = TipoRelacionInstitucionAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoRelacionInstitucionDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoRelacionInstitucionAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoRelacionInstitucionFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoRelacionInstitucionFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }
}
