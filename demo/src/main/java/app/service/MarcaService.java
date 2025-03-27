package app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Marca;
import app.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository marcaRepository;
	
	public List<Marca> findAll(){
		return this.marcaRepository.findAll();
	}
	
	public Marca findById(long id) {
		return this.marcaRepository.findById(id).get();
	}
	
	public List<Marca> findByNome(String nome) {
		return this.marcaRepository.findByNomeContainingIgnoreCase(nome);
	}
	
	public String save(Marca marca) {
		this.marcaRepository.save(marca);
		return "Marca salvo com sucesso";
	}
	
	public String update(Marca marca, long id) {
		marca.setId(id);
		this.marcaRepository.save(marca);
		return "Marca atualizado com sucesso";
	}
	
	public String deleteById(long id) {
		this.marcaRepository.deleteById(id);
		return "Marca deletado com sucesso";
	}

}
