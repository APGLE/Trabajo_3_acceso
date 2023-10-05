package modelos;

public class Usuario {
	
	private String id;
	private String NombreUsuario;
	private String password;
	
	public Usuario(String id, String nombreUsuario, String password) {
		super();
		this.id = id;
		NombreUsuario = nombreUsuario;
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
		return NombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		NombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", NombreUsuario=" + NombreUsuario + ", password=" + password + "]";
	}
	
	
	
}
