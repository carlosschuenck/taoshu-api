package br.com.taoshu.resource;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@RestController
@RequestMapping("/aluno")
public class AlunoResource {

    private final AlunoService alunoService;

    public AlunoResource(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> buscarTodos() {
        return ok(alunoService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id)
                           .map(ResponseEntity::ok)
                           .orElseGet(() -> noContent().build());
    }

    @PostMapping
    public ResponseEntity<Aluno> inserir(@RequestBody Aluno aluno) {
        return status(CREATED).body(alunoService.inserir(aluno));
    }

    @PutMapping
    public ResponseEntity<Aluno> atualizar(@RequestBody Aluno aluno) {
        return ok(alunoService.atualizar(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        alunoService.deletar(id);
        return noContent().build();
    }
}
