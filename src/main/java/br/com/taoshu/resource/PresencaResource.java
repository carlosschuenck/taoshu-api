package br.com.taoshu.resource;

import br.com.taoshu.entity.Presenca;
import br.com.taoshu.service.PresencaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.ResponseEntity.*;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@RestController
@RequestMapping("/presenca")
public class PresencaResource {

    private final PresencaService presencaService;

    public PresencaResource(PresencaService presencaService) {
        this.presencaService = presencaService;
    }

    @GetMapping
    public ResponseEntity<List<Presenca>> buscarTodos() {
        return ok(presencaService.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Presenca> inserir(@RequestBody Presenca presenca) {
        return status(CREATED).body(presencaService.inserir(presenca));
    }

    @PutMapping
    public ResponseEntity<Presenca> atualizar(@RequestBody Presenca presenca) {
        return ok(presencaService.atualizar(presenca));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@RequestParam("id") Long id) {
        presencaService.deletar(id);
        return noContent().build();
    }
}
