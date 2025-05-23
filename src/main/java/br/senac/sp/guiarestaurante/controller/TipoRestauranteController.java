package br.senac.sp.guiarestaurante.controller;

import br.senac.sp.guiarestaurante.repository.TipoRestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.senac.sp.guiarestaurante.model.TipoRestaurante;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/tiporestaurante")
public class TipoRestauranteController {

@Autowired
private TipoRestauranteRepository repository;

@PostMapping
public ResponseEntity<Object> criarTipo(@RequestBody TipoRestaurante tipo){
	try {
		//salvar no banco
		repository.save(tipo);
		return ResponseEntity.created(URI.create("/tiporestaurante/"+tipo.getId())).body(tipo);
	}catch (Exception e){
		e.printStackTrace();
		String erro = e.getMessage();
		return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

	@GetMapping
	public ResponseEntity<Iterable<TipoRestaurante>> listartodos() {
		return ResponseEntity.ok(repository.findAll());
	}


	@GetMapping("/{id}")                      //PathVar especifica que vai ser recebida via parametro da requisicao
	public ResponseEntity<TipoRestaurante> buscarporId(@PathVariable("id") Long id){ //tipo do dado do id recebe o Longd df na classe
		Optional<TipoRestaurante>  tipo = repository.findById(id);;
	if (tipo.isPresent()){
		return ResponseEntity.ok(tipo.get());
	}else {
		return ResponseEntity.notFound().build();//build é para montar o objeto not found
		}
	}


	@PutMapping("/{id}")
	public ResponseEntity<Object> alterarTipo(@RequestBody TipoRestaurante tipo, @PathVariable Long id){
		try {
			//salvar no banco
			repository.save(tipo);
			return ResponseEntity.ok().build();
		}catch (Exception e){
			e.printStackTrace();
			String erro = e.getMessage();
			return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		repository.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
