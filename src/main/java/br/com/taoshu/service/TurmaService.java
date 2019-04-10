package br.com.taoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.taoshu.entity.Turma;
import br.com.taoshu.repository.TurmaRepository;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */

@Service
@Transactional(readOnly = true)
public class TurmaService{

    @Autowired
    private TurmaRepository turmaRepository;
    
    @Autowired
    private AlunoService alunoService;

    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }
    
    public List<Turma> findByProfessorId(Long id) {
        return turmaRepository.findByProfessorId(id);
    }
    
    public Turma findById(Integer id) {
        return turmaRepository.findById(id).orElse(null);
    }
    
    @Transactional(readOnly = false)
    public Turma persist(Turma turma) {
        return turmaRepository.save(turma);
    }
    
    @Transactional(readOnly = false)
    public Turma update(Turma turma) {
        Turma classToUpdate = turmaRepository.getOne(turma.getId());
        classToUpdate.setDiaSemana(turma.getDiaSemana());
        classToUpdate.setHoraFim(turma.getHoraFim());
        classToUpdate.setHoraInicio(turma.getHoraInicio());
        if(turma.getProfessor().getId() != null) classToUpdate.setProfessor(turma.getProfessor());
        return turmaRepository.save(classToUpdate);
    }
    
    @Transactional(readOnly = false)
    public void delete(Integer id) {
    	alunoService.findByTumaId(id).forEach(aluno ->{
    		aluno.setTurma(null);
    		alunoService.update(aluno);
        });
        turmaRepository.deleteById(id);
    }
}
