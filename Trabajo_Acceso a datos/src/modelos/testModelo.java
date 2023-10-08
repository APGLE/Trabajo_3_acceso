package modelos;

public class testModelo {

	public static void main(String[] args) {
		
		Modelo modelo = new Modelo(null);
		
		Proveedor proveedor = new Proveedor("P324567","Mariquita Perez", "Barcelona", "600546789");
		
//		modelo.registrarProveedor(proveedor);
		
//		Usuario usuario = new Usuario("U456789","JoseP3r32","otorrino");
		
//		modelo.registrarUsuario(usuario);
		
//		Producto producto = new Producto("PR123456","Escritorio nordico","","Mesa blanca escritorio", "Mesas",25.00);

//		modelo.registrarProducto(producto);
		
//		producto.setDescripcion("Silla madera comedor");
//		producto.setNombre("Silla comedor");
		
//		modelo.actualizarProducto(producto);
		
		
//		modelo.eliminarProducto(producto);
		
		modelo.eliminarProveedor(proveedor);
	}
	
	

}
