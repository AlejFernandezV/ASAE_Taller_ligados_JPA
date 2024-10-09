package co.edu.unicauca.asae.taller_jpa;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import co.edu.unicauca.asae.taller_jpa.models.Asignatura;
import co.edu.unicauca.asae.taller_jpa.models.Curso;
import co.edu.unicauca.asae.taller_jpa.models.Docente;
import co.edu.unicauca.asae.taller_jpa.models.EspacioFisico;
import co.edu.unicauca.asae.taller_jpa.models.FranjaHoraria;
import co.edu.unicauca.asae.taller_jpa.models.Oficina;
import co.edu.unicauca.asae.taller_jpa.models.Persona;
import co.edu.unicauca.asae.taller_jpa.repositories.AsignaturaRepository;
import co.edu.unicauca.asae.taller_jpa.repositories.CursoRepository;
import co.edu.unicauca.asae.taller_jpa.repositories.EspacioFisicoRepository;
import co.edu.unicauca.asae.taller_jpa.repositories.FranjaHorariaRepository;
import co.edu.unicauca.asae.taller_jpa.repositories.PersonaRepository;
import jakarta.transaction.Transactional;

@SpringBootApplication
@Transactional
public class TallerJpaApplication implements CommandLineRunner {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private EspacioFisicoRepository espacioFisicoRepository;
	
	@Autowired
	private FranjaHorariaRepository franjaHorariaRepository;


	public static void main(String[] args) {
		SpringApplication.run(TallerJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.almacenarDocente();
		this.almacenarCurso();
		this.almacenarFranjaHoraria();
		this.consultarFranjasHorarias();
		this.consultarFranjaHorariaDocente(2);
		this.eliminarCurso(2);
		this.consultarFranjaHorariaDocente(2);
	}

	private void almacenarDocente(){

		System.out.println("\n\n Almacenando Docente");

		Docente docente = new Docente();
		docente.setNombre("Juan");
		docente.setApellido("Perez");
		docente.setCorreo("juan.perez@unicauca.edu.co");

		Oficina oficina = new Oficina();
		oficina.setNombre("Oficina 1");
		oficina.setUbicacion("edificio central");

		docente.setObjOficina(oficina);
		this.personaRepository.save(docente);
	}

	private void almacenarCurso(){

		System.out.println("\n\n Almacenando Curso");

		Optional<Asignatura> objAsignatura = this.asignaturaRepository.findById(1);

		Docente objDocente = new Docente();
		objDocente.setNombre("Alexander");
		objDocente.setApellido("Sanchez");
		objDocente.setCorreo("alxsanchez@unicauca.edu.co");		

		Curso objCurso = new Curso();
		objCurso.setNombre("Ingeniería de sistemas 2024-2");
		objCurso.setObjAsignatura(objAsignatura.get());

		objDocente.setLstCursos(List.of(objCurso));
		objCurso.setLstDocentes(List.of(objDocente));

		this.cursoRepository.save(objCurso);
	}

	private void almacenarFranjaHoraria(){

		System.out.println("\n\n Almacenando Franja Horaria");

		Curso objCurso = this.cursoRepository.findById(2).get(); 
		EspacioFisico objEspacioFisico = this.espacioFisicoRepository.findById(1).get(); 

		FranjaHoraria objFranjaHoraria1 = new FranjaHoraria();
		objFranjaHoraria1.setDia("Lunes");
		objFranjaHoraria1.setHoraInicio(LocalTime.of(9, 0));
		objFranjaHoraria1.setHoraFin(LocalTime.of(11, 0));
		objFranjaHoraria1.setObjCurso(objCurso);
		objFranjaHoraria1.setObjEspacioFisico(objEspacioFisico);

		FranjaHoraria objFranjaHoraria2 = new FranjaHoraria();
		objFranjaHoraria2.setDia("Viernes");
		objFranjaHoraria2.setHoraInicio(LocalTime.of(9, 0));
		objFranjaHoraria2.setHoraFin(LocalTime.of(11, 0));
		objFranjaHoraria2.setObjCurso(objCurso);
		objFranjaHoraria2.setObjEspacioFisico(objEspacioFisico);

		List<FranjaHoraria> lstFranjaHorarias = List.of(objFranjaHoraria1,objFranjaHoraria2);

		objCurso.setLstFranjasHorarias(lstFranjaHorarias);

		this.franjaHorariaRepository.saveAll(lstFranjaHorarias);
	}

	private void consultarFranjasHorarias(){

		System.out.println("\n\n Consultando Franjas Horarias");

		Iterable<FranjaHoraria> lstFranjasHorarias = this.franjaHorariaRepository.findAll();

		System.out.println("------ Consultando franjas horarias ------");
		for(FranjaHoraria objFranjaHoraria: lstFranjasHorarias){
			System.out.println("\t Franja Horaria para el curso "+objFranjaHoraria.getObjCurso().getNombre());
			System.out.println("\t Espacio fisico: "+objFranjaHoraria.getObjEspacioFisico().getNombre());
			System.out.println("\t Capacidad del Espacio fisico: "+objFranjaHoraria.getObjEspacioFisico().getCapacidad());
			System.out.println("\t Dia: "+objFranjaHoraria.getDia());
			System.out.println("\t Hora Inicio: "+objFranjaHoraria.getHoraInicio());
			System.out.println("\t Hora Fin: "+objFranjaHoraria.getHoraFin());
			System.out.println("============================================================================");
		}
	}

	private void consultarFranjaHorariaDocente(int idDocente){

		System.out.println("\n\n Consultando Franjas Horarias por Docente");

		Optional<Persona> docente = this.personaRepository.findById(idDocente);
		Docente objDocente = (Docente) docente.get();

		System.out.println("\n\nImprimiendo las franjas horarias del Docente "+objDocente.getNombre()+" "+objDocente.getApellido());

		System.out.println("------ Cursos ------");
		if(objDocente.getLstCursos() != null){
			for(Curso objCurso: objDocente.getLstCursos()){
				System.out.println("\t Nombre: "+objCurso.getNombre());
				System.out.println("\t\t------ Franjas horarias ------");
				if(objCurso.getLstFranjasHorarias() != null){
					for(FranjaHoraria objFranjaHoraria: objCurso.getLstFranjasHorarias()){
						System.out.println("\t\t\t Franja Horaria para el curso "+objFranjaHoraria.getObjCurso().getNombre());
						System.out.println("\t\t\t Espacio fisico: "+objFranjaHoraria.getObjEspacioFisico().getNombre());
						System.out.println("\t\t\t Capacidad del Espacio fisico: "+objFranjaHoraria.getObjEspacioFisico().getCapacidad());
						System.out.println("\t\t\t Dia: "+objFranjaHoraria.getDia());
						System.out.println("\t\t\t Hora Inicio: "+objFranjaHoraria.getHoraInicio());
						System.out.println("\t\t\t Hora Fin: "+objFranjaHoraria.getHoraFin());
						System.out.println("\t\t========================================================================================");
					}
				}else{
					System.out.println("\t\t No hay franjas horarias para el curso "+objCurso.getNombre()+".\n");
				}
			}
		}else{
			System.out.println("No hay cursos impartidos por el profesor "+objDocente.getNombre()+" "+objDocente.getApellido()+ ", por lo tanto, no hay franjas horarias.\n");
		}
	}

	private void eliminarCurso(int idCurso){
		if (cursoRepository.existsById(idCurso)) {
			cursoRepository.deleteById(idCurso);
			System.out.println("Curso con ID " + idCurso + " eliminado.");
		} else {
			System.out.println("No se encontró un curso con ID " + idCurso + ".");
		}
	}

}
