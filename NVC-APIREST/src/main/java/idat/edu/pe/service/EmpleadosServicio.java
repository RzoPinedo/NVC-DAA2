package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.modelo.Empleados;
import idat.edu.pe.repositorio.EmpleadosRepositorio;



@Service
@Transactional
public class EmpleadosServicio {
	
	@Autowired
	private EmpleadosRepositorio repositorio;
	
	public EmpleadosServicio(){
		
	}
	
	public List<Empleados> buscarTodo(){
		return(List<Empleados>) repositorio.findAll();
	}
	
	public Empleados crear(Empleados empleados) {
		return repositorio.save(empleados);
	}
	
	public Empleados actualizar(Empleados empleadosActualizar) {
		Empleados empleadoActual = repositorio.findById(empleadosActualizar.getID_EMPLEADOS()).get();
		empleadoActual.setID_EMPLEADOS(empleadosActualizar.getID_EMPLEADOS());
		empleadoActual.setNOMBRES(empleadosActualizar.getNOMBRES());
		empleadoActual.setAPELLIDOS(empleadosActualizar.getAPELLIDOS());
		empleadoActual.setDNI(empleadosActualizar.getDNI());
		empleadoActual.setCORREO(empleadosActualizar.getCORREO());
		empleadoActual.setTELEFONO(empleadosActualizar.getTELEFONO());
		empleadoActual.setDIRECCION(empleadosActualizar.getDIRECCION());
		empleadoActual.setESTADO(empleadosActualizar.getESTADO());
		empleadoActual.setID_CARGO(empleadosActualizar.getID_CARGO());
		
		Empleados empleadoActualizado = repositorio.save(empleadoActual);
		return empleadoActualizado;
	}
	
	public Empleados buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
