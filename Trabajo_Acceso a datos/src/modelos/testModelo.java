package modelos;

public class testModelo {

	public static void main(String[] args) {
		
		Modelo modelo = new Modelo(null);
		
		Proveedor proveedor = new Proveedor("C321234","Juan Palomo", "Madrid", 956056129);
		
		modelo.registrarProveedor(proveedor);

	}

}
