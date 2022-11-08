package br.com.dvtisul.persistencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dvtisul.persistencia.model.Cliente;
import br.com.dvtisul.persistencia.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente incluir(Cliente c) {
		return clienteRepository.save(c);
	}
	
	public List<Cliente> listarTodos() {
		return clienteRepository.findAll();
	}
	
	public Cliente excluir(Integer id) {
		Cliente c = clienteRepository.findById(id).get();
		clienteRepository.delete(c);
		return c;
	}
	
	public Cliente alterar(Cliente c) {
		return clienteRepository.save(c);
	}
}
