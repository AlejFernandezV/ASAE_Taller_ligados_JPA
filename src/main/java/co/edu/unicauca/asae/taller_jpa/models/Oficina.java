package co.edu.unicauca.asae.taller_jpa.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "Oficina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oficina {
    @Id
    @GeneratedValue()
    private int id;

    private String nombre;
    private String ubicacion;
}
