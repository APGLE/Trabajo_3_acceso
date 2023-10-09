package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Interfaz_Objeto extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Interfaz_Objeto(String nombre, String descripcion, double precio, String categoria, String imagenPath) {
        // Configurar la ventana de detalles del objeto
        setTitle("Detalles del Objeto");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());

        // Panel para la imagen
        JPanel imagenPanel = new JPanel();
        imagenPanel.setPreferredSize(new Dimension(200, 200));
        imagenPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Cargar la imagen del objeto
        JLabel imagenLabel = new JLabel();
        try {
            BufferedImage imagen = ImageIO.read(new File(imagenPath));
            ImageIcon imagenIcon = new ImageIcon(imagen.getScaledInstance(200, 200, Image.SCALE_SMOOTH));
            imagenLabel.setIcon(imagenIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        imagenPanel.add(imagenLabel);

        // Panel para la descripción, nombre y categoría
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BorderLayout());

        JLabel nombreLabel = new JLabel("Nombre: " + nombre);
        JLabel precioLabel = new JLabel("Precio: " + precio);
        JLabel descripcionLabel = new JLabel("Descripción: " + descripcion);
        JLabel categoriaLabel = new JLabel("Categoría: " + categoria);

        infoPanel.add(nombreLabel, BorderLayout.NORTH);
        infoPanel.add(precioLabel, BorderLayout.EAST);
        infoPanel.add(descripcionLabel, BorderLayout.CENTER);
        infoPanel.add(categoriaLabel, BorderLayout.SOUTH);

        // Agregar elementos al panel de contenido
        contentPanel.add(imagenPanel, BorderLayout.WEST);
        contentPanel.add(infoPanel, BorderLayout.CENTER);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Ejemplo de uso de la interfaz de objeto
                new Interfaz_Objeto("Producto 1", "Descripción del producto 1", 29.99, "Electrónica", "imagen_producto1.jpg");
            }
        });
    }
}