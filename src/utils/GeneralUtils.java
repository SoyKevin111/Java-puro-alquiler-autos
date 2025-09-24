package utils;

import java.time.LocalDate;
import java.util.Scanner;

import validations.GeneralValidation;

public class GeneralUtils {

	Scanner sc;
	GeneralValidation generalValidation;

	public GeneralUtils(Scanner sc, GeneralValidation generalValidation) {
		this.sc = sc;
		this.generalValidation = generalValidation;
	}

	public LocalDate obtenerCalendario() {
		LocalDate hoy = LocalDate.now();
		int ultimoDia = hoy.lengthOfMonth();

		System.out.println(hoy.getMonth().toString());
		for (int i = hoy.getDayOfMonth(); i <= ultimoDia; i++) {
			System.out.printf("%d ", i);
		}
		System.out.println();
		while (true) {
			System.out.println("Seleccione un dia: ");
			int dia = this.generalValidation.validarInt(sc.nextLine());
			if (dia >= hoy.getDayOfMonth() && dia <= ultimoDia) {
				return hoy.withDayOfMonth(dia);
			}
			System.out.printf("Rango disponible [%d - %d]%n", hoy.getDayOfMonth(), ultimoDia);
		}

	}

	public static void main(String[] args) {
		GeneralUtils gu = new GeneralUtils(new Scanner(System.in), new GeneralValidation());
		gu.obtenerCalendario();
	}
}
