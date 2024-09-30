package co.edu.unicauca.asae.taller_jpa.repositories;

import org.springframework.data.repository.CrudRepository;

import co.edu.unicauca.asae.taller_jpa.models.Persona;

public interface PersonaRepository extends CrudRepository<Persona, Integer> {

}
