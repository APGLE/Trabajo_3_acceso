package proveedor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class TablaProveedores extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tabla;
	DefaultTableModel mt;
	JScrollPane s1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TablaProveedores frame = new TablaProveedores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TablaProveedores() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		mt = new DefaultTableModel();
		tabla = new JTable();
		s1 = new JScrollPane();
		tabla.setBounds(0, 0, 341, 250);
		s1.setBounds(0, 0, 341, 250);
		contentPane.add(tabla);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(345, 11, 89, 23);
		contentPane.add(btnActualizar);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(345, 59, 89, 23);
		contentPane.add(btnEliminar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.setBounds(345, 227, 89, 23);
		contentPane.add(btnSalir);
		
		//s1.setViewportView(tabla);
		
		String titulos[] = {"Cif","Nombre","Direccion","Telefono"};
		mt.setColumnIdentifiers(titulos);
		
		tabla = new JTable(mt);
	}
}
