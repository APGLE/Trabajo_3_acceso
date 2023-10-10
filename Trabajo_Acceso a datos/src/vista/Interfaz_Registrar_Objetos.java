package vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Registrar_Objetos extends JFrame {
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
        JLabel lblId = new JLabel("ID:");
        lblId.setBounds(10, 9, 46, 25);
        JTextField txtId = new JTextField();
        txtId.setBounds(89, 5, 188, 33);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 52, 46, 25);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(89, 48, 188, 33);

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
        JTextField txtImagen = new JTextField();
        txtImagen.setBounds(89, 281, 188, 31);

        formularioPanel.setLayout(null);

        formularioPanel.add(lblId);
        formularioPanel.add(txtId);
        formularioPanel.add(lblNombre);
        formularioPanel.add(txtNombre);
        formularioPanel.add(lblDescripcion);
        formularioPanel.add(descripcionScrollPane);
        formularioPanel.add(lblPrecio);
        formularioPanel.add(txtPrecio);
        formularioPanel.add(lblCategoria);
        formularioPanel.add(cboCategoria);
        formularioPanel.add(lblImagen);
        formularioPanel.add(txtImagen);

        // Botón para agregar el producto
        JButton btnAgregar = new JButton("Agregar Producto");
        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los valores del producto desde los campos de entrada
                String id = txtId.getText();
                String nombre = txtNombre.getText();
                String descripcion = txtDescripcion.getText();
                double precio = Double.parseDouble(txtPrecio.getText());
                String categoria = (String) cboCategoria.getSelectedItem();
                String imagen = txtImagen.getText(); // Obtener la ruta de la imagen

                // Lógica para agregar el producto a la base de datos
                if (guardarProductoEnBaseDeDatos(id, nombre, descripcion, precio, categoria, imagen)) {
                    JOptionPane.showMessageDialog(
                        Interfaz_Registrar_Objetos.this,
                        "Producto agregado con éxito."
                    );
                } else {
                    JOptionPane.showMessageDialog(
                        Interfaz_Registrar_Objetos.this,
                        "Error al agregar el producto. Verifica la conexión a la base de datos."
                    );
                }
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

    // Función para guardar el producto en la base de datos
    private boolean guardarProductoEnBaseDeDatos(String id, String nombre, String descripcion, double precio, String categoria, String imagen) {
        String url = "jdbc:mysql://localhost:3306/tiendamuebles";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            String consulta = "INSERT INTO producto (id, nombre, descripcion, precio, categoria, imagen) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, descripcion);
            preparedStatement.setDouble(4, precio);
            preparedStatement.setString(5, categoria);
            preparedStatement.setString(6, imagen); // Insertar la ruta de la imagen

            int filasAfectadas = preparedStatement.executeUpdate();

            // Cerrar la conexión
            preparedStatement.close();
            connection.close();

            return filasAfectadas > 0; // Retorna true si al menos una fila fue afectada (éxito)
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // Retorna false en caso de error
        }
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