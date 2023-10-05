package modelos;

public class Productos {
	
	private String id;
	private String nombre;
	private String imagen;
	private String descripcion;
	private String categoria;
	private float precio;
	
	
	public Productos(String id, String nombre, String imagen, String descripcion, String categoria,
			float precioUnd) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.precio = precioUnd;
	}
	
	public Productos () {
		
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

	public String getImgProd() {
		return imagen;
	}

	public void setImgProd(String imgProd) {
		this.imagen = imgProd;
	}

	public String getDescripcionProd() {
		return descripcion;
	}

	public void setDescripcionProd(String descripcionProd) {
		this.descripcion = descripcionProd;
	}

	public String getCategoriaProd() {
		return categoria;
	}

	public void setCategoriaProd(String categoriaProd) {
		categoria = categoriaProd;
	}

	public float getPrecioUnd() {
		return precio;
	}

	public void setPrecioUnd(float precioUnd) {
		this.precio = precioUnd;
	}

	@Override
	public String toString() {
		return "Productos [idProd=" + id + ", nombreProd=" + nombre + ", imgProd=" + imagen
				+ ", descripcionProd=" + descripcion + ", CategoriaProd=" + categoria + ", precioUnd="
				+ precio + "]";
	}
	
	

}
