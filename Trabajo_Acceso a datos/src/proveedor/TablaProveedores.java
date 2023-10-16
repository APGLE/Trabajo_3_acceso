package proveedor;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablaProveedores extends JFrame {

	private JFrame datos;
	private JTable tablaProveedores;
	private static final long serialVersionUID = 1L;
	private JPanel panelProveedor;
	private static JTable tablaProveedor;
	private DefaultTableModel dtmConsulta;
	private JScrollPane jspProveedor;
	private ControladorProveedor controladorProveedor;
	DefaultTableModel mt;
	JScrollPane s1;
	
	public TablaProveedores(ControladorProveedor controladorProveedor) {
		this.controladorProveedor = controladorProveedor;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 350);
		panelProveedor = new JPanel();
		panelProveedor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelProveedor);
		panelProveedor.setLayout(null);
		mt = new DefaultTableModel();
		tablaProveedor = new JTable();
		s1 = new JScrollPane();
		tablaProveedor.setBounds(0, 0, 375, 300);
		s1.setBounds(0, 0, 341, 250);
		panelProveedor.add(tablaProveedor);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(385, 11, 89, 23);
		panelProveedor.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(385, 45, 89, 23);
		panelProveedor.add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(385, 277, 89, 23);
		panelProveedor.add(btnSalir);
		
		//s1.setViewportView(tabla);
		
		String columnas[] = {"Cif","Nombre","Direccion","Telefono"};
		mt.setColumnIdentifiers(columnas);
		
		tablaProveedor = new JTable(mt);
	}
	
	public TablaProveedores() {
		
			
	}

	private void inicializarComponentes() {

		panelProveedor = new JPanel();
		panelProveedor.setLayout(null);
		panelProveedor.setBounds(200, 0, 433, 463);

		String[] columnas = new String[] { "Cif", "Nombre", "Direccion" , "Telefono"};
		dtmConsulta = new DefaultTableModel(columnas, 0);
		setTablaProveedor(new JTable(dtmConsulta));
		getTablaProveedor().setPreferredScrollableViewportSize(new Dimension(250, 100));
		getTablaProveedor().getTableHeader().setReorderingAllowed(true);
		getTablaProveedor().setEnabled(true);

		 
		// Crear el ordenador de filas TableRowSorter<DefaultTableModel> sorter = new
		// TableRowSorter<>(ComboCoche); getTablaCoches().setRowSorter(sorter);
		// sorter.sort();

		jspProveedor = new JScrollPane(getTablaProveedor());
		jspProveedor.setBounds(5, 5, 450, 355);
		datos.add(jspProveedor);

	}
	
	public static JTable getTablaProveedor() {
		return tablaProveedor;
	}

	public void setTablaProveedor(JTable tablaProveedor) {
		TablaProveedores.tablaProveedor = tablaProveedor;
	}

	
	private String [] nombresColumnas= {"Cif","Nombre","Direccion","Telefono"};
	
	private Object [] [] datosFila= {
		
			{"P123456","Juan Palomo","Pontevedra","+34678903345"},
			{"P654321","Manolita Perez","Cuenca","+34655432190"}
	};
	
}
