package idat.edu.pe.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import idat.edu.pe.controller.exception.ResourceNotFoundException;
import idat.edu.pe.modelo.Empleados;
import idat.edu.pe.repositorio.EmpleadosRepositorio;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/empleados")
public class EmpleadoRestController {
	
	@Autowired
	private EmpleadosRepositorio empleadosRepository;

	@GetMapping("/empleados")
	public List<Empleados> getAllEmpleados() {
		return empleadosRepository.findAll();
	}

	@GetMapping("/empleados/{id}")
	public ResponseEntity<Empleados> getEmpleadosById(@PathVariable(value = "id") Integer empleadosId)
			throws ResourceNotFoundException {
		Empleados empleados = empleadosRepository.findById(empleadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Empleados not found for this id :: " + empleadosId));
		return ResponseEntity.ok().body(empleados);
	}

	@PostMapping("/empleados")
	public Empleados createEmpleados(@Valid @RequestBody Empleados empleados) {
		return empleadosRepository.save(empleados);
	}

	@PutMapping("/empleados/{id}")
	public ResponseEntity<Empleados> updateEmpleados(@PathVariable(value = "id") Integer empleadosId,
			@Valid @RequestBody Empleados empleadoDetails) throws ResourceNotFoundException {
		Empleados empleados = empleadosRepository.findById(empleadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Empleados not found for this id :: " + empleadosId));

		empleados.setNOMBRES(empleadoDetails.getNOMBRES());
		empleados.setAPELLIDOS(empleadoDetails.getAPELLIDOS());
		empleados.setDNI(empleadoDetails.getDNI());
		empleados.setCORREO(empleadoDetails.getCORREO());
		empleados.setTELEFONO(empleadoDetails.getTELEFONO());
		empleados.setDIRECCION(empleadoDetails.getDIRECCION());
		empleados.setESTADO(empleadoDetails.getESTADO());
		empleados.setID_CARGO(empleadoDetails.getID_CARGO());
		final Empleados updatedEmpleados = empleadosRepository.save(empleados);
		return ResponseEntity.ok(updatedEmpleados);
	}

	@DeleteMapping("/empleados/{id}")
	public Map<String, Boolean> deleteEmpleados(@PathVariable(value = "id") Integer empleadosId)
			throws ResourceNotFoundException {
		Empleados empleados = empleadosRepository.findById(empleadosId)
				.orElseThrow(() -> new ResourceNotFoundException("Empleados not found for this id :: " + empleadosId));

		empleadosRepository.delete(empleados);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
