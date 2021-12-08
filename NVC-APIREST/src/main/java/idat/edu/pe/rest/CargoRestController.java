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
import idat.edu.pe.modelo.Cargo;
import idat.edu.pe.repositorio.CargoRepositorio;


@CrossOrigin(origins = "http://localhost:4200") 
@RestController
@RequestMapping("/rest/cargo")
public class CargoRestController {

	@Autowired
	private CargoRepositorio cargorepositorio;

	@GetMapping("/cargo")
	public List<Cargo> getAllEmployees() {
		return cargorepositorio.findAll();
	}
	
	@GetMapping("/cargo/{id}")
	public ResponseEntity<Cargo> getEmployeeById(@PathVariable(value = "id") Integer cargoId)
			throws ResourceNotFoundException {
		Cargo cargo = cargorepositorio.findById(cargoId)
				.orElseThrow(() -> new ResourceNotFoundException("Cargo not found for this id :: " + cargoId));
		return ResponseEntity.ok().body(cargo);
	}

	
	@PostMapping("/cargo")
	public Cargo createCargo(@Valid @RequestBody Cargo cargo) {
		return cargorepositorio.save(cargo);
	}

	@PutMapping("/cargo/{id}")
	public ResponseEntity<Cargo> updateCargo(@PathVariable(value = "id") Integer cargoId,
			@Valid @RequestBody Cargo cargoDetails) throws ResourceNotFoundException {
		Cargo cargo = cargorepositorio.findById(cargoId)
				.orElseThrow(() -> new ResourceNotFoundException("Cargo not found for this id :: " + cargoId));

		//cargo.setID_CARGO(cargoDetails.getID_CARGO());
		cargo.setNOMBRE(cargoDetails.getNOMBRE());
		cargo.setESTADO(cargoDetails.getESTADO());
		final Cargo updateCargo = cargorepositorio.save(cargo);
		return ResponseEntity.ok(updateCargo);
	}
	
	@DeleteMapping("/cargo/{id}")
	public Map<String, Boolean> deleteCargo(@PathVariable(value = "id") Integer cargoId)
			throws ResourceNotFoundException {
		Cargo cargo = cargorepositorio.findById(cargoId)
				.orElseThrow(() -> new ResourceNotFoundException("Cargo not found for this id :: " + cargoId));

		cargorepositorio.delete(cargo);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
