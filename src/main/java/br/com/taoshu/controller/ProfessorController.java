package br.com.taoshu.controller;

import br.com.taoshu.entity.Professor;
import br.com.taoshu.service.ProfessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Avell 1513 on 06/05/2018.
 */

@Api(value = "Professor")
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @ApiOperation(value = "Find all Professors", nickname = "findAll")
    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        return ResponseEntity.ok(professorService.findAll());
    }

    @ApiOperation(value = "Persist a Professor", nickname = "persist")
    @PostMapping
    public ResponseEntity<Professor> persist(@RequestBody Professor professor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(professorService.persist(professor));
    }

    @ApiOperation(value = "Update a Professor", nickname = "update")
    @PutMapping
    public ResponseEntity<Professor> update(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.update(professor));
    }

    @ApiOperation(value = "Delete a Professor", nickname = "delete")
    @DeleteMapping
    public ResponseEntity delete(@RequestParam("id") Long id){
        professorService.delete(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
