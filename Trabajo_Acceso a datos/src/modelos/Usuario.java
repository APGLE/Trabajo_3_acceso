package modelos;

public class Usuario {
	
	private String id;
	private String usuario;
	private String password;
	
	public Usuario(String id, String usuario, String password) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.password = password;
	}
	
	public Usuario() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return usuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		usuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", NombreUsuario=" + usuario + ", password=" + password + "]";
	}
	
	
	
}
