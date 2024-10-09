package co.edu.unicauca.asae.taller_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.taller_jpa.models.Docente;
import co.edu.unicauca.asae.taller_jpa.models.Oficina;
import co.edu.unicauca.asae.taller_jpa.repositories.DocenteRepository;
import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class TallerJpaApplication {

	@Autowired
	private DocenteRepository docenteRepository;


	public static void main(String[] args) {
		SpringApplication.run(TallerJpaApplication.class, args);
		TallerJpaApplication app = new TallerJpaApplication();
        app.crearDocente();
	}
	@PostConstruct
	private void crearDocente(){
		Docente docente = new Docente();
		docente.setNombre("Juan");
		docente.setApellido("Perez");
		docente.setCorreo("juan.perez@unicauca.edu.co");

		Oficina oficina = new Oficina();
		oficina.setNombre("Oficina 1");
		oficina.setUbicacion("edificio central");

		docente.setObjOficina(oficina);
		docenteRepository.save(docente);
		
	}

}
