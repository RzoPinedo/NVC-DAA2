package idat.edu.pe.rest;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.modelo.Alumnos;
import idat.edu.pe.modelo.AlumnosCursos;
import idat.edu.pe.modelo.Cargo;
import idat.edu.pe.modelo.CarritoCompraCursos;
import idat.edu.pe.modelo.Cursos;
import idat.edu.pe.modelo.Empleados;
import idat.edu.pe.repositorio.CargoRepositorio;
import idat.edu.pe.repositorio.CursosRepositorio;
import idat.edu.pe.service.AlumnosCursosServicio;
import idat.edu.pe.service.AlumnosServicio;
import idat.edu.pe.service.CursosServicio;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/rest/curso")
public class CursoRestController {
	
	@Autowired
	private CursosServicio cursosServicio;
	@Autowired
	private AlumnosServicio alumnosServicio;
	@Autowired
	private AlumnosCursosServicio alumnosCursosServicio;
	
	@GetMapping("/curso")
	public List<Cursos> getAll() {
		return cursosServicio.buscarTodo();
	}
	
	@PostMapping("/curso")
	public void CarritoCompraCursos(@Valid @RequestBody CarritoCompraCursos carritoCompraCursos) {
		Alumnos alumnoCrear= new Alumnos();
		
		alumnoCrear.setNOMBRES(carritoCompraCursos.getNombres());
		alumnoCrear.setAPELLIDOS(carritoCompraCursos.getApellidos());
		alumnoCrear.setDNI(carritoCompraCursos.getDni());
		alumnoCrear.setCORREO(carritoCompraCursos.getCorreo());
		alumnoCrear.setTELEFONO(carritoCompraCursos.getTelefono());
		alumnoCrear.setDIRECCION(carritoCompraCursos.getDireccion());
		alumnoCrear.setESTADO(1);
		
		Alumnos alumno = alumnosServicio.crear(alumnoCrear);
		
		for(Integer idCurso:carritoCompraCursos.getCursos()) {
			AlumnosCursos alumnoCurso = new AlumnosCursos();
			Cursos curso = cursosServicio.buscarPorID(idCurso);
			alumnoCurso.setIDALUMNO(alumno);
			alumnoCurso.setID_CURSOS(curso);
			alumnoCurso.setESTADO("1");			
			alumnosCursosServicio.crear(alumnoCurso);
		}		
	}
}
