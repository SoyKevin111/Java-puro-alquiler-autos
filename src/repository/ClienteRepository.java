package repository;

import model.Cliente;

public class ClienteRepository extends AbstractRepository<Cliente> {

	private long nextId = 1;

	@Override
	public Cliente guardar(Cliente entity) {
		entity.setId(nextId++);
		storage.put(entity.getId(), entity);
		return entity;
	}

}
