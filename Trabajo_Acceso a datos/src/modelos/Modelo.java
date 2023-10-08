package modelos;

import java.sql.*;

import modelos.Controlador;

public class Modelo {
	private Controlador controlador;
	private Connection connection;

	public Modelo(Controlador controlador) {
		super();

		this.controlador = controlador;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			// Database connect
			// Conectamos con la base de datos
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendamuebles", "root", "");
			boolean valid = connection.isValid(50000);
			System.out.println(valid ? "TEST OK" : "TEST FAIL");
		} catch (ClassNotFoundException ex) {
			System.out.println("Error al registrar el driver de MySQL: " + ex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String registrarProducto(Producto producto) {

		String sql = " insert into producto (id, nombre, imagen, descripcion, categoria, precio)"
				+ " values (?, ?, ?, ?,?,?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(sql);
			preparedStmt.setString(1, producto.getId());
			preparedStmt.setString(2, producto.getNombre());
			preparedStmt.setString(3, producto.getImagen());
			preparedStmt.setString(4, producto.getDescripcion());
			preparedStmt.setString(5, producto.getCategoria());
			preparedStmt.setDouble(6, producto.getPrecio());
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public String actualizarProducto(Producto producto) {

		String sql = " update producto set (nombre = ?, imagen = ?, descripcion = ?, categoria = ?, precio = ?) where id = ?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(sql);

			preparedStmt.setString(1, producto.getNombre());
			preparedStmt.setString(2, producto.getImagen());
			preparedStmt.setString(3, producto.getDescripcion());
			preparedStmt.setString(4, producto.getCategoria());
			preparedStmt.setDouble(5, producto.getPrecio());
			preparedStmt.setString(6, producto.getId());
			

			int filasActualizadas = preparedStmt.executeUpdate();

			if (filasActualizadas > 0) {
				System.out.println("Producto actualizado correctamente.");
			} else {
				System.out.println("No se pudo actualizar el producto.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "";
	}

	public String eliminarProducto(Producto producto) {

		String sql = " delete from producto where id = ?";
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(sql);

			preparedStmt.setString(1, producto.getId());

			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public String listarProducto() {

		return "";
	}

	public String insertImg() {

		return "";
	}

	public String eliminarImg() {
		
		

		return "";
	}

	public String cambiarImg() {

		return "";
	}

	public String mostrarImg() {

		return "";
	}

	public String registrarProveedor(Proveedor proveedor) {

		String sql = " insert into proveedor (cif, nombre, direccion, telefono)" + " values (?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(sql);
			preparedStmt.setString(1, proveedor.getCif());
			preparedStmt.setString(2, proveedor.getNombre());
			preparedStmt.setString(3, proveedor.getDireccion());
			preparedStmt.setString(4, proveedor.getTelefono());
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public String actualizarProveedor(Proveedor proveedor) {

		String sql = " update producto set (nombre = ?, direccion= ?, telefono= ?) where cif = ?";

		try {
			PreparedStatement preparedStmt = connection.prepareStatement(sql);

			preparedStmt.setString(1, proveedor.getNombre());
			preparedStmt.setString(2, proveedor.getDireccion());
			preparedStmt.setString(3, proveedor.getTelefono());
			preparedStmt.setString(4, proveedor.getCif());
			preparedStmt.execute();

			int filasActualizadas = preparedStmt.executeUpdate();

			if (filasActualizadas > 0) {
				System.out.println("Proveedor actualizado correctamente.");
			} else {
				System.out.println("No se pudo actualizar el proveedor.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return "";
	}

	public String eliminarProveedor(Proveedor proveedor) {

		String sql = " delete from proveedor where cif = ?";
		
		
		try {
			PreparedStatement preparedStmt = connection.prepareStatement(sql);

			preparedStmt.setString(1, proveedor.getCif());

			preparedStmt.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return "";
	}

	public String listarProveedor() {

		return "";
	}

	public String recibirProductoProveedor() {

		return "";
	}

	public String ventaProducto() {

		return "";
	}

	public String listaTransacciones() {

		return "";
	}

	public String actualizarStock() {

		return "";
	}

	public String buscarProducto() {

		return "";
	}

	public String informesInventario() {

		return "";
	}

	public String registrarUsuario(Usuario usuario) {

		String sql = " insert into usuario (usuario, password, rol)" + " values (?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = connection.prepareStatement(sql);
			preparedStmt.setString(1, usuario.getUsuario());
			preparedStmt.setString(2, usuario.getPassword());
			preparedStmt.setString(3, usuario.getRol());
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public String iniciarSesion() {

		return "";
	}

}
