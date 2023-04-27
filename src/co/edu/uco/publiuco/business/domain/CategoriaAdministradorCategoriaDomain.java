package co.edu.uco.publiuco.business.domain;

import co.edu.uco.publiuco.crosscutting.utils.UtilUUID;

import java.util.UUID;
public final class CategoriaAdministradorCategoriaDomain {

	private UUID identificador;
	private CategoriaDomain categoria;
	private AdministradorCategoriaDomain administradorCategoria;

	public CategoriaAdministradorCategoriaDomain(UUID identificador, CategoriaDomain categoria, AdministradorCategoriaDomain administradorCategoria) {
		super();
		setIdentificador(identificador);
		setCategoria(categoria);
		setAdministradorCategoria(administradorCategoria);
	}

	public final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	public final void setCategoria(final CategoriaDomain categoria) {
		this.categoria = categoria;
	}

	public final void setAdministradorCategoria(final AdministradorCategoriaDomain administradorCategoria) {
		this.administradorCategoria = administradorCategoria;
	}

	public UUID getIdentificador() {
		return identificador;
	}

	public CategoriaDomain getCategoria() {
		return categoria;
	}

	public AdministradorCategoriaDomain getAdministradorCategoria() {
		return administradorCategoria;
	}
}