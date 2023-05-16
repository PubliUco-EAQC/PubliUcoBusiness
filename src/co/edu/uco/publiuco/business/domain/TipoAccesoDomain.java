package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class TipoAccesoDomain {
    private UUID identificador;
    private String nombre;
    private String descripcion;
    private EstadoDomain estado;
    public static TipoAccesoDomain DEFAULT_OBJECT = new TipoAccesoDomain();

    private TipoAccesoDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setNombre(UtilText.getDefaultValue());
        setDescripcion(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }
    public TipoAccesoDomain(UUID identificador, String nombre, String descripcion, EstadoDomain estado) {
        setIdentificador(identificador);
        setNombre(nombre);
        setDescripcion(descripcion);
        setEstado(estado);
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

    public EstadoDomain getEstado() {
        return estado;
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

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static TipoAccesoDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }

}
