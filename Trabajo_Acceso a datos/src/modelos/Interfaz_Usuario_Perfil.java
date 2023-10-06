package modelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Usuario_Perfil extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;

    public Interfaz_Usuario_Perfil(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        // Configurar la ventana de perfil de usuario
        setTitle("Perfil de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Etiqueta de bienvenida
        JLabel lblBienvenida = new JLabel("¡Bienvenido, " + nombreUsuario + "!");
        lblBienvenida.setHorizontalAlignment(JLabel.CENTER);

        // Crear un panel para mostrar información del usuario
        JPanel infoUsuarioPanel = new JPanel();
        infoUsuarioPanel.setLayout(new GridLayout(4, 2, 10, 10)); // 4 filas, 2 columnas

        // Información del usuario (puedes personalizarla)
        JLabel lblNombre = new JLabel("Nombre:");
        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        JLabel lblContraseña = new JLabel("Contraseña:");

        JTextField txtNombre = new JTextField("John Doe");
        JTextField txtCorreo = new JTextField("john.doe@example.com");
        JPasswordField txtContraseña = new JPasswordField();

        infoUsuarioPanel.add(lblNombre);
        infoUsuarioPanel.add(txtNombre);
        infoUsuarioPanel.add(lblCorreo);
        infoUsuarioPanel.add(txtCorreo);
        infoUsuarioPanel.add(lblContraseña);
        infoUsuarioPanel.add(txtContraseña);

        // Botón para actualizar la información del usuario
        JButton btnActualizar = new JButton("Actualizar Información");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los nuevos valores del usuario
                String nuevoNombre = txtNombre.getText();
                String nuevoCorreo = txtCorreo.getText();
                String nuevaContraseña = new String(txtContraseña.getPassword());

                // Lógica para actualizar la información del usuario
                actualizarInformacionUsuario(nombreUsuario, nuevoNombre, nuevoCorreo, nuevaContraseña);
            }
        });

        // Botón para cerrar la ventana de perfil de usuario
        JButton btnCerrarPerfil = new JButton("Cerrar Perfil");
        btnCerrarPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cierra la ventana de perfil de usuario
                dispose();
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(lblBienvenida, BorderLayout.NORTH);
        contentPanel.add(infoUsuarioPanel, BorderLayout.CENTER);
        contentPanel.add(btnActualizar, BorderLayout.SOUTH);
        contentPanel.add(btnCerrarPerfil, BorderLayout.SOUTH);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void actualizarInformacionUsuario(String nombreUsuario, String nuevoNombre, String nuevoCorreo, String nuevaContraseña) {
        // Lógica para actualizar la información del usuario
        // Debes implementar la lógica real para actualizar los datos del usuario aquí
        JOptionPane.showMessageDialog(this, "Información actualizada:\nNombre: " + nuevoNombre + "\nCorreo: " + nuevoCorreo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Simulación de inicio de sesión exitoso
                String nombreUsuario = "JohnDoe";
                new Interfaz_Usuario_Perfil(nombreUsuario);
            }
        });
    }
}