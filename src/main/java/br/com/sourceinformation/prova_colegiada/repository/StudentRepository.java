package br.com.sourceinformation.prova_colegiada.repository;

import br.com.sourceinformation.prova_colegiada.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
