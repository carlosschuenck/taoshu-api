package br.com.taoshu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.taoshu.entity.Professor;
import br.com.taoshu.repository.ProfessorRepository;

@Service
@Transactional(readOnly = true)
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;
    
    @Autowired
    private TurmaService turmaService;
   
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
    
    public Professor findById(Long id) {
        return professorRepository.findById(id)
        						  .orElseThrow(() -> new IllegalArgumentException("Não existe um professor com o id informado"));
    }
    
    @Transactional(readOnly = false)
    public Professor persist(Professor professor) {
        return professorRepository.save(professor);
    }
    
    @Transactional(readOnly = false)
    public Professor update(Professor professor) {
        Professor professorOld = professorRepository.getOne(professor.getId());
        professorOld.setNomePai(professor.getNomePai());
        professorOld.setNomeMae(professor.getNomeMae());
        professorOld.setNomeCompleto(professor.getNomeCompleto());
        professorOld.setDataNascimento(professor.getDataNascimento());
        return professorRepository.save(professorOld);
    }
    
    @Transactional(readOnly = false)
    public void delete(Long id) {
    	turmaService.findByProfessorId(id).forEach(turma ->{
    		turmaService.delete(turma.getId());
    	});
        professorRepository.deleteById(id);
    }
}
