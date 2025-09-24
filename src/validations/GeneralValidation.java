package validations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GeneralValidation {

	private Scanner sc = new Scanner(System.in);

	public int validarInt(String valor) {
		while (true) {
			try {
				return Integer.parseInt(valor);
			} catch (NumberFormatException e) {
				System.out.print("Error, ingrese un número entero: ");
				valor = sc.nextLine().trim();
			}
		}
	}

	public double validarDouble(String valor) {
		while (true) {
			try {
				return Double.parseDouble(valor);
			} catch (NumberFormatException e) {
				System.out.println("Error: ingrese un numero decimal: ");
				valor = sc.nextLine().trim();
			}
		}
	}

	public LocalDate validarLocalDate(String valor) {
		while (true) {
			System.out.println("yyyy-MM-dd): ");
			try {
				return LocalDate.parse(valor, DateTimeFormatter.ISO_LOCAL_DATE);
			} catch (DateTimeParseException e) {
				System.out.println("Error (yyyy-MM-dd): ingrese una fecha: ");
				valor = sc.nextLine().trim();
			}
		}
	}
}
