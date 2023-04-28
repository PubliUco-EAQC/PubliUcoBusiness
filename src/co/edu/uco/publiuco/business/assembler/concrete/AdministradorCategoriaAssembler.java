package co.edu.uco.publiuco.business.assembler.concrete;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;
import java.util.UUID;

public final class AdministradorCategoriaAssembler {
    private UUID identificador;
    private PersonaAssembler datosPersona;
    private EstadoAssembler estado;

    public AdministradorCategoriaAssembler(UUID identificador, PersonaAssembler persona, EstadoAssembler estado) {
        super();
        setIdentificador(identificador);
        setPersona(persona);
        setEstado(estado);
    }

    private final void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private final void setPersona(final PersonaAssembler datosPersona) {
        this.datosPersona = datosPersona;
    }

    private final void setEstado(final EstadoAssembler estado) {
        this.estado = estado;
    }

    public final UUID getIdentificador() {
        return identificador;
    }

    public final PersonaAssembler getNombre() {
        return datosPersona;
    }

    public final EstadoAssembler getEstado() {
        return estado;
    }
}
