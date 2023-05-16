package co.edu.uco.publiuco.business.facade.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.publiuco.business.assembler.concrete.EstadoAssembler;
import co.edu.uco.publiuco.business.domain.EstadoDomain;
import co.edu.uco.publiuco.business.business.EstadoBusiness;
import co.edu.uco.publiuco.business.business.impl.EstadoBusinessImpl;
import co.edu.uco.publiuco.business.facade.EstadoFacade;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoBusinessException;
import co.edu.uco.publiuco.crosscutting.exception.PubliUcoException;
import co.edu.uco.publiuco.data.dao.factory.DAOFactory;
import co.edu.uco.publiuco.data.dao.factory.Factory;
import co.edu.uco.publiuco.dto.EstadoDTO;
import co.edu.uco.publiuco.utils.Messages.EstadoFacadeImplMessages;

public final class EstadoFacadeImpl implements EstadoFacade{

	private final DAOFactory daoFactory;
	private final EstadoBusiness business;
	
	public EstadoFacadeImpl() {
		daoFactory = DAOFactory.getFactory(Factory.POSTGRESQL);
		business = new EstadoBusinessImpl(daoFactory);
	}
	
	@Override
	public void register(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			business.register(domain);
			
			daoFactory.commitTransaction();
		
			
		} catch (final PubliUcoException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = EstadoFacadeImplMessages.USER_MESSAGE_REGISTER;
			var technicalMessage = EstadoFacadeImplMessages.TECHNICAL_MESSAGE_REGISTER;
			
			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
		
	}

	@Override
	public List<EstadoDTO> list(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoDomain domainList = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			List<EstadoDomain> lista = business.list(domainList); 
			
			daoFactory.commitTransaction();
			
			return EstadoAssembler.getInstance().toDTOFromDomainList(lista);
		
			
		} catch (final PubliUcoException exception) {
			throw exception;
		} catch (final Exception exception) {
			var userMessage = EstadoFacadeImplMessages.USER_MESSAGE_LIST;
			var technicalMessage = EstadoFacadeImplMessages.TECHNICAL_MESSAGE_LIST;
			
			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
	}

	@Override
	public void modify(EstadoDTO dto) {
		try {
			daoFactory.initTransaction();
			final EstadoDomain domain = EstadoAssembler.getInstance().toDomainFromDTO(dto);
			
			business.modify(domain);
			
			daoFactory.commitTransaction();
		
			
		} catch (final PubliUcoException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		} catch (final Exception exception) {
			daoFactory.rollbackTransaction();
			var userMessage = EstadoFacadeImplMessages.USER_MESSAGE_MODIFY;
			var technicalMessage = EstadoFacadeImplMessages.TECHNICAL_MESSAGE_MODIFY;
			
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
			var userMessage = EstadoFacadeImplMessages.USER_MESSAGE_DROP;
			var technicalMessage = EstadoFacadeImplMessages.TECHNICAL_MESSAGE_DROP;
			
			throw PubliUcoBusinessException.create(technicalMessage, userMessage, exception);
		} finally {
			daoFactory.closeConection();
		}
		
	}
	

}
