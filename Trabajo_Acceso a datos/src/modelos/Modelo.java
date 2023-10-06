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

	public String registrarProducto() {

		return "";
	}

	public String actualizarProducto() {

		return "";
	}

	public String eliminarProducto() {

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
			preparedStmt.setString(1, proveedor.getId());
			preparedStmt.setString(2, proveedor.getNombre());
			preparedStmt.setString(3, proveedor.getDireccion());
			preparedStmt.setInt(4, proveedor.getTelefono());
			preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "";
	}

	public String actualizarProveedor() {

		return "";
	}

	public String eliminarProveedor() {

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

	public String registrarUsuario() {

		return "";
	}

	public String iniciarSesion() {

		return "";
	}

}
