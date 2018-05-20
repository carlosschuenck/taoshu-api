package br.com.taoshu.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * Created by Carlos Schuenck on 01/05/2018.
 */


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@SequenceGenerator(name = "sequence_presenca", sequenceName = "sequence_presenca", initialValue = 1,allocationSize = 1)
public class Presenca {

    @Id
    @GeneratedValue(generator = "sequence_professor", strategy = GenerationType.AUTO)
    @Column(name = "presenca_id")
    private Long id;

    @Column(nullable = false)
    @NotNull
    private LocalDate data;

    @Column(nullable = false)
    @NotNull
    private Boolean presenca;

    /**
     * Relacionamentos
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "aluno_id_fk", nullable = false)
    @NotNull
    private Aluno aluno = new Aluno();
}
