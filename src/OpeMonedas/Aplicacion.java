package OpeMonedas;

import Menu.IntConversorMonedas;

public class Aplicacion {
	
	Conversor miConversion;

	public Aplicacion() {
		miConversion = new Conversor();
		presentarVentana();
	}

	private void presentarVentana() {
		IntConversorMonedas ventana = new IntConversorMonedas();
		ventana.asignarMoneda(miConversion);
		ventana.setVisible(true);
	}

}
