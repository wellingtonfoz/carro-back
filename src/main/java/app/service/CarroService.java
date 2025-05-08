package app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Carro;
import app.repository.CarroRepository;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository carroRepository;
	
	public List<Carro> findAll(){
		return this.carroRepository.findAll();
	}
	
	public Carro findById(long id) {
		Optional<Carro> carro = this.carroRepository.findById(id);
		if(carro.isPresent())
			return carro.get();
		else
			return null;
	}
	
	public List<Carro> findByNome(String nome) {
		return this.carroRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public String save(Carro carro) {
		this.carroRepository.save(carro);
		return "Carro salvo com sucesso";
	}
	
	public String update(Carro carro, long id) {
		carro.setId(id);
		this.carroRepository.save(carro);
		return "Carro atualizado com sucesso";
	}
	
	public String deleteById(long id) {
		this.carroRepository.deleteById(id);
		return "Carro deletado com sucesso";
	}

}
