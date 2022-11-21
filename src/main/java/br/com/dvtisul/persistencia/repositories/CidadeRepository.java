package br.com.dvtisul.persistencia.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dvtisul.persistencia.model.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer>{
		
	public List<Cidade> findByUf(String uf);
}
