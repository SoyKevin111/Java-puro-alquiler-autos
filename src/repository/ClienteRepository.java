package repository;

import model.Cliente;

public class ClienteRepository extends AbstractRepository<Cliente> {

	private long nextId = 4;

	public ClienteRepository() {
		Cliente c1 = new Cliente("Kevin 1", "Steven");
		c1.setId(1l);
		Cliente c2 = new Cliente("Kevin 2", "Steven");
		c2.setId(2l);
		Cliente c3 = new Cliente("Kevin 3", "Steven");
		c3.setId(3l);

		storage.put(c1.getId(), c1);
		storage.put(c2.getId(), c2);
		storage.put(c3.getId(), c3);
	}

	@Override
	public Cliente guardar(Cliente entity) {
		entity.setId(nextId++);
		storage.put(entity.getId(), entity);
		return entity;
	}

}
