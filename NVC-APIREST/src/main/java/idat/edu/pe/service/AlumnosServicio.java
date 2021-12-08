package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.modelo.Alumnos;
import idat.edu.pe.repositorio.AlumnosRepositorio;

@Service
@Transactional
public class AlumnosServicio {
	@Autowired
	private AlumnosRepositorio repositorio;
	
	public AlumnosServicio(){
		
	}
	
	public List<Alumnos> buscarTodo(){
		return(List<Alumnos>) repositorio.findAll();
	}
	
	public Alumnos crear(Alumnos alumnos) {
		return repositorio.save(alumnos);
	}
	
	public Alumnos actualizar(Alumnos alumnosActualizar) {
		Alumnos alumnosActual = repositorio.findById(alumnosActualizar.getID_ALUMNO()).get();
		alumnosActual.setID_ALUMNO(alumnosActual.getID_ALUMNO());
		alumnosActual.setNOMBRES(alumnosActual.getNOMBRES());
		alumnosActual.setAPELLIDOS(alumnosActual.getAPELLIDOS());
		alumnosActual.setDNI(alumnosActual.getDNI());
		alumnosActual.setCORREO(alumnosActual.getCORREO());
		alumnosActual.setTELEFONO(alumnosActual.getTELEFONO());
		alumnosActual.setDIRECCION(alumnosActual.getDIRECCION());
		alumnosActual.setESTADO(alumnosActual.getESTADO());
		
		Alumnos alumnosActualizado = repositorio.save(alumnosActual);
		return alumnosActualizado;
	}
	
	public Alumnos buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}
	

}
