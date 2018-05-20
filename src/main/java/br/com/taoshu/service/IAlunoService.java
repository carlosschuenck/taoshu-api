package br.com.taoshu.service;

import br.com.taoshu.entity.Aluno;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
public interface IAlunoService {
    List<Aluno> findAll();
    Aluno persist(Aluno aluno);
    Aluno update(Aluno aluno);
    void delete(Long id);
}
