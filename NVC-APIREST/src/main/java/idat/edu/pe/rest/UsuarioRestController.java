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
import idat.edu.pe.modelo.Usuarios;
import idat.edu.pe.repositorio.UsuariosRepositorio;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/usuarios")
public class UsuarioRestController {
	
	@Autowired
	private UsuariosRepositorio usuariosRepository;

	@GetMapping("/usuarios")
	public List<Usuarios> getAllUsuarios() {
		return (List<Usuarios>) usuariosRepository.findAll();
	}

	@GetMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> getUsuariosById(@PathVariable(value = "id") Integer usuariosId)
			throws ResourceNotFoundException {
		Usuarios usuarios = usuariosRepository.findById(usuariosId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuarios not found for this id :: " + usuariosId));
		return ResponseEntity.ok().body(usuarios);
	}

	@PostMapping("/usuarios")
	public Usuarios createUsuarios(@Valid @RequestBody Usuarios usuarios) {
		return usuariosRepository.save(usuarios);
	}

	@PutMapping("/usuarios/{id}")
	public ResponseEntity<Usuarios> updateUsuarios(@PathVariable(value = "id") Integer usuariosId,
			@Valid @RequestBody Usuarios usuariosDetails) throws ResourceNotFoundException {
		Usuarios usuarios = usuariosRepository.findById(usuariosId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuarios not found for this id :: " + usuariosId));
		
		usuarios.setUSERNAME(usuariosDetails.getUSERNAME());
		usuarios.setPASSWORD(usuariosDetails.getPASSWORD());	
		usuarios.setID_EMPLEADOS(usuariosDetails.getID_EMPLEADOS());
		usuarios.setID_ALUMNO(usuariosDetails.getID_ALUMNO());
		usuarios.setID_ROL(usuariosDetails.getID_ROL());
		usuarios.setESTADO(usuariosDetails.getESTADO());
		usuarios.setOBSERVACION(usuariosDetails.getOBSERVACION());
		
		final Usuarios updatedUsuarios = usuariosRepository.save(usuarios);
		return ResponseEntity.ok(updatedUsuarios);
	}

	@DeleteMapping("/usuarios/{id}")
	public Map<String, Boolean> deleteUsuarios(@PathVariable(value = "id") Integer usuariosId)
			throws ResourceNotFoundException {
		Usuarios usuarios = usuariosRepository.findById(usuariosId)
				.orElseThrow(() -> new ResourceNotFoundException("Usuarios not found for this id :: " + usuariosId));

		usuariosRepository.delete(usuarios);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	
}
