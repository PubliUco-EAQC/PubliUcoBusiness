package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoBusinessImpl;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.business.facade.EstadoFacade;
import co.edu.uco.publiuco.crosscutting.exceptions.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exceptions.PubliUcoException;
import co.edu.uco.publiuco.crosscutting.utils.Messages.EstadoFacadeImplMessages;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoDTO;

public class EstadoFacadeImpl implements EstadoFacade {

	private DAOFactory daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
	
	private final EstadoBusiness business;
	
	public EstadoFacadeImpl() {
		
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoBusinessImpl(daoFactory);
		
	}
	
	@Override
	public void register(final EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			
			final EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			business.register(domain);
			
			daoFactory.commitTransaction();
		} catch (final PubliUcoException exception ) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception ) {
			daoFactory.cancelTransaction();
			
			var userMessage = EstadoFacadeImplMessages.REGISTER_USER_MESSAGE;
			var technicalMessage = EstadoFacadeImplMessages.REGISTER_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeTransaction();
		}
	}


	@Override
	public List<EstadoDTO> list(EstadoDTO dto) {
		try {
			
			final var userMessage = EstadoFacadeImplMessages.LIST_EXCEPTION_USER_MESSAGE;
			final var technicalMessage = EstadoFacadeImplMessages.LIST_EXCEPTION_TECHNICAL_MESSAGE;
			//return EstadoAssembler.getInstance()
		} catch (final PubliUcoException exception ) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception ) {
			daoFactory.cancelTransaction();
			
			var userMessage = EstadoFacadeImplMessages.MODIFY_USER_MESSAGE;
			var technicalMessage = EstadoFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeTransaction();
		}	}

	@Override
	public void modify(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			
			final EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			business.register(domain);
			
			daoFactory.commitTransaction();
		} catch (final PubliUcoException exception ) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception ) {
			daoFactory.cancelTransaction();
			
			var userMessage = EstadoFacadeImplMessages.MODIFY_USER_MESSAGE;
			var technicalMessage = EstadoFacadeImplMessages.MODIFY_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeTransaction();
		}
	}

	@Override
	public void drop(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			
			final EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			business.register(domain);
			
			daoFactory.commitTransaction();
		} catch (final PubliUcoException exception ) {
			daoFactory.cancelTransaction();
			throw exception;
		} catch (final Exception exception ) {
			daoFactory.cancelTransaction();
			
			var userMessage = EstadoFacadeImplMessages.DROP_USER_MESSAGE;
			var technicalMessage = EstadoFacadeImplMessages.DROP_EXCEPTION_TECHNICAL_MESSAGE;
			
			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeTransaction();
		}
	}

}