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

import app.entity.Carro;
import app.service.CarroService;


@RestController
@RequestMapping("/api/carro")
@CrossOrigin("*")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll(){
		List<Carro> lista = this.carroService.findAll();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/findByNome/{id}")
	public ResponseEntity<List<Carro>> findByNome(@RequestParam("nome") String nome){
		List<Carro> lista = this.carroService.findByNome(nome);
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Carro> findById(@PathVariable("id") long id){
		Carro carro = this.carroService.findById(id);
		return new ResponseEntity<>(carro, HttpStatus.OK);
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") long id){
		String mensagem = this.carroService.deleteById(id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro){
		String mensagem = this.carroService.save(carro);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable("id") long id){
		String mensagem = this.carroService.update(carro, id);
		return new ResponseEntity<>(mensagem, HttpStatus.OK);
	}

}
