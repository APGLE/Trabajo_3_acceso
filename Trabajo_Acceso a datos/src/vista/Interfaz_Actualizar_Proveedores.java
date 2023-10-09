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
    private JButton btnActualizarProveedor;

    public Interfaz_Actualizar_Proveedores() {
        // Configurar la ventana de actualización de proveedor
        setTitle("Actualizar Proveedor");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3, 2, 10, 10)); // 3 filas, 2 columnas

        // Campos de entrada
        JLabel lblNombreProveedor = new JLabel("Nombre del Proveedor:");
        nombreProveedorTextField = new JTextField();

        JLabel lblDireccionProveedor = new JLabel("Nueva Dirección:");
        direccionProveedorTextField = new JTextField();

        btnActualizarProveedor = new JButton("Actualizar Proveedor");
        btnActualizarProveedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los nuevos valores del proveedor
                String nuevoNombreProveedor = nombreProveedorTextField.getText();
                String nuevaDireccionProveedor = direccionProveedorTextField.getText();

                // Lógica para actualizar el proveedor (debes implementar tu lógica real aquí)
                actualizarProveedor(nuevoNombreProveedor, nuevaDireccionProveedor);
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(lblNombreProveedor);
        contentPanel.add(nombreProveedorTextField);
        contentPanel.add(lblDireccionProveedor);
        contentPanel.add(direccionProveedorTextField);
        contentPanel.add(btnActualizarProveedor);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void actualizarProveedor(String nuevoNombreProveedor, String nuevaDireccionProveedor) {
        // Lógica para actualizar el proveedor (debes implementar tu lógica real aquí)
        // Por ejemplo, podrías actualizar los datos en tu base de datos o sistema de proveedores.
        JOptionPane.showMessageDialog(this, "Proveedor actualizado:\nNombre: " + nuevoNombreProveedor
                + "\nNueva Dirección: " + nuevaDireccionProveedor);
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
