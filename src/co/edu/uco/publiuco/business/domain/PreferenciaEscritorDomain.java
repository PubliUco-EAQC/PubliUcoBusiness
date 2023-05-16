package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class PreferenciaEscritorDomain {
    private UUID identificador;
    private PerfilDomain perfil;
    private EscritorDomain escritor;
    public static PreferenciaEscritorDomain DEFAULT_OBJECT = new PreferenciaEscritorDomain();

    private PreferenciaEscritorDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setPerfil(PerfilDomain.getDefaultObject());
        setEscritor(EscritorDomain.getDefaultObject());
    }
    public PreferenciaEscritorDomain(UUID identificador, PerfilDomain perfil, EscritorDomain escritor) {
        setIdentificador(identificador);
        setPerfil(perfil);
        setEscritor(escritor);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PerfilDomain getPerfil() {
        return perfil;
    }

    public EscritorDomain getEscritor() {
        return escritor;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPerfil(final PerfilDomain perfil) {
        this.perfil = UtilObject.getDefault(perfil, PerfilDomain.getDefaultObject());
    }

    private void setEscritor(final EscritorDomain escritor) {
        this.escritor = UtilObject.getDefault(escritor, EscritorDomain.getDefaultObject());
    }
    public static PreferenciaEscritorDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
