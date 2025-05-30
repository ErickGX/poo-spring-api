package br.senac.sp.guiarestaurante.controller;


import br.senac.sp.guiarestaurante.model.Restaurante;
import br.senac.sp.guiarestaurante.model.Usuario;
import br.senac.sp.guiarestaurante.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteRepository repository;


    @PostMapping
    public ResponseEntity<Object> criarUser(@RequestBody Restaurante restaurante){
        try {
            repository.save(restaurante);
            return ResponseEntity.created(URI.create("/restaurante/"+restaurante.getId())).body(restaurante);
        }catch (Exception e){
            e.printStackTrace();
            String erro = e.getMessage();
            return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Restaurante>> listarRestaurante(){
        return ResponseEntity.ok(repository.findAll());
    }


    @GetMapping("/{id}") //PathVar especifica que vai ser recebida via parametro da requisicao
    public ResponseEntity<Restaurante> buscarporId(@PathVariable("id") Long id){ //tipo do dado do id recebe o Longd df na classe
        Optional<Restaurante> tipo = repository.findById(id);;
        if (tipo.isPresent()){
            return ResponseEntity.ok(tipo.get());
        }else {
            return ResponseEntity.notFound().build();//build é para montar o objeto not found
        }
    }


    @PutMapping("/{id}")
    public ResponseEntity<Object> alterarTipo(@RequestBody Restaurante tipo, @PathVariable Long id){
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
