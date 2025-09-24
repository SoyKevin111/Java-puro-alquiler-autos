package ui;

import java.util.Scanner;

import Service.ClienteService;
import model.Cliente;

public class ClienteConsola {

	Scanner sc;
	ClienteService clienteService;

	public ClienteConsola(Scanner sc, ClienteService clienteService) {
		this.sc = sc;
		this.clienteService = clienteService;
	}

	public void registrar() {
		System.out.println("=== REGISTRAR ===");
		System.out.println("Ingrese un nombre: ");
		String nombre = this.sc.nextLine();
		System.out.println("Ingrese un apellido: ");
		String apellido = this.sc.nextLine();

		try {
			this.clienteService.registrarCliente(new Cliente(nombre, apellido));
			System.out.println("CLIENTE REGISTRADO CON EXITO.");
		} catch (Exception e) {
			System.out.println("error" + e.getMessage());
		}

	}

	public void consultar() {
		System.out.println("=== REGISTRAR ===");
		this.clienteService.obtenerTodos()
				.stream()
				.forEach(c -> System.out.printf("- ID = %d ; Nombre = %s ; Apellido = %s%n", c.getId(), c.getNombre(),
						c.getApellido()));
	}

}
