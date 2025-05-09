package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.auth.Usuario;
import app.service.UsuarioService;


@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/findAll")
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> lista = this.usuarioService.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable("id") long id){
		Usuario usuario = this.usuarioService.findById(id);
		return new ResponseEntity<>(usuario, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		String mensagem = this.usuarioService.deleteById(id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Usuario usuario){
		String mensagem = this.usuarioService.save(usuario);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Usuario usuario, @PathVariable("id") long id){
		String mensagem = this.usuarioService.update(usuario, id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}
	
	@PutMapping("/alterarSenha/{id}")
	public ResponseEntity<String> alterarSenha(@PathVariable("id") long id, @RequestParam("novaSenha") String novaSenha){
		String mensagem = this.usuarioService.alterarSenha(novaSenha, id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

}
