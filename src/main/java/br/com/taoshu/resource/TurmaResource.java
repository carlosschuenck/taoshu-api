package br.com.taoshu.resource;

import br.com.taoshu.entity.Turma;
import br.com.taoshu.service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@RestController
@RequestMapping("/turma")
public class TurmaResource {

    private final TurmaService turmaService;

    public TurmaResource(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping
    public ResponseEntity<List<Turma>> buscarTodos() {
        return ResponseEntity.ok(turmaService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(turmaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Turma> inserir(@RequestBody Turma turma) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.inserir(turma));
    }

    @PutMapping
    public ResponseEntity<Turma> atualizar(@RequestBody Turma turma) {
        return ResponseEntity.ok(turmaService.atualizar(turma));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        turmaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
