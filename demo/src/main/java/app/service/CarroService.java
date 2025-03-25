package app.service;

import java.util.List;

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
		return this.carroRepository.findById(id).get();
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
