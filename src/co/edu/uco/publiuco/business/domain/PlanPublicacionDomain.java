package co.edu.uco.publiuco.business.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilDate;
import co.edu.uco.publiuco.utils.UtilNumber;
import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class PlanPublicacionDomain {
    private UUID identificador;
    private PublicacionDomain publicacion;
    private Double precio;
    private LocalDateTime fechaDesde;
    private LocalDateTime fechaHasta;
    private EstadoDomain estado;
    public static PlanPublicacionDomain DEFAULT_OBJECT = new PlanPublicacionDomain();

    private PlanPublicacionDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setPrecio(UtilNumber.getRealDefaultValue());
        setFechaDesde(UtilDate.getDefaultValue());
        setFechaHasta(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public PlanPublicacionDomain(UUID identificador, PublicacionDomain publicacion, Double precio, LocalDateTime fechaDesde, LocalDateTime fechaHasta, EstadoDomain estado) {
        super();
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setPrecio(precio);
        setFechaDesde(fechaDesde);
        setFechaHasta(fechaHasta);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public Double getPrecio() {
        return precio;
    }

    public LocalDateTime getFechaDesde() {
        return fechaDesde;
    }

    public LocalDateTime getFechaHasta() {
        return fechaHasta;
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

    private void setPrecio(final Double precio) {
        this.precio = UtilNumber.getDefaultReal(precio);
    }

    private void setFechaDesde(final LocalDateTime fechaDesde) {
        this.fechaDesde = UtilDate.getDefault(fechaDesde);
    }

    private void setFechaHasta(final LocalDateTime fechaHasta) {
        this.fechaHasta = UtilDate.getDefault(fechaHasta);
    }

    private void setEstado(final EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }
    public static PlanPublicacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
