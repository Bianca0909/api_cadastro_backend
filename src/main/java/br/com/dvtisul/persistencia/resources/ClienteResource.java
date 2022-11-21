package br.com.dvtisul.persistencia.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dvtisul.persistencia.model.Cidade;
import br.com.dvtisul.persistencia.model.Cliente;
import br.com.dvtisul.persistencia.services.ClienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;

	@PostMapping
	@ApiOperation(value = "Incluir um cliente no banco de dados")
	@ApiResponse(code = 200, message = "Cliente cadastrado")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente incluído com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public Cliente incluirCliente(@RequestBody Cliente c) {
		return clienteService.incluir(c);
	}

	@GetMapping
	@ApiOperation(value = "Listar todos os clientes no banco de dados")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Clientes listados com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public List<Cliente> listarTodos() {
		return clienteService.listarTodos();
	}

	@GetMapping("/buscar-por-cidade/{cidade}")
	@ApiOperation(value = "Listar os clientes cadastrados banco de dados por cidade")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Clientes listados com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public List<Cliente> listarPorCidade(@PathVariable("cidade") Cidade cidade) {
		return clienteService.listarPorCidade(cidade);
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir um cliente no banco de dados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente excluído com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public Cliente excluirCliente(@PathVariable("id") Integer id) {
		return clienteService.excluir(id);
	}

	@PutMapping
	@ApiOperation(value = "Alterar o registro de um cliente no banco de dados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Cliente excluído com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public Cliente alterarCliente(@RequestBody Cliente c, @RequestParam("id") Integer id) {
		c.setId(id);
		return clienteService.alterar(c);
	}

}
