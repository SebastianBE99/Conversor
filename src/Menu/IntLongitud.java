package Menu;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import OpeMonedas.Conversor;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

public class IntLongitud extends JFrame implements ActionListener {

	private JPanel panelLongitud;
	private JTextField textoConv;
	private JTextField textValor1;
	private JTextField textValor2;
	
	OpeLongitud.Conversor miConversion;

	public IntLongitud() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponente();
		setResizable(false);
		setLocationRelativeTo(null);
	}
		
	private void iniciarComponente() {
		setBounds(100, 100, 450, 220);
		panelLongitud = new JPanel();
		panelLongitud.setBackground(UIManager.getColor("Button.background"));
		panelLongitud.setForeground(UIManager.getColor("Button.background"));
		panelLongitud.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelLongitud);
		panelLongitud.setLayout(null);
		
		JComboBox despLongitud1 = new JComboBox();
		despLongitud1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		String[] opcionesLongitud = {"Kilómetro", "Hectómetro", "Decámetro", "Metro", "Decimentro", "Centimetro", "Milímetro"};
		
		despLongitud1.setModel(new DefaultComboBoxModel(opcionesLongitud));
		despLongitud1.setBounds(20, 98, 180, 22);
		panelLongitud.add(despLongitud1);
		
		textValor1 = new JTextField();
		textValor1.setToolTipText("Ejemplos: 4000; 3.6; 2.0003");
		textValor1.setBorder(new LineBorder(new Color(192, 192, 192)));
		textValor1.setBackground(new Color(255, 255, 255));
		textValor1.setBounds(20, 65, 180, 22);
		panelLongitud.add(textValor1);
		textValor1.setColumns(10);
		
		textValor2 = new JTextField();
		textValor2.setToolTipText("");
		textValor2.setBorder(new LineBorder(new Color(192, 192, 192)));
		textValor2.setBackground(new Color(255, 255, 255));
		textValor2.setEditable(false);
		textValor2.setColumns(10);
		textValor2.setBounds(235, 65, 180, 22);
		panelLongitud.add(textValor2);
		
		JComboBox despLongitud2 = new JComboBox();
		despLongitud2.setModel(new DefaultComboBoxModel(opcionesLongitud));
		despLongitud2.setBounds(235, 98, 180, 22);
		panelLongitud.add(despLongitud2);
		
		textoConv = new JTextField();
		textoConv.setForeground(SystemColor.desktop);
		textoConv.setEditable(false);
		textoConv.setBackground(UIManager.getColor("Button.background"));
		textoConv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoConv.setHorizontalAlignment(SwingConstants.CENTER);
		textoConv.setText("Conversor de Longitudes");
		textoConv.setBorder(new LineBorder(new Color(192, 192, 192)));
		textoConv.setBounds(115, 11, 210, 28);
		panelLongitud.add(textoConv);
		textoConv.setColumns(10);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
            	IntMenu ventanaMoneda = new IntMenu();
            	ventanaMoneda.setVisible(true);
            	dispose();  
			}
		});
		
		btnVolver.setBounds(20, 139, 89, 23);
		panelLongitud.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setBounds(20, 50, 180, 14);
		panelLongitud.add(lblNewLabel);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(235, 50, 180, 14);
		panelLongitud.add(lblResultado);
		
        despLongitud1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				String seleccion1 = (String) despLongitud1.getSelectedItem();
				String seleccion2 = (String) despLongitud2.getSelectedItem();

	            try { 
	                // Obtener las proporcion1 y proporcion2 según las selecciones
	            	
	            	double valor1 = Double.parseDouble(textValor1.getText());
	            	
	                double proporcion1 = obtenerProporcion(seleccion1);
	                double proporcion2 = obtenerProporcion(seleccion2);

	                // Realizar la conversión y mostrar el resultado en textValor2
	                double respuesta = miConversion.conversion(valor1, proporcion1, proporcion2);
	                System.out.println(respuesta);
	                textValor2.setText(String.valueOf(respuesta));
		            
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor válido.");
		            }
	            
	            /////////////// AQUÍ TERMINA EL TRY Y CATCH
			}
			
	        private double obtenerProporcion(String longitud) {
	            switch (longitud) {
	                case "Kilómetro":
	                    return 0.001;
	                case "Hectómetro":
	                    return 0.01;
	                case "Decámetro":
	                	return 0.1;
	                case "Metro":
	                    return 1;
	                case "Decimentro":
	                    return 10;
	                case "Centimetro":
	                    return 100;
	                case "Milímetro":
	                    return 1000;
	                default:
	                    return 0; // Valor predeterminado en caso de moneda no reconocida
	            }
	        }		
		});
        
        despLongitud2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				String seleccion1 = (String) despLongitud1.getSelectedItem();
				String seleccion2 = (String) despLongitud2.getSelectedItem();

	            try { 
	                // Obtener las proporcion1 y proporcion2 según las selecciones
	            	
	            	double valor1 = Double.parseDouble(textValor1.getText());
	            	
	                double proporcion1 = obtenerProporcion(seleccion1);
	                double proporcion2 = obtenerProporcion(seleccion2);

	                // Realizar la conversión y mostrar el resultado en textValor2
	                double respuesta = miConversion.conversion(valor1, proporcion1, proporcion2);
	                System.out.println(respuesta);
	                textValor2.setText(String.valueOf(respuesta));
		            
		            } catch (NumberFormatException ex) {
		                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor válido.");
		            }
	            
	            /////////////// AQUÍ TERMINA EL TRY Y CATCH
			}
			
	        private double obtenerProporcion(String longitud) {
	            switch (longitud) {
	                case "Kilómetro":
	                    return 0.001;
	                case "Hectómetro":
	                    return 0.01;
	                case "Decámetro":
	                	return 0.1;
	                case "Metro":
	                    return 1;
	                case "Decimentro":
	                    return 10;
	                case "Centimetro":
	                    return 100;
	                case "Milímetro":
	                    return 1000;
	                default:
	                    return 0; // Valor predeterminado en caso de moneda no reconocida
	            }
	        }		
		});
		

	}


	public void asignarLongitud(OpeLongitud.Conversor miConversion2) {
		this.miConversion = miConversion2;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	



}
