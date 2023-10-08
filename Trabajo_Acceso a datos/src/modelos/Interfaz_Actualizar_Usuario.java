package modelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Actualizar_Usuario extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombreUsuario;

    public Interfaz_Actualizar_Usuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;

        // Configurar la ventana de actualización de perfil de usuario
        setTitle("Actualizar Perfil de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Crear un panel para el formulario de actualización de perfil
        JPanel formularioPanel = new JPanel();

        // Campos de entrada
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 24, 46, 24);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(78, 25, 188, 24);

        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setBounds(10, 108, 96, 24);
        JTextField txtCorreo = new JTextField();
        txtCorreo.setBounds(116, 109, 188, 29);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(10, 190, 56, 29);
        JPasswordField txtContraseña = new JPasswordField();
        txtContraseña.setBounds(78, 190, 188, 29);
        formularioPanel.setLayout(null);

        formularioPanel.add(lblNombre);
        formularioPanel.add(txtNombre);
        formularioPanel.add(lblCorreo);
        formularioPanel.add(txtCorreo);
        formularioPanel.add(lblContraseña);
        formularioPanel.add(txtContraseña);

        // Botón para actualizar el perfil del usuario
        JButton btnActualizar = new JButton("Actualizar Perfil");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los nuevos valores del perfil del usuario
                String nuevoNombre = txtNombre.getText();
                String nuevoCorreo = txtCorreo.getText();
                String nuevaContraseña = new String(txtContraseña.getPassword());

                // Lógica para actualizar el perfil del usuario
                actualizarPerfilUsuario(nombreUsuario, nuevoNombre, nuevoCorreo, nuevaContraseña);
            }
        });

        // Agregar elementos al panel de contenido
        contentPanel.add(formularioPanel, BorderLayout.CENTER);
        contentPanel.add(btnActualizar, BorderLayout.SOUTH);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    private void actualizarPerfilUsuario(String nombreUsuario, String nuevoNombre, String nuevoCorreo, String nuevaContraseña) {
        // Lógica para actualizar el perfil del usuario
        // Debes implementar la lógica real para actualizar los datos del perfil del usuario aquí
        JOptionPane.showMessageDialog(this, "Perfil actualizado:\nNombre: " + nuevoNombre + "\nCorreo Electrónico: " + nuevoCorreo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Simulación de inicio de sesión exitoso
                String nombreUsuario = "JohnDoe";
                new Interfaz_Actualizar_Usuario(nombreUsuario);
            }
        });
    }
}