package br.com.taoshu.resource;

import br.com.taoshu.entity.Professor;
import br.com.taoshu.service.ProfessorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

@Api(value = "Professor")
@RestController
@RequestMapping("/professor")
public class ProfessorResource {

    private final ProfessorService professorService;

    public ProfessorResource(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @ApiOperation(value = "Buscar todos professores", nickname = "buscarTodos")
    @GetMapping
    public ResponseEntity<List<Professor>> buscarTodos() {
        return ok(professorService.buscarTodos());
    }

    @ApiOperation(value = "Buscar professor por id", nickname = "buscarPorId")
    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable("id") Long id) {
        return ok(professorService.buscarPorId(id));
    }

    @ApiOperation(value = "Inserir um professor", nickname = "inserir")
    @PostMapping
    public ResponseEntity<Professor> inserir(@RequestBody Professor professor) {
        return status(CREATED).body(professorService.inserir(professor));
    }

    @ApiOperation(value = "Atualizar um professor", nickname = "atualizar")
    @PutMapping
    public ResponseEntity<Professor> atualizar(@RequestBody Professor professor) {
        return ok(professorService.atualizar(professor));
    }

    @ApiOperation(value = "Deletar um professor", nickname = "deletar")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
        professorService.deletar(id);
        return noContent().build();
    }
}
