package OpeLongitud;

import Menu.IntLongitud;

public class AplicacionLong {
	
	Conversor miConversion;

	public AplicacionLong() {
		miConversion = new Conversor();
		presentarVentana();
	}

	private void presentarVentana() {
		IntLongitud ventana = new IntLongitud();
		ventana.asignarLongitud(miConversion);
		ventana.setVisible(true);
	}

}
