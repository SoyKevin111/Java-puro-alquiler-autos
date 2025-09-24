package ui;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Service.AutoService;
import exceptions.AutoNoDisponibleException;
import model.Auto;
import model.autos.Coupe;
import model.autos.Minivan;
import model.autos.Suv;
import utils.GeneralUtils;
import validations.GeneralValidation;

public class AutoConsola {

	Scanner sc;
	AutoService autoService;
	GeneralUtils generalUtils;
	GeneralValidation generalValidation;

	public AutoConsola(Scanner sc, AutoService autoService, GeneralUtils generalUtils,
			GeneralValidation generalValidation) {
		this.sc = sc;
		this.autoService = autoService;
		this.generalUtils = generalUtils;
		this.generalValidation = generalValidation;
	}

	public void registrar() {
		System.out.println("=== REGISTRAR ===");
		System.out.printf("%nTipo [SUV, MINIVAN, COUPE]: ");
		String tipo = sc.nextLine();
		Auto auto = switch (tipo) {
			case "SUV" -> new Suv();
			case "COUPE" -> new Coupe();
			case "MINIVAN" -> new Minivan();
			default -> null;
		};
		if (auto != null) {
			System.out.printf("%nMarca: ");
			auto.setMarca(sc.nextLine());
			System.out.printf("%nModelo: ");
			auto.setModelo(sc.nextLine());
			System.out.printf("%nPrecio por dia: ");
			auto.setPrecioPorDia(generalValidation.validarBigDecimal(sc.nextLine()));
			auto.setDisponible(false);

			try {
				this.autoService.registrarAuto(auto);
			} catch (Exception e) {
				System.out.println("Error al crear el auto: " + e.getMessage());
			}
		}
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
							"Auto ID: %d - %s - %.2f - disponible(%b)%n",
							a.getId(), a.getMarca(), a.getPrecioPorDia(), a.isDisponible()));
		}
	}

	public void consultarPorFecha() {
		while (true) {
			LocalDate dia = this.generalUtils.obtenerCalendario();
			System.out.println("Autos Disponibles: ");
			try {
				this.autoService.obtenerAutosDisponiblesPorFecha(dia).forEach(a -> System.out.printf("%s%n", a.toString()));
				break;
			} catch (AutoNoDisponibleException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
