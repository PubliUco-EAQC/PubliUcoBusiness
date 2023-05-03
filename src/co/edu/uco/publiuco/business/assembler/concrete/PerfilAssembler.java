package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PerfilDomain;
import co.edu.uco.publiuco.dto.PerfilDTO;
import co.edu.uco.publiuco.entities.PerfilEntity;

public final class PerfilAssembler implements Assembler<PerfilDomain, PerfilDTO, PerfilEntity> {
    public static final PerfilAssembler INSTANCE = new PerfilAssembler();
    public static PerfilAssembler getInstance() { return INSTANCE; }
    private PerfilAssembler(){
        super();
    }
    @Override
    public PerfilDTO toDTOFromDomain(PerfilDomain domain) {
        return PerfilDTO.create().setIdentificador(domain.getIdentificador()).setLector(LectorAssembler.getInstance().toDTOFromDomain(domain.getLector()))
                .setDeseaRecibirRecomendacionesDeAutor(RespuestaAssembler.getInstance().toDTOFromDomain(domain.getDeseaRecibirRecomendacionesDeAutor()))
                .setDeseaRecibirRecomendacionesDeCategoria(RespuestaAssembler.getInstance().toDTOFromDomain(domain.getDeseaRecibirRecomendacionesDeCategoria()));
    }

    @Override
    public PerfilDomain toDomainFromDTO(PerfilDTO dto) {
        return new PerfilDomain(dto.getIdentificador(),LectorAssembler.getInstance().toDomainFromDTO(dto.getLector()),
                RespuestaAssembler.getInstance().toDomainFromDTO(dto.getDeseaRecibirRecomendacionesDeCategoria()),RespuestaAssembler.getInstance().toDomainFromDTO(dto.getDeseaRecibirRecomendacionesDeAutor()));
    }

    @Override
    public PerfilEntity toEntityFromDomain(PerfilDomain domain) {
        return new PerfilEntity(domain.getIdentificador(),LectorAssembler.getInstance().toEntityFromDomain(domain.getLector()),
                RespuestaAssembler.getInstance().toEntityFromDomain(domain.getDeseaRecibirRecomendacionesDeCategoria()),RespuestaAssembler.getInstance().toEntityFromDomain(domain.getDeseaRecibirRecomendacionesDeAutor()) );
    }

    @Override
    public PerfilDomain toDomainFromEntity(PerfilEntity entity) {
        return new PerfilDomain(entity.getIdentificador(),LectorAssembler.getInstance().toDomainFromEntity(entity.getLector()),
                RespuestaAssembler.getInstance().toDomainFromEntity(entity.getDeseaRecibirRecomendacionesDeCategoria()),RespuestaAssembler.getInstance().toDomainFromEntity(entity.getDeseaRecibirRecomendacionesDeAutor()) );
    }
}
