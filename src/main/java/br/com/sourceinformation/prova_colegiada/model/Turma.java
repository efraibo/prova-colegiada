package br.com.sourceinformation.prova_colegiada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turma extends AbstractEntity {
    private String periodo;
    private String turno;
    private String semestre;
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
}
