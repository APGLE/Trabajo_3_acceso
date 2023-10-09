package modelos;

import java.util.ArrayList;

public class testModelo {

	public static void main(String[] args) {

		Modelo modelo = new Modelo(null);

		Proveedor proveedor = new Proveedor("P324567", "Mariquita Perez", "Barcelona", "600546789");

//		modelo.registrarProveedor(proveedor);

//		Usuario usuario = new Usuario("U456789","JoseP3r32","otorrino");

//		modelo.registrarUsuario(usuario);

		Producto producto = new Producto("PR123456", "Escritorio nordico", "", "Mesa blanca escritorio", "Mesas",
				25.00);

		modelo.registrarProducto(producto);
		
		Producto producto2 = new Producto("PR765432", "Silla jardin", "", "Silla plastico jardin", "Sillas",
				10.00);

		modelo.registrarProducto(producto2);

//		producto.setDescripcion("Silla madera comedor");
//		producto.setNombre("Silla comedor");

//		modelo.actualizarProducto(producto);

//		modelo.eliminarProducto(producto);

//		modelo.eliminarProveedor(proveedor);

//		Producto producto2 = new Producto();

//		producto2.setId("PR123456");

//		ArrayList<Producto> productos = new ArrayList();

//		productos = (ArrayList<Producto>) modelo.buscarProducto(producto2);

//		for (Producto producto3 : productos) {

//		System.out.println(producto3);
		
		ArrayList<Producto> productos = new ArrayList();
		
		productos = (ArrayList<Producto>) modelo.listarProductos();
		
		for (Producto producto4 : productos) {
			
		System.out.println(producto4);
		}

	}

}
