package modelos;

package modelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interfaz_Registrar_Objetos extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interfaz_Registrar_Objetos() {
        // Configurar la ventana de agregar producto
        setTitle("Agregar Producto");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Crear un panel para el formulario de agregar producto
        JPanel formularioPanel = new JPanel();

        // Campos de entrada
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 35, 46, 25);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(89, 31, 188, 33);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(10, 91, 66, 25);
        JTextArea txtDescripcion = new JTextArea();
        JScrollPane descripcionScrollPane = new JScrollPane(txtDescripcion);
        descripcionScrollPane.setBounds(89, 91, 188, 41);

        JLabel lblPrecio = new JLabel("Precio Unitario:");
        lblPrecio.setBounds(10, 159, 79, 25);
        JTextField txtPrecio = new JTextField();
        txtPrecio.setBounds(89, 153, 188, 37);

        JLabel lblCategoria = new JLabel("Categoría:");
        lblCategoria.setBounds(10, 222, 54, 31);
        String[] categorias = {"Electrónica", "Ropa", "Alimentación", "Hogar", "Deportes"};
        JComboBox<String> cboCategoria = new JComboBox<>(categorias);
        cboCategoria.setBounds(74, 222, 188, 31);

        JLabel lblImagen = new JLabel("Imagen:");
        lblImagen.setBounds(10, 281, 46, 31);
        JButton btnCargarImagen = new JButton("Cargar Imagen");
        btnCargarImagen.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnCargarImagen.setBounds(89, 281, 188, 31);
        formularioPanel.setLayout(null);

        formularioPanel.add(lblNombre);
        formularioPanel.add(txtNombre);
        formularioPanel.add(lblDescripcion);
        formularioPanel.add(descripcionScrollPane);
        formularioPanel.add(lblPrecio);
        formularioPanel.add(txtPrecio);
        formularioPanel.add(lblCategoria);
        formularioPanel.add(cboCategoria);
        formularioPanel.add(lblImagen);
        formularioPanel.add(btnCargarImagen);

        // Botón para agregar el producto
        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del producto
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                String categoria = (String) cboCategoria.getSelectedItem();

                // Lógica para agregar el producto a tu sistema
                agregarProducto(nombre, descripcion, precio, categoria);
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(formularioPanel, BorderLayout.CENTER);
        contentPanel.add(btnAgregar, BorderLayout.SOUTH);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void agregarProducto(String nombre, String descripcion, double precio, String categoria) {
        // Lógica para agregar el producto a tu sistema
        // Debes implementar la lógica real para almacenar los datos del producto aquí
        JOptionPane.showMessageDialog(this, "Producto agregado:\nNombre: " + nombre + "\nDescripción: " + descripcion
                + "\nPrecio Unitario: " + precio + "\nCategoría: " + categoria);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Registrar_Objetos();
            }
        });
    }
}