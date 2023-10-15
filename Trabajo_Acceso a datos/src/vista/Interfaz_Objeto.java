package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import modelos.Producto;

public class Interfaz_Objeto extends JFrame {
    private JLabel nombreLabel;
    private JLabel precioLabel;
    private JLabel descripcionLabel;
    private JLabel categoriaLabel;
    private JLabel imagenLabel;

    public Interfaz_Objeto(Producto producto) {
        setTitle("Detalles del Objeto");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(1, 2));

        JPanel imagenPanel = new JPanel();
        imagenPanel.setPreferredSize(new Dimension(300, 300));
        imagenPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        try {
            BufferedImage imagen = ImageIO.read(new File(producto.getImagen()));
            ImageIcon imagenIcon = new ImageIcon(imagen.getScaledInstance(300, 300, Image.SCALE_SMOOTH));
            imagenLabel = new JLabel(imagenIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(5, 1));

        nombreLabel = new JLabel("Nombre: " + producto.getNombre());
        precioLabel = new JLabel("Precio: " + producto.getPrecio());
        descripcionLabel = new JLabel("Descripción: " + producto.getDescripcion());
        categoriaLabel = new JLabel("Categoría: " + producto.getCategoria());

        infoPanel.add(nombreLabel);
        infoPanel.add(precioLabel);
        infoPanel.add(descripcionLabel);
        infoPanel.add(categoriaLabel);

        contentPanel.add(imagenPanel);
        contentPanel.add(infoPanel);

        JButton botonactualizar = new JButton("Actualizar información");
        infoPanel.add(botonactualizar);

        botonactualizar.addActionListener(e -> {
            Interfaz_Actualizar_Objeto actualizarObjeto = new Interfaz_Actualizar_Objeto(producto);

            if (actualizarObjeto.isActualizacionExitosa()) {
                nombreLabel.setText("Nombre: " + actualizarObjeto.getNombreActualizado());
                precioLabel.setText("Precio: " + actualizarObjeto.getPrecioActualizado());
                descripcionLabel.setText("Descripción: " + actualizarObjeto.getDescripcionActualizada());
                categoriaLabel.setText("Categoría: " + actualizarObjeto.getCategoriaActualizada());
                // También puedes actualizar la imagen si es necesario
                // imagenLabel.setIcon(actualizarObjeto.getImagenActualizada());
            }
        });

        getContentPane().add(contentPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Producto producto = new Producto("1", "Producto 1", "imagen_producto1.jpg", "Descripción del producto 1", "Electrónica", 29.99);
            new Interfaz_Objeto(producto);
        });
    }
}
