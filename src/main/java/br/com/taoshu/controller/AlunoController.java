package br.com.taoshu.controller;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping
    public ResponseEntity<Aluno> persist(@RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.persist(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> update(@RequestBody Aluno aluno){
        return ResponseEntity.ok(alunoService.update(aluno));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("id") Long id){
        alunoService.delete(id);
        return ResponseEntity.ok("OK");
    }
}
