package br.com.taoshu.service;

import br.com.taoshu.entity.Turma;
import br.com.taoshu.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */

@Service
@Transactional(readOnly = false)
public class TurmaService{

    @Autowired
    private TurmaRepository turmaRepository;

    @Transactional(readOnly = true)
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    public Turma persist(Turma turma) {
        return turmaRepository.save(turma);
    }

    public Turma update(Turma turma) {
        Turma oldTurma = turmaRepository.getOne(turma.getId());
        oldTurma.setHoraFim(turma.getHoraFim());
        oldTurma.setHoraInicio(turma.getHoraInicio());
        if(turma.getProfessor().getId() != null) oldTurma.setProfessor(turma.getProfessor());
        return turmaRepository.save(oldTurma);
    }

    public void delete(Integer id) {
        turmaRepository.deleteById(id);
    }
}
