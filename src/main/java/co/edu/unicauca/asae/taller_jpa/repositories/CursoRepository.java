package co.edu.unicauca.asae.taller_jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.taller_jpa.models.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
