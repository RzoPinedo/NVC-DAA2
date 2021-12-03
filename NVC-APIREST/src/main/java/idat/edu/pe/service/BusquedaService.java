package idat.edu.pe.service;

import java.util.List;

import idat.edu.pe.modelo.Alumnos;
import idat.edu.pe.modelo.AlumnosCursos;

public interface BusquedaService {
	public List<AlumnosCursos> findByIDALUMNO(Integer IDALUMNO);	
	
}
