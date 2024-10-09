package co.edu.unicauca.asae.taller_jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "oficina")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Oficina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="oficina_id")
    private int id;

    @Column(unique = true, length = 20)
    private String nombre;
    
    @Column(length = 20)
    private String ubicacion;

    @OneToOne(mappedBy = "objOficina")
    private Docente objDocente;
}
