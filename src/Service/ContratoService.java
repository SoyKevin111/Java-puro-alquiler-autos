package Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.AutoNoDisponibleException;
import exceptions.ContratosNoEncontradosException;
import model.Contrato;
import repository.AutoRepository;
import repository.ContratoRepository;

public class ContratoService {

	AutoRepository autoRepository;
	ContratoRepository contratoRepository;

	public ContratoService(AutoRepository autoRepository, ContratoRepository contratoRepository) {
		this.autoRepository = autoRepository;
		this.contratoRepository = contratoRepository;
	}

	public Contrato registrarContrato(Contrato contrato) {
		contrato.validar();
		return this.contratoRepository.guardar(contrato);
	}

	public void validarAutoDisponible(long id, LocalDate fInicio, LocalDate fFinal) {
		boolean disponible = this.contratoRepository.todos()
				.stream()
				.filter(c -> c.getAuto().getId().equals(id))
				.anyMatch(c -> fInicio.isBefore(c.getFechaSalida()) && fFinal.isAfter(c.getFechaInicio()))
						? false // no disponible
						: true; // disponible
		if (!disponible) {
			new AutoNoDisponibleException("Auto no disponible para la fecha.");
		}
		System.out.println("Disponible!");
	}

	public List<Contrato> obtenerContratos() {
		List<Contrato> contratos = this.contratoRepository.todos()
				.stream()
				.collect(Collectors.toList()); // set to list

		contratos.forEach(System.out::println);
		if (contratos.isEmpty())
			new ContratosNoEncontradosException("Contratos no encontrados");
		return contratos;
	}

	public static void main(String[] args) {
		ContratoService cs = new ContratoService(new AutoRepository(), new ContratoRepository());
		cs.validarAutoDisponible(
				2l,
				LocalDate.of(2025, 9, 25),
				LocalDate.of(2025, 9, 29));
	}

}
