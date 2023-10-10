package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Interfaz_Actualizar_Objeto extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField idObjetoTextField;
    private JTextField nombreObjetoTextField;
    private JTextField nuevoPrecioTextField;
    private JTextField descripcionTextField;
    private JTextField categoriaTextField;
    private JTextField imagenTextField;
    private JButton btnActualizarObjeto;

    public Interfaz_Actualizar_Objeto() {
        // Configurar la ventana de actualización de objeto
        setTitle("Actualizar Objeto");
        setSize(400, 300); // Aumentamos la altura para acomodar la descripción y la categoría
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(7, 2, 10, 10)); // 7 filas, 2 columnas

        // Campos de entrada
        JLabel lblIdObjeto = new JLabel("ID del Objeto:");
        idObjetoTextField = new JTextField();

        JLabel lblNombreObjeto = new JLabel("Nuevo Nombre:");
        nombreObjetoTextField = new JTextField();

        JLabel lblNuevoPrecio = new JLabel("Nuevo Precio:");
        nuevoPrecioTextField = new JTextField();

        JLabel lblDescripcion = new JLabel("Nueva Descripción:");
        descripcionTextField = new JTextField();

        JLabel lblCategoria = new JLabel("Nueva Categoría:");
        categoriaTextField = new JTextField();

        JLabel lblImagen = new JLabel("Nueva Imagen:");
        imagenTextField = new JTextField();

        btnActualizarObjeto = new JButton("Actualizar Objeto");
        btnActualizarObjeto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener la ID del objeto a actualizar
                int idObjeto = Integer.parseInt(idObjetoTextField.getText());

                // Verificar si la ID existe en la base de datos
                if (existeObjeto(idObjeto)) {
                    // La ID existe, mostrar ventana de actualización
                    String nuevoNombreObjeto = nombreObjetoTextField.getText();
                    double nuevoPrecio = Double.parseDouble(nuevoPrecioTextField.getText());
                    String nuevaDescripcion = descripcionTextField.getText();
                    String nuevaCategoria = categoriaTextField.getText();
                    String nuevaImagen = imagenTextField.getText();

                    // Lógica para actualizar el objeto en la base de datos
                    if (actualizarObjeto(idObjeto, nuevoNombreObjeto, nuevoPrecio, nuevaDescripcion, nuevaCategoria, nuevaImagen)) {
                        JOptionPane.showMessageDialog(
                            Interfaz_Actualizar_Objeto.this,
                            "Objeto actualizado con éxito."
                        );
                    } else {
                        JOptionPane.showMessageDialog(
                            Interfaz_Actualizar_Objeto.this,
                            "Error al actualizar el objeto. Verifica la conexión a la base de datos."
                        );
                    }
                } else {
                    // La ID no existe, mostrar ventana de error
                    JOptionPane.showMessageDialog(
                        Interfaz_Actualizar_Objeto.this,
                        "La ID del objeto no existe en la base de datos. Introduce una ID válida."
                    );
                }
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(lblIdObjeto);
        contentPanel.add(idObjetoTextField);
        contentPanel.add(lblNombreObjeto);
        contentPanel.add(nombreObjetoTextField);
        contentPanel.add(lblNuevoPrecio);
        contentPanel.add(nuevoPrecioTextField);
        contentPanel.add(lblDescripcion);
        contentPanel.add(descripcionTextField);
        contentPanel.add(lblCategoria);
        contentPanel.add(categoriaTextField);
        contentPanel.add(lblImagen);
        contentPanel.add(imagenTextField);
        contentPanel.add(btnActualizarObjeto);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    // Función para verificar si la ID del objeto existe en la base de datos
    private boolean existeObjeto(int idObjeto) {
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            String consulta = "SELECT id FROM objetos WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setInt(1, idObjeto);

            ResultSet resultSet = preparedStatement.executeQuery();
            boolean existe = resultSet.next();

            // Cerrar la conexión
            resultSet.close();
            preparedStatement.close();
            connection.close();

            return existe;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // En caso de error, se considera que la ID no existe
        }
    }

    // Función para actualizar el objeto en la base de datos
    private boolean actualizarObjeto(int idObjeto, String nuevoNombreObjeto, double nuevoPrecio, String nuevaDescripcion, String nuevaCategoria, String nuevaImagen) {
        String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
        String usuario = "tu_usuario";
        String contraseña = "tu_contraseña";

        try {
            Connection connection = DriverManager.getConnection(url, usuario, contraseña);
            String consulta = "UPDATE objetos SET nombre = ?, precio = ?, descripcion = ?, categoria = ?, imagen = ? WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(consulta);
            preparedStatement.setString(1, nuevoNombreObjeto);
            preparedStatement.setDouble(2, nuevoPrecio);
            preparedStatement.setString(3, nuevaDescripcion);
            preparedStatement.setString(4, nuevaCategoria);
            preparedStatement.setString(5, nuevaImagen);
            preparedStatement.setInt(6, idObjeto);

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
                new Interfaz_Actualizar_Objeto();
            }
        });
    }
}