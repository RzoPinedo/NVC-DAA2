package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.modelo.Empleados;
import idat.edu.pe.repositorio.EmpleadosRepositorio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/empleados")
public class EmpleadoController {
	@Autowired
	private EmpleadosRepositorio empleadoRepositorio;
	
	@GetMapping("/empleados")
	public List<Empleados> getAllEmpleado(){
		return empleadoRepositorio.findAll();
	}
	
}
