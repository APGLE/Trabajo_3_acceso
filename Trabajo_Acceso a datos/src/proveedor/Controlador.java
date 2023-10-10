package proveedor;

import java.util.ArrayList;

public class Controlador {

	private VistaProveedor vista;
	private Modelo modelo;

	
	public Controlador() {
		super();
		modelo = new Modelo(this);
		vista = new Vista(this);
		actualizarTabla();
	}

	public void registrarProducto(String nombre, String descripcion, float precio_unitario, String categoria, String imagen) {

		Productos document = new Productos(nombre, descripcion, precio_unitario, categoria, imagen);
		modelo.createDoc(document);
		actualizarTabla();

	}

	public void actualizarProducto(String nombre, String descripcion, float precio_unitario, String categoria, String imagen) {
		vista.datoIntroducido(document);

	}
	
	public void actualizarTabla() {
		
		ArrayList<Productos> datos = (ArrayList<Productos>) modelo.readAllDocsAndData();
		vista.mostrarDatos(datos);
		
	}

	public void borrarProducto(String id, String rev) {
		
		Productos p = new Productos(id,rev); 
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
		
	}*/

}
