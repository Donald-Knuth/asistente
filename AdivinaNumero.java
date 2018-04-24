package juegos;

import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero {
	private int rangoMin;
	private int rangoMax;

	public AdivinaNumero(int rangoMin, int rangoMax) {
		this.rangoMin = rangoMin;
		this.rangoMax = rangoMax;
	}

	public AdivinaNumero() {
		this.rangoMin = Integer.MIN_VALUE;
		this.rangoMax = Integer.MAX_VALUE;
	}

	public int adivinaTuNumero() {

		int limInf = this.rangoMin;
		int limSup = this.rangoMax;
		while (true) {
			Random rand = new Random();
			int numeroPensado = rand.nextInt(limSup - limInf) + limInf;
			int comparacion = comparacion(numeroPensado);

			if (comparacion == 0)
				return numeroPensado;
			else if (comparacion > 0)
				limInf = numeroPensado;
			else
				limSup = numeroPensado;
		}

	}

	public static int comparacion(int numPropuesto) {
		Scanner scan = new Scanner(System.in);
		while (true) {

			System.out.println("Es " + numPropuesto + " tu número? [S/N]");
			String respuesta = scan.nextLine();
			respuesta = respuesta.toUpperCase();
			if (respuesta.equals("S")) {
				return 0;
			} else if (respuesta.equals("N")) {
				System.out.println("Tu número es más grande?[S/N]");
				respuesta = scan.nextLine();
				respuesta = respuesta.toUpperCase();
				if (respuesta.equals("S")) {
					return 1;
				} else if (respuesta.equals("N")) {
					return -1;
				} else
					System.out.println("Contestá con S o con N");
			} else
				System.out.println("Contestá con S o con N");
		}
	}

	public void adivinaMiNumero() {
		Random rand = new Random();
		int numToGuess = rand.nextInt(this.rangoMax - this.rangoMin) + this.rangoMin;
		String siNo = new String();
		System.out.format("Intentá adivinar mi número:");

		while (true) {
			Scanner scan = new Scanner(System.in);
			int intento = scan.nextInt();

			if (intento > numToGuess)
				System.out.println("Mi número es más chico");

			else if (intento < numToGuess)
				System.out.println("Mi número es más grande");

			else {
				System.out.println("Ese es mi número!");
				System.out.println("Querés jugar de nuevo? [S/N]");
				siNo = scan.next();
				if (siNo.equals("N")) {
					scan.close();
					return;
				}
			}
		}

	}

}
