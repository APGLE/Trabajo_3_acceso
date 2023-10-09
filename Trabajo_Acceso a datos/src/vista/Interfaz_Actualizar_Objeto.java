package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Actualizar_Objeto extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombreObjetoTextField;
    private JTextField nuevoPrecioTextField;
    private JTextField descripcionTextField;
    private JTextField categoriaTextField;
    private JButton btnActualizarObjeto;

    public Interfaz_Actualizar_Objeto() {
        // Configurar la ventana de actualización de objeto
        setTitle("Actualizar Objeto");
        setSize(400, 250); // Aumentamos la altura para acomodar la descripción y la categoría
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(5, 2, 10, 10)); // 5 filas, 2 columnas

        // Campos de entrada
        JLabel lblNombreObjeto = new JLabel("Nombre del Objeto:");
        nombreObjetoTextField = new JTextField();

        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio:");
        nuevoPrecioTextField = new JTextField();

        JLabel lblDescripcion = new JLabel("Descripción:");
        descripcionTextField = new JTextField();

        JLabel lblCategoria = new JLabel("Categoría:");
        categoriaTextField = new JTextField();

        btnActualizarObjeto = new JButton("Actualizar Objeto");
        btnActualizarObjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los nuevos valores del objeto
                String nuevoNombreObjeto = nombreObjetoTextField.getText();
                double nuevoPrecio = Double.parseDouble(nuevoPrecioTextField.getText());
                String nuevaDescripcion = descripcionTextField.getText();
                String nuevaCategoria = categoriaTextField.getText();

                // Lógica para actualizar el objeto (debes implementar tu lógica real aquí)
                actualizarObjeto(nuevoNombreObjeto, nuevoPrecio, nuevaDescripcion, nuevaCategoria);
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(lblNombreObjeto);
        contentPanel.add(nombreObjetoTextField);
        contentPanel.add(lblNuevoPrecio);
        contentPanel.add(nuevoPrecioTextField);
        contentPanel.add(lblDescripcion);
        contentPanel.add(descripcionTextField);
        contentPanel.add(lblCategoria);
        contentPanel.add(categoriaTextField);
        contentPanel.add(btnActualizarObjeto);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void actualizarObjeto(String nuevoNombreObjeto, double nuevoPrecio, String nuevaDescripcion, String nuevaCategoria) {
        // Lógica para actualizar el objeto (debes implementar tu lógica real aquí)
        // Por ejemplo, podrías actualizar los datos en tu base de datos o sistema de objetos.
        JOptionPane.showMessageDialog(this, "Objeto actualizado:\nNombre: " + nuevoNombreObjeto
                + "\nNuevo Precio: " + nuevoPrecio + "\nDescripción: " + nuevaDescripcion + "\nCategoría: " + nuevaCategoria);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Actualizar_Objeto();
            }
        });
    }
}