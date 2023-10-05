package modelos;

public class Proveedores {

	private String id;
	private String nombre;
	private String direccion;
	private int telefono;
	
	
	public Proveedores(String id, String nombre, String direccion, int telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
	}
	
	public Proveedores () {
		
	}

	public String getIdProveedor() {
		return id;
	}

	public void setIdProveedor(String idProveedor) {
		this.id = idProveedor;
	}

	public String getNombreProveedor() {
		return nombre;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombre = nombreProveedor;
	}

	public String getDireccionProveedor() {
		return direccion;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccion = direccionProveedor;
	}

	public int getTelefonoProveedor() {
		return telefono;
	}

	public void setTelefonoProveedor(int telefonoProveedor) {
		this.telefono = telefonoProveedor;
	}

	@Override
	public String toString() {
		return "Proveedores [idProveedor=" + id + ", nombreProveedor=" + nombre
				+ ", direccionProveedor=" + direccion + ", telefonoProveedor=" + telefono + "]";
	}
	
	
	
}
