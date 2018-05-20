package br.com.taoshu.repository;

import br.com.taoshu.entity.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Carlos Schuenck on 20/05/2018.
 */
public interface AlunoRepository extends JpaRepository<Aluno, Long>{
}
