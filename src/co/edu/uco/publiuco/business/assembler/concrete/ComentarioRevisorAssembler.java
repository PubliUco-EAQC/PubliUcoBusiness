package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;

public class ComentarioRevisorAssembler {
    private UUID identificador;
    private RevisorRevisionEntity revisorRevision;
    private TipoComentarioRevisorEntity tipoComentarioRevisor;
    private String comentario;

    public ComentarioRevisorAssembler(UUID identificador, RevisorRevisionEntity revisorRevision, TipoComentarioRevisorEntity tipoComentarioRevisor, String comentario) {
        super();
        setIdentificador(UtilUUID.DEFAULT_UUID);
        setRevisorRevision(revisorRevision);
        setTipoComentarioRevisor(tipoComentarioRevisor);
        setComentario(comentario);
    }

    public UUID getIdentificador() {
        return identificador;
    }

    public RevisorRevisionEntity getRevisorRevision() {
        return revisorRevision;
    }

    public TipoComentarioRevisorEntity getTipoComentarioRevisor() {
        return tipoComentarioRevisor;
    }

    public String getComentario() {
        return comentario;
    }

    private final void  setIdentificador(UUID identificador) {
        this.identificador = identificador;
    }

    private final void setRevisorRevision(RevisorRevisionEntity revisorRevision) {
        this.revisorRevision = revisorRevision;
    }

    private final void setTipoComentarioRevisor(TipoComentarioRevisorEntity tipoComentarioRevisor) {
        this.tipoComentarioRevisor = tipoComentarioRevisor;
    }

    private final void setComentario(String comentario) {
        this.comentario = UtilText.applyTrim(comentario);
    }
}