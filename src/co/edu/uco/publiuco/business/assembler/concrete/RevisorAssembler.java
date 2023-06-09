package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.RevisorDomain;
import co.edu.uco.publiuco.dto.RevisorDTO;
import co.edu.uco.publiuco.entities.RevisorEntity;

import java.util.List;

public final class RevisorAssembler implements Assembler<RevisorDomain, RevisorDTO, RevisorEntity> {
    public static final RevisorAssembler INSTANCE = new RevisorAssembler();
    public static RevisorAssembler getInstance() { return INSTANCE; }
    private RevisorAssembler(){
        super();
    }
    @Override
    public RevisorDTO toDTOFromDomain(RevisorDomain domain) {
        return RevisorDTO.create().setIdentificador(domain.getIdentificador()).setEstado(EstadoAssembler.getInstance().toDTOFromDomain(domain.getEstado()))
                .setDatosPersona(PersonaAssembler.getInstance().toDTOFromDomain(domain.getDatosPersona()));
    }

    @Override
    public RevisorDomain toDomainFromDTO(RevisorDTO dto) {
        return new RevisorDomain(dto.getIdentificador(),PersonaAssembler.getInstance().toDomainFromDTO(dto.getDatosPersona()), EstadoAssembler.getInstance().toDomainFromDTO(dto.getEstado()));
    }

    @Override
    public RevisorEntity toEntityFromDomain(RevisorDomain domain) {
        return new RevisorEntity(domain.getIdentificador(),PersonaAssembler.getInstance().toEntityFromDomain(domain.getDatosPersona()), EstadoAssembler.getInstance().toEntityFromDomain(domain.getEstado()));
    }

    @Override
    public RevisorDomain toDomainFromEntity(RevisorEntity entity) {
        return new RevisorDomain(entity.getIdentificador(),PersonaAssembler.getInstance().toDomainFromEntity(entity.getDatosPersona()),EstadoAssembler.getInstance().toDomainFromEntity(entity.getEstado()));
    }

    @Override
    public List<RevisorDomain> toDomainFromEntityList(List<RevisorEntity> entityList) {
        return entityList.stream().map(entity -> toDomainFromEntity(entity)).toList();

    }

    @Override
    public List<RevisorDomain> toDomainFromDTOList(List<RevisorDTO> dtoList) {
        return dtoList.stream().map(dto -> toDomainFromDTO(dto)).toList();    }

    @Override
    public List<RevisorDTO> toDTOFromDomainList(List<RevisorDomain> domainList) {
        return domainList.stream().map(domain -> toDTOFromDomain(domain)).toList();

    }
}
