package br.com.taoshu.service;

import br.com.taoshu.entity.Turma;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
public interface ITurmaService {
    List<Turma> findAll();
    Turma persist(Turma turma);
    Turma update(Turma turma);
    void delete(Integer id);
}
