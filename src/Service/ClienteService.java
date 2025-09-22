package Service;

import model.Cliente;
import repository.ClienteRepository;

public class ClienteService {

	ClienteRepository clienteRepository;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public Cliente registrarCliente(Cliente cliente) {
		return this.clienteRepository.guardar(cliente);
	}

	public Cliente obtenerClientePorId(long id) {
		return this.clienteRepository.porId(id).orElseThrow(() -> new RuntimeException("Error, cliente no encontrado."));
	}

}
