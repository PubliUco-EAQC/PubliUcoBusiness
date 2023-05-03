package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public final class TipoRelacionInstitucionDomain {
    private UUID identificador;
    private String nombre;
    private String descripcion;
    private EstadoDomain estado;
    public static TipoRelacionInstitucionDomain DEFAULT_OBJECT = new TipoRelacionInstitucionDomain();

    private TipoRelacionInstitucionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setNombre(UtilText.getDefaultValue());
        setDescripcion(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }
    public TipoRelacionInstitucionDomain(UUID identificador, String nombre, String descripcion, EstadoDomain estado) {
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
        this.estado = estado;
    }
    public static TipoRelacionInstitucionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }

}


