package br.com.taoshu.service.impl;

import br.com.taoshu.entity.Professor;
import br.com.taoshu.entity.Turma;
import br.com.taoshu.repository.TurmaRepository;
import br.com.taoshu.service.ITurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */

@Service
@Transactional(readOnly = false)
public class TurmaService implements ITurmaService{

    @Autowired
    private TurmaRepository turmaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma persist(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma update(Turma turma) {
        Turma oldTurma = turmaRepository.getOne(turma.getId());
        oldTurma.setHoraFim(turma.getHoraFim());
        oldTurma.setHoraInicio(turma.getHoraInicio());
        if(turma.getProfessor().getId() != null) oldTurma.setProfessor(turma.getProfessor());
        return turmaRepository.save(oldTurma);
    }

    @Override
    public void delete(Integer id) {
        turmaRepository.deleteById(id);
    }
}
