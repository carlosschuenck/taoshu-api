package br.com.taoshu.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.taoshu.entity.Turma;
import br.com.taoshu.service.TurmaService;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        return ResponseEntity.ok(turmaService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id){
        return ResponseEntity.ok(turmaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Turma> persist(@RequestBody Turma turma){
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.persist(turma));
    }

    @PutMapping
    public ResponseEntity<Turma> update(@RequestBody Turma turma){
        return ResponseEntity.ok(turmaService.update(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        turmaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
