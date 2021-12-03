package idat.edu.pe.repositorio;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import idat.edu.pe.modelo.Alumnos;
import idat.edu.pe.modelo.AlumnosCursos;
import idat.edu.pe.modelo.Cursos;

public interface AlumnosCursosRepositorio extends CrudRepository<AlumnosCursos, Integer> {
	/*@Query(value = "SELECT c FROM alumnos_cursos c WHERE c.ID_ALUMNO_CURSOS = ?1")
	public List<AlumnosCursos> buscarCursosPorId(int ID_ALUMNO_CURSOS);

	@Query(value = "SELECT c FROM alumnos_cursos c WHERE c.ID_ALUMNO_CURSOS like CONCAT(?1, '%')")
	public List<AlumnosCursos> buscarCursosLikeId(int ID_ALUMNO_CURSOS);*/
	
	/*public List<AlumnosCursos> findByiD_ALUMNO(Integer ID_ALUMNO);*/	
	public abstract List<AlumnosCursos> findByIDALUMNO( Integer IDALUMNO);
}
