package co.edu.uco.publiuco.business.assembler.concrete;

import java.util.UUID;

public class EscritorAssembler {
    private UUID identificador;
    private PersonaEntity datosPersona;
    private TipoRelacionInstitucionEntity tipoRelacionInstitucion;
    private EstadoEntity estado;

    public EscritorAssembler(UUID identificador, PersonaEntity datosPersona, TipoRelacionInstitucionEntity tipoRelacionInstitucion, EstadoEntity estado) {
        super();
        setIdentificador(identificador);
        setDatosPersona(datosPersona);
        setTipoRelacionInstitucion(tipoRelacionInstitucion);
        setEstado(estado);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public PersonaEntity getDatosPersona() {
        return datosPersona;
    }

    public TipoRelacionInstitucionEntity getTipoRelacionInstitucion() {
        return tipoRelacionInstitucion;
    }

    public EstadoEntity getEstado() {
        return estado;
    }

    private void setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private void setDatosPersona(PersonaEntity datosPersona) {
        this.datosPersona = datosPersona;
    }

    private void setTipoRelacionInstitucion(TipoRelacionInstitucionEntity tipoRelacionInstitucion) {
        this.tipoRelacionInstitucion = tipoRelacionInstitucion;
    }

    private void setEstado(EstadoEntity estado) {
        this.estado = estado;
    }
}