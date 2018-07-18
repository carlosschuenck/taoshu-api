package br.com.taoshu.service;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */

@Transactional(readOnly = false)
@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno persist(Aluno aluno) { return alunoRepository.save(aluno); }

    public Aluno update(Aluno aluno) {
        Aluno oldAluno = alunoRepository.getOne(aluno.getId());
        oldAluno.setDataNascimento(aluno.getDataNascimento());
        oldAluno.setNomePai(aluno.getNomePai());
        oldAluno.setNomeMae(aluno.getNomeMae());
        oldAluno.setNomeCompleto(aluno.getNomeCompleto());
        oldAluno.setTurma(aluno.getTurma());
        return alunoRepository.save(aluno);
    }

    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}
