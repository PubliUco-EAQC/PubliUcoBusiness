package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class RevisionDomain {
    private UUID identificador;
    private VersionDomain version;
    private TipoRevisionDomain tipoRevision;
    private LocalDateTime fechaSolicitudRevision;
    private LocalDateTime fechaLimiteRevision;
    private LocalDateTime fechaCompletitudRevision;
    private EstadoDomain estado;
    public static RevisionDomain DEFAULT_OBJECT = new RevisionDomain();

    private RevisionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setVersion(VersionDomain.getDefaultObject());
        setTipoRevision(TipoRevisionDomain.getDefaultObject());
        setFechaSolicitudRevision(UtilDate.getDefaultValue());
        setFechaLimiteRevision(UtilDate.getDefaultValue());
        setFechaCompletitudRevision(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }
    public RevisionDomain(UUID identificador, VersionDomain version, TipoRevisionDomain tipoRevision, LocalDateTime fechaSolicitudRevision, LocalDateTime fechaLimiteRevision, LocalDateTime fechaCompletitudRevision, EstadoDomain estado) {
        setIdentificador(identificador);
        setVersion(version);
        setTipoRevision(tipoRevision);
        setFechaSolicitudRevision(fechaSolicitudRevision);
        setFechaLimiteRevision(fechaLimiteRevision);
        setFechaCompletitudRevision(fechaCompletitudRevision);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public VersionDomain getVersion() {
        return version;
    }

    public TipoRevisionDomain getTipoRevision() {
        return tipoRevision;
    }

    public LocalDateTime getFechaSolicitudRevision() {
        return fechaSolicitudRevision;
    }

    public LocalDateTime getFechaLimiteRevision() {
        return fechaLimiteRevision;
    }

    public LocalDateTime getFechaCompletitudRevision() {
        return fechaCompletitudRevision;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setVersion(final VersionDomain version) {
        this.version = UtilObject.getDefault(version, VersionDomain.getDefaultObject());
    }

    private void setTipoRevision(final TipoRevisionDomain tipoRevision) {
        this.tipoRevision = UtilObject.getDefault(tipoRevision, TipoRevisionDomain.getDefaultObject());
    }

    private void setFechaSolicitudRevision(final LocalDateTime fechaSolicitudRevision) {
        this.fechaSolicitudRevision = UtilDate.getDefault(fechaSolicitudRevision);
    }

    private void setFechaLimiteRevision(final LocalDateTime fechaLimiteRevision) {
        this.fechaLimiteRevision = UtilDate.getDefault(fechaLimiteRevision);
    }

    private void setFechaCompletitudRevision(final LocalDateTime fechaCompletitudRevision) {
        this.fechaCompletitudRevision = UtilDate.getDefault(fechaCompletitudRevision);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static RevisionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
