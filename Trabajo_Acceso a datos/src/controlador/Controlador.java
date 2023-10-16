package controlador;

import java.util.ArrayList;

import modelos.Modelo;
import modelos.Producto;
import vista.Vista;

public class Controlador {

	private Vista vista;
	private Modelo modelo;

	
	public Controlador() {
		super();
		modelo = new Modelo(this);
		vista = new Vista();
		actualizarTabla();
	}

	public void registrarProducto(String nombre, String descripcion, float precio_unitario, String categoria, String imagen) {

		Producto document = new Producto();
		//modelo.createDoc(document);
		actualizarTabla();

	}

	public void actualizarProducto(String nombre, String descripcion, float precio_unitario, String categoria, String imagen) {
		//vista.datoIntroducido(document);

	}
	
	public void actualizarTabla() {
		
		//ArrayList<Producto> datos = (ArrayList<Producto>) modelo.readAllDocsAndData();
		//vista.mostrarDatos(datos);
		
	}

	public void borrarProducto(String id, String rev) {
		
		Producto p = new Producto(); 
		//modelo.deleteDoc(p);
		actualizarTabla();
		
	}

	public  Producto recuperarCoche(String id) {
		
		return null;
				
	}
}
