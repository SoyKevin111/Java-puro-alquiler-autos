package repository;

import java.math.BigDecimal;

import model.Auto;
import model.autos.Coupe;
import model.autos.Minivan;
import model.autos.Suv;

public class AutoRepository extends AbstractRepository<Auto> {

	private long nextId = 4;

	public AutoRepository() {

		Auto a1 = new Coupe("auto1", "modelo1", new BigDecimal("23.4"));
		a1.setId(1l);
		Auto a2 = new Minivan("auto2", "modelo2", new BigDecimal("24.4"));
		a2.setId(2l);
		Auto a3 = new Suv("auto3", "modelo3", new BigDecimal("25.4"));
		a3.setId(3l);

		storage.put(1l, a1);
		storage.put(2l, a2);
		storage.put(3l, a3);

	}

	@Override
	public Auto guardar(Auto entity) {
		entity.setId(nextId++);
		storage.put(entity.getId(), entity);
		return entity;
	}

}
