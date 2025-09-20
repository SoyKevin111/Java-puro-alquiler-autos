package ui;

import java.util.Scanner;

public class ConsolaPrincipal {

	Scanner sc = new Scanner(System.in);
	AutoConsola autoConsola;
	ContratoConsola contratoConsola;
	ClienteConsola clienteConsola;

	public ConsolaPrincipal(AutoConsola autoConsola, ContratoConsola contratoConsola, ClienteConsola clienteConsola) {
		this.autoConsola = autoConsola;
		this.contratoConsola = contratoConsola;
		this.clienteConsola = clienteConsola;
	}

	public void principal() {

		while (true) {
			System.out.printf("=== ALQUILER DE AUTOS ===%n1. Autos%n2. Contratos%n3. Clientes%n4. Salir%nopcion: ");
			int opcion = sc.nextInt();

			switch (opcion) {
				case 1 -> detalleSeleccion(opcion);
				case 2 -> detalleSeleccion(opcion);
				case 3 -> detalleSeleccion(opcion);
				case 4 -> {
					return;
				}
			}
		}

	}

	public void detalleSeleccion(int seleccion) {
		while (true) {
			switch (seleccion) {
				case 1 -> System.out.println("=== Autos ===");
				case 2 -> System.out.println("=== Contratos ===");
				case 3 -> System.out.println("=== Clientes ===");
			}
			System.out.printf("%n1. Registro%n2. Consulta%n3. Salir%nopcion: ");
			int opcion = sc.nextInt();
			sc.nextLine();
			switch (seleccion) {
				case 1 -> {
					switch (opcion) {
						case 1 -> autoConsola.registrar();
						case 2 -> autoConsola.consultar();
						case 3 -> {
							return;
						}
					}
				}
				case 2 -> {
					switch (opcion) {
						case 1 -> contratoConsola.registrar();
						case 2 -> contratoConsola.consultar();
						case 3 -> {
							return;
						}
					}
				}
				case 3 -> {
					switch (opcion) {
						case 1 -> clienteConsola.registrar();
						case 2 -> clienteConsola.consultar();
						case 3 -> {
							return;
						}
					}
				}

			}
		}
	}

	public static void main(String[] args) {
		ConsolaPrincipal c = new ConsolaPrincipal(new AutoConsola(), new ContratoConsola(), new ClienteConsola());
		c.principal();
	}

}
