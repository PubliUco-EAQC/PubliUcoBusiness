package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

public class EscritorPublicacionDomain {
    private UUID identificador;
    private PublicacionEntity publicacion;
    private EscritorDomain escritor;
    private TipoEscritorEntity tipoEscritor;

    public EscritorPublicacionDomain(UUID identificador, PublicacionEntity publicacion, EscritorDomain escritor, TipoEscritorEntity tipoEscritor) {
        super();
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setEscritor(escritor);
        setTipoEscritor(tipoEscritor);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionEntity getPublicacion() {
        return publicacion;
    }

    public EscritorDomain getEscritor() {
        return escritor;
    }

    public TipoEscritorEntity getTipoEscritor() {
        return tipoEscritor;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setPublicacion(PublicacionEntity publicacion) {
        this.publicacion = publicacion;
    }

    private void setEscritor(EscritorDomain escritor) {
        this.escritor = escritor;
    }

    private void setTipoEscritor(TipoEscritorEntity tipoEscritor) {
        this.tipoEscritor = tipoEscritor;
    }
}