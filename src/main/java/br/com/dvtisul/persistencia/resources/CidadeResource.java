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
import br.com.dvtisul.persistencia.services.CidadeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	CidadeService cidadeService;

	@PostMapping
	@ApiOperation(value = "Incluir uma cidade no banco de dados")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Cidade incluído com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"), @ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"), })
	public Cidade incluirCidade(@RequestBody Cidade c) {
		return cidadeService.incluir(c);
	}

	@GetMapping
	@ApiOperation(value = "Lista todas as cidades do banco de dados")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Clientes listados com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public List<Cidade> listarTodas() {
		return cidadeService.listarTodas();
	}

	@DeleteMapping("/{id}")
	@ApiOperation(value = "Excluir uma cidade do banco de dados")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Cliente excluído com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public Cidade excluirCidade(@PathVariable("id") Integer id) {
		return cidadeService.excluir(id);
	}

	@PutMapping
	@ApiOperation(value = "Alterar registro de uma cidade do banco de dados")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Cliente alterado com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public Cidade alterarCidade(@RequestBody Cidade c, @RequestParam("id") Integer id) {
		c.setId(id);
		return cidadeService.alterar(c);
	}

	@GetMapping("/buscar-por-uf/{uf}")
	@ApiOperation(value = "Filtrar cidades cadastradas no banco de dados por unidade federal")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Clientes listados com sucesso"),
			@ApiResponse(code = 400, message = "Erro na requisição"),
			@ApiResponse(code = 401, message = "Método de requisição não autorizado"),
			@ApiResponse(code = 403, message = "Erro de acesso"),
			@ApiResponse(code = 404, message = "Não encontrado"),
			@ApiResponse(code = 500, message = "Erro na API"),
			})
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf) {
		return cidadeService.buscarPorUf(uf);
	}

}
