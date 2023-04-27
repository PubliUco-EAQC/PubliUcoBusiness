package co.edu.uco.publiuco.business.assembler.concrete;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;
public final class CategoriaAdministradorCategoriaAssembler {

	private UUID identificador;
	private CategoriaAssembler categoria;
	private AdministradorCategoriaAssembler administradorCategoria;

	public CategoriaAdministradorCategoriaAssembler(UUID identificador, CategoriaAssembler categoria, AdministradorCategoriaAssembler administradorCategoria) {
		super();
		setIdentificador(identificador);
		setCategoria(categoria);
		setAdministradorCategoria(administradorCategoria);
	}

	public final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final void setCategoria(final CategoriaAssembler categoria) {
		this.categoria = categoria;
	}

	public final void setAdministradorCategoria(final AdministradorCategoriaAssembler administradorCategoria) {
		this.administradorCategoria = administradorCategoria;
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public CategoriaAssembler getCategoria() {
		return categoria;
	}

	public AdministradorCategoriaAssembler getAdministradorCategoria() {
		return administradorCategoria;
	}
}