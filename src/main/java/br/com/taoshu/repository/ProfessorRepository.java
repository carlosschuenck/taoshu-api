package br.com.taoshu.repository;

import br.com.taoshu.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Avell 1513 on 06/05/2018.
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
