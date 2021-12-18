package idat.edu.pe.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.modelo.Cargo;
import idat.edu.pe.modelo.Cursos;
import idat.edu.pe.repositorio.CargoRepositorio;
import idat.edu.pe.repositorio.CursosRepositorio;
import idat.edu.pe.service.CursosServicio;

@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/rest/curso")
public class CursoRestController {
	@Autowired
	private CursosRepositorio cursosrepositorio;
	@Autowired
	private CursosServicio cursosServicio;
	

	@GetMapping("/curso")
	public List<Cursos> getAll() {
		return cursosServicio.buscarTodo();
	}
}
