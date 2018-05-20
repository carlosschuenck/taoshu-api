package br.com.taoshu.service.impl;

import br.com.taoshu.entity.Professor;
import br.com.taoshu.repository.ProfessorRepository;
import br.com.taoshu.service.IProfessorService;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Avell 1513 on 06/05/2018.
 */
@Service
@Transactional(readOnly = false)
public class ProfessorService implements IProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor persist(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor update(Professor professor) {
        Professor professorOld = professorRepository.getOne(professor.getId());
        professorOld.setNomePai(professor.getNomePai());
        professorOld.setNomeMae(professor.getNomeMae());
        professorOld.setNomeCompleto(professor.getNomeCompleto());
        professorOld.setDataNascimento(professor.getDataNascimento());
        return professorRepository.save(professorOld);
    }

    @Override
    public void delete(Long id) {
        professorRepository.deleteById(id);
    }
}
