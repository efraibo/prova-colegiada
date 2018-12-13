package br.com.sourceinformation.prova_colegiada.controller;

import br.com.sourceinformation.prova_colegiada.model.Turma;
import br.com.sourceinformation.prova_colegiada.service.TurmarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "turmas")
public class TurmaController {

    @Autowired
    private TurmarService turmarService;

    @PostMapping
    public ResponseEntity<Turma> save(@RequestBody Turma turma) {
        return new ResponseEntity<>(turmarService.save(turma), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Turma> update(@RequestBody Turma turma) {
        return new ResponseEntity<>(turmarService.update(turma), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Turma> findTurmaById(@PathVariable Long id) {
        return new ResponseEntity<>(turmarService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        turmarService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
