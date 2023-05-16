package co.edu.uco.publiuco.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class PublicacionDomain {
    private UUID identificador;
    private CategoriaDomain categoria;
    private TipoAccesoDomain tipoAcceso;
    private LocalDateTime fechaPublicacion;
    private VersionDomain versionPublicada;
    private EstadoDomain estado;
    public static PublicacionDomain DEFAULT_OBJECT = new PublicacionDomain();

    private PublicacionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setCategoria(CategoriaDomain.getDefaultObject());
        setTipoAcceso(TipoAccesoDomain.getDefaultObject());
        setFechaPublicacion(UtilDate.getDefaultValue());
        setVersionPublicada(VersionDomain.getDefaultObject());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public PublicacionDomain(UUID identificador, CategoriaDomain categoria, TipoAccesoDomain tipoAcceso, LocalDateTime fechaPublicacion, VersionDomain versionPublicada, EstadoDomain estado) {
        setIdentificador(identificador);
        setCategoria(categoria);
        setTipoAcceso(tipoAcceso);
        setFechaPublicacion(fechaPublicacion);
        setVersionPublicada(versionPublicada);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public CategoriaDomain getCategoria() {
        return categoria;
    }

    public TipoAccesoDomain getTipoAcceso() {
        return tipoAcceso;
    }

    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    public VersionDomain getVersionPublicada() {
        return versionPublicada;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setCategoria(final CategoriaDomain categoria) {
        this.categoria = UtilObject.getDefault(categoria, CategoriaDomain.getDefaultObject());
    }

    private void setTipoAcceso(final TipoAccesoDomain tipoAcceso) {
        this.tipoAcceso = UtilObject.getDefault(tipoAcceso, TipoAccesoDomain.getDefaultObject());
    }

    private void setFechaPublicacion(final LocalDateTime fechaPublicacion) {
        this.fechaPublicacion = UtilDate.getDefault(fechaPublicacion);
    }

    private void setVersionPublicada(final VersionDomain versionPublicada) {
        this.versionPublicada = UtilObject.getDefault(versionPublicada, VersionDomain.getDefaultObject());
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static PublicacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
