package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Marca;

public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
