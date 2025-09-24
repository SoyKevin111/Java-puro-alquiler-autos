package repository;

import java.math.BigDecimal;
import java.time.LocalDate;

import model.Auto;
import model.Cliente;
import model.Contrato;
import model.autos.Coupe;
import model.autos.Minivan;
import model.autos.Suv;

public class ContratoRepository extends AbstractRepository<Contrato> {

	private long nextId = 5;

	public ContratoRepository() {

		Auto a1 = new Coupe("auto1", "modelo1", new BigDecimal("23.4"));
		a1.setId(1l);
		Auto a2 = new Minivan("auto2", "modelo2", new BigDecimal("24.4"));
		a2.setId(2l);
		Auto a3 = new Suv("auto3", "modelo3", new BigDecimal("25.4"));
		a3.setId(3l);

		Cliente cl1 = new Cliente("Kevin 1", "Steven");
		cl1.setId(1l);
		Cliente cl2 = new Cliente("Kevin 2", "Steven");
		cl2.setId(2l);
		Cliente cl3 = new Cliente("Kevin 3", "Steven");
		cl3.setId(3l);

		Contrato c1 = new Contrato(cl1, a1, LocalDate.of(2025, 9, 17), LocalDate.of(2025, 9, 19));
		c1.setCantidadDias(2);
		c1.setTotal(new BigDecimal("100.40"));

		Contrato c2 = new Contrato(cl2, a2, LocalDate.of(2025, 9, 19), LocalDate.of(2025, 9, 21));
		c2.setCantidadDias(2);
		c2.setTotal(new BigDecimal("100.40"));

		Contrato c3 = new Contrato(cl3, a3, LocalDate.of(2025, 9, 21), LocalDate.of(2025, 9, 23));
		c3.setCantidadDias(2);
		c3.setTotal(new BigDecimal("100.40"));

		Contrato c4 = new Contrato(cl1, a2, LocalDate.of(2025, 9, 24), LocalDate.of(2025, 9, 26));
		c4.setCantidadDias(2);
		c4.setTotal(new BigDecimal("100.40"));

		storage.put(1L, c1);
		storage.put(2L, c2);
		storage.put(3L, c3);
		storage.put(4L, c4);

	}

	@Override
	public Contrato guardar(Contrato entity) {
		entity.setId(nextId++);
		storage.put(entity.getId(), entity);
		return entity;
	}

}
