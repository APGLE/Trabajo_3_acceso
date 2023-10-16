package proveedor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioProveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldCif;
	private JTextField textFieldNombre;
	private JTextField textFieldDireccion;
	private JTextField textFieldTelefono;
	private ControladorProveedor controladorProveedor;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public FormularioProveedor(ControladorProveedor controlador) {
		this.controladorProveedor = controlador;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCif = new JLabel("Cif");
		lblCif.setBounds(10, 23, 46, 14);
		contentPane.add(lblCif);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(10, 73, 46, 14);
		contentPane.add(lblNombre);

		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(10, 123, 46, 14);
		contentPane.add(lblDireccion);

		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(10, 173, 46, 14);
		contentPane.add(lblTelefono);

		textFieldCif = new JTextField();
		textFieldCif.setBounds(162, 20, 290, 20);
		contentPane.add(textFieldCif);
		textFieldCif.setColumns(10);

		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(162, 70, 290, 20);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		textFieldDireccion = new JTextField();
		textFieldDireccion.setBounds(162, 120, 290, 20);
		contentPane.add(textFieldDireccion);
		textFieldDireccion.setColumns(10);

		textFieldTelefono = new JTextField();
		textFieldTelefono.setBounds(162, 170, 290, 20);
		contentPane.add(textFieldTelefono);
		textFieldTelefono.setColumns(10);

		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRegistrar.setBounds(10, 227, 89, 23);
		contentPane.add(btnRegistrar);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(126, 227, 89, 23);
		contentPane.add(btnActualizar);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(245, 227, 89, 23);
		contentPane.add(btnEliminar);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(385, 227, 89, 23);
		contentPane.add(btnSalir);

		setVisible(true);

	}
}
