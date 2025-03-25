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
		try {
			List<Carro> lista = this.carroService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Carro> findById(@PathVariable long id){
		try {
			Carro carro = this.carroService.findById(id);
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable long id){
		try {
			String mensagem = this.carroService.deleteById(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro){
		try {
			String mensagem = this.carroService.save(carro);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> save(@RequestBody Carro carro, @PathVariable long id){
		try {
			String mensagem = this.carroService.update(carro, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null,HttpStatus.BAD_REQUEST);
		}
	}

}
