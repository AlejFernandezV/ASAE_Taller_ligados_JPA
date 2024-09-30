package co.edu.unicauca.asae.taller_jpa.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Docente extends Persona {
    private int oficina_id;

    @JoinTable(name="curso_docente", joinColumns=@JoinColumn(name="docente_id"), inverseJoinColumns=@JoinColumn(name="curso_id"))
    private List<Curso> lstCursos;
}
