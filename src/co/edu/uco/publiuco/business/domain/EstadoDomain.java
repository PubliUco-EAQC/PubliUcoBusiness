package co.edu.uco.publiuco.business.domain;


import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;


public final class EstadoDomain {

    private UUID identificador;
    private String nombre;
    private TipoEstadoDomain tipoEstado;
    public static EstadoDomain DEFAULT_OBJECT = new EstadoDomain();


    private EstadoDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setNombre(UtilText.getDefaultValue());
        setTipoEstado(TipoEstadoDomain.getDefaultObject());
    }


    public EstadoDomain(UUID identificador, String nombre, TipoEstadoDomain tipoEstado) {
        super();
        setIdentificador(identificador);
        setNombre(nombre);
        setTipoEstado(tipoEstado);
    }

    private final void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private final void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private final void setTipoEstado(final TipoEstadoDomain tipoEstado) {

        this.tipoEstado = UtilObject.getDefault(tipoEstado, TipoEstadoDomain.getDefaultObject());
    }

    public final UUID getIdentificador() {
        return identificador;
    }

    public final String getNombre() {
        return nombre;
    }

    public final TipoEstadoDomain getTipoEstado() {
        return tipoEstado;
    }

    public static EstadoDomain getDefaultObject(){
        return DEFAULT_OBJECT;
    }
}
