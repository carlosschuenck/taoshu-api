package br.com.taoshu.controller;

import br.com.taoshu.entity.Presenca;
import br.com.taoshu.service.PresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@RestController
@RequestMapping("/presenca")
public class PresencaController {

    @Autowired
    private PresencaService presencaService;

    @GetMapping
    public ResponseEntity<List<Presenca>> findAll(){
        return ResponseEntity.ok(presencaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Presenca> persist(@RequestBody Presenca presenca){
        return ResponseEntity.status(HttpStatus.CREATED).body(presencaService.persist(presenca));
    }

    @PutMapping
    public ResponseEntity<Presenca> update(@RequestBody Presenca presenca){
        return ResponseEntity.ok(presencaService.update(presenca));
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("id") Long id){
        presencaService.delete(id);
        return ResponseEntity.ok("ok");
    }
}
