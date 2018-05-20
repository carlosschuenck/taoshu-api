package br.com.taoshu.service;

import br.com.taoshu.entity.Professor;

import java.util.List;
import java.util.Set;

/**
 * Created by Carlos Schuenck on 06/05/2018.
 */
public interface IProfessorService {
    List<Professor> findAll();
    Professor persist(Professor professor);
    Professor update(Professor professor);
    void delete(Long id);
}
