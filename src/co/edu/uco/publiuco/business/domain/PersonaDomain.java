package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class PersonaDomain {
    private UUID identificador;
    private TipoIdentificacionDomain tipoIdentificacionDTO;
    private String numeroIdentificacion;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String correoElectronico;
    private PaisDomain indicadorPais;
    private String numeroTelefonoMovil;
    private EstadoDomain estado;
    private TipoRelacionInstitucionDomain tipoRelacionInstitucion;
    public static PersonaDomain DEFAULT_OBJECT = new PersonaDomain();

    private PersonaDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setTipoIdentificacionDTO(TipoIdentificacionDomain.getDefaultObject());
        setNumeroIdentificacion(UtilText.getDefaultValue());
        setPrimerNombre(UtilText.getDefaultValue());
        setSegundoNombre(UtilText.getDefaultValue());
        setPrimerApellido(UtilText.getDefaultValue());
        setSegundoApellido(UtilText.getDefaultValue());
        setCorreoElectronico(UtilText.getDefaultValue());
        setIndicadorPais(PaisDomain.getDefaultObject());
        setNumeroTelefonoMovil(UtilText.getDefaultValue());
        setEstado(EstadoDomain.getDefaultObject());
    }

    public PersonaDomain(UUID identificador, TipoIdentificacionDomain tipoIdentificacionDTO, String numeroIdentificacion, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido, String correoElectronico, PaisDomain indicadorPais, String numeroTelefonoMovil, EstadoDomain estado, TipoRelacionInstitucionDomain tipoRelacionInstitucion) {
        super();
        setIdentificador(identificador);
        setTipoIdentificacionDTO(tipoIdentificacionDTO);
        setNumeroIdentificacion(numeroIdentificacion);
        setPrimerNombre(primerNombre);
        setSegundoNombre(segundoNombre);
        setPrimerApellido(primerApellido);
        setSegundoApellido(segundoApellido);
        setCorreoElectronico(correoElectronico);
        setIndicadorPais(indicadorPais);
        setNumeroTelefonoMovil(numeroTelefonoMovil);
        setTipoRelacionInstitucion(tipoRelacionInstitucion);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public TipoIdentificacionDomain getTipoIdentificacionDTO() {
        return tipoIdentificacionDTO;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public PaisDomain getIndicadorPais() {
        return indicadorPais;
    }

    public String getNumeroTelefonoMovil() {
        return numeroTelefonoMovil;
    }

    public EstadoDomain getEstado() {
        return estado;
    }

    public TipoRelacionInstitucionDomain getTipoRelacionInstitucion() {
        return tipoRelacionInstitucion;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setTipoIdentificacionDTO(final TipoIdentificacionDomain tipoIdentificacionDTO) {
        this.tipoIdentificacionDTO = UtilObject.getDefault(tipoIdentificacionDTO, TipoIdentificacionDomain.getDefaultObject());
    }

    private void setNumeroIdentificacion(final String numeroIdentificacion) {
        this.numeroIdentificacion = UtilText.applyTrim(numeroIdentificacion);
    }

    private void setPrimerNombre(final String primerNombre) {
        this.primerNombre = UtilText.applyTrim(primerNombre);
    }

    private void setSegundoNombre(final String segundoNombre) {
        this.segundoNombre = UtilText.applyTrim(segundoNombre);
    }

    private void setPrimerApellido(final String primerApellido) {
        this.primerApellido = UtilText.applyTrim(primerApellido);
    }

    private void setSegundoApellido(final String segundoApellido) {
        this.segundoApellido = UtilText.applyTrim(segundoApellido);
    }

    private void setCorreoElectronico(final String correoElectronico) {
        this.correoElectronico = UtilText.applyTrim(correoElectronico);
    }

    private void setIndicadorPais(final PaisDomain indicadorPais) {
        this.indicadorPais = UtilObject.getDefault(indicadorPais, PaisDomain.getDefaultObject());
    }

    private void setNumeroTelefonoMovil(final String numeroTelefonoMovil) {
        this.numeroTelefonoMovil = UtilText.applyTrim(numeroTelefonoMovil);
    }

    private void setEstado(EstadoDomain estado) {
        this.estado = UtilObject.getDefault(estado, EstadoDomain.getDefaultObject());
    }

    private void setTipoRelacionInstitucion(TipoRelacionInstitucionDomain tipoRelacionInstitucion) {
        this.tipoRelacionInstitucion = UtilObject.getDefault(tipoRelacionInstitucion, TipoRelacionInstitucionDomain.getDefaultObject());
    }
    public static PersonaDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
