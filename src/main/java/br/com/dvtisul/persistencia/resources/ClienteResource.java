package br.com.dvtisul.persistencia.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dvtisul.persistencia.model.Cliente;
import br.com.dvtisul.persistencia.services.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;

	@PostMapping
	public Cliente incluirCliente(@RequestBody Cliente c) {
		return clienteService.incluir(c);
	}

	@GetMapping
	public List<Cliente> listarTodos() {
		return clienteService.listarTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<Cliente> listarPorId(@PathVariable("id") Integer id) {
		return clienteService.listarPorId(id);
	}

	@DeleteMapping("/{id}")
	public Cliente excluirCliente(@PathVariable("id") Integer id) {
		return clienteService.excluir(id);
	}
	
	@PutMapping
	public Cliente alterarCliente(@RequestBody Cliente c, @RequestParam("id") Integer id) {
		c.setId(id);
		return clienteService.alterar(c);
	}

}
