package co.edu.uco.publiuco.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class RevisorRevisionDomain {
    private UUID identificador;
    private RevisionDomain revision;
    private RevisorDomain revisor;
    private LocalDateTime fechaAsignacionRevision;
    private LocalDateTime fechaCompletitudRevision;
    private EstadoDomain estado;
    public static RevisorRevisionDomain DEFAULT_OBJECT = new RevisorRevisionDomain();

    private RevisorRevisionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setRevision(RevisionDomain.getDefaultObject());
        setRevisor(RevisorDomain.getDefaultObject());
        setFechaAsignacionRevision(UtilDate.getDefaultValue());
        setFechaCompletitudRevision(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());

    }
    public RevisorRevisionDomain(UUID identificador, RevisionDomain revision, RevisorDomain revisor, LocalDateTime fechaAsignacionRevision, LocalDateTime fechaCompletitudRevision, EstadoDomain estado) {
        setIdentificador(identificador);
        setRevision(revision);
        setRevisor(revisor);
        setFechaAsignacionRevision(fechaAsignacionRevision);
        setFechaCompletitudRevision(fechaCompletitudRevision);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public RevisionDomain getRevision() {
        return revision;
    }

    public RevisorDomain getRevisor() {
        return revisor;
    }

    public LocalDateTime getFechaAsignacionRevision() {
        return fechaAsignacionRevision;
    }

    public LocalDateTime getFechaCompletitudRevision() {
        return fechaCompletitudRevision;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public RevisorRevisionDomain setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
        return this;
    }

    private void setRevision(final RevisionDomain revision) {
        this.revision = UtilObject.getDefault(revision, RevisionDomain.getDefaultObject());
    }

    private void setRevisor(final RevisorDomain revisor) {
        this.revisor = UtilObject.getDefault(revisor, RevisorDomain.getDefaultObject());
    }

    private void setFechaAsignacionRevision(final LocalDateTime fechaAsignacionRevision) {
        this.fechaAsignacionRevision = UtilDate.getDefault(fechaAsignacionRevision);
    }

    private void setFechaCompletitudRevision(final LocalDateTime fechaCompletitudRevision) {
        this.fechaCompletitudRevision = UtilDate.getDefault(fechaCompletitudRevision);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static RevisorRevisionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
