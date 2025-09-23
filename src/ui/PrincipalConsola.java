package ui;

import java.util.List;
import java.util.Scanner;

public class PrincipalConsola {

	private Scanner sc = new Scanner(System.in);
	private AutoConsola autoConsola;
	private ClienteConsola clienteConsola;
	private ContratoConsola contratoConsola;

	public PrincipalConsola(Scanner sc, AutoConsola autoConsola, ClienteConsola clienteConsola,
			ContratoConsola contratoConsola) {
		this.sc = sc;
		this.autoConsola = autoConsola;
		this.clienteConsola = clienteConsola;
		this.contratoConsola = contratoConsola;
	}

	private void mostrarMenu(String header, List<String> opciones, Runnable... acciones) {
		while (true) {
			System.out.printf("%n==== %s ====%n", header);
			for (int i = 0; i < opciones.size(); i++) {
				System.out.printf("%d. %s%n", i + 1, opciones.get(i));
			}
			System.out.printf("%d. Salir%n", opciones.size() + 1);
			System.out.print("opcion: ");

			int op = sc.nextInt();
			if (op == opciones.size() + 1)
				return;
			if (op >= 1 && op <= acciones.length)
				acciones[op - 1].run();
			else
				System.out.println("Opción inválida.");
		}
	}

	public void iniciar() {
		mostrarMenu("ALQUILER DE AUTOS", List.of("Autos", "Contratos", "Clientes"),
				() -> mostrarMenu("AUTOS", List.of("Registrar", "Consultar"),
						() -> this.autoConsola.registrar(),
						() -> this.autoConsola.consultar()),
				() -> mostrarMenu("CONTRATOS", List.of("Registrar", "Consultar"),
						() -> this.contratoConsola.registrar(),
						() -> this.contratoConsola.consultar()),
				() -> mostrarMenu("CLIENTES", List.of("Registrar", "Consultar"),
						() -> this.clienteConsola.registrar(),
						() -> this.clienteConsola.consultar()));
	}

	public static void main(String[] args) {
		/// new ConsolaAbstracta().iniciar();
	}
}
