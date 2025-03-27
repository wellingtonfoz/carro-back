package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

	public List<Marca> findByNomeContainingIgnoreCase(String nome);

}
