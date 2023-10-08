package modelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Eliminar_Proveedores extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultListModel<String> listaProveedoresModel;

    public Interfaz_Eliminar_Proveedores() {
        // Configurar la ventana de eliminación de proveedores
        setTitle("Eliminar Proveedor");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Crear una lista de proveedores
        listaProveedoresModel = new DefaultListModel<>();
        JList<String> listaProveedores = new JList<>(listaProveedoresModel);
        JScrollPane listaProveedoresScrollPane = new JScrollPane(listaProveedores);

        // Botón para cargar proveedores de ejemplo
        JButton btnCargarProveedores = new JButton("Cargar Proveedores de la base de datos");
        btnCargarProveedores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cargar proveedores de ejemplo en la lista (simulación)
                cargarProveedoresDeEjemplo();
            }
        });

        // Botón para eliminar proveedores seleccionados
        JButton btnEliminar = new JButton("Eliminar Proveedores Seleccionados");
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los proveedores seleccionados
                int[] indicesSeleccionados = listaProveedores.getSelectedIndices();

                // Lógica para eliminar los proveedores seleccionados (simulación)
                eliminarProveedoresSeleccionados(indicesSeleccionados);
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(btnCargarProveedores, BorderLayout.NORTH);
        contentPanel.add(listaProveedoresScrollPane, BorderLayout.CENTER);
        contentPanel.add(btnEliminar, BorderLayout.SOUTH);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void cargarProveedoresDeEjemplo() {
        // Simulación de carga de proveedores de ejemplo
        listaProveedoresModel.addElement("Proveedor1");
        listaProveedoresModel.addElement("Proveedor2");
        listaProveedoresModel.addElement("Proveedor3");
    }

    private void eliminarProveedoresSeleccionados(int[] indicesSeleccionados) {
        // Lógica para eliminar los proveedores seleccionados (simulación)
        for (int i = indicesSeleccionados.length - 1; i >= 0; i--) {
            listaProveedoresModel.remove(indicesSeleccionados[i]);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Eliminar_Proveedores();
            }
        });
    }
}