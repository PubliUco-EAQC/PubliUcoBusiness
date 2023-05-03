package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;

public final class HistorialAccesoPublicacionDomain {
    private UUID identificador;
    private LectorDomain lector;
    private PublicacionDomain publicacion;
    private LocalDateTime fechaAcceso;
    public static HistorialAccesoPublicacionDomain DEFAULT_OBJECT = new HistorialAccesoPublicacionDomain();

    private HistorialAccesoPublicacionDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setLector(LectorDomain.getDefaultObject());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setFechaAcceso(UtilDate.getDefaultValue());
    }

    public HistorialAccesoPublicacionDomain(UUID identificador, LectorDomain lector, PublicacionDomain publicacion, LocalDateTime fechaAcceso) {
        super();
        setIdentificador(identificador);
        setLector(lector);
        setPublicacion(publicacion);
        setFechaAcceso(fechaAcceso);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public LectorDomain getLector() {
        return lector;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public LocalDateTime getFechaAcceso() {
        return fechaAcceso;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setLector(final LectorDomain lector) {
        this.lector = UtilObject.getDefault(lector, LectorDomain.getDefaultObject());
    }

    private void setPublicacion(final PublicacionDomain publicacion) {
        this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
    }

    private void setFechaAcceso(final LocalDateTime fechaAcceso) {
        this.fechaAcceso = UtilDate.getDefault(fechaAcceso);
    }
    public static HistorialAccesoPublicacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
