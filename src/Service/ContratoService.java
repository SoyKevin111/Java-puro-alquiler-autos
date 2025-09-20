package Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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
		return this.contratoRepository.crear(contrato);
	}

	public boolean validarAutoDisponible(long id, LocalDate fInicio, LocalDate fFinal) {
		return this.contratoRepository.todos()
				.stream()
				.filter(c -> c.getAuto().getId().equals(id))
				.anyMatch(c -> fInicio.isBefore(c.getFechaSalida()) && fFinal.isAfter(c.getFechaInicio()))
						? false // no disponible
						: true; // disponible
	}

	public List<Contrato> obtenerContratos() {
		List<Contrato> contratos = this.contratoRepository.todos()
				.stream()
				.collect(Collectors.toList());

		contratos.forEach(System.out::println);
		return contratos;
	}

	public static void main(String[] args) {
		ContratoService cs = new ContratoService(new AutoRepository(), new ContratoRepository());
		System.out.println(cs.validarAutoDisponible(
				2l,
				LocalDate.of(2025, 9, 25),
				LocalDate.of(2025, 9, 29)));
	}

}
