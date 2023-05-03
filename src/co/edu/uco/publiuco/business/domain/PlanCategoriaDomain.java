package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilNumber;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;
import java.time.LocalDateTime;

public final class PlanCategoriaDomain {
    private UUID identificador;
    private CategoriaDomain categoria;
    private Double precio;
    private LocalDateTime fechaDesde;
    private LocalDateTime fechaHasta;
    private EstadoDomain estado;
    public static PlanCategoriaDomain DEFAULT_OBJECT = new PlanCategoriaDomain();

    private PlanCategoriaDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setCategoria(CategoriaDomain.getDefaultObject());
        setPrecio(UtilNumber.getRealDefaultValue());
        setFechaDesde(UtilDate.getDefaultValue());
        setFechaHasta(UtilDate.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public PlanCategoriaDomain(UUID identificador, CategoriaDomain categoria, Double precio, LocalDateTime fechaDesde, LocalDateTime fechaHasta, EstadoDomain estado) {
       super();
       setIdentificador(identificador);
       setCategoria(categoria);
       setPrecio(precio);
       setFechaDesde(fechaDesde);
       setFechaHasta(fechaHasta);
       setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public CategoriaDomain getCategoria() {
        return categoria;
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

    private void setCategoria(final CategoriaDomain categoria) {
        this.categoria = UtilObject.getDefault(categoria, CategoriaDomain.getDefaultObject());
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
    public static PlanCategoriaDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
