package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class RevisorDomain {
    private UUID identificador;
    private PersonaDomain datosPersona;
    private EstadoDomain estado;
    public static RevisorDomain DEFAULT_OBJECT = new RevisorDomain();

    private RevisorDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setDatosPersona(PersonaDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }
    public RevisorDomain(UUID identificador, PersonaDomain datosPersona, EstadoDomain estado) {
        setIdentificador(identificador);
        setDatosPersona(datosPersona);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PersonaDomain getDatosPersona() {
        return datosPersona;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setDatosPersona(final PersonaDomain datosPersona) {
        this.datosPersona = UtilObject.getDefault(datosPersona, PersonaDomain.getDefaultObject());
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static RevisorDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
