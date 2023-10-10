package Usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelos.Usuario;

public class JFrameUsuarios extends JFrame {

    private JTable table_1;
    private DefaultTableModel modelo;
    private JLabel NombreTabla;
    private JButton delete, insert, update, filtrar, salir, volver;
    private List<Usuario> ListaUsuarios = new ArrayList<>();
    private List<Usuario> datosOriginales = new ArrayList<>();
    
    public JFramePaises() {
        super("Paises");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(514, 395);
        setResizable(false);
        getContentPane().setLayout(null);
        
        NombreTabla = new JLabel("Paises");
        NombreTabla.setBounds(25, 210, 100, 30);
        getContentPane().add(NombreTabla);

        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table_1 = new JTable();
        table_1.setModel(modelo);
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBounds(25, 21, 464, 179);
        getContentPane().add(scrollPane);

        modelo.addColumn("Nombre");
        modelo.addColumn("Continente");
        modelo.addColumn("Aliados");
        modelo.addColumn("Imagen");
        modelo.addColumn("Habitantes");
        
        delete = new JButton("Borrar");
        delete.setBounds(5, 311, 71, 23);
        getContentPane().add(delete);
        
        insert = new JButton("Insertar");
        insert.setBounds(156, 311, 80, 23);
        getContentPane().add(insert);
        
        update = new JButton("Editar");
        update.setBounds(244, 311, 80, 22);
        getContentPane().add(update);

        filtrar = new JButton("Filtrar");
        filtrar.setBounds(80, 311, 71, 23);
        getContentPane().add(filtrar);

        salir = new JButton("Salir");
        salir.setBounds(420, 311, 71, 23);
        getContentPane().add(salir);
        
        volver = new JButton("Volver");
        volver.setBounds(332, 311, 80, 23);
        getContentPane().add(volver);

        EscribirTitulos();

        ListaPaises.add(new Pais("Espania", "Europa", "Portugal", "imagen", 45000000));
        ListaPaises.add(new Pais("Italia", "Europa", "España", "imagen", 15623000));
        ListaPaises.add(new Pais("Malta", "Europa", "Portugal", "imagen", 64233400));
        ListaPaises.add(new Pais("Estados Unidos", "América", "Portugal", "imagen", 889912300));
        ListaPaises.add(new Pais("Argentina", "América", "Portugal", "imagen", 64312300));
        ListaPaises.add(new Pais("Chile", "América", "Portugal", "imagen", 242312300));
        ListaPaises.add(new Pais("Francia", "Europa", "Portugal", "imagen", 46712300));
        
        EscribirTabla();

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table_1.getSelectedRow();
                if (selectedRow != -1) {
                    String selectedItem = (String) table_1.getValueAt(selectedRow, 0);
                    int option = JOptionPane.showConfirmDialog(null,
                            "¿Estás seguro de eliminar '" + selectedItem + "'?", "Confirmar eliminación",
                            JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        modelo.removeRow(selectedRow);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No hay elementos seleccionados para eliminar.");
                }
            }
        });

        insert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre del país:");
                String continente = JOptionPane.showInputDialog(null, "Ingrese el continente:");
                String aliados = JOptionPane.showInputDialog(null, "Ingrese los aliados:");
                String imagen = JOptionPane.showInputDialog(null, "Ingrese la URL de la imagen:");
                int habitantes = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la cantidad de habitantes:"));
                
                Pais nuevoPais = new Pais(nombre, continente, aliados, imagen, habitantes);
                ListaPaises.add(nuevoPais);
                
                Object[] fila = new Object[modelo.getColumnCount()];
                fila[0] = nuevoPais.getNombre();
                fila[1] = nuevoPais.getContinente();
                fila[2] = nuevoPais.getAliados();
                fila[3] = nuevoPais.getImagen();
                fila[4] = nuevoPais.getHabitantes();
                modelo.addRow(fila);
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table_1.getSelectedRow();
                if (selectedRow != -1) {
                    String nombre = JOptionPane.showInputDialog(null, "Nombre actual: " + table_1.getValueAt(selectedRow, 0) + "\nIngrese el nuevo nombre:");
                    String continente = JOptionPane.showInputDialog(null, "Continente actual: " + table_1.getValueAt(selectedRow, 1) + "\nIngrese el nuevo continente:");
                    String aliados = JOptionPane.showInputDialog(null, "Aliados actuales: " + table_1.getValueAt(selectedRow, 2) + "\nIngrese los nuevos aliados:");
                    String imagen = JOptionPane.showInputDialog(null, "Imagen actual: " + table_1.getValueAt(selectedRow, 3) + "\nIngrese la nueva URL de la imagen:");
                    int habitantes = Integer.parseInt(JOptionPane.showInputDialog(null, "Habitantes actuales: " + table_1.getValueAt(selectedRow, 4) + "\nIngrese la nueva cantidad de habitantes:"));
                    
                    Pais paisActualizado = ListaPaises.get(selectedRow);
                    paisActualizado.setNombre(nombre);
                    paisActualizado.setContinente(continente);
                    paisActualizado.setAliados(aliados);
                    paisActualizado.setImagen(imagen);
                    paisActualizado.setHabitantes(habitantes);
                    
                    table_1.setValueAt(nombre, selectedRow, 0);
                    table_1.setValueAt(continente, selectedRow, 1);
                    table_1.setValueAt(aliados, selectedRow, 2);
                    table_1.setValueAt(imagen, selectedRow, 3);
                    table_1.setValueAt(habitantes, selectedRow, 4);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecciona un país para actualizar.");
                }
            }
        });

        filtrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String filtro = JOptionPane.showInputDialog(null, "Introduce un filtro:");
                if (filtro != null) {
                    almacenarDatosOriginales();
                    List<Pais> resultados = filtrar(filtro);
                    actualizarTabla(resultados);
                    volver.setEnabled(true);
                }
            }
        });

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                volver();
            }
        });
    }

    public void EscribirTitulos() {
        Object[] titulos = new Object[modelo.getColumnCount()];
        titulos[0] = "Nombre";
        titulos[1] = "Continente";
        titulos[2] = "Aliados";
        titulos[3] = "Imagen";
        titulos[4] = "Habitantes";

        modelo.addRow(titulos);
    }

    public void EscribirTabla() {
        for (Pais p : ListaPaises) {
            Object[] Fila = new Object[modelo.getColumnCount()];
            Fila[0] = p.getNombre();
            Fila[1] = p.getContinente();
            Fila[2] = p.getAliados();
            Fila[3] = p.getImagen();
            Fila[4] = p.getHabitantes();

            try {
                modelo.addRow(Fila);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Pais> filtrar(String filtro) {
        List<Pais> resultadosFiltrados = new ArrayList<>();

        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombre = (String) modelo.getValueAt(i, 0);
            if (nombre.toLowerCase().contains(filtro.toLowerCase())) {
                resultadosFiltrados.add(ListaPaises.get(i));
            }
        }

        return resultadosFiltrados;
    }

    public void actualizarTabla(List<Pais> resultados) {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        for (Pais pais : resultados) {
            Object[] fila = new Object[modelo.getColumnCount()];
            fila[0] = pais.getNombre();
            fila[1] = pais.getContinente();
            fila[2] = pais.getAliados();
            fila[3] = pais.getImagen();
            fila[4] = pais.getHabitantes();

            modelo.addRow(fila);
        }
    }
    
    private void almacenarDatosOriginales() {
        datosOriginales.clear();
        datosOriginales.addAll(ListaPaises);
    }

    private void volver() {
        actualizarTabla(datosOriginales);
        volver.setEnabled(false);
    }

    public static void main(String[] args) {
        JFramePaises frame = new JFramePaises();
        frame.setVisible(true);
    }
}
