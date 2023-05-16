package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilText;
import co.edu.uco.publiuco.utils.UtilUUID;

public final class ComentarioRevisorDomain {
    private UUID identificador;
    private RevisorRevisionDomain revisorRevision;
    private TipoComentarioRevisorDomain tipoComentarioRevisor;
    private String comentario;
    public static ComentarioRevisorDomain DEFAULT_OBJECT = new ComentarioRevisorDomain();

    public ComentarioRevisorDomain(UUID identificador, RevisorRevisionDomain revisorRevision, TipoComentarioRevisorDomain tipoComentarioRevisor, String comentario) {
        super();
        setIdentificador(identificador);
        setRevisorRevision(revisorRevision);
        setTipoComentarioRevisor(tipoComentarioRevisor);
        setComentario(comentario);

    }
    private ComentarioRevisorDomain() {
        super();
        setIdentificador(UtilUUID.getDefaultValue());
        setRevisorRevision(RevisorRevisionDomain.getDefaultObject());
        setTipoComentarioRevisor(TipoComentarioRevisorDomain.getDefaultObject());
        setComentario(UtilText.getDefaultValue());

    }

    public UUID getIdentificador() {
        return identificador;
    }

    public RevisorRevisionDomain getRevisorRevision() {
        return revisorRevision;
    }

    public TipoComentarioRevisorDomain getTipoComentarioRevisor() {
        return tipoComentarioRevisor;
    }

    public String getComentario() {
        return comentario;
    }

    private void setIdentificador(final UUID identificador) {
        this.identificador = UtilUUID.getDefault(identificador);
    }

    private void setRevisorRevision(final RevisorRevisionDomain revisorRevision) {
        this.revisorRevision = UtilObject.getDefault(revisorRevision, RevisorRevisionDomain.getDefaultObject());
    }

    private void setTipoComentarioRevisor(final TipoComentarioRevisorDomain tipoComentarioRevisor) {
        this.tipoComentarioRevisor = UtilObject.getDefault(tipoComentarioRevisor, TipoComentarioRevisorDomain.getDefaultObject());
    }

    private void setComentario(final String comentario) {
        this.comentario = UtilText.applyTrim(comentario);
    }
    public static ComentarioRevisorDomain getDefaultObject (){
        return DEFAULT_OBJECT;
    }
}
