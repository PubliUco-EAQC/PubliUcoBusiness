package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public final class SuscripcionCategoriaDomain {
    private UUID identificador;
    private PerfilDomain perfil;
    private PlanCategoriaDomain planCategoria;
    public static SuscripcionCategoriaDomain DEFAULT_OBJECT = new SuscripcionCategoriaDomain();

    private SuscripcionCategoriaDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setPerfil(PerfilDomain.getDefaultObject());
        setPlanCategoria(PlanCategoriaDomain.getDefaultObject());
    }

    public SuscripcionCategoriaDomain(UUID identificador, PerfilDomain perfil, PlanCategoriaDomain planCategoria) {
        setIdentificador(identificador);
        setPerfil(perfil);
        setPlanCategoria(planCategoria);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PerfilDomain getPerfil() {
        return perfil;
    }

    public PlanCategoriaDomain getPlanCategoria() {
        return planCategoria;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPerfil(final PerfilDomain perfil) {
        this.perfil = UtilObject.getDefault(perfil, PerfilDomain.getDefaultObject());
    }

    private void setPlanCategoria(final PlanCategoriaDomain planCategoria) {
        this.planCategoria = UtilObject.getDefault(planCategoria, PlanCategoriaDomain.getDefaultObject());
    }
    public static SuscripcionCategoriaDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
