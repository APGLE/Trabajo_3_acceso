package proveedor;

import java.util.ArrayList;

public class ControladorProveedor {

	private VistaProveedor vistaProveedor;
	private ModeloProveedor modeloProveedor;

	
	public ControladorProveedor() {
		super();
		modeloProveedor = new ModeloProveedor(this);
		vistaProveedor = new VistaProveedor(this);
		actualizarTabla();
	}

	public void registrarProducto(String cif, String nombre, String direccion, String telefono) {

		Proveedor document = new Proveedor("cif", "nombre", "direccion", "telefono");
		//modeloProveedor.createDoc(document);
		actualizarTabla();

	}

	public void actualizarProveedor(String cif, String nombre, String direccion, String telefono) {
		
		//Proveedor proveedor = recuperarProveedor(cif);
		//vistaProveedor.datoIntroducido(document);

	}
	
	private Proveedor recuperarProveedor(String cif) {
		
		return null;
		
	}

	public void actualizarTabla() {
		
		//ArrayList<Proveedor> datos = (ArrayList<Proveedor>) modeloProveedor.readAllDocsAndData();
		//vistaProveedor.mostrarDatos(datos);
		
	}

	public void borrarProducto(String id, String rev) {
		
		//Proveedor p = new Proveedor(cif); 
		//modeloProveedor.deleteDoc(p);
		actualizarTabla();
		
	}

	
	public void actualizarCoche(String cif, String nombre, String direccion, String telefono) {
		Proveedor proveedor = recuperarProveedor(cif);
		proveedor.setCif(cif);
		proveedor.setNombre(nombre);
		proveedor.setDireccion(direccion);
		//proveedor.setKm(telefono);
		//modeloProveedor.updateDoc(proveedor);
		actualizarTabla();
		
	}

	public void crearProveedor(String cif, String nombre, String direccion, String telefono) {
		// TODO Auto-generated method stub
		
	}

}
