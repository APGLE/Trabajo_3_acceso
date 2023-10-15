package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.Producto;

public class Interfaz_Actualizar_Objeto extends JFrame {
    private JTextField idObjetoTextField;
    private JTextField nuevoNombreObjetoTextField;
    private JTextField nuevoPrecioTextField;
    private JTextField nuevaDescripcionTextField;
    private JTextField nuevaCategoriaTextField;
    private boolean actualizacionExitosa = false;

    public Interfaz_Actualizar_Objeto(Producto producto) {
        setTitle("Actualizar Objeto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblIdObjeto = new JLabel("ID del Objeto:");
        idObjetoTextField = new JTextField(producto.getId());
        idObjetoTextField.setEditable(false);

        JLabel lblNuevoNombreObjeto = new JLabel("Nuevo Nombre:");
        nuevoNombreObjetoTextField = new JTextField(producto.getNombre());

        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio:");
        nuevoPrecioTextField = new JTextField(String.valueOf(producto.getPrecio()));

        JLabel lblNuevaDescripcion = new JLabel("Nueva Descripción:");
        nuevaDescripcionTextField = new JTextField(producto.getDescripcion());

        JLabel lblNuevaCategoria = new JLabel("Nueva Categoría:");
        nuevaCategoriaTextField = new JTextField(producto.getCategoria());

        JButton btnActualizarObjeto = new JButton("Actualizar Objeto");

        contentPanel.add(lblIdObjeto);
        contentPanel.add(idObjetoTextField);
        contentPanel.add(lblNuevoNombreObjeto);
        contentPanel.add(nuevoNombreObjetoTextField);
        contentPanel.add(lblNuevoPrecio);
        contentPanel.add(nuevoPrecioTextField);
        contentPanel.add(lblNuevaDescripcion);
        contentPanel.add(nuevaDescripcionTextField);
        contentPanel.add(lblNuevaCategoria);
        contentPanel.add(nuevaCategoriaTextField);
        contentPanel.add(btnActualizarObjeto);

        btnActualizarObjeto.addActionListener(e -> {
            // Obtener los datos actualizados desde los campos de texto
            String nuevoNombreObjeto = nuevoNombreObjetoTextField.getText();
            double nuevoPrecio = Double.parseDouble(nuevoPrecioTextField.getText());
            String nuevaDescripcion = nuevaDescripcionTextField.getText();
            String nuevaCategoria = nuevaCategoriaTextField.getText();

            // Lógica para actualizar el objeto en la base de datos
            // Debes implementar la lógica real para actualizar la base de datos aquí

            // Simula una actualización exitosa (debes implementar la lógica real)
            actualizacionExitosa = true;

            dispose();
        });

        getContentPane().add(contentPanel);
        setVisible(true);
    }

    public boolean isActualizacionExitosa() {
        return actualizacionExitosa;
    }

    public String getNombreActualizado() {
        return nuevoNombreObjetoTextField.getText();
    }

    public double getPrecioActualizado() {
        return Double.parseDouble(nuevoPrecioTextField.getText());
    }

    public String getDescripcionActualizada() {
        return nuevaDescripcionTextField.getText();
    }

    public String getCategoriaActualizada() {
        return nuevaCategoriaTextField.getText();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Producto producto = new Producto("1", "Producto 1", "imagen_producto1.jpg", "Descripción del producto 1", "Electrónica", 29.99);
            new Interfaz_Actualizar_Objeto(producto);
        });
    }
}
