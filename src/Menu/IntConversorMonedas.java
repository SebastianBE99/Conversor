package Menu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import OpeMonedas.Conversor;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JCheckBoxMenuItem;

public class IntConversorMonedas extends JFrame implements ActionListener{

	private JPanel panelDivisas;
	private JTextField textValor1;
	private JTextField textValor2;
	private JTextField textoConv;
	
	Conversor miConversion;

	public IntConversorMonedas() {
		setTitle("Conversor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		iniciarComponente();
		setResizable(false);
		setLocationRelativeTo(null);
	}

	private void iniciarComponente() {
		setBounds(100, 100, 450, 220);
		panelDivisas = new JPanel();
		panelDivisas.setBackground(UIManager.getColor("Button.background"));
		panelDivisas.setForeground(UIManager.getColor("Button.background"));
		panelDivisas.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelDivisas);
		panelDivisas.setLayout(null);
		
		JComboBox despMoneda1 = new JComboBox<>();
		despMoneda1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		
		String[] opcionesMonedas= {"Dolar Estadounidense", "Euros", "Libra Esterlina", "Peso Colombiano", "Won sul-coreano", "Yen Japonés"};
		
		despMoneda1.setModel(new DefaultComboBoxModel<>(opcionesMonedas));
		despMoneda1.setBounds(20, 98, 180, 22);
		panelDivisas.add(despMoneda1);
		
		textValor1 = new JTextField();
		textValor1.setToolTipText("Ejemplos: 4000; 3.6; 2.0003");
		textValor1.setBorder(new LineBorder(new Color(192, 192, 192)));
		textValor1.setBackground(new Color(255, 255, 255));
		textValor1.setBounds(20, 65, 180, 22);
		panelDivisas.add(textValor1);
		textValor1.setColumns(10);
		
		textValor2 = new JTextField();
		textValor2.setToolTipText("");
		textValor2.setBorder(new LineBorder(new Color(192, 192, 192)));
		textValor2.setBackground(new Color(255, 255, 255));
		textValor2.setEditable(false);
		textValor2.setColumns(10);
		textValor2.setBounds(235, 65, 180, 22);
		panelDivisas.add(textValor2);
		
		JComboBox<?> despMoneda2 = new JComboBox<>();
		despMoneda2.setModel(new DefaultComboBoxModel(opcionesMonedas));
		despMoneda2.setBounds(235, 98, 180, 22);
		panelDivisas.add(despMoneda2);
		
		textoConv = new JTextField();
		textoConv.setForeground(SystemColor.desktop);
		textoConv.setEditable(false);
		textoConv.setBackground(UIManager.getColor("Button.background"));
		textoConv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textoConv.setHorizontalAlignment(SwingConstants.CENTER);
		textoConv.setText("Conversor de Monedas");
		textoConv.setBorder(new LineBorder(new Color(192, 192, 192)));
		textoConv.setBounds(125, 11, 200, 28);
		panelDivisas.add(textoConv);
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
		panelDivisas.add(btnVolver);
		
		JLabel lblNewLabel = new JLabel("Valor");
		lblNewLabel.setBounds(20, 50, 180, 14);
		panelDivisas.add(lblNewLabel);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setBounds(235, 50, 180, 14);
		panelDivisas.add(lblResultado);
		

        despMoneda1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
	
				String seleccion1 = (String) despMoneda1.getSelectedItem();
				String seleccion2 = (String) despMoneda2.getSelectedItem();

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

	        private double obtenerProporcion(String moneda) {
	            switch (moneda) {
	                case "Dolar Estadounidense":
	                    return 1;
	                case "Euros":
	                    return 0.90;
	                case "Libra Esterlina":
	                	return 0.78;
	                case "Peso Colombiano":
	                    return 4000;
	                case "Won sul-coreano":
	                    return 1280.65;
	                case "Yen Japonés":
	                    return 141.32;
	                default:
	                    return 0; // Valor predeterminado en caso de moneda no reconocida
	            }
	        }		
		});
        
        despMoneda2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				String seleccion1 = (String) despMoneda1.getSelectedItem();
				String seleccion2 = (String) despMoneda2.getSelectedItem();

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
		                JOptionPane.showMessageDialog(null, "Error: Ingresa un valor válido");
		            }
			}

	        private double obtenerProporcion(String moneda) {
	            switch (moneda) {
	                case "Dolar Estadounidense":
	                    return 1;
	                case "Euros":
	                    return 0.90;
	                case "Libra Esterlina":
	                	return 0.78;
	                case "Peso Colombiano":
	                    return 4000;
	                case "Won sul-coreano":
	                    return 1280.65;
	                case "Yen Japonés":
	                    return 141.32;
	                default:
	                    return 0; // Valor predeterminado en caso de moneda no reconocida
	            }
	        }		
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

	public void asignarMoneda(Conversor miConversion) {
		this.miConversion = miConversion;
	}
}
