package br.com.taoshu.controller;

import br.com.taoshu.entity.Professor;
import br.com.taoshu.service.IProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avell 1513 on 06/05/2018.
 */
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private IProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        return ResponseEntity.ok(professorService.findAll());
    }

    @PostMapping
    public ResponseEntity<Professor> persist(@RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.persist(professor));
    }

    @PutMapping
    public ResponseEntity<Professor> update(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.update(professor));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("id") Long id){
        professorService.delete(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

    @GetMapping("/api")
    public ResponseEntity teste(){
        return ResponseEntity.ok("API FUNCIONANDO COM SUCESSO!");
    }
}
