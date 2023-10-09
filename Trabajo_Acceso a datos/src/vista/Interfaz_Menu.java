package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Menu extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interfaz_Menu() {
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

        // Agregar la opción "Iniciar Sesión" en la cabecera
        JButton botonIniciarSesion = new JButton("Iniciar Sesión");
        botonIniciarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir la ventana de inicio de sesión
                abrirVentanaInicioSesion();
            }
        });

        // Agregar la opción "Registrarse" en la cabecera
        JButton botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir la ventana de registro
                abrirVentanaRegistro();
            }
        });

        headerPanel.add(campoBusqueda);
        headerPanel.add(botonBuscar);
        headerPanel.add(botonIniciarSesion);
        headerPanel.add(botonRegistrarse);

        // Agregar la cabecera a la ventana
        contentPanel.add(headerPanel, BorderLayout.NORTH);

        // Agregar el panel de contenido principal a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void abrirVentanaInicioSesion() {
        // Lógica para abrir la ventana de inicio de sesión
        // Puedes crear una nueva ventana o un diálogo para el inicio de sesión aquí
        JOptionPane.showMessageDialog(this, "Ventana de Inicio de Sesión");
    }

    private void abrirVentanaRegistro() {
        // Lógica para abrir la ventana de registro
        // Puedes crear una nueva ventana o un diálogo para el registro aquí
        JOptionPane.showMessageDialog(this, "Ventana de Registro");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Menu();
            }
        });
    }
}