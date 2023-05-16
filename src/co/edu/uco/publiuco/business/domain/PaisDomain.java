package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class PaisDomain {
    private UUID identificador;
    private String nombre;
    private String indicadorPais;
    public static PaisDomain DEFAULT_OBJECT = new PaisDomain();

    private PaisDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setNombre(UtilText.getDefaultValue());
        setIndicadorPais(UtilText.getDefaultValue());
    }

    public PaisDomain(UUID identificador, String nombre, String indicadorPais) {
        super();
        setIdentificador(identificador);
        setNombre(nombre);
        setIndicadorPais(indicadorPais);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIndicadorPais() {
        return indicadorPais;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setNombre(final String nombre) {
        this.nombre = UtilText.applyTrim(nombre);
    }

    private void setIndicadorPais(final String indicadorPais) {
        this.indicadorPais = UtilText.applyTrim(indicadorPais);
    }
    public static PaisDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
