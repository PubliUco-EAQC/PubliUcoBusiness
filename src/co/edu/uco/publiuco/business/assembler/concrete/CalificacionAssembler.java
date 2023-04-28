package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import java.time.LocalDateTime;
import java.util.UUID;

public class CalificacionAssembler {
    private UUID identificador;
    private PublicacionAssembler publicacion;
    private LectorAssembler lector;
    private LocalDateTime fechaCalificacion;
    private String calificacion;

    public CalificacionAssembler(UUID identificador, PublicacionEntity publicacion, LectorEntity lector, LocalDateTime fechaCalificacion, String calificacion) {
        super();
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setLector(lector);
        setFechaCalificacion(fechaCalificacion);
        setCalificacion(calificacion);
    }

    private final void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private final void setPublicacion(PublicacionEntity publicacion) {
        this.publicacion = publicacion;
    }

    private final void setLector(LectorEntity lector) {
        this.lector = lector;
    }

    private final void setFechaCalificacion(LocalDateTime fechaCalificacion) {
        this.fechaCalificacion = fechaCalificacion;
    }

    private final void setCalificacion(String calificacion) {
        this.calificacion = UtilText.applyTrim(calificacion);
    }
    
    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionEntity getPublicacion() {
        return publicacion;
    }

    public LectorEntity getLector() {
        return lector;
    }

    public LocalDateTime getFechaCalificacion() {
        return fechaCalificacion;
    }

    public String getCalificacion() {
        return calificacion;
    }
}