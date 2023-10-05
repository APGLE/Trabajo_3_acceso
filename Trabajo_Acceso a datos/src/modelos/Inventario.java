package modelos;



public class Inventario  {
	
	private String idProd;
	private String nombreProd;
	private String descripcionProd;
	private int precioProd;
	private int categoriaProd;
	private int cantidadStock;
	 
	public Inventario(String idProd, String nombreProd, String descripcionProd, int precioProd, int categoriaProd,
			int cantidadStock) {
		super();
		this.idProd = idProd;
		this.nombreProd = nombreProd;
		this.descripcionProd = descripcionProd;
		this.precioProd = precioProd;
		this.categoriaProd = categoriaProd;
		this.cantidadStock = cantidadStock;
	}
	
	prublic Inventario() {
		
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

	public String getDescripcionProd() {
		return descripcionProd;
	}

	public void setDescripcionProd(String descripcionProd) {
		this.descripcionProd = descripcionProd;
	}

	public int getPrecioProd() {
		return precioProd;
	}

	public void setPrecioProd(int precioProd) {
		this.precioProd = precioProd;
	}

	public int getCategoriaProd() {
		return categoriaProd;
	}

	public void setCategoriaProd(int categoriaProd) {
		this.categoriaProd = categoriaProd;
	}

	public int getCantidadStock() {
		return cantidadStock;
	}

	public void setCantidadStock(int cantidadStock) {
		this.cantidadStock = cantidadStock;
	}

	@Override
	public String toString() {
		return "Inventario [idProd=" + idProd + ", nombreProd=" + nombreProd + ", descripcionProd=" + descripcionProd
				+ ", precioProd=" + precioProd + ", categoriaProd=" + categoriaProd + ", cantidadStock=" + cantidadStock
				+ "]";
	}
	
	
	

}
