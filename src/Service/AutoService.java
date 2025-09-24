package Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import exceptions.AutoNoEncontradoException;
import exceptions.AutoNoDisponibleException;
import exceptions.TipoAutoNoEncontradoException;
import model.Auto;
import model.Contrato;
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
		auto.validar();
		return this.autoRepository.guardar(auto);
	}

	public List<Auto> obtenerAutoPorTipo(String tipo) {
		List<Auto> autos = this.autoRepository.todos()
				.stream()
				.filter(a -> a.getTipo().equalsIgnoreCase(tipo))
				.collect(Collectors.toList());

		if (autos.isEmpty()) {
			throw new TipoAutoNoEncontradoException("No se encontraron autos del tipo: " + tipo);
		}

		return autos;
	}

	public List<Auto> obtenerAutosDisponiblesPorFecha(LocalDate fecha) {
		List<Auto> autos = this.contratoRepository.todos()
				.stream()
				.filter(c -> !fecha.isBefore(c.getFechaInicio()) && !fecha.isAfter(c.getFechaSalida()))
				.map(Contrato::getAuto)
				.collect(Collectors.toList());

		if (autos.isEmpty()) {
			throw new AutoNoDisponibleException("No hay autos disponibles para la fecha: " + fecha);
		}

		return autos;
	}

	public Auto obtenerAutoPorId(long id) {
		return this.autoRepository.porId(id)
				.orElseThrow(() -> new AutoNoEncontradoException("Auto no encontrado con id: " + id));
	}

	public static void main(String[] args) {
		AutoService s = new AutoService(new AutoRepository(), new ContratoRepository());
		s.obtenerAutoPorTipo("SUV")
				.stream()
				.forEach(a -> System.out.println(a + " tipo: " + a.getTipo()));
		;
	}

}
