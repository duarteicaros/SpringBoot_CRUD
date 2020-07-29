package com.escola.escola.controller;

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

import com.escola.escola.model.Turma;
import com.escola.escola.repository.TurmaRepository;

@RestController // fala que é um controlador
@RequestMapping("/turma") // informa a classe que vai ser acessada 
@CrossOrigin("*") // todas outras aplicações podem utilizar o arquivo
public class TurmaController {
	
	// injetar a classe do repositorio dentro do controller
	@Autowired // sendo uma interface, o spring que tem que atuar sobre
	private TurmaRepository repository;
	
	//fazer os metodos 
	
	//metodos para achar todos
	@GetMapping // declarar o tipo do método
	public ResponseEntity<List<Turma>> mostraTudo(){
		return ResponseEntity.ok(repository.findAll());
	}
	// metodo response enti.. vai ser uma lista que vai mostrar o metodo
	// turma + o nome do metodos + (Parametro)
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> mostraUm(@PathVariable long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Turma> postarTurma(@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(turma));
	}
	
	@PutMapping
	public ResponseEntity<Turma> atualizarTurma(@RequestBody Turma turma){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(turma));
	}
	
	@DeleteMapping("/{id}")
	public void delete (@PathVariable long id) {
		repository.deleteById(id);
	}
	

}
