package br.com.taoshu.repository;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.entity.Turma;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
public interface TurmaRepository extends JpaRepository<Turma, Integer>{
	
	public List<Turma> findByProfessorId(Long id);
}