package br.com.taoshu.service;

import br.com.taoshu.entity.Presenca;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
public interface IPresencaService {
    List<Presenca> findAll();
    Presenca persist(Presenca presenca);
    Presenca update(Presenca presenca);
    void delete(Long id);
}
