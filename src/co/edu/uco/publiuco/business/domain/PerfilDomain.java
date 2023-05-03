package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public final class PerfilDomain {
    private UUID identificador;
    private LectorDomain lector;
    private RespuestaDomain deseaRecibirRecomendacionesDeCategoria;
    private RespuestaDomain deseaRecibirRecomendacionesDeAutor;
    public static PerfilDomain DEFAULT_OBJECT = new PerfilDomain();

    private PerfilDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setLector(LectorDomain.getDefaultObject());
        setDeseaRecibirRecomendacionesDeCategoria(RespuestaDomain.getDefaultObject());
        setDeseaRecibirRecomendacionesDeAutor(RespuestaDomain.getDefaultObject());
    }

    public PerfilDomain(UUID identificador, LectorDomain lector, RespuestaDomain deseaRecibirRecomendacionesDeCategoria, RespuestaDomain deseaRecibirRecomendacionesDeAutor) {
       super();
       setIdentificador(identificador);
       setLector(lector);
       setDeseaRecibirRecomendacionesDeCategoria(deseaRecibirRecomendacionesDeCategoria);
       setDeseaRecibirRecomendacionesDeAutor(deseaRecibirRecomendacionesDeAutor);
    }

    public UUID getIdentificador(){
        return identificador;
    }

    public LectorDomain getLector() {
        return lector;
    }

    public RespuestaDomain getDeseaRecibirRecomendacionesDeCategoria() {
        return deseaRecibirRecomendacionesDeCategoria;
    }

    public RespuestaDomain getDeseaRecibirRecomendacionesDeAutor() {
        return deseaRecibirRecomendacionesDeAutor;
    }

    public PerfilDomain setIdentificador(UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
        return this;
    }

    private void setLector(final LectorDomain lector) {
        this.lector = UtilObject.getDefault(lector, LectorDomain.getDefaultObject());
    }

    private void setDeseaRecibirRecomendacionesDeCategoria(final RespuestaDomain deseaRecibirRecomendacionesDeCategoria) {
        this.deseaRecibirRecomendacionesDeCategoria = UtilObject.getDefault(deseaRecibirRecomendacionesDeCategoria, RespuestaDomain.getDefaultObject());
    }

    private void setDeseaRecibirRecomendacionesDeAutor(final RespuestaDomain deseaRecibirRecomendacionesDeAutor) {
        this.deseaRecibirRecomendacionesDeAutor = UtilObject.getDefault(deseaRecibirRecomendacionesDeAutor, RespuestaDomain.getDefaultObject());
    }
    public static PerfilDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
