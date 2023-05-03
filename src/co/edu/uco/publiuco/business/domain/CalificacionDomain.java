package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class CalificacionDomain {
    private UUID identificador;
    private PublicacionDomain publicacion;
    private LectorDomain lector;
    private LocalDateTime fechaCalificacion;
    private String calificacion;
    public static CalificacionDomain DEFAULT_OBJECT = new CalificacionDomain();

    private CalificacionDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setLector(LectorDomain.getDefaultObject());
        setFechaCalificacion(UtilDate.getDefaultValue());
        setCalificacion(UtilText.getDefaultValue());
    }

    public CalificacionDomain(UUID identificador, PublicacionDomain publicacion, LectorDomain lector, LocalDateTime fechaCalificacion, String calificacion) {
        super();
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setLector(lector);
        setFechaCalificacion(fechaCalificacion);
        setCalificacion(calificacion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public LectorDomain getLector() {
        return lector;
    }

    public LocalDateTime getFechaCalificacion() {
        return fechaCalificacion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPublicacion(final PublicacionDomain publicacion) {
        this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
    }

    private void setLector(final LectorDomain lector) {
        this.lector = UtilObject.getDefault(lector, LectorDomain.getDefaultObject());
    }

    private void setFechaCalificacion(final LocalDateTime fechaCalificacion) {
        this.fechaCalificacion = UtilDate.getDefault(fechaCalificacion);
    }

    private void setCalificacion(final String calificacion) {
        this.calificacion = UtilText.applyTrim(calificacion);
    }
    public static CalificacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
