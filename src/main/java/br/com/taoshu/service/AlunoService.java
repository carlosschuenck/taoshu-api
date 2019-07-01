package br.com.taoshu.service;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
@Transactional(readOnly = true)
@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<Aluno> buscarTodos() { return alunoRepository.findAll(); }

    List<Aluno> buscarTurmaPorId(Integer turmaId) {
        return alunoRepository.findByTurmaId(turmaId);
    }

    @Transactional
    public Aluno inserir(Aluno aluno) {
    	return alunoRepository.save(aluno);
    }

    @Transactional
    public Aluno atualizar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Transactional
    public void deletar(Long id) { alunoRepository.deleteById(id); }

    public Optional<Aluno> buscarPorId(Long id) { return alunoRepository.findById(id); }
}
