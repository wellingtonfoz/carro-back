package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.entity.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
