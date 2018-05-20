package br.com.taoshu.service.impl;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.repository.AlunoRepository;
import br.com.taoshu.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */

@Transactional(readOnly = false)
@Service
public class AlunoService implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno persist(Aluno aluno) { return alunoRepository.save(aluno); }

    @Override
    public Aluno update(Aluno aluno) {
        Aluno oldAluno = alunoRepository.getOne(aluno.getId());
        oldAluno.setDataNascimento(aluno.getDataNascimento());
        oldAluno.setNomePai(aluno.getNomePai());
        oldAluno.setNomeMae(aluno.getNomeMae());
        oldAluno.setNomeCompleto(aluno.getNomeCompleto());
        oldAluno.setTurma(aluno.getTurma());
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);
    }
}
