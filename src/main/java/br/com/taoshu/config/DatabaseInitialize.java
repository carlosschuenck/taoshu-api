package br.com.taoshu.config;

import br.com.taoshu.entity.Aluno;
import br.com.taoshu.entity.Professor;
import br.com.taoshu.entity.Turma;
import br.com.taoshu.service.AlunoService;
import br.com.taoshu.service.ProfessorService;
import br.com.taoshu.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class DatabaseInitialize implements ApplicationRunner {

    private final AlunoService alunoService;

    private final ProfessorService professorService;

    private final TurmaService turmaService;

    public DatabaseInitialize(AlunoService alunoService, ProfessorService professorService, TurmaService turmaService) {
        this.alunoService = alunoService;
        this.professorService = professorService;
        this.turmaService = turmaService;
    }

    @Override
    public void run(ApplicationArguments args){
        gerarDados();
    }

    private void gerarDados() {
        int count = 1;
        for (int i = 0; i < 3; i++) {
            int numero = (i + 1);
            Professor professor = new Professor(null, "Nome Professor " + numero, "Pai Professor " + numero, "Mãe Professor " + numero, LocalDate.now());
            Turma turma = turmaService.inserir(new Turma(null, LocalTime.now(), LocalTime.now().plusHours(2L), "Sábado", professorService.inserir(professor)));
            for (int j = 1; j < 6; j++) {
                alunoService.inserir(new Aluno(null, "Aluno " + count, "Pai do Aluno " + count, "Mãe do Aluno " + count, LocalDate.now(), turma));
                count++;
            }
        }
    }
}
