package co.edu.unicauca.asae.taller_jpa.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FranjaHoraria {
    private int id;
    private String dia;
    private String horaInicio;
    private String horaFin;
}
