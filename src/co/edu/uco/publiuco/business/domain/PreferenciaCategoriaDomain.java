package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public final class PreferenciaCategoriaDomain {
    private UUID identificador;
    private PerfilDomain perfil;
    private CategoriaDomain categoria;
    public static PreferenciaCategoriaDomain DEFAULT_OBJECT = new PreferenciaCategoriaDomain();

    private PreferenciaCategoriaDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setPerfil(PerfilDomain.getDefaultObject());
        setCategoria(CategoriaDomain.getDefaultObject());
    }

    public PreferenciaCategoriaDomain(UUID identificador, PerfilDomain perfil, CategoriaDomain categoria) {
     super();
     setIdentificador(identificador);
     setPerfil(perfil);
     setCategoria(categoria);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PerfilDomain getPerfil() {
        return perfil;
    }

    public CategoriaDomain getCategoria() {
        return categoria;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPerfil(final PerfilDomain perfil) {
        this.perfil = UtilObject.getDefault(perfil, PerfilDomain.getDefaultObject());
    }

    private void setCategoria(final CategoriaDomain categoria) {
        this.categoria = UtilObject.getDefault(categoria, CategoriaDomain.getDefaultObject());
    }
    public static PreferenciaCategoriaDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
