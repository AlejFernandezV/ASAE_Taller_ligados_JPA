package co.edu.unicauca.asae.taller_jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "asignatura")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Asignatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 255)
    private String nombre;
    @Column(length = 50)
    private String codigo;

    //Relaciones
    @OneToMany(mappedBy="objAsignatura")
    private List<Curso> lstCursos;
}
