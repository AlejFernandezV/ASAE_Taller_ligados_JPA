package co.edu.unicauca.asae.taller_jpa.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "espacio_fisico")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EspacioFisico {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="espacio_fisico_id")
    private int id;
    @Column(unique = true, length = 25)
    private String nombre;
    private String capacidad;

    // Relaciones
    @OneToMany(fetch =  FetchType.LAZY, mappedBy = "objEspacioFisico")
    private List<FranjaHoraria> lstFranjasHorarias;
}
