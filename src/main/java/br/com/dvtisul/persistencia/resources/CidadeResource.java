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

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

	@Autowired
	CidadeService cidadeService;

	@PostMapping
	public Cidade incluirCidade(@RequestBody Cidade c) {
		return cidadeService.incluir(c);
	}

	@GetMapping
	public List<Cidade> listarTodas() {
		return cidadeService.listarTodas();
	}

	@DeleteMapping("/{id}")
	public Cidade excluirCidade(@PathVariable("id") Integer id) {
		return cidadeService.excluir(id);
	}

	@PutMapping("/{id}")
	public Cidade alterarCidade(@RequestBody Cidade c, @RequestParam("id") Integer id) {
		c.setId(id);
		return cidadeService.alterar(c);
	}
	
	@GetMapping("/buscar-por-uf/{uf}") 
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf) {
		return cidadeService.buscarPorUf(uf);
	}
	
	@GetMapping("/buscar-por-nome/{nome}") 
	public List<Cidade> buscarPorNome(@PathVariable("nome") String nome) {
		return cidadeService.buscarPorNome(nome);
	}
}
