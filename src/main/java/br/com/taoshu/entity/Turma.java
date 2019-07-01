package br.com.taoshu.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

/**
 * Created by Carlos Schuenck on 01/05/2018.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "sequence_turma", sequenceName = "sequence_turma", allocationSize = 1)
public class Turma {

    @Id
    @GeneratedValue(generator = "sequence_turma", strategy = GenerationType.AUTO)
    @Column(name = "turma_id")
    private Integer id;

    @Column(nullable = false)
    @NotNull
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaInicio;

    @Column
    @JsonFormat(pattern = "HH:mm")
    private LocalTime horaFim;

    @Column
    private String diaSemana;

    /**
     * Relacionamentos
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id_fk", nullable = false)
    @NotNull(message = "PROFESSOR NAO TA AQUI")
    private Professor professor = new Professor();
}
