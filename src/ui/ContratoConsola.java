package ui;

import java.time.LocalDate;
import java.util.Scanner;

import Service.ClienteService;
import Service.ContratoService;
import exceptions.AutoNoDisponibleException;
import exceptions.ClienteNoEncontradoException;
import model.Auto;
import model.Cliente;
import model.Contrato;
import utils.GeneralUtils;
import validations.GeneralValidation;

public class ContratoConsola {

	Scanner sc;
	GeneralUtils generalUtils;
	ContratoService contratoService;
	ClienteService clienteService;
	GeneralValidation generalValidation;

	public ContratoConsola(Scanner sc, GeneralUtils generalUtils, ContratoService contratoService,
			ClienteService clienteService, GeneralValidation generalValidation) {
		this.sc = sc;
		this.generalUtils = generalUtils;
		this.contratoService = contratoService;
		this.clienteService = clienteService;
		this.generalValidation = generalValidation;
	}

	public void registrar() {
		System.out.println("=== REGISTRAR 1===");
		this.generalUtils.mostrarCalendario();

		System.out.println("ID del Auto: ");
		int autoId = this.generalValidation.validarInt(sc.nextLine());
		System.out.printf("Fecha de inicio: ");
		LocalDate fechaInicio = this.generalUtils.obtenerFecha();
		System.out.printf("Fecha de vencimiento: ");
		LocalDate fechaSalida = this.generalUtils.obtenerFecha();

		System.out.println("ID del cliente: ");
		long clienteId = this.generalValidation.validarLong(sc.nextLine());

		try {
			Auto autoObtenido = this.contratoService.validarAutoDisponible(autoId, fechaInicio, fechaSalida);
			autoObtenido.setDisponible(false);
			Cliente clienteObtenido = this.clienteService.obtenerClientePorId(clienteId);
			this.contratoService.registrarContrato(new Contrato(clienteObtenido, autoObtenido, fechaInicio, fechaSalida));
			System.out.println("CONTRATO REGISTRADO CON EXITO.");
		} catch (AutoNoDisponibleException | ClienteNoEncontradoException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void consultar() {
		System.out.println("=== TODOS ===");
		System.out.println("Contratos: ");
		this.contratoService.obtenerContratos()
				.stream()
				.forEach(c -> System.out.printf("- %s ; dias = %d ;  total gastado = %f%n", c.getCliente().getNombre(),
						c.getCantidadDias(), c.getTotal()));
		;
	}

}
