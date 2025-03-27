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

import app.entity.Acessorio;
import app.entity.Carro;
import app.service.AcessorioService;


@RestController
@RequestMapping("/api/acessorio")
@CrossOrigin("*")
public class AcessorioController {

	@Autowired
	private AcessorioService acessorioService;

	@GetMapping("/findAll")
	public ResponseEntity<List<Acessorio>> findAll(){
		List<Acessorio> lista = this.acessorioService.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Acessorio>> findByNome(@RequestParam("nome") String nome){
		List<Acessorio> lista = this.acessorioService.findByNome(nome);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	

	@GetMapping("/findById/{id}")
	public ResponseEntity<Acessorio> findById(@PathVariable("id") long id){
		Acessorio acessorio = this.acessorioService.findById(id);
		return new ResponseEntity<>(acessorio, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		String mensagem = this.acessorioService.deleteById(id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Acessorio acessorio){
		String mensagem = this.acessorioService.save(acessorio);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Acessorio acessorio, @PathVariable("id") long id){
		String mensagem = this.acessorioService.update(acessorio, id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

}
