package co.edu.unicauca.asae.taller_jpa.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "curso")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="curso_id")
    private int id;

    @Column(length = 255)
    private String nombre;

    //Relaciones
    @OneToMany(
        cascade = {CascadeType.REMOVE},
        fetch =  FetchType.LAZY, 
        mappedBy = "objCurso"
    )
    private List<FranjaHoraria> lstFranjasHorarias = new ArrayList<>();

    @ManyToMany(
        cascade = {CascadeType.PERSIST},
        fetch = FetchType.EAGER
    )
    @JoinTable(
        name = "curso_docente", 
        joinColumns=@JoinColumn(name="curso_id"),
        inverseJoinColumns=@JoinColumn(name ="docente_id")
    )
    private List<Docente> lstDocentes = new ArrayList<>();
    
    @ManyToOne(
        cascade = {CascadeType.PERSIST}
    )
    @JoinColumn(
        name="asignatura_id",
        referencedColumnName = "asignatura_id"
    )
    private Asignatura objAsignatura;
}
