package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Usuario.JFrameUsuarios;

public class Interfaz_Menu_Usuario extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interfaz_Menu_Usuario() {
        // Configurar la ventana principal
        setTitle("Mi Aplicación");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido principal
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Crear una cabecera similar a la de Ikea
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(0, 102, 204)); // Color azul similar al de Ikea
        headerPanel.setPreferredSize(new Dimension(800, 80)); // Altura de la cabecera

        // Agregar un campo de búsqueda en la cabecera
        JTextField campoBusqueda = new JTextField();
        campoBusqueda.setPreferredSize(new Dimension(200, 30)); // Tamaño del campo de búsqueda

        JButton botonBuscar = new JButton("Buscar");
        botonBuscar.setPreferredSize(new Dimension(80, 30)); // Tamaño del botón de búsqueda

        // Obtener el nombre del usuario (simulado)
        String nombreUsuario = "JohnDoe";

        // Crear un botón para el nombre del usuario que lleva al perfil
        JButton botonUsuario = new JButton(nombreUsuario);
        botonUsuario.setFocusPainted(false); // Evita el resaltado al hacer clic
        botonUsuario.setBorderPainted(false); // Quita el borde del botón
        botonUsuario.setContentAreaFilled(false); // Hace que el fondo sea transparente
        botonUsuario.setForeground(Color.WHITE); // Cambia el color del texto
        botonUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir el perfil del usuario
                abrirPerfilUsuario(nombreUsuario);
            }
        });

        headerPanel.add(campoBusqueda);
        headerPanel.add(botonBuscar);
        headerPanel.add(botonUsuario); // Agregar el botón del usuario en lugar de "Iniciar Sesión" y "Registrarse"

        // Agregar la cabecera a la ventana
        contentPanel.add(headerPanel, BorderLayout.NORTH);

        // Agregar el panel de contenido principal a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void abrirPerfilUsuario(String nombreUsuario) {
        // Lógica para abrir el perfil del usuario
        // Puedes crear una nueva ventana o cambiar el contenido de esta ventana
        JOptionPane.showMessageDialog(this, "Perfil de usuario: " + nombreUsuario);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Menu_Usuario();
            }
        });
    }
}