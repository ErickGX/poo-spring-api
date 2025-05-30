package br.senac.sp.guiarestaurante.controller;


import br.senac.sp.guiarestaurante.model.Avaliacao;
import br.senac.sp.guiarestaurante.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    public AvaliacaoRepository repository;


    @PostMapping
    public ResponseEntity<Object> criarAvaliacao(@RequestBody Avaliacao avaliacao){
        try {
            repository.save(avaliacao);
            return ResponseEntity.created(URI.create("/avaliacao/"+avaliacao.getId())).body(avaliacao);
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping
    public ResponseEntity<Iterable<Avaliacao>> listarAvaliacoes(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarporId(@PathVariable("id") Long id){
        Optional<Avaliacao> tipo = repository.findById(id);
        if (tipo.isPresent()){
            return ResponseEntity.ok(tipo.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/id")
    public ResponseEntity<Object> alterarAvaliacao(@RequestBody Avaliacao tipo, @PathVariable Long id){
        try {
            repository.save(tipo);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            //forma mais classica  : return new ResponseEntity<Object>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
            return  ResponseEntity.internalServerError().body(e); //forma mais moderna

        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }








}
