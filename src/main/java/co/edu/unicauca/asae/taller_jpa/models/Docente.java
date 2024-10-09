package co.edu.unicauca.asae.taller_jpa.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
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
    //Relaciones
    @OneToOne(
        cascade = {CascadeType.PERSIST}
    )
    @JoinColumn(
        name="oficina_id", 
        referencedColumnName="oficina_id"
    )
    private Oficina objOficina;

    @ManyToMany(
        cascade = {CascadeType.PERSIST},
        fetch = FetchType.EAGER
    )
    @JoinTable(
        name = "curso_docente", 
        joinColumns=@JoinColumn(name="docente_id"),
        inverseJoinColumns=@JoinColumn(name ="curso_id")
    )
    private List<Curso> lstCursos;
}
