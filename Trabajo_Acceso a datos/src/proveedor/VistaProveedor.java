package proveedor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaProveedor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame datos;
	private FormularioProveedor formulario;
	private JTextField cifTextField;
	private JTextField nombreTextField;
	private JTextField direccionTextField;
	private JTextField telefonoTextField;
	private JButton btnActualizar;
	private JButton btnRegistrar;
	private JButton btnBorrar;
	private JButton btnListar;
	private JButton btnSalir;
	private ControladorProveedor controladorProveedor;
	private Object proveedorSeleccionado;
	private JTable tablaProveedores;
	private JPanel panelProveedores;
	private DefaultTableModel dtmDatos;
	private JScrollPane jspProveedores;

	public VistaProveedor() {
		// Configurar la ventana de actualización de proveedor
	}

	public VistaProveedor(ControladorProveedor controlador) {

		this.controladorProveedor = controlador;
		datos = new JFrame();
		datos.setBounds(100, 100, 575, 425);
		datos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		datos.setLocationRelativeTo(null);
		datos.getContentPane().setLayout(null);

		String[] nombreColumnas = { "Cif", "Nombre", "Direccion", "Telefono" };
		Object[][] datosColumnas = { { "P123456", "Mariquita", "Madrid", "+34600987654" } };
		tablaProveedores = new JTable(datosColumnas, nombreColumnas);
		tablaProveedores.setPreferredScrollableViewportSize(new Dimension(250, 100));
		// datos.add(tablaProveedores.getTableHeader(),BorderLayout.PAGE_START);
		// datos.add(tablaProveedores);
		jspProveedores = new JScrollPane(tablaProveedores);
		jspProveedores.setBounds(0, 0, 450, 300);
		datos.add(jspProveedores);
		datos.setVisible(true);

		/*
		 * setTitle("Proveedor"); setSize(700, 400);
		 * setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		 * setLocationRelativeTo(null);
		 * 
		 * // Crear un panel para el contenido JPanel contentPanel = new JPanel();
		 * contentPanel.setLayout(null); contentPanel.setBounds(200, 0, 433, 463);
		 * 
		 * // Campos de entrada JLabel lblCif = new JLabel("Cif: ");
		 * lblCif.setBounds(25,50,100,25); contentPanel.add(lblCif); nombreTextField =
		 * new JTextField();
		 * 
		 * JLabel lblNombre = new JLabel("Nombre: ");
		 * lblNombre.setBounds(25,100,100,25); contentPanel.add(lblNombre);
		 * nombreTextField = new JTextField();
		 * 
		 * JLabel lblDireccion = new JLabel("Direccion: ");
		 * lblDireccion.setBounds(25,150,100,25); contentPanel.add(lblDireccion);
		 * nombreTextField = new JTextField();
		 * 
		 * JLabel lblTelefono = new JLabel("Telefono: ");
		 * lblTelefono.setBounds(25,200,100,25); contentPanel.add(lblTelefono);
		 * nombreTextField = new JTextField();
		 */

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// Lógica para actualizar el proveedor (debes implementar tu lógica real aquí)
				actualizarProveedor();
			}
		});

		/*
		 * // Agregar elementos al panel de contenido
		 * 
		 * cifTextField = new JTextField(); cifTextField.setBounds(150,50, 200, 25);
		 * panelProveedores.add(lblCif);
		 * 
		 * nombreTextField = new JTextField(); nombreTextField.setBounds(150,50, 200,
		 * 25); panelProveedores.add(lblNombre);
		 * 
		 * direccionTextField = new JTextField(); direccionTextField.setBounds(150,50,
		 * 200, 25); panelProveedores.add(lblDireccion);
		 * 
		 * telefonoTextField = new JTextField(); telefonoTextField.setBounds(150,50,
		 * 200, 25); panelProveedores.add(lblTelefono);
		 * 
		 * panelProveedores.add(btnActualizar);
		 * 
		 * // Agregar el panel de contenido a la ventana
		 * getContentPane().add(panelProveedores);
		 * 
		 * // Mostrar la ventana setVisible(true);
		 */

		btnActualizar.setBounds(440, 20, 89, 23);
		datos.getContentPane().add(btnActualizar);

		// Este es el boton Modify

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cif;
				// id = (String) dtmConsulta.getValueAt(getTablaProveedores().getSelectedRow(),
				// 0);
				// accionBotonBorrar(cif);
				// System.out.println(id + " " + rev);

			}

			private Object getTablaProveedores() {
				// TODO Auto-generated method stub
				return null;
			}

			private void accionBotonBorrar(String id) {
				// TODO Auto-generated method stub

			}

		});

		btnEliminar.setBounds(460, 90, 89, 23);
		datos.getContentPane().add(btnEliminar);

		// Este es el boton Delete

		JButton btnRefresh = new JButton("Actualizar");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// System.out.println("El boton refresh tambien funciona");

				accionBotonActualizar();
			}

			private void accionBotonActualizar() {
				// TODO Auto-generated method stub

			}

		});

		btnActualizar.setBounds(460, 120, 89, 23);
		datos.getContentPane().add(btnActualizar);

		// Este es el boton Refresh

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				datos.dispose();
			}
		});

		btnSalir.setBounds(460, 320, 89, 23);
		datos.getContentPane().add(btnSalir);

		// Este es el boton Exit

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.setBounds(460, 20, 89, 23);
		datos.getContentPane().add(btnRegistrar);
		btnRegistrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				accionBotonRegistrar();
				
			}
			
		});
	}

	private void mostrarFormulario(char c) {
		// TODO Auto-generated method stub

	}

	/*
	 * private void inicializarComponentes() { // TODO Auto-generated method stub
	 * 
	 * } /** Lógica para actualizar el proveedor (debes implementar tu lógica real
	 * aquí) Por ejemplo, podrías actualizar los datos en tu base de datos o sistema
	 * de proveedores.
	 * 
	 * @param nuevoNombreProveedor
	 * 
	 * @param nuevaDireccionProveedor
	 */

	private void actualizarProveedor() {

	}

	protected void accionBotonActualizar(String cif, String nombre, String direccion, String telefono) {
		formulario = new FormularioProveedor(controladorProveedor);
	}

	protected void accionBotonSalir() {
		formulario.dispose();

	}

	public void mostrarDatos(ArrayList<Proveedor> datosTabla) {
		// dtmConsulta.addRow(new Object[]
		// {"Cif","Nombre","Direccion","Telefono"});
		dtmDatos.setRowCount(0);
		// datosTabla.add(Proveedor.placeHolder());
		for (Proveedor doc : datosTabla) {
			dtmDatos.addRow(new Object[] { doc.getCif(), doc.getNombre(), doc.getDireccion(), doc.getTelefono() });

		}

	}

	public void accionBotonRegistrar() {
		formulario = new FormularioProveedor(controladorProveedor);
	}

}
