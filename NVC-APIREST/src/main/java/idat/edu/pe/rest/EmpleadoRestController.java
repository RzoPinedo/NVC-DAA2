package idat.edu.pe.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import idat.edu.pe.modelo.Empleados;
import idat.edu.pe.service.EmpleadosServicio;

@RestController
@RequestMapping("/rest/empleados")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadosServicio servicio;

	@GetMapping
	public ResponseEntity<Object> buscartTodo() {

		List<Empleados> listaEmpleados = servicio.buscarTodo();
		return new ResponseEntity<>(listaEmpleados, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public ResponseEntity<Object> buscarPorId(@PathVariable("id") int id) {
		Empleados empleado = servicio.buscarPorID(id);
		if (empleado == null)

			throw new ResponseStatusException(HttpStatus.NOT_FOUND,
					"Empleado no encontrado,id porporcionado no es correcto");
		return new ResponseEntity<Object>(empleado, HttpStatus.OK);

	}
	
	@PostMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, consumes = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> crear(@RequestBody Empleados empleados) {
		servicio.crear(empleados);
		return new ResponseEntity<Object>("Empleado creado correctamente", HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Object> actualizar(@PathVariable("id") int id, @RequestBody Empleados empleados) {
		servicio.actualizar(empleados);
		return new ResponseEntity<Object>("Empleado actualizado correctamente", HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Object> borrar(@PathVariable("id") int id) {
		servicio.borrarPorID(id);
		return new ResponseEntity<Object>("Empleado eliminado correctamente", HttpStatus.OK);

	}
	
}
