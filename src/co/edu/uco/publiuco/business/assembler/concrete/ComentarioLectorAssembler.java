package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.crosscutting.utils.UtilDate;
import co.edu.uco.publiuco.crosscutting.utils.UtilText;
import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
public final class ComentarioLectorAssembler {

	private UUID identificador;
	private LectorEntity lector;
	private PublicacionEntity publicacion;
	private ComentarioLectorAssembler comentarioPadre;
	private String cotenido;
	private LocalDateTime fechaCalificacion;
	private EstadoEntity estado;

	public ComentarioLectorAssembler(UUID identificador, LectorEntity lector, PublicacionEntity publicacion, ComentarioLectorDTO comentarioPadre, String contenido, LocalDateTime fechaCalificacion, EstadoDTO estado) {
		super();
		setIdentificador(identificador);
		setLector(lector);
		setPublicacion(publicacion);
		setComentarioPadre(comentarioPadre);
		setCotenido(contenido);
		setFechaCalificacion(fechaCalificacion);
		setEstado(estado);
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public LectorEntity getLector() {
		return lector;
	}

	public PublicacionEntity getPublicacion() {
		return publicacion;
	}

	public ComentarioLectorAssembler getComentarioPadre() {
		return comentarioPadre;
	}

	public String getCotenido() {
		return cotenido;
	}

	public LocalDateTime getFechaCalificacion() {
		return fechaCalificacion;
	}

	public EstadoEntity getEstado() {
		return estado;
	}
	
	private final void setIdentificador(UUID identificador) {
		this.identificador = identificador;
	}

	private final void setLector(LectorEntity lector) {
		this.lector = lector;
	}

	private final void setPublicacion(PublicacionEntity publicacion) {
		this.publicacion = publicacion;
	}

	private final void setComentarioPadre(final ComentarioLectorAssembler comentarioPadre) {
		this.comentarioPadre = comentarioPadre;
	}

	private final void setEstado(final EstadoEntity estado) {
		this.estado = estado;
	}

	private final void setCotenido(String cotenido) {
		this.cotenido = cotenido;
	}

	private final void setFechaCalificacion(LocalDateTime fechaCalificacion) {
		this.fechaCalificacion = fechaCalificacion;
	}
	
}