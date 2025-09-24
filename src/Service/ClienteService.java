package Service;

import exceptions.ClienteNoEncontradoException;
import model.Cliente;
import repository.ClienteRepository;

public class ClienteService {

	ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente registrarCliente(Cliente cliente) {
		cliente.validar();
		return this.clienteRepository.guardar(cliente);
	}

	public Cliente obtenerClientePorId(long id) {
		return this.clienteRepository.porId(id)
				.orElseThrow(() -> new ClienteNoEncontradoException("Cliente no encontrado con id: " + id));
	}

}
