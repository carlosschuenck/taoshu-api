package br.com.taoshu.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.taoshu.entity.Professor;
import br.com.taoshu.service.ProfessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Professor")
@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @ApiOperation(value = "Find all Professors", nickname = "findAll")
    @GetMapping
    public ResponseEntity<List<Professor>> findAll(){
        return ok(professorService.findAll());
    }
    
    @ApiOperation(value = "Find Professors by id", nickname = "findAll")
    @GetMapping("/{id}")
    public ResponseEntity<Professor> findById(@PathVariable("id") Long id){
        return ok(professorService.findById(id));
    }

    @ApiOperation(value = "Persist a Professor", nickname = "persist")
    @PostMapping
    public ResponseEntity<Professor> persist(@RequestBody Professor professor) {
        return status(CREATED).body(professorService.persist(professor));
    }

    @ApiOperation(value = "Update a Professor", nickname = "update")
    @PutMapping
    public ResponseEntity<Professor> update(@RequestBody Professor professor) {
        return ok(professorService.update(professor));
    }

    @ApiOperation(value = "Delete a Professor", nickname = "delete")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        professorService.delete(id);
        return noContent().build();
    }
}
