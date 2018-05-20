package br.com.taoshu.controller;

import br.com.taoshu.entity.Turma;
import br.com.taoshu.service.ITurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private ITurmaService turmaService;

    @GetMapping
    public ResponseEntity<List<Turma>> findAll(){
        return ResponseEntity.ok(turmaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Turma> persist(@RequestBody Turma turma){
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.persist(turma));
    }

    @PutMapping
    public ResponseEntity<Turma> update(@RequestBody Turma turma){
        return ResponseEntity.ok(turmaService.update(turma));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("id") Integer id){
        turmaService.delete(id);
        return ResponseEntity.ok("OK");
    }
}
