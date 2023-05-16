package co.edu.uco.publiuco.business.domain;

import java.util.UUID;

import co.edu.uco.publiuco.utils.UtilObject;
import co.edu.uco.publiuco.utils.UtilUUID;
public final class CategoriaAdministradorCategoriaDomain {

	private UUID identificador;
	private CategoriaDomain categoria;
	private AdministradorCategoriaDomain administradorCategoria;
	public static CategoriaAdministradorCategoriaDomain DEFAULT_OBJECT = new CategoriaAdministradorCategoriaDomain();

	private CategoriaAdministradorCategoriaDomain() {
		super();
		setIdentificador(UtilUUID.getDefaultValue());
		setCategoria(CategoriaDomain.getDefaultObject());
		setAdministradorCategoria(AdministradorCategoriaDomain.getDefaultObject());
	}


	public CategoriaAdministradorCategoriaDomain(UUID identificador, CategoriaDomain categoria, AdministradorCategoriaDomain administradorCategoria) {
		super();
		setIdentificador(identificador);
		setCategoria(categoria);
		setAdministradorCategoria(administradorCategoria);
	}

	private final void setIdentificador(final UUID identificador) {
		this.identificador = UtilUUID.getDefault(identificador);
	}

	private final void setCategoria(final CategoriaDomain categoria) {
		this.categoria = UtilObject.getDefault(categoria, CategoriaDomain.getDefaultObject());
	}

	private final void setAdministradorCategoria(final AdministradorCategoriaDomain administradorCategoria) {

		this.administradorCategoria = UtilObject.getDefault(administradorCategoria, AdministradorCategoriaDomain.getDefaultObject());
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

	public static CategoriaAdministradorCategoriaDomain getDefaultObject (){
		return DEFAULT_OBJECT;
	}
}