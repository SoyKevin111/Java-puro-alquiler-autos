package repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import model.Cliente;

public class ClienteRepository {

	private final Set<Cliente> clientes = new HashSet<>();
	private long nextId = 1;

	public Cliente crear(Cliente cliente) {
		cliente.setId(nextId++);
		clientes.add(cliente);
		return cliente;
	}

	public Set<Cliente> todos() {
		return this.clientes;
	}

	public Optional<Cliente> porId(Long id) {
		return this.clientes.stream()
				.filter(c -> c.getId().equals(id))
				.findFirst();
	}

}
