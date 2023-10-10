package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VistaProveedores extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame datos;
	private DefaultTableModel dtmConsulta;
	private JTextField cifTextField;
	private JTextField nombreTextField;
	private JTextField direccionTextField;
    private JTextField telefonoTextField;
    private JButton btnActualizar;
    private JButton btnRegistrar;
    private JButton btnBorrar;
    private JButton btnListar;
    private JButton btnSalir;

    public VistaProveedores() {
        // Configurar la ventana de actualización de proveedor
        setTitle("Proveedor");
        setSize(700, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear un panel para el contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null); 
        contentPanel.setBounds(200, 0, 433, 463);
        
        // Campos de entrada
        JLabel lblCif = new JLabel("Cif: ");
        lblCif.setBounds(25,50,100,25);
        contentPanel.add(lblCif);
        nombreTextField = new JTextField();
        
        JLabel lblNombre = new JLabel("Nombre: ");
        lblNombre.setBounds(25,100,100,25);
        contentPanel.add(lblNombre);
        nombreTextField = new JTextField();

        JLabel lblDireccion = new JLabel("Direccion: ");
        lblDireccion.setBounds(25,150,100,25);
        contentPanel.add(lblDireccion);
        nombreTextField = new JTextField();
        
        JLabel lblTelefono = new JLabel("Telefono: ");
        lblTelefono.setBounds(25,200,100,25);
        contentPanel.add(lblTelefono);
        nombreTextField = new JTextField();

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los nuevos valores del proveedor
                String nuevoNombreProveedor = nombreTextField.getText();
                String nuevaDireccionProveedor = direccionTextField.getText();

                // Lógica para actualizar el proveedor (debes implementar tu lógica real aquí)
                actualizarProveedor(nuevoNombreProveedor, nuevaDireccionProveedor);
            }
        });

        // Agregar elementos al panel de contenido
        
        cifTextField = new JTextField();
        cifTextField.setBounds(150,50, 200, 25);
        contentPanel.add(lblCif);
         
        nombreTextField = new JTextField();
        nombreTextField.setBounds(150,50, 200, 25);
        contentPanel.add(lblNombre);
        
        direccionTextField = new JTextField();
        direccionTextField.setBounds(150,50, 200, 25);
        contentPanel.add(lblDireccion);
        
        telefonoTextField = new JTextField();
        telefonoTextField.setBounds(150,50, 200, 25);
        contentPanel.add(lblTelefono);
        
        contentPanel.add(btnActualizar);

        // Agregar el panel de contenido a la ventana
        getContentPane().add(contentPanel);

        // Mostrar la ventana
        setVisible(true);
    }
    
    public VistaProveedores(Controlador controlador) {

		this.controlador = controlador;
		datos = new JFrame();
		datos.setBounds(100, 100, 570, 400);
		datos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		datos.setLocationRelativeTo(null);
		datos.getContentPane().setLayout(null);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id;
				String rev;
				id = (String) dtmConsulta.getValueAt(getTablaProveedores().getSelectedRow(), 0);
				accionBotonActualizar(id);
				// System.out.println("El boton modificar funciona");
			}
		});
		
		btnActualizar.setBounds(460, 60, 89, 23);
		datos.getContentPane().add(btnActualizar);
		
		// Este es el boton Modify

				JButton btnEliminar = new JButton("Eliminar");
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id;
						id = (String) dtmConsulta.getValueAt(getTablaProveedores().getSelectedRow(), 0);
						accionBotonBorrar(id);
						// System.out.println(id + " " + rev);

					}

				});
				
				btnEliminar.setBounds(460, 90, 89, 23);
				datos.getContentPane().add(btnEliminar);

				// Este es el boton Delete

				JButton btnRefresh = new JButton("Actualizar");
				btnRefresh.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// System.out.println("El boton refresh tambien funciona");

						accionBotonActualizar();
					}

				});
				
				btnActualizar.setBounds(460, 120, 89, 23);
				datos.getContentPane().add(btnActualizar);

				// Este es el boton Refresh

				JButton btnSalir = new JButton("Salir");
				btnSalir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						datos.dispose();
					}
				});
				
				btnSalir.setBounds(460, 320, 89, 23);
				datos.getContentPane().add(btnSalir);

				// Este es el boton Exit

				JButton btnRegistrar = new JButton("Registrar");
				btnRegistrar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
//						String entrada = JOptionPane.showInputDialog("Introduzca su matricula");
//						String entrada1 = JOptionPane.showInputDialog("Introduzca la marca del vehiculo");
//						String entrada2 = JOptionPane.showInputDialog("Introduzca el modelo del vehiculo");
//						String entrada3 = JOptionPane.showInputDialog("Introduzca los kilometros de su vehiculo");
//						String entrada4 = JOptionPane.showInputDialog("Introduzca el color");
//						controlador.crearDocumento(entrada, entrada1, entrada2, entrada3, entrada4);
						// System.out.println(entrada + "\n" + entrada1 + "\n" + entrada2 + "\n" +
						// entrada3 + "\n" + entrada4);
						mostrarFormulario('a');

					}

				});
				
				btnRegistrar.setBounds(460, 30, 89, 23);
				datos.getContentPane().add(btnRegistrar);

				inicializarComponentes();

				datos.setVisible(true);
				mostrarDatos(new ArrayList());
			}
    }

    private void actualizarProveedor(String nuevoNombreProveedor, String nuevaDireccionProveedor) {
        // Lógica para actualizar el proveedor (debes implementar tu lógica real aquí)
        // Por ejemplo, podrías actualizar los datos en tu base de datos o sistema de proveedores.
        JOptionPane.showMessageDialog(this, "Proveedor actualizado:\nNombre: " + nuevoNombreProveedor
                + "\nNueva Dirección: " + nuevaDireccionProveedor);
    }
    
    protected void accionBotonActualizar(String cif, String nombre, String direccion, String telefono) {
		controlador.actualizarCoche(proveedorSeleccionado.getId(),proveedorSeleccionado.getRevision(),nombre, direccion, telefono);
	}

	protected void accionBotonSalir() {
		formulario.dispose();

	}

	public void mostrarDatos(ArrayList<Proveedor> datosTabla) {
		// dtmConsulta.addRow(new Object[]
		// {"Cif","Nombre","Direccion","Telefono"});
		dtmConsulta.setRowCount(0);
		// datosTabla.add(Proveedor.placeHolder());
		for (Proveedor doc : datosTabla) {
			dtmConsulta.addRow(new Object[] { doc.getCif(), doc.getNombre(), doc.getDireccion(), doc.getTelefono()});

		}

	}

	public void accionBotonRegistrar(String cif, String nombre, String direccion, String telefono) {
		controlador.crearProveedor(cif, nombre, direccion, telefono);
	}

}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VistaProveedores();
            }
        });
    }
}
