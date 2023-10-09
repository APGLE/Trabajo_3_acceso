package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Actualizar_Proveedores extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombreProveedorTextField;
    private JTextField direccionProveedorTextField;
    private JTextField telefonoProveedorTextField; // Nuevo campo para el número de teléfono
    private JButton btnActualizarProveedor;

    public Interfaz_Actualizar_Proveedores() {
        // Configurar la ventana de actualización de proveedor
        setTitle("Actualizar Proveedor");
        setSize(400, 250); // Aumentamos la altura para acomodar el campo del número de teléfono
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 filas, 2 columnas

        // Campos de entrada
        JLabel lblNombreProveedor = new JLabel("Nombre del Proveedor:");
        nombreProveedorTextField = new JTextField();

        JLabel lblDireccionProveedor = new JLabel("Nueva Dirección:");
        direccionProveedorTextField = new JTextField();

        JLabel lblTelefonoProveedor = new JLabel("Nuevo Teléfono:");
        telefonoProveedorTextField = new JTextField();

        btnActualizarProveedor = new JButton("Actualizar Proveedor");
        btnActualizarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los nuevos valores del proveedor
                String nuevoNombreProveedor = nombreProveedorTextField.getText();
                String nuevaDireccionProveedor = direccionProveedorTextField.getText();
                String nuevoTelefonoProveedor = telefonoProveedorTextField.getText();

                // Lógica para actualizar el proveedor (debes implementar tu lógica real aquí)
                actualizarProveedor(nuevoNombreProveedor, nuevaDireccionProveedor, nuevoTelefonoProveedor);
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(lblNombreProveedor);
        contentPanel.add(nombreProveedorTextField);
        contentPanel.add(lblDireccionProveedor);
        contentPanel.add(direccionProveedorTextField);
        contentPanel.add(lblTelefonoProveedor);
        contentPanel.add(telefonoProveedorTextField);
        contentPanel.add(btnActualizarProveedor);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void actualizarProveedor(String nuevoNombreProveedor, String nuevaDireccionProveedor, String nuevoTelefonoProveedor) {
        // Lógica para actualizar el proveedor (debes implementar tu lógica real aquí)
        // Por ejemplo, podrías actualizar los datos en tu base de datos o sistema de proveedores.
        JOptionPane.showMessageDialog(this, "Proveedor actualizado:\nNombre: " + nuevoNombreProveedor
                + "\nNueva Dirección: " + nuevaDireccionProveedor + "\nNuevo Teléfono: " + nuevoTelefonoProveedor);
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