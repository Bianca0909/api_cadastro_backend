package br.com.dvtisul.persistencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.dvtisul.persistencia.model.Cidade;
import br.com.dvtisul.persistencia.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository cidadeRepository;
	
	public Cidade incluir(Cidade c) {
		return cidadeRepository.save(c);
	}
	
	public List<Cidade> listarTodas() {
		return cidadeRepository.findAll();
	}
	
	public Cidade excluir(Integer id) {
		Cidade c = cidadeRepository.findById(id).get();
		 cidadeRepository.delete(c);
		 return c;
	}
	public Cidade alterar(Cidade c) {
		return cidadeRepository.save(c);
	}
	
	public List<Cidade> buscarPorUf(String uf) {
		return cidadeRepository.findByUf(uf);
	}
	
	public List<Cidade> buscarPorNome(String nome) {
		return cidadeRepository.findByNome(nome);
	}
}
