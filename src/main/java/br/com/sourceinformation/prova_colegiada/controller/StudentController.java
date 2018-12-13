package br.com.sourceinformation.prova_colegiada.controller;

import br.com.sourceinformation.prova_colegiada.model.Student;
import br.com.sourceinformation.prova_colegiada.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> save(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.save(student), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Student> update(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.update(student), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(studentService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
