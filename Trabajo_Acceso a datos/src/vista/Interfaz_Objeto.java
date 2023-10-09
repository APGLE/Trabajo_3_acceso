package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Interfaz_Objeto extends JFrame {
	public Interfaz_Objeto() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 10, 434, 44);
		panel.add(panel_1);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(10, 10, 33, 21);
		panel_1.add(btnNewButton);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(109, 11, 190, 19);
		panel_1.add(textField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(322, 14, 86, 13);
		panel_1.add(lblNewLabel);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

}
