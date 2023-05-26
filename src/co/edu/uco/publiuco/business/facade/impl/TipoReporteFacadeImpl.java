package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.TipoReporteAssembler;
import co.edu.uco.publiuco.business.business.TipoReporteBusiness;
import co.edu.uco.publiuco.business.business.impl.TipoReporteBusinessImpl;
import co.edu.uco.publiuco.business.domain.TipoReporteDomain;
import co.edu.uco.publiuco.business.facade.TipoReporteFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.TipoReporteDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class TipoReporteFacadeImpl implements TipoReporteFacade {
    private final DAOFactory daoFactory;
    private final TipoReporteBusiness business;

    public TipoReporteFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new TipoReporteBusinessImpl(daoFactory);
    }

    @Override
    public void register(TipoReporteDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoReporteDomain domain = TipoReporteAssembler.getInstance().toDomainFromDTO(dto);

            business.register(domain);

            daoFactory.commitTransaction();


        } catch (final PubliUcoException exception) {
            daoFactory.rollbackTransaction();
            throw exception;
        } catch (final Exception exception) {
            daoFactory.rollbackTransaction();
            var userMessage = Messages.TipoReporteFacadeImplMessages.USER_MESSAGE_REGISTER;
            var technicalMessage = Messages.TipoReporteFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();
        }
    }

    @Override
    public List<TipoReporteDTO> list(TipoReporteDTO dto) {
        try {
            daoFactory.initTransaction();
            final TipoReporteDomain domainList = TipoReporteAssembler.getInstance().toDomainFromDTO(dto);

            List<TipoReporteDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return TipoReporteAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.TipoReporteFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.TipoReporteFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }
}
