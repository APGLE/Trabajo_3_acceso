package modelos;

public class Producto {
	
	private String id;
	private String nombre;
	private String imagen;
	private String descripcion;
	private String categoria;
	private double precio;
	
	public final static String MESA = "mesa";
	public final static String SILLA = "silla";
	public final static String ARMARIO = "armario";
	public final static String SOFA = "sofa";
	public final static String CAMA = "cama";
	
	
	public Producto(String id, String nombre, String imagen, String descripcion, String categoria,
			double precio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precio;
	}
	
	public Producto () {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String idProd) {
		this.id = idProd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + ", precio=" + precio + "]";
	}

	

}
