package co.edu.unicauca.asae.taller_jpa.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String dia;
    private String horaInicio; // TO DO: CAMBIAR TIPO A DATETIME
    private String horaFin; // TO DO: CAMBIAR TIPO A DATETIME

    //Relaciones
    @ManyToOne
    private EspacioFisico objEspacioFisico;

    @ManyToOne
    private Curso objCurso;
}
