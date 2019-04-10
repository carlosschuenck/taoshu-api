package br.com.taoshu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.repository.AlunoRepository;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@Transactional(readOnly = true)
@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

   
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }
    
    public List<Aluno> findByTumaId(Integer idTurma) {
        return alunoRepository.findByTurmaId(idTurma);
    }
    
    @Transactional(readOnly = false)
    public Aluno persist(Aluno aluno) { 
    	return alunoRepository.save(aluno); 
    }
    
    @Transactional(readOnly = false)
    public Aluno update(Aluno aluno) {
        return alunoRepository.save(aluno);
    }
    	
    @Transactional(readOnly = false)
    public Boolean delete(Long id) {
        alunoRepository.deleteById(id);
        return true;
    }
    
    public Optional<Aluno> findById(Long id) {
    	return alunoRepository.findById(id);
    }
}
