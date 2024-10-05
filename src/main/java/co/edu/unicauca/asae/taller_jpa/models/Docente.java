package co.edu.unicauca.asae.taller_jpa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
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
    @ManyToMany(
        cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
        mappedBy="lstDocentes"
    )
    private List<Curso> lstCursos;
}
