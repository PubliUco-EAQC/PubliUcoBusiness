package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilObject;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.time.LocalDateTime;
import java.util.UUID;
public final class ComentarioLectorDomain {

	private UUID identificador;
	private LectorDomain lector;
	private PublicacionDomain publicacion;
	private ComentarioLectorDomain comentarioPadre;
	private String contenido;
	private LocalDateTime fechaCalificacion;
	private EstadoDomain estado;
	public static ComentarioLectorDomain DEFAULT_OBJECT = new ComentarioLectorDomain();


	private ComentarioLectorDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultValue());
		setLector(LectorDomain.getDefaultObject());
		setPublicacion(PublicacionDomain.getDefaultObject());
		setComentarioPadre(getDefaultObject());
		setContenido(UtilText.getDefaultValue());
		setFechaCalificacion(UtilDate.getDefaultValue());
		setEstado(EstadoDomain.getDefaultObject() );
	}


	public ComentarioLectorDomain(UUID identificador, LectorDomain lector, PublicacionDomain publicacion, ComentarioLectorDomain comentarioPadre, String contenido, LocalDateTime fechaCalificacion, EstadoDomain estado) {
		super();
		setIdentificador(identificador);
		setLector(lector);
		setComentarioPadre(comentarioPadre);
		setPublicacion(publicacion);
		setContenido(contenido);
		setFechaCalificacion(fechaCalificacion);
		setEstado(estado);
	}



	public UUID getIdentificador() {
		return identificador;
	}

	public LectorDomain getLector() {
		return lector;
	}

	public PublicacionDomain getPublicacion() {
		return publicacion;
	}

	public ComentarioLectorDomain getComentarioPadre() {
		return comentarioPadre;
	}

	public String getCotenido() {
		return contenido;
	}

	public LocalDateTime getFechaCalificacion() {
		return fechaCalificacion;
	}

	public EstadoDomain getEstado() {
		return estado;
	}

	private void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	private void setLector(final LectorDomain lector) {
		this.lector = UtilObject.getDefault(lector, LectorDomain.getDefaultObject());
	}

	private void setPublicacion(final PublicacionDomain publicacion) {
		this.publicacion = UtilObject.getDefault(publicacion, PublicacionDomain.getDefaultObject());
	}

	private void setComentarioPadre(final ComentarioLectorDomain comentarioPadre) {
		this.comentarioPadre = UtilObject.getDefault(comentarioPadre, ComentarioLectorDomain.getDefaultObject());
	}

	private void setEstado(final EstadoDomain estado) {
		this.estado = estado;
	}

	private void setContenido(final String contenido) {
		this.contenido = contenido;
	}

	private void setFechaCalificacion(final LocalDateTime fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}

	public static ComentarioLectorDomain getDefaultObject() {
		return DEFAULT_OBJECT;
	}
}