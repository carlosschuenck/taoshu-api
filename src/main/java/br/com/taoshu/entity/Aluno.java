package br.com.taoshu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.internal.constraintvalidators.hv.NotBlankValidator;

import javax.persistence.*;
import javax.validation.Constraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Carlos Schuenck on 23/04/2018.
 */


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "sequence_aluno", sequenceName = "sequence_aluno", allocationSize = 1, initialValue = 1)
public class Aluno {

    @Id
    @GeneratedValue(generator = "sequence_aluno", strategy = GenerationType.AUTO)
    @Column(name = "aluno_id")
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String nomeCompleto;

    @Column
    private String nomePai;

    @Column(nullable = false)
    @NotBlank
    private String nomeMae;

    @Column(nullable = false)
    @NotNull
    private LocalDate dataNascimento;

    /**
     * Relacionamentos
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "turma_id_fk")
    private Turma turma;
}
