package co.edu.uco.publiuco.business.domain;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public final class AdministradorCategoriaDomain {
    private UUID identificador;
    private PersonaDomain datosPersona;
    private EstadoDomain estado;
    public static AdministradorCategoriaDomain DEFAULT_OBJECT = new AdministradorCategoriaDomain();
    private AdministradorCategoriaDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPersona(PersonaDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }


    public AdministradorCategoriaDomain(UUID identificador, PersonaDomain persona, EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setPersona(persona);
        setEstado(estado);
    }

    private final void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private final void setPersona(final PersonaDomain datosPersona) {
        this.datosPersona = UtilObject.getDefault(datosPersona, PersonaDomain.getDefaultObject());
    }

    private final void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    public final UUID getIdentificador() {
        return identificador;
    }

    public final PersonaDomain getPersona() {
        return datosPersona;
    }

    public final EstadoDomain getEstado() {
        return estado;
    }

    public static AdministradorCategoriaDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
