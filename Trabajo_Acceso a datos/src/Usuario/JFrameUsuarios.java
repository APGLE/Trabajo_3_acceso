package Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Usuario;
import vista.Interfaz_Menu;
import vista.Interfaz_Menu_Usuario;

public class JFrameUsuarios extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table_1;
    private DefaultTableModel modelo;
    private JLabel NombreTabla;
    private JButton delete, insert, update, filtrar, salir, volver;
    private List<Usuario> ListaUsuarios = new ArrayList<>();
    private List<Usuario> datosOriginales = new ArrayList<>();
    
    public JFrameUsuarios() {
        super("Usuario");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(514, 395);
        setResizable(false);
        getContentPane().setLayout(null);
        
        NombreTabla = new JLabel("Usuarios");
        NombreTabla.setBounds(25, 210, 100, 30);
        getContentPane().add(NombreTabla);

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table_1 = new JTable();
        table_1.setModel(modelo);
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(25, 21, 464, 179);
        getContentPane().add(scrollPane);

        modelo.addColumn("User");
        modelo.addColumn("Password");
        modelo.addColumn("Rol");
        
        delete = new JButton("Borrar");
        delete.setBounds(5, 311, 71, 23);
        getContentPane().add(delete);
        
        insert = new JButton("Insertar");
        insert.setBounds(156, 311, 80, 23);
        getContentPane().add(insert);
        
        update = new JButton("Editar");
        update.setBounds(244, 311, 80, 22);
        getContentPane().add(update);

        filtrar = new JButton("Filtrar");
        filtrar.setBounds(80, 311, 71, 23);
        getContentPane().add(filtrar);

        salir = new JButton("Salir");
        salir.setBounds(420, 311, 71, 23);
        getContentPane().add(salir);
        
        volver = new JButton("Volver");
        volver.setBounds(332, 311, 80, 23);
        getContentPane().add(volver);
        
        
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table_1.getSelectedRow();
                if (selectedRow != -1) {
                    String selectedItem = (String) table_1.getValueAt(selectedRow, 0);
                    int option = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de eliminar '" + selectedItem + "'?", "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        modelo.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay elementos seleccionados para eliminar.");
                }
            }
        });

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = JOptionPane.showInputDialog(null, "Ingrese el nombre del usuario:");
                String password = JOptionPane.showInputDialog(null, "Ingrese la contraseña del usuario:");
                String rol = JOptionPane.showInputDialog(null, "Ingrese su rol:");
                
                Usuario nuevoUsuario = new Usuario(user, password, rol);
                ListaUsuarios.add(nuevoUsuario);
                
                Object[] fila = new Object[modelo.getColumnCount()];
                fila[0] = nuevoUsuario.getUsuario();
                fila[1] = nuevoUsuario.getPassword();
                fila[2] = nuevoUsuario.getRol();
                modelo.addRow(fila);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table_1.getSelectedRow();
                if (selectedRow != -1) {
                    String user = JOptionPane.showInputDialog(null, "Usuario actual: " + table_1.getValueAt(selectedRow, 0) + "\n Ingrese el nuevo usuario:");
                    String password = JOptionPane.showInputDialog(null, "Contraseña actual: " + table_1.getValueAt(selectedRow, 1) + "\n Ingrese la nueva contraseña:");
                    String rol = JOptionPane.showInputDialog(null, "Rol actual: " + table_1.getValueAt(selectedRow, 2) + "\n Ingrese el nuevo:");
                    
                    Usuario usuarioActualizado = ListaUsuarios.get(selectedRow);
                    usuarioActualizado.setUsuario(user);
                    usuarioActualizado.setPassword(password);
                    usuarioActualizado.setRol(rol);
                    
                    table_1.setValueAt(user, selectedRow, 0);
                    table_1.setValueAt(password, selectedRow, 1);
                    table_1.setValueAt(rol, selectedRow, 2);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un usuario para actualizar.");
                }
            }
        });

        filtrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filtro = JOptionPane.showInputDialog(null, "Introduce un filtro:");
                if (filtro != null) {
                    almacenarDatosOriginales();
                    List<Usuario> resultados = filtrar(filtro);
                    actualizarTabla(resultados);
                    volver.setEnabled(true);
                }
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 int option = JOptionPane.showConfirmDialog(null, "¿Estás seguro de salir?", "Confirmar salida", JOptionPane.YES_NO_OPTION);
                 if (option == JOptionPane.YES_OPTION) {
                     dispose(); // Cierra la ventana actual
                     new Interfaz_Menu();
                 }
           }
        });
        
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }


    public void EscribirTabla() {
        for (Usuario u : ListaUsuarios) {
            Object[] Fila = new Object[modelo.getColumnCount()];
            Fila[0] = u.getUsuario();
            Fila[1] = u.getPassword();
            Fila[2] = u.getRol();

            try {
                modelo.addRow(Fila);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Usuario> filtrar(String filtro) {
        List<Usuario> resultadosFiltrados = new ArrayList<>();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombre = (String) modelo.getValueAt(i, 0);
            if (nombre.toLowerCase().contains(filtro.toLowerCase())) {
                resultadosFiltrados.add(ListaUsuarios.get(i));
            }
        }

        return resultadosFiltrados;
    }

    public void actualizarTabla(List<Usuario> resultados) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (Usuario u : resultados) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = u.getUsuario();
            fila[1] = u.getPassword();
            fila[2] = u.getRol();
            

            modelo.addRow(fila);
        }
    }
    
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
    
    
    private void almacenarDatosOriginales() {
        datosOriginales.clear();
        datosOriginales.addAll(ListaUsuarios);
    }

    private void volver() {
        actualizarTabla(datosOriginales);
        volver.setEnabled(false);
    }

    public static void main(String[] args) {
        JFrameUsuarios frame = new JFrameUsuarios();
        frame.setVisible(true);
    }

}
