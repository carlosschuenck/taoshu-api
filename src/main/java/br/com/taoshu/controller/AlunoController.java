package br.com.taoshu.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.service.AlunoService;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll(){
        return ResponseEntity.ok(alunoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<Aluno> persist(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.persist(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> update(@RequestBody Aluno aluno){
        return ResponseEntity.ok(alunoService.update(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(alunoService.delete(id));
    }
}
