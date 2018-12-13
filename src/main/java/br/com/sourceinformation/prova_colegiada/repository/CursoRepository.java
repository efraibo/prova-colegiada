package br.com.sourceinformation.prova_colegiada.repository;

import br.com.sourceinformation.prova_colegiada.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Long> {
}
