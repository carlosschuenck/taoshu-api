package br.com.taoshu.entity;

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
@SequenceGenerator(name = "sequence_turma", sequenceName = "sequence_turma", allocationSize = 1, initialValue = 1)
public class Turma {

    @Id
    @GeneratedValue(generator = "sequence_turma", strategy = GenerationType.AUTO)
    @Column(name = "turma_id")
    private Integer id;

    @Column(nullable =  false)
    @NotNull
    private LocalTime horaInicio;

    @Column
    private LocalTime horaFim;

    /**
     * Relacionamentos
     */
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "professor_id_fk", nullable = false)
    @NotNull(message = "PROFESSOR NAO TA AQUI")
    private Professor professor = new Professor();
}
