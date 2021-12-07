package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import idat.edu.pe.modelo.Cargo;
import idat.edu.pe.repositorio.CargoRepositorio;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/rest/cargo")
public class CargoController {
	@Autowired
	private CargoRepositorio cargoRepositorio;
	
	@GetMapping("/cargo")
	public List<Cargo> getAllCargo(){
		return cargoRepositorio.findAll();
	}
}
