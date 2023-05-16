package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class TipoIdentificacionDomain {
    private UUID identificador;
    private String nombre;
    private String descripcion;
    public static TipoIdentificacionDomain DEFAULT_OBJECT = new TipoIdentificacionDomain();

    private TipoIdentificacionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setNombre(UtilText.getDefaultValue());
        setDescripcion(UtilText.getDefaultValue());
    }
    public TipoIdentificacionDomain(UUID identificador, String nombre, String descripcion) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDescripcion(descripcion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }


    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private void setDescripcion(final String descripcion) {
        this.descripcion = UtilText.applyTrim(descripcion);
    }

    public static TipoIdentificacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}


