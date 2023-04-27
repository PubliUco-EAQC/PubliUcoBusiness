package co.edu.uco.publiuco.business.assembler.concrete;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import java.util.UUID;

public final class AdministradorCategoriaAssembler {
    private UUID identificador;
    private PersonaEntity datosPersona;
    private EstadoEntity estado;

    public AdministradorCategoriaAssembler(UUID identificador, PersonaEntity persona, EstadoEntity estado) {
        super();
        setIdentificador(identificador);
        setPersona(persona);
        setEstado(estado);
    }

    private final void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private final void setPersona(final PersonaEntity datosPersona) {
        this.datosPersona = datosPersona;
    }

    private final void setEstado(final EstadoEntity estado) {
        this.estado = estado;
    }

    public final UUID getIdentificador() {
        return identificador;
    }

    public final PersonaEntity getNombre() {
        return datosPersona;
    }

    public final EstadoEntity getEstado() {
        return estado;
    }
}
