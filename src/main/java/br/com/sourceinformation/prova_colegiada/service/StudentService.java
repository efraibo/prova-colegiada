package br.com.sourceinformation.prova_colegiada.service;

import br.com.sourceinformation.prova_colegiada.exception.ObjectNotFoundException;
import br.com.sourceinformation.prova_colegiada.model.Student;
import br.com.sourceinformation.prova_colegiada.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        verifyIfStudentExist(student.getId());
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        verifyIfStudentExist(id);
        studentRepository.deleteById(id);
    }

    public Student findById(Long id) {
        verifyIfStudentExist(id);
        return studentRepository.findById(id).get();
    }

    private void verifyIfStudentExist(Long id) {
        Optional<Student> obj = studentRepository.findById(id);
        obj.orElseThrow(() -> new ObjectNotFoundException("Student not found for ID :" + id + ", type: " + Student.class.getName()));
    }
}
