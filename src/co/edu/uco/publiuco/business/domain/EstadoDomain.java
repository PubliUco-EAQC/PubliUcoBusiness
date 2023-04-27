package co.edu.uco.publiuco.business.domain;


import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;


public final class EstadoDomain {

    private UUID identificador;
    private String nombre;
    private TipoEstadoDomain tipoEstado;

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
        this.tipoEstado = tipoEstado;
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
}