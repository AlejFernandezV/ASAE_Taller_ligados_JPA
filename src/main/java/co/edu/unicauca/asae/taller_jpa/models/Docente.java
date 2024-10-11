package co.edu.unicauca.asae.taller_jpa.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
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
        fetch = FetchType.EAGER,
        mappedBy = "lstDocentes"
    )
    private List<Curso> lstCursos = new ArrayList<>();
}
