package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public final class SuscripcionPublicacionDomain {
    private UUID identificador;
    private PerfilDomain perfil;
    private PlanPublicacionDomain planPublicacion;
    public static SuscripcionPublicacionDomain DEFAULT_OBJECT = new SuscripcionPublicacionDomain();

    private SuscripcionPublicacionDomain() {
        setIdentificador(UtilUUID.getDefaultValue());
        setPerfil(PerfilDomain.getDefaultObject());
        setPlanPublicacion(PlanPublicacionDomain.getDefaultObject());
    }
    public SuscripcionPublicacionDomain(UUID identificador, PerfilDomain perfil, PlanPublicacionDomain planPublicacion) {
        setIdentificador(identificador);
        setPerfil(perfil);
        setPlanPublicacion(planPublicacion);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PerfilDomain getPerfil() {
        return perfil;
    }

    public PlanPublicacionDomain getPlanPublicacion() {
        return planPublicacion;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setPerfil(PerfilDomain perfil) {
        this.perfil = UtilObject.getDefault(perfil, PerfilDomain.getDefaultObject());
    }

    private void setPlanPublicacion(final PlanPublicacionDomain planPublicacion) {
        this.planPublicacion = UtilObject.getDefault(planPublicacion, PlanPublicacionDomain.getDefaultObject());
    }
    public static SuscripcionPublicacionDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
