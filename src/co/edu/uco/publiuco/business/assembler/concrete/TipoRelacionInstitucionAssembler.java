package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.List;


import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.TipoRelacionInstitucionDomain;
import co.edu.uco.publiuco.dto.TipoRelacionInstitucionDTO;
import co.edu.uco.publiuco.entities.TipoRelacionInstitucionEntity;

public final class TipoRelacionInstitucionAssembler implements Assembler<TipoRelacionInstitucionDomain, TipoRelacionInstitucionDTO,TipoRelacionInstitucionEntity> {

    public static final TipoRelacionInstitucionAssembler INSTANCE = new TipoRelacionInstitucionAssembler();
    public static TipoRelacionInstitucionAssembler getInstance() { return INSTANCE; }
    private TipoRelacionInstitucionAssembler(){
        super();
    }
    @Override
    public TipoRelacionInstitucionDTO toDTOFromDomain(TipoRelacionInstitucionDomain domain) {
        return new TipoRelacionInstitucionDTO().setIdentificador(domain.getIdentificador()).setNombre(domain.getNombre()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()));
    }

    @Override
    public TipoRelacionInstitucionDomain toDomainFromDTO(TipoRelacionInstitucionDTO dto) {
        return null;
    }

    @Override
    public TipoRelacionInstitucionEntity toEntityFromDomain(TipoRelacionInstitucionDomain domain) {
        return null;
    }

    @Override
    public TipoRelacionInstitucionDomain toDomainFromEntity(TipoRelacionInstitucionEntity entity) {
        return null;
    }
    
	@Override
	public List<TipoRelacionInstitucionDomain> toDomainFromEntityList(List<TipoRelacionInstitucionEntity> entityList) {
		// TODO Auto-generated method stub
		return null;
	}
}
