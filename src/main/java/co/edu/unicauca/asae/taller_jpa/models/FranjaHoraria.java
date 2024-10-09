package co.edu.unicauca.asae.taller_jpa.models;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    private Date horaInicio; 
    private Date horaFin; 
    
    //Relaciones
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(
        name = "espacio_fisico_id",
        referencedColumnName = "espacio_fisico_id"
    )
    private EspacioFisico objEspacioFisico;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(
        name = "curso_id",
        referencedColumnName = "curso_id"
    )
    private Curso objCurso;
}
