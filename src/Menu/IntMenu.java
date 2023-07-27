package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import OpeMonedas.Principal;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.awt.event.ItemEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class IntMenu extends JFrame {

	private JPanel menuConversor;
	private JComboBox<String> desplegableConversion;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntMenu frame = new IntMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntMenu() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 450, 220);
		menuConversor = new JPanel();
		menuConversor.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(menuConversor);
		menuConversor.setLayout(null);
		
		setResizable(false);
		setLocationRelativeTo(null);
		
		desplegableConversion = new JComboBox<String>();
		desplegableConversion.setFont(new Font("Tahoma", Font.PLAIN, 16));
		desplegableConversion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
	    String[] opciones = {"Conversor de Monedas", "Conversor de Longitudes", "Salir"};
	    desplegableConversion.setModel(new DefaultComboBoxModel<>(opciones));
		desplegableConversion.setBounds(55, 85, 320, 25);
		menuConversor.add(desplegableConversion);
		
        desplegableConversion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String seleccion = (String) desplegableConversion.getSelectedItem();
				
	            if (seleccion.equals("Conversor de Monedas")) {
	                Principal.main(new String[0]);
	                dispose(); 
	            } else if (seleccion.equals("Conversor de Longitudes")) {
	                OpeLongitud.Principal.main(new String[0]);
	                dispose(); 
	            } else if (seleccion.equals("Salir")) {
					JOptionPane.showMessageDialog(null, "¡Hasta Pronto!");
					System.exit(0);
	            }
			}

		});
		
		JLabel textoMenu = new JLabel("Seleccione una opción de conversión");
		textoMenu.setFont(new Font("Tahoma", Font.PLAIN, 12));
		textoMenu.setBounds(55, 65, 320, 22);
		menuConversor.add(textoMenu);
		
		lblNewLabel = new JLabel("MENÚ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(168, 11, 90, 50);
		menuConversor.add(lblNewLabel);
	}
}
