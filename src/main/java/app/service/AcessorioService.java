package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Acessorio;
import app.entity.Carro;
import app.repository.AcessorioRepository;

@Service
public class AcessorioService {
	
	@Autowired
	private AcessorioRepository acessorioRepository;
	
	public List<Acessorio> findAll(){
		return this.acessorioRepository.findAll();
	}
	
	public Acessorio findById(long id) {
		return this.acessorioRepository.findById(id).get();
	}
	
	public List<Acessorio> findByNome(String nome) {
		return this.acessorioRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public String save(Acessorio acessorio) {
		this.acessorioRepository.save(acessorio);
		return "Acessorio salvo com sucesso";
	}
	
	public String update(Acessorio acessorio, long id) {
		acessorio.setId(id);
		this.acessorioRepository.save(acessorio);
		return "Acessorio atualizado com sucesso";
	}
	
	public String deleteById(long id) {
		this.acessorioRepository.deleteById(id);
		return "Acessorio deletado com sucesso";
	}

}
