package co.edu.uco.publiuco.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class ReporteDomain {
    private UUID identificador;
    private LectorDomain lector;
    private ComentarioLectorDomain comentario;
    private String razon;
    private TipoReporteDomain tipoReporte;
    private LocalDateTime fechaReporte;
    public static ReporteDomain DEFAULT_OBJECT = new ReporteDomain();

    private ReporteDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setLector(LectorDomain.getDefaultObject());
        setComentario(ComentarioLectorDomain.getDefaultObject());
        setRazon(UtilText.getDefaultValue());
        setTipoReporte(TipoReporteDomain.getDefaultObject());
        setFechaReporte(UtilDate.getDefaultValue());
    }

    public ReporteDomain(UUID identificador, LectorDomain lector, ComentarioLectorDomain comentario, String razon, TipoReporteDomain tipoReporte, LocalDateTime fechaReporte) {
        setIdentificador(identificador);
        setLector(lector);
        setComentario(comentario);
        setRazon(razon);
        setTipoReporte(tipoReporte);
        setFechaReporte(fechaReporte);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public LectorDomain getLector() {
        return lector;
    }

    public ComentarioLectorDomain getComentario() {
        return comentario;
    }

    public String getRazon() {
        return razon;
    }

    public TipoReporteDomain getTipoReporte() {
        return tipoReporte;
    }

    public LocalDateTime getFechaReporte() {
        return fechaReporte;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setLector(final LectorDomain lector) {
        this.lector = UtilObject.getDefault(lector, LectorDomain.getDefaultObject());
    }

    private void setComentario(final ComentarioLectorDomain comentario) {
        this.comentario = UtilObject.getDefault(comentario, ComentarioLectorDomain.getDefaultObject());
    }

    private void setRazon(final String razon) {
        this.razon = UtilText.applyTrim(razon);
    }

    private void setTipoReporte(final TipoReporteDomain tipoReporte) {
        this.tipoReporte = UtilObject.getDefault(tipoReporte, TipoReporteDomain.getDefaultObject());
    }

    private void setFechaReporte(final LocalDateTime fechaReporte) {
        this.fechaReporte = UtilDate.getDefault(fechaReporte);
    }
    public static ReporteDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
