package br.com.taoshu.repository;

import br.com.taoshu.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    List<Turma> findByProfessorId(Long id);
}