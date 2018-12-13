package br.com.sourceinformation.prova_colegiada.service;

import br.com.sourceinformation.prova_colegiada.exception.ObjectNotFoundException;
import br.com.sourceinformation.prova_colegiada.model.Curso;
import br.com.sourceinformation.prova_colegiada.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }

    public Curso update(Curso curso) {
        verifyIfCursoExist(curso.getId());
        return cursoRepository.save(curso);
    }

    public void delete(Long id) {
        verifyIfCursoExist(id);
        cursoRepository.deleteById(id);
    }

    public Curso findById(Long id) {
        verifyIfCursoExist(id);
        return cursoRepository.findById(id).get();
    }

    private void verifyIfCursoExist(Long id) {
        Optional<Curso> obj = cursoRepository.findById(id);
        obj.orElseThrow(() -> new ObjectNotFoundException("Curso not found for ID :" + id + ", type: " + Curso.class.getName()));
    }
}
