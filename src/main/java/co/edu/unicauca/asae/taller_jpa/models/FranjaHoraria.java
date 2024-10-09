package co.edu.unicauca.asae.taller_jpa.models;

import java.time.LocalTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "franja_horaria")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHoraria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="franja_horaria_id")
    private int id;

    @Column(length = 20)
    private String dia;
    private LocalTime horaInicio; 
    private LocalTime horaFin; 
    
    //Relaciones
    @ManyToOne(
        cascade = {CascadeType.PERSIST},
        fetch= FetchType.LAZY
    )
    @JoinColumn(
        name = "espacio_fisico_id",
        referencedColumnName = "espacio_fisico_id"
    )
    private EspacioFisico objEspacioFisico;

    @ManyToOne(
        cascade={CascadeType.REMOVE}
    )
    @JoinColumn(
        name = "curso_id",
        referencedColumnName = "curso_id",
        nullable=false
    )
    private Curso objCurso;
}
