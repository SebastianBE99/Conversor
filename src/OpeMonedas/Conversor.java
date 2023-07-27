package OpeMonedas;

import java.util.Scanner;

public class Conversor {
	public static void mostrarMenu() {
		System.out.println("=========");
		System.out.println("Dolar");
		System.out.println("Peso colombiano");
		System.out.println("Salir");
		System.out.println("Elija un opción valida");
		System.out.println("========");
	}
	
	public double conversion(double valor, double proporcion1, double proporcion2) {
		return valor * (1/proporcion1) * proporcion2;
	}
}
