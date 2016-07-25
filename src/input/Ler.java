package input;

import java.util.Scanner;

public class Ler {
	private static Scanner scanner = new Scanner(System.in);

	public static float lerFloat() {
		while (!scanner.hasNextFloat()) {
			System.err.print("Digite um float!");
			scanner.next();
		}

		return scanner.nextFloat();
	}
	
	public static int lerInt() {
		while (!scanner.hasNextInt()) {
			System.err.print("Digite um número inteiro válido!");
			scanner.next();
		}

		return scanner.nextInt();
	}

	public static String linha() {
		return scanner.next();
	}
}
