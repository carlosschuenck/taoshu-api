package br.com.taoshu.service;

import br.com.taoshu.entity.Turma;
import br.com.taoshu.repository.TurmaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */

@Service
@Transactional(readOnly = true)
public class TurmaService {

    private final TurmaRepository turmaRepository;

    private final AlunoService alunoService;

    public TurmaService(TurmaRepository turmaRepository, AlunoService alunoService) {
        this.turmaRepository = turmaRepository;
        this.alunoService = alunoService;
    }

    public List<Turma> buscarTodos() {
        return turmaRepository.findAll();
    }

    List<Turma> buscarPorProfessorId(Long id) {
        return turmaRepository.findByProfessorId(id);
    }

    public Turma buscarPorId(Integer id) {
        return turmaRepository.findById(id).orElse(null);
    }

    @Transactional
    public Turma inserir(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Transactional
    public Turma atualizar(Turma turma) {
        Turma ultimaVersao = turmaRepository.getOne(turma.getId());
        ultimaVersao.setDiaSemana(turma.getDiaSemana());
        ultimaVersao.setHoraFim(turma.getHoraFim());
        ultimaVersao.setHoraInicio(turma.getHoraInicio());
        if (turma.getProfessor().getId() != null) ultimaVersao.setProfessor(turma.getProfessor());
        return turmaRepository.save(ultimaVersao);
    }

    @Transactional
    public void deletar(Integer id) {
        alunoService.buscarTurmaPorId(id)
                    .forEach(aluno -> {
            aluno.setTurma(null);
            alunoService.atualizar(aluno);
        });
        turmaRepository.deleteById(id);
    }
}
