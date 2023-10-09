package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Eliminar_Usuario extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> listaUsuariosModel;

    public Interfaz_Eliminar_Usuario() {
        // Configurar la ventana de eliminación de usuarios
        setTitle("Eliminar Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Crear una lista de usuarios
        listaUsuariosModel = new DefaultListModel<>();
        JList<String> listaUsuarios = new JList<>(listaUsuariosModel);
        JScrollPane listaUsuariosScrollPane = new JScrollPane(listaUsuarios);

        // Botón para cargar usuarios de ejemplo
        JButton btnCargarUsuarios = new JButton("Cargar Usuarios de la base de datos");
        btnCargarUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cargar usuarios de ejemplo en la lista (simulación)
                cargarUsuariosDeEjemplo();
            }
        });

        // Botón para eliminar usuarios seleccionados
        JButton btnEliminar = new JButton("Eliminar Usuarios Seleccionados");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los usuarios seleccionados
                int[] indicesSeleccionados = listaUsuarios.getSelectedIndices();

                // Lógica para eliminar los usuarios seleccionados (simulación)
                eliminarUsuariosSeleccionados(indicesSeleccionados);
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(btnCargarUsuarios, BorderLayout.NORTH);
        contentPanel.add(listaUsuariosScrollPane, BorderLayout.CENTER);
        contentPanel.add(btnEliminar, BorderLayout.SOUTH);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void cargarUsuariosDeEjemplo() {
        // Simulación de carga de usuarios de ejemplo
        listaUsuariosModel.addElement("Usuario1");
        listaUsuariosModel.addElement("Usuario2");
        listaUsuariosModel.addElement("Usuario3");
    }

    private void eliminarUsuariosSeleccionados(int[] indicesSeleccionados) {
        // Lógica para eliminar los usuarios seleccionados (simulación)
        for (int i = indicesSeleccionados.length - 1; i >= 0; i--) {
            listaUsuariosModel.remove(indicesSeleccionados[i]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Eliminar_Usuario();
            }
        });
    }
}