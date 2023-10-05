package modelos;

public class Proveedores {

	private String idProveedor;
	private String nombreProveedor;
	private String direccionProveedor;
	private int telefonoProveedor;
	
	
	public Proveedores(String idProveedor, String nombreProveedor, String direccionProveedor, int telefonoProveedor) {
		super();
		this.idProveedor = idProveedor;
		this.nombreProveedor = nombreProveedor;
		this.direccionProveedor = direccionProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}
	
	public Proveedores () {
		
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public int getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(int telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	@Override
	public String toString() {
		return "Proveedores [idProveedor=" + idProveedor + ", nombreProveedor=" + nombreProveedor
				+ ", direccionProveedor=" + direccionProveedor + ", telefonoProveedor=" + telefonoProveedor + "]";
	}
	
	
	
}
