package ui;

import java.util.Scanner;

public class AutoConsola {

	Scanner sc = new Scanner(System.in);

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

	}

	public void consultarPorFecha() {

	}

}
