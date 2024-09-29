package co.edu.unicauca.asae.taller_jpa.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Docente extends Persona {
    private int oficina_id;
}
