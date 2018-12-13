package br.com.sourceinformation.prova_colegiada.controller;

import br.com.sourceinformation.prova_colegiada.model.Curso;
import br.com.sourceinformation.prova_colegiada.service.CursoService;
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
@RequestMapping(value = "cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<Curso> save(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.save(curso), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Curso> update(@RequestBody Curso curso) {
        return new ResponseEntity<>(cursoService.update(curso), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Curso> findCursoById(@PathVariable Long id) {
        return new ResponseEntity<>(cursoService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        cursoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
