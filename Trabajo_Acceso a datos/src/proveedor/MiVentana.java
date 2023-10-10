package proveedor;


	import javax.swing.*;
	import java.awt.*;

	public class MiVentana extends JFrame {
	    private JTextField cifTextField;
	    private JTextField nombreTextField;
	    private JTextField direccionTextField;
	    private JTextField telefonoTextField;

	    public MiVentana() {
	        // Configuración de la ventana
	        setTitle("Mi Ventana");
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	        // Crear el panel de contenido
	        JPanel contentPanel = new JPanel();
	        contentPanel.setLayout(new GridLayout(4, 2)); // GridLayout para organizar los componentes en filas y columnas

	        // Crear etiquetas y campos de texto
	        JLabel lblCif = new JLabel("CIF:");
	        cifTextField = new JTextField();

	        JLabel lblNombre = new JLabel("Nombre:");
	        nombreTextField = new JTextField();
	        nombreTextField.setBounds(50,50,25,100);
	        
	        JLabel lblDireccion = new JLabel("Dirección:");
	        direccionTextField = new JTextField();

	        JLabel lblTelefono = new JLabel("Teléfono:");
	        telefonoTextField = new JTextField();

	        // Agregar etiquetas y campos de texto al panel de contenido
	        contentPanel.add(lblCif);
	        contentPanel.add(cifTextField);
	        contentPanel.add(lblNombre);
	        contentPanel.add(nombreTextField);
	        contentPanel.add(lblDireccion);
	        contentPanel.add(direccionTextField);
	        contentPanel.add(lblTelefono);
	        contentPanel.add(telefonoTextField);

	        // Agregar el panel de contenido a la ventana
	        getContentPane().add(contentPanel);

	        // Mostrar la ventana
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new MiVentana();
	        });
	    }
}
