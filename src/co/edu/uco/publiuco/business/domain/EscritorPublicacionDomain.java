package co.edu.uco.publiuco.business.domain;
import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class EscritorPublicacionDomain {
    private UUID identificador;
    private PublicacionDomain publicacion;
    private EscritorDomain escritor;
    private TipoEscritorDomain tipoEscritor;
    public static EscritorPublicacionDomain DEFAULT_OBJECT = new EscritorPublicacionDomain();

    private EscritorPublicacionDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setEscritor(EscritorDomain.getDefaultObject());
        setTipoEscritor(TipoEscritorDomain.getDefaultObject());
    }

    public EscritorPublicacionDomain(UUID identificador, PublicacionDomain publicacion, EscritorDomain escritor, TipoEscritorDomain tipoEscritor) {
        super();
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setEscritor(escritor);
        setTipoEscritor(tipoEscritor);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public EscritorDomain getEscritor() {
        return escritor;
    }

    public TipoEscritorDomain getTipoEscritor() {
        return tipoEscritor;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPublicacion(final PublicacionDomain publicacion) {
        this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
    }

    private void setEscritor(final EscritorDomain escritor) {
        this.escritor = UtilObject.getDefault(escritor, EscritorDomain.getDefaultObject());
    }

    private void setTipoEscritor(final TipoEscritorDomain tipoEscritor) {
        this.tipoEscritor = UtilObject.getDefault(tipoEscritor, TipoEscritorDomain.getDefaultObject());
    }
    public static EscritorPublicacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
