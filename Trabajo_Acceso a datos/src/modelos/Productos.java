package modelos;

public class Productos {
	
	private String idProd;
	private String nombreProd;
	private String imgProd;
	private String descripcionProd;
	private String CategoriaProd;
	private float precioUnd;
	
	
	public Productos(String idProd, String nombreProd, String imgProd, String descripcionProd, String categoriaProd,
			float precioUnd) {
		super();
		this.idProd = idProd;
		this.nombreProd = nombreProd;
		this.imgProd = imgProd;
		this.descripcionProd = descripcionProd;
		CategoriaProd = categoriaProd;
		this.precioUnd = precioUnd;
	}
	
	public Productos () {
		
	}

	public String getIdProd() {
		return idProd;
	}

	public void setIdProd(String idProd) {
		this.idProd = idProd;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public String getImgProd() {
		return imgProd;
	}

	public void setImgProd(String imgProd) {
		this.imgProd = imgProd;
	}

	public String getDescripcionProd() {
		return descripcionProd;
	}

	public void setDescripcionProd(String descripcionProd) {
		this.descripcionProd = descripcionProd;
	}

	public String getCategoriaProd() {
		return CategoriaProd;
	}

	public void setCategoriaProd(String categoriaProd) {
		CategoriaProd = categoriaProd;
	}

	public float getPrecioUnd() {
		return precioUnd;
	}

	public void setPrecioUnd(float precioUnd) {
		this.precioUnd = precioUnd;
	}

	@Override
	public String toString() {
		return "Productos [idProd=" + idProd + ", nombreProd=" + nombreProd + ", imgProd=" + imgProd
				+ ", descripcionProd=" + descripcionProd + ", CategoriaProd=" + CategoriaProd + ", precioUnd="
				+ precioUnd + "]";
	}
	
	

}
