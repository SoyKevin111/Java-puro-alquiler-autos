package repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import model.Auto;
import model.Contrato;
import model.autos.Coupe;
import model.autos.Minivan;
import model.autos.Suv;

public class ContratoRepository {

	private final Set<Contrato> contratos = new HashSet<>();
	private long nextId = 1;

	public ContratoRepository() {

		Auto a1 = new Coupe("auto1", "modelo1", new BigDecimal("23.4"));
		a1.setId(1l);
		Auto a2 = new Minivan("auto2", "modelo2", new BigDecimal("24.4"));
		a2.setId(2l);
		Auto a3 = new Suv("auto3", "modelo3", new BigDecimal("25.4"));
		a3.setId(3l);

		Contrato c1 = new Contrato(null, a1, LocalDate.of(2025, 9, 17), LocalDate.of(2025, 9, 19));
		c1.setCantidadDias(2);
		c1.setTotal(new BigDecimal("100.40"));

		Contrato c2 = new Contrato(null, a2, LocalDate.of(2025, 9, 19), LocalDate.of(2025, 9, 21));
		c1.setCantidadDias(2);
		c1.setTotal(new BigDecimal("100.40"));

		Contrato c3 = new Contrato(null, a3, LocalDate.of(2025, 9, 21), LocalDate.of(2025, 9, 23));
		c1.setCantidadDias(2);
		c1.setTotal(new BigDecimal("100.40"));

		Contrato c4 = new Contrato(null, a2, LocalDate.of(2025, 9, 24), LocalDate.of(2025, 9, 26));
		c1.setCantidadDias(2);
		c1.setTotal(new BigDecimal("100.40"));

		contratos.add(c1);
		contratos.add(c2);
		contratos.add(c3);
		contratos.add(c4);

	}

	public Contrato crear(Contrato contrato) {
		contrato.setId(nextId++);
		contratos.add(contrato);
		return contrato;
	}

	public Set<Contrato> todos() {
		return this.contratos;
	}

	public Optional<Contrato> porId(Long id) {
		return this.contratos.stream()
				.filter(a -> a.getId().equals(id))
				.findFirst();
	}

}
