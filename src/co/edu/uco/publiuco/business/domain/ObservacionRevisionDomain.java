package co.edu.uco.publiuco.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class ObservacionRevisionDomain {
    private UUID identificador;
    private EscritorPublicacionDomain escritorPublicacion;
    private ComentarioRevisorDomain comentarioRevisor;
    private LocalDateTime fechaReportePublicacion;
    private LocalDateTime fechaRevisionObservacion;
    private String observacion;
    private EstadoDomain estado;
    public static ObservacionRevisionDomain DEFAULT_OBJECT = new ObservacionRevisionDomain();

    private ObservacionRevisionDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setEscritorPublicacion(EscritorPublicacionDomain.getDefaultObject());
        setComentarioRevisor(ComentarioRevisorDomain.getDefaultObject());
        setFechaReportePublicacion(UtilDate.getDefaultValue());
        setFechaRevisionObservacion(UtilDate.getDefaultValue());
        setObservacion(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public ObservacionRevisionDomain(UUID identificador, EscritorPublicacionDomain escritorPublicacion, ComentarioRevisorDomain comentarioRevisor, LocalDateTime fechaReportePublicacion, LocalDateTime fechaRevisionObservacion, String observacion, EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setEscritorPublicacion(escritorPublicacion);
        setComentarioRevisor(comentarioRevisor);
        setFechaReportePublicacion(fechaReportePublicacion);
        setFechaRevisionObservacion(fechaRevisionObservacion);
        setObservacion(observacion);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public EscritorPublicacionDomain getEscritorPublicacion() {
        return escritorPublicacion;
    }

    public ComentarioRevisorDomain getComentarioRevisor() {
        return comentarioRevisor;
    }

    public LocalDateTime getFechaReportePublicacion() {
        return fechaReportePublicacion;
    }

    public LocalDateTime getFechaRevisionObservacion() {
        return fechaRevisionObservacion;
    }

    public String getObservacion() {
        return observacion;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setEscritorPublicacion(final EscritorPublicacionDomain escritorPublicacion) {
        this.escritorPublicacion = UtilObject.getDefault(escritorPublicacion, EscritorPublicacionDomain.getDefaultObject());
    }

    private void setComentarioRevisor(final ComentarioRevisorDomain comentarioRevisor) {
        this.comentarioRevisor = UtilObject.getDefault(comentarioRevisor, ComentarioRevisorDomain.getDefaultObject());
    }

    private void setFechaReportePublicacion(final LocalDateTime fechaReportePublicacion) {
        this.fechaReportePublicacion = UtilDate.getDefault(fechaReportePublicacion);
    }

    private void setFechaRevisionObservacion(final LocalDateTime fechaRevisionObservacion) {
        this.fechaRevisionObservacion = UtilDate.getDefault(fechaRevisionObservacion);
    }

    private void setObservacion(final String observacion) {
        this.observacion = UtilText.applyTrim(observacion);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static ObservacionRevisionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
