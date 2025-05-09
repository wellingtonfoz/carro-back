package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import app.auth.Usuario;
import jakarta.transaction.Transactional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Modifying
	@Transactional
	@Query("UPDATE Usuario u SET u.password = :novaSenha WHERE id = :id")
	public void alterarSenha(String novaSenha, long id);

}
