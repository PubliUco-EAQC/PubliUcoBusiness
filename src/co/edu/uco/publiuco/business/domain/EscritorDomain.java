package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public final class EscritorDomain {
    private UUID identificador;
    private PersonaDomain datosPersona;
    private TipoRelacionInstitucionDomain tipoRelacionInstitucion;
    private EstadoDomain estado;
    public static EscritorDomain DEFAULT_OBJECT = new EscritorDomain();

    private EscritorDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setDatosPersona(PersonaDomain.getDefaultObject());
        setTipoRelacionInstitucion(TipoRelacionInstitucionDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }
    public EscritorDomain(UUID identificador, PersonaDomain datosPersona, TipoRelacionInstitucionDomain tipoRelacionInstitucion, EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setDatosPersona(datosPersona);
        setTipoRelacionInstitucion(tipoRelacionInstitucion);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PersonaDomain getDatosPersona() {
        return datosPersona;
    }

    public TipoRelacionInstitucionDomain getTipoRelacionInstitucion() {
        return tipoRelacionInstitucion;
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

    private void setTipoRelacionInstitucion(TipoRelacionInstitucionDomain tipoRelacionInstitucion) {
        this.tipoRelacionInstitucion = UtilObject.getDefault(tipoRelacionInstitucion, TipoRelacionInstitucionDomain.getDefaultObject());
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static EscritorDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
