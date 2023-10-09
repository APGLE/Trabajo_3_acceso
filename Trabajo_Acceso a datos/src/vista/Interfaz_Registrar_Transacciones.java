package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JButton;

public class Interfaz_Registrar_Transacciones extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Interfaz_Registrar_Transacciones() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 10, 318, 243);
		panel.add(table);
		
		JButton btnNewButton = new JButton("Refrescar");
		btnNewButton.setBounds(338, 217, 85, 21);
		panel.add(btnNewButton);
	}
	private JTable table;
}