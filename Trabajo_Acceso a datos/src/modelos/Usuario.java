package modelos;

public class Usuario {
	
	private String usuario;
	private String password;
	private String rol;
	
	public static final String CLIENTE = "cliente";
	public static final String ADMINISTRADOR = "administrador";
	public static final String PROVEEDOR= "proveedor";
	
	
	public Usuario() {
		
	}
	
	public Usuario(String usuario, String password, String rol) {
		super();
		this.usuario = usuario;
		this.password = password;
		this.rol = rol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
		return "Usuario [usuario=" + usuario + ", password=" + password + ", rol=" + rol + "]";
	}
	
	
	
}
	
	