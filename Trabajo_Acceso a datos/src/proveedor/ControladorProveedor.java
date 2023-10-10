package proveedor;

import java.util.ArrayList;

public class ControladorProveedor {

	private VistaProveedor vista;
	private ModeloProveedor modelo;

	
	public ControladorProveedor() {
		super();
		modeloProveedor = new ModeloProveedor(this);
		vistaProveedor = new VistaProveedor(this);
		actualizarTabla();
	}

	public void registrarProducto(String cif, String nombre, String direccion, String telefono) {

		Proveedor document = new Proveedor("cif", "nombre", "direccion", "telefono");
		modeloProveedor.createDoc(document);
		actualizarTabla();

	}

	public void actualizarProducto(String cif, String nombre, String direccion, String telefono) {
		vista.datoIntroducido(document);

	}
	
	public void actualizarTabla() {
		
		ArrayList<Proveedor> datos = (ArrayList<Proveedor>) modeloProveedor.readAllDocsAndData();
		vista.mostrarDatos(datos);
		
	}

	public void borrarProducto(String id, String rev) {
		
		Proveedor p = new Proveedor(cif); 
		modelo.deleteDoc(p);
		actualizarTabla();
		
	}

	public  Productos recuperarCoche(String id) {
		
		return modelo.readDoc(id);
				
	}

	public void actualizarCoche(String id, String revision, String matricula, String marca, String modelo2, String km,
			String color) {
		Coche coche = recuperarCoche(id);
		coche.setMarca(marca);
		coche.setMatricula(matricula);
		coche.setModelo(modelo2);
		coche.setKm(km);
		coche.setColor(color);
		modelo.updateDoc(coche);
		actualizarTabla();
		
	}

	public void crearProveedor(String cif, String nombre, String direccion, String telefono) {
		// TODO Auto-generated method stub
		
	}*/

}
