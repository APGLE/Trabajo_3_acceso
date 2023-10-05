package modelos;



public class Inventario  {
	
	private String id;
	private String nombre;
	private String descripcion;
	private int precio;
	private int categoria;
	private String proveedor;
	private int cantidad;
	 
	public Inventario(String id, String nombre, String descripcion, int precio, int categoria, String proveedor,
			int cantidadStock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.categoria = categoria;
		this.proveedor = proveedor;
		this.cantidad = cantidadStock;
	}
	
	public Inventario() {
		
	}

	
	
	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	public String getIdProd() {
		return id;
	}

	public void setIdProd(String idProd) {
		this.id = idProd;
	}

	public String getNombreProd() {
		return nombre;
	}

	public void setNombreProd(String nombreProd) {
		this.nombre = nombreProd;
	}

	public String getDescripcionProd() {
		return descripcion;
	}

	public void setDescripcionProd(String descripcionProd) {
		this.descripcion = descripcionProd;
	}

	public int getPrecioProd() {
		return precio;
	}

	public void setPrecioProd(int precioProd) {
		this.precio = precioProd;
	}

	public int getCategoriaProd() {
		return categoria;
	}

	public void setCategoriaProd(int categoriaProd) {
		this.categoria = categoriaProd;
	}

	public int getCantidadStock() {
		return cantidad;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidad = cantidadStock;
	}

	@Override
	public String toString() {
		return "Inventario [idProd=" + id + ", nombreProd=" + nombre + ", descripcionProd=" + descripcion
				+ ", precioProd=" + precio + ", categoriaProd=" + categoria + ", proveedor=" + proveedor
				+ ", cantidadStock=" + cantidad + "]";
	}

	
	
	

}
