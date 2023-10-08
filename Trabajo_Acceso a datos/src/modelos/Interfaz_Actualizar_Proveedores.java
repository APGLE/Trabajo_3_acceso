package modelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Actualizar_Proveedores extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interfaz_Actualizar_Proveedores() {
        // Configurar la ventana de registro de proveedores
        setTitle("Registro de Proveedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Crear un panel para el formulario de registro de proveedores
        JPanel formularioPanel = new JPanel();

        // Campos de entrada
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 27, 40, 26);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(60, 28, 188, 26);

        JLabel lblDireccion = new JLabel("Dirección:");
        lblDireccion.setBounds(10, 76, 46, 26);
        JTextField txtDireccion = new JTextField();
        txtDireccion.setBounds(66, 77, 188, 26);

        JLabel lblTelefono = new JLabel("Número de Teléfono:");
        lblTelefono.setBounds(10, 139, 98, 26);
        JTextField txtTelefono = new JTextField();
        txtTelefono.setBounds(118, 140, 188, 26);

        JLabel lblOtraInformacion = new JLabel("Otra Información:");
        lblOtraInformacion.setBounds(10, 206, 87, 26);
        JTextArea txtOtraInformacion = new JTextArea();
        JScrollPane otraInformacionScrollPane = new JScrollPane(txtOtraInformacion);
        otraInformacionScrollPane.setBounds(107, 212, 188, 26);
        formularioPanel.setLayout(null);

        formularioPanel.add(lblNombre);
        formularioPanel.add(txtNombre);
        formularioPanel.add(lblDireccion);
        formularioPanel.add(txtDireccion);
        formularioPanel.add(lblTelefono);
        formularioPanel.add(txtTelefono);
        formularioPanel.add(lblOtraInformacion);
        formularioPanel.add(otraInformacionScrollPane);

        // Botón para registrar al proveedor
        JButton btnRegistrar = new JButton("Registrar Proveedor");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del proveedor
                String nombre = txtNombre.getText();
                String direccion = txtDireccion.getText();
                String telefono = txtTelefono.getText();
                String otraInformacion = txtOtraInformacion.getText();

                // Lógica para registrar al proveedor en tu sistema
                registrarProveedor(nombre, direccion, telefono, otraInformacion);
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(formularioPanel, BorderLayout.CENTER);
        contentPanel.add(btnRegistrar, BorderLayout.SOUTH);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void registrarProveedor(String nombre, String direccion, String telefono, String otraInformacion) {
        // Lógica para registrar al proveedor en tu sistema
        // Debes implementar la lógica real para almacenar los datos del proveedor aquí
        JOptionPane.showMessageDialog(this, "Proveedor registrado:\nNombre: " + nombre + "\nDirección: " + direccion
                + "\nNúmero de Teléfono: " + telefono + "\nOtra Información: " + otraInformacion);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Actualizar_Proveedores();
            }
        });
    }
}