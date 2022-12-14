package br.com.dvtisul.persistencia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.dvtisul.persistencia.model.Cidade;
import br.com.dvtisul.persistencia.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Override
	public Optional<Cliente> findById(Integer id);
	
	public List<Cliente> findByCidade(Cidade cidade);
}
