package idat.edu.pe.repositorio;

import java.util.List;

import org.springframework.stereotype.Service;

import idat.edu.pe.modelo.AlumnosCursos;


public interface ICursosAlumnosService {
	List<AlumnosCursos> buscarCursoPorIdAlumno(int idAlumno);
}
