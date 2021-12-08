package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.modelo.Cargo;
import idat.edu.pe.repositorio.CargoRepositorio;

@Service
@Transactional
public class CargoServicio {

	@Autowired
	private CargoRepositorio repositorio;
	
	public CargoServicio(){
		
	}
	
	public List<Cargo> buscarTodo(){
		return(List<Cargo>) repositorio.findAll();
	}
	
	public Cargo crear(Cargo cargo) {
		return repositorio.save(cargo);
	}
	
	public Cargo actualizar(Cargo cargoActualizar) {
		Cargo cargoActual = repositorio.findById(cargoActualizar.getID_CARGO()).get();
		cargoActual.setID_CARGO(cargoActualizar.getID_CARGO());
		cargoActual.setNOMBRE(cargoActualizar.getNOMBRE());
		cargoActual.setESTADO(cargoActualizar.getESTADO());

		
		Cargo empleadoActualizado = repositorio.save(cargoActual);
		return empleadoActualizado;
	}
	
	public Cargo buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
