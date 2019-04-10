package br.com.taoshu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.taoshu.entity.Aluno;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	public List<Aluno> findByTurmaId(Integer id);
}
