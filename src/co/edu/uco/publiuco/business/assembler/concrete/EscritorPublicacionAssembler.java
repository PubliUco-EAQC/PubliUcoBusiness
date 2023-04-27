package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.UUID;

public class EscritorPublicacionAssembler {
    private UUID identificador;
    private PublicacionEntity publicacion;
    private EscritorAssembler escritor;
    private TipoEscritorEntity tipoEscritor;

    public EscritorPublicacionAssembler(UUID identificador, PublicacionEntity publicacion, EscritorAssembler escritor, TipoEscritorEntity tipoEscritor) {
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

    public EscritorAssembler getEscritor() {
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

    private void setEscritor(EscritorAssembler escritor) {
        this.escritor = escritor;
    }

    private void setTipoEscritor(TipoEscritorEntity tipoEscritor) {
        this.tipoEscritor = tipoEscritor;
    }
}