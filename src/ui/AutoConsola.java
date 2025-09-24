package ui;

import java.util.List;
import java.util.Scanner;

import Service.AutoService;
import utils.GeneralUtils;

public class AutoConsola {

	Scanner sc;
	AutoService autoService;
	GeneralUtils generalUtils;

	public AutoConsola(Scanner sc, AutoService autoService, GeneralUtils generalUtils) {
		this.sc = sc;
		this.autoService = autoService;
		this.generalUtils = generalUtils;
	}

	public void registrar() {

	}

	public void consultar() {
		while (true) {
			System.out.printf("%n=== Consultar ===%n1. Todos%n2. Por fecha%n3. Salir%nopcion: ");
			int opcion = sc.nextInt();
			sc.nextLine();
			switch (opcion) {
				case 1 -> consultarTodos();
				case 2 -> consultarPorFecha();
				case 3 -> {
					return;
				}
			}
		}
	}

	public void consultarTodos() {

		List<String> tipos = List.of("SUV", "COUPE", "MINIVAN");
		System.out.println("=== TODOS ===");
		for (String tipo : tipos) {
			System.out.println("Tipo: " + tipo);
			this.autoService.obtenerAutoPorTipo(tipo)
					.forEach(a -> System.out.printf(
							"Auto #%d - %s - %.2f - disponible(%b)%n",
							a.getId(), a.getMarca(), a.getPrecioPorDia(), a.isDisponible()));
		}
	}

	public void consultarPorFecha() {
		this.generalUtils.obtenerCalendario();
	}

}
