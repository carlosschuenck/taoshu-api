package br.com.taoshu.service;

import br.com.taoshu.entity.Professor;
import br.com.taoshu.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Avell 1513 on 06/05/2018.
 */
@Service
@Transactional(readOnly = false)
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Transactional(readOnly = true)
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor persist(Professor professor) {
        return professorRepository.save(professor);
    }

    public Professor update(Professor professor) {
        Professor professorOld = professorRepository.getOne(professor.getId());
        professorOld.setNomePai(professor.getNomePai());
        professorOld.setNomeMae(professor.getNomeMae());
        professorOld.setNomeCompleto(professor.getNomeCompleto());
        professorOld.setDataNascimento(professor.getDataNascimento());
        return professorRepository.save(professorOld);
    }

    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
}
