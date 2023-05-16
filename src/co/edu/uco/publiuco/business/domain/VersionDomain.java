package co.edu.uco.publiuco.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.publiuco.utils.*;

public final class VersionDomain {
    private UUID identificador;
    private PublicacionDomain publicacion;
    private VersionDomain versionAnterior;
    private Integer numeroVersion;
    private LocalDateTime fechaCreacion;
    private LocalDateTime ultimaFechaModificacion;
    private String titulo;
    private String resumen;
    private String cuerpo;
    private EstadoDomain estado;

    public static VersionDomain DEFAULT_OBJECT = new VersionDomain();


    private VersionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setVersionAnterior(getDefaultObject());
        setNumeroVersion(UtilNumber.getIntegerDefaultValue());
        setFechaCreacion(UtilDate.getDefaultValue());
        setUltimaFechaModificacion(UtilDate.getDefaultValue());
        setTitulo(UtilText.getDefaultValue());
        setResumen(UtilText.getDefaultValue());
        setCuerpo(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public VersionDomain(UUID identificador, PublicacionDomain publicacion, VersionDomain versionAnterior, int numeroVersion, LocalDateTime fechaCreacion, LocalDateTime ultimaFechaModificacion, String titulo, String resumen, String cuerpo, EstadoDomain estado) {
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setVersionAnterior(versionAnterior);
        setNumeroVersion(numeroVersion);
        setFechaCreacion(fechaCreacion);
        setUltimaFechaModificacion(ultimaFechaModificacion);
        setTitulo(titulo);
        setResumen(resumen);
        setCuerpo(cuerpo);
        setEstado(estado);
    }


    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public VersionDomain getVersionAnterior() {
        return versionAnterior;
    }

    public Integer getNumeroVersion() {
        return numeroVersion;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public LocalDateTime getUltimaFechaModificacion() {
        return ultimaFechaModificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumen() {
        return resumen;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPublicacion(final PublicacionDomain publicacion) {
        this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
    }

    private void setVersionAnterior(VersionDomain versionAnterior) {
        this.versionAnterior = UtilObject.getDefault(versionAnterior, VersionDomain.getDefaultObject());
    }

    private void setNumeroVersion(final Integer numeroVersion) {
        this.numeroVersion = UtilNumber.getDefaultInt(numeroVersion);
    }

    private void setFechaCreacion(final LocalDateTime fechaCreacion) {
        this.fechaCreacion = UtilDate.getDefault(fechaCreacion);
    }

    private void setUltimaFechaModificacion(final LocalDateTime ultimaFechaModificacion) {
        this.ultimaFechaModificacion = UtilDate.getDefault(ultimaFechaModificacion);
    }

    private void setTitulo(final String titulo) {
        this.titulo = UtilText.applyTrim(titulo);
    }

    private void setResumen(final String resumen) {
        this.resumen = UtilText.applyTrim(resumen);
    }

    private void setCuerpo(final String cuerpo) {
        this.cuerpo = UtilText.applyTrim(cuerpo);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static VersionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
