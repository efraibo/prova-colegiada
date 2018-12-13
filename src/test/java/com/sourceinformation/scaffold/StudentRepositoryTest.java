package com.sourceinformation.scaffold;

import br.com.sourceinformation.prova_colegiada.model.Student;
import br.com.sourceinformation.prova_colegiada.model.Student.StudentBuilder;
import br.com.sourceinformation.prova_colegiada.repository.StudentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    private StudentBuilder builder;

    public StudentRepositoryTest() {
        builder = Student.builder();
    }

    @Test
    public void createTest() {
        builder.name("Evandro Nascimento");
        Student student = this.studentRepository.save(builder.build());
        assertThat(student.getId()).isNotNull();//Assertions.assertThat
        assertThat(student.getName()).isEqualTo("Evandro Nascimento");
    }

    @Test
    public void deleteTest() {
        builder.name("Evandro Nascimento");
        Student student = this.studentRepository.save(builder.build());
        this.studentRepository.delete(student);
        assertThat(studentRepository.findById(student.getId()).orElse(null)).isNull();
    }

    @Test
    public void updateTest() {
        builder.name("Evandro Nascimento");
        Student student = this.studentRepository.save(builder.build());
        student.setName("Evandro");
        this.studentRepository.save(student);
        Student studentUpdate = this.studentRepository.findById(student.getId()).orElse(null);
        assertThat(studentUpdate.getName()).isEqualTo("Evandro");
    }

}
