package modelos;

public class Usuario {
	
	private String user;
	private String password;
	private String rol;
	
	public static final String CLIENTE = "cliente";
	public static final String ADMINISTRADOR = "administrador";
	public static final String PROVEEDOR= "proveedor";
	
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String password, String rol) {
		super();
		this.user = usuario;
		this.password = password;
		this.rol = rol;
	}

	public String getUsuario() {
		return user;
	}

	public void setUsuario(String usuario) {
		this.user = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [usuario=" + user + ", password=" + password + ", rol=" + rol + "]";
	}
	
	
	
}
	
	