package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class PalabraClavePublicacionDomain {
    private UUID identificador;
    private PublicacionDomain publicacion;
    private String palabraClave;
    public static PalabraClavePublicacionDomain DEFAULT_OBJECT = new PalabraClavePublicacionDomain();

    private PalabraClavePublicacionDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPublicacion(PublicacionDomain.getDefaultObject());
        setPalabraClave(UtilText.getDefaultValue());
    }

    public PalabraClavePublicacionDomain(UUID identificador, PublicacionDomain publicacion, String palabraClave) {
        super();
        setIdentificador(identificador);
        setPublicacion(publicacion);
        setPalabraClave(palabraClave);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PublicacionDomain getPublicacion() {
        return publicacion;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPublicacion(final PublicacionDomain publicacion) {
        this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
    }

    private void setPalabraClave(final String palabraClave) {
        this.palabraClave = UtilText.applyTrim(palabraClave);
    }
    public static PalabraClavePublicacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
