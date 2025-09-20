package repository;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import model.Auto;
import model.autos.Coupe;
import model.autos.Minivan;
import model.autos.Suv;

public class AutoRepository {

	private final Set<Auto> autos = new HashSet<>();
	private long nextId = 1;

	public AutoRepository() {

		Auto a1 = new Coupe("auto1", "modelo1", new BigDecimal("23.4"));
		a1.setId(1l);
		Auto a2 = new Minivan("auto2", "modelo2", new BigDecimal("24.4"));
		a2.setId(2l);
		Auto a3 = new Suv("auto3", "modelo3", new BigDecimal("25.4"));
		a3.setId(3l);

		this.autos.add(a1);
		this.autos.add(a2);
		this.autos.add(a3);

	}

	public Auto crear(Auto auto) {
		auto.setId(nextId++);
		autos.add(auto);
		return auto;
	}

	public Set<Auto> todos() {
		return this.autos;
	}

	public Optional<Auto> porId(Long id) {
		return this.autos.stream()
				.filter(a -> a.getId().equals(id))
				.findFirst();
	}

}
