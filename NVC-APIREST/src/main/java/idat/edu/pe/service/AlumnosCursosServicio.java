package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.modelo.Alumnos;
import idat.edu.pe.modelo.AlumnosCursos;
import idat.edu.pe.modelo.Cursos;
import idat.edu.pe.repositorio.AlumnosCursosRepositorio;

@Service
@Transactional
public class AlumnosCursosServicio implements BusquedaService{
	@Autowired
	AlumnosCursosRepositorio repositorio;
	
	public AlumnosCursosServicio(){		
	}
	
	public List<AlumnosCursos> buscarTodo(){
		return(List<AlumnosCursos>) repositorio.findAll();
	}
	
	public AlumnosCursos buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	@Override
	public List<AlumnosCursos> findByIDALUMNO(Integer IDALUMNO)
	{
		return(List<AlumnosCursos>) repositorio.findByIDALUMNO(IDALUMNO);
	}	

}
