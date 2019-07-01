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

    private final ProfessorRepository professorRepository;

    private final TurmaService turmaService;

    public ProfessorService(ProfessorRepository professorRepository, TurmaService turmaService) {
        this.professorRepository = professorRepository;
        this.turmaService = turmaService;
    }

    public List<Professor> buscarTodos() {
        return professorRepository.findAll();
    }

    public Professor buscarPorId(Long id) {
        return professorRepository.findById(id)
        						  .orElseThrow(() -> new IllegalArgumentException("Não existe um professor com o id informado"));
    }

    @Transactional
    public Professor inserir(Professor professor) {
        return professorRepository.save(professor);
    }

    @Transactional
    public Professor atualizar(Professor professor) {
        Professor professorOld = professorRepository.getOne(professor.getId());
        professorOld.setNomePai(professor.getNomePai());
        professorOld.setNomeMae(professor.getNomeMae());
        professorOld.setNomeCompleto(professor.getNomeCompleto());
        professorOld.setDataNascimento(professor.getDataNascimento());
        return professorRepository.save(professorOld);
    }

    @Transactional
    public void deletar(Long id) {
    	turmaService.buscarPorProfessorId(id).forEach(turma ->	turmaService.deletar(turma.getId()));
        professorRepository.deleteById(id);
    }
}
