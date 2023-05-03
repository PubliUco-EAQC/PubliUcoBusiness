package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.business.assembler.Assembler;
import co.edu.uco.publiuco.business.domain.PreferenciaEscritorDomain;
import co.edu.uco.publiuco.dto.PreferenciaEscritorDTO;
import co.edu.uco.publiuco.entities.PreferenciaEscritorEntity;

public final class PreferenciaEscritorAssembler implements Assembler<PreferenciaEscritorDomain, PreferenciaEscritorDTO, PreferenciaEscritorEntity> {
    @Override
    public PreferenciaEscritorDTO toDTOFromDomain(PreferenciaEscritorDomain domain) {
        return PreferenciaEscritorDTO.create().setIdentificador(domain.getIdentificador()).setEscritor(EscritorAssembler.getInstance().toDTOFromDomain(domain.getEscritor()))
                .setPerfil(PerfilAssembler.getInstance().toDTOFromDomain(domain.getPerfil()));
    }

    @Override
    public PreferenciaEscritorDomain toDomainFromDTO(PreferenciaEscritorDTO dto) {
        return new PreferenciaEscritorDomain(dto.getIdentificador(),PerfilAssembler.getInstance().toDomainFromDTO(dto.getPerfil()),
                EscritorAssembler.getInstance().toDomainFromDTO(dto.getEscritor()));
    }

    @Override
    public PreferenciaEscritorEntity toEntityFromDomain(PreferenciaEscritorDomain domain) {
        return new PreferenciaEscritorEntity(domain.getIdentificador(),PerfilAssembler.getInstance().toEntityFromDomain(domain.getPerfil()),
                EscritorAssembler.getInstance().toEntityFromDomain(domain.getEscritor()));
    }

    @Override
    public PreferenciaEscritorDomain toDomainFromEntity(PreferenciaEscritorEntity entity) {
        return new PreferenciaEscritorDomain(entity.getIdentificador(),PerfilAssembler.getInstance().toDomainFromEntity(entity.getPerfil()),
                EscritorAssembler.getInstance().toDomainFromEntity(entity.getEscritor()));
    }
}
