package Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import model.Auto;
import repository.AutoRepository;
import repository.ContratoRepository;

public class AutoService {

	AutoRepository autoRepository;
	ContratoRepository contratoRepository;

	public AutoService(AutoRepository autoRepository, ContratoRepository contratoRepository) {
		this.autoRepository = autoRepository;
		this.contratoRepository = contratoRepository;
	}

	public Auto registrarAuto(Auto auto) {
		return this.autoRepository.guardar(auto);
	}

	public List<Auto> obtenerAutoPorTipo(String tipo) {
		return this.autoRepository.todos()
				.stream()
				.filter(a -> a.getTipo().equalsIgnoreCase(tipo))
				.collect(Collectors.toList());
	}

	public List<Auto> obtenerAutosDisponiblesPorFecha(LocalDate fecha) {
		return this.contratoRepository.todos()
				.stream()
				.filter(c -> !fecha.isBefore(c.getFechaInicio()) && !fecha.isAfter(c.getFechaSalida()))
				.map(c -> c.getAuto())
				.collect(Collectors.toList());
	}

	public Auto obtenerAutoPorId(long id) {
		return this.autoRepository.porId(id).orElseThrow(() -> new RuntimeException("Error, Auto no encontrado."));
	}

	public static void main(String[] args) {
		AutoService s = new AutoService(new AutoRepository(), new ContratoRepository());
		s.obtenerAutoPorTipo("SUV")
				.stream()
				.forEach(a -> System.out.println(a + " tipo: " + a.getTipo()));
		;
	}

}
