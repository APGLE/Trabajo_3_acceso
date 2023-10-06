package modelos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Registrar_Usuario extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interfaz_Registrar_Usuario() {
        // Configurar la ventana de registro
        setTitle("Registro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Crear un panel para el formulario de registro
        JPanel formularioPanel = new JPanel();

        // Etiquetas y campos de entrada
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(10, 35, 63, 22);
        JTextField txtNombre = new JTextField();
        txtNombre.setBounds(73, 27, 188, 40);

        JLabel lblCorreo = new JLabel("Correo Electrónico:");
        lblCorreo.setBounds(10, 117, 94, 22);
        JTextField txtCorreo = new JTextField();
        txtCorreo.setBounds(114, 109, 188, 40);

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setBounds(10, 191, 63, 22);
        JPasswordField txtContraseña = new JPasswordField();
        txtContraseña.setBounds(83, 180, 178, 40);
        formularioPanel.setLayout(null);

        formularioPanel.add(lblNombre);
        formularioPanel.add(txtNombre);
        formularioPanel.add(lblCorreo);
        formularioPanel.add(txtCorreo);
        formularioPanel.add(lblContraseña);
        formularioPanel.add(txtContraseña);

        // Botón de registro
        JButton btnRegistrar = new JButton("Registrar");
        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica de registro aquí
                String nombre = txtNombre.getText();
                String correo = txtCorreo.getText();
                String contraseña = new String(txtContraseña.getPassword());

                // Puedes realizar la validación y el proceso de registro aquí
                JOptionPane.showMessageDialog(null, "Usuario registrado:\nNombre: " + nombre + "\nCorreo: " + correo);
            }
        });

        // Agregar el formulario y el botón al panel de contenido
        contentPanel.add(formularioPanel, BorderLayout.CENTER);
        contentPanel.add(btnRegistrar, BorderLayout.SOUTH);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Interfaz_Registrar_Usuario();
            }
        });
    }
}