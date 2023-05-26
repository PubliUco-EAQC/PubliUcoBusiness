package co.edu.uco.publiuco.business.facade.impl;

import co.edu.uco.publiuco.business.assembler.concrete.PaisAssembler;
import co.edu.uco.publiuco.business.business.PaisBusiness;
import co.edu.uco.publiuco.business.business.impl.PaisBusinessImpl;
import co.edu.uco.publiuco.business.domain.PaisDomain;
import co.edu.uco.publiuco.business.facade.PaisFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.PaisDTO;
import co.edu.uco.publiuco.utils.Messages;

import java.util.List;

public final class PaisFacadeImpl implements PaisFacade {
    private final DAOFactory daoFactory;
    private final PaisBusiness business;

    public PaisFacadeImpl() {
        daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
        business = new PaisBusinessImpl(daoFactory);
    }



    @Override
    public List<PaisDTO> list(PaisDTO dto) {
        try {
            daoFactory.initTransaction();
            final PaisDomain domainList = PaisAssembler.getInstance().toDomainFromDTO(dto);

            List<PaisDomain> lista = business.list(domainList);

            daoFactory.commitTransaction();

            return PaisAssembler.getInstance().toDTOFromDomainList(lista);


        } catch (final PubliUcoException exception) {
            throw exception;
        } catch (final Exception exception) {
            var userMessage = Messages.PaisFacadeImplMessages.USER_MESSAGE_LIST;
            var technicalMessage = Messages.PaisFacadeImplMessages.TECHNICAL_MESSAGE_LIST;

            throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
        } finally {
            daoFactory.closeConnection();

        }
    }

}
