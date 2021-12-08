package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.modelo.Cursos;
import idat.edu.pe.repositorio.CursosRepositorio;


@Service
@Transactional
public class CursosServicio {
	@Autowired
	private CursosRepositorio repositorio;
	
	public CursosServicio(){
		
	}
	
	public List<Cursos> buscarTodo(){
		return(List<Cursos>) repositorio.findAll();
	}
	
	public Cursos crear(Cursos cursos) {
		return repositorio.save(cursos);
	}
	
	public Cursos actualizar(Cursos cursosActualizar) {
		Cursos cursoActual = repositorio.findById(cursosActualizar.getID_CURSOS()).get();
		cursoActual.setID_CURSOS(cursosActualizar.getID_CURSOS());
		cursoActual.setNOMBRE(cursosActualizar.getNOMBRE());
		cursoActual.setNRO_HORAS(cursosActualizar.getNRO_HORAS());
		cursoActual.setFECHA_INICIO(cursosActualizar.getFECHA_INICIO());
		cursoActual.setFECHA_FIN(cursosActualizar.getFECHA_FIN());
		cursoActual.setPRECIO_CURSO(cursosActualizar.getPRECIO_CURSO());
		cursoActual.setESTADO(cursosActualizar.getESTADO());
		cursoActual.setID_EMPLEADOS(cursosActualizar.getID_EMPLEADOS());
		
		Cursos cursoActualizado = repositorio.save(cursoActual);
		return cursoActualizado;
	}
	
	public Cursos buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
