package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Acessorio;

public interface AcessorioRepository extends JpaRepository<Acessorio, Long> {

	public List<Acessorio> findByNomeContainingIgnoreCase(String nome);

}
