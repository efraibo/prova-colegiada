package br.com.sourceinformation.prova_colegiada.service;

import br.com.sourceinformation.prova_colegiada.exception.ObjectNotFoundException;
import br.com.sourceinformation.prova_colegiada.model.Turma;
import br.com.sourceinformation.prova_colegiada.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TurmarService {

    private final TurmaRepository turmaRepository;

    @Autowired
    public TurmarService(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    public Turma save(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma update(Turma turma) {
        verifyIfTurmaExist(turma.getId());
        return turmaRepository.save(turma);
    }

    public void delete(Long id) {
        verifyIfTurmaExist(id);
        turmaRepository.deleteById(id);
    }

    public Turma findById(Long id) {
        verifyIfTurmaExist(id);
        return turmaRepository.findById(id).get();
    }

    private void verifyIfTurmaExist(Long id) {
        Optional<Turma> obj = turmaRepository.findById(id);
        obj.orElseThrow(() -> new ObjectNotFoundException("Turma not found for ID :" + id + ", type: " + Turma.class.getName()));
    }
}
