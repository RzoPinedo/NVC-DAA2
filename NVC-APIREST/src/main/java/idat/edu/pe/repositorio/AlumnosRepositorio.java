package idat.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.modelo.Alumnos;

public interface AlumnosRepositorio extends CrudRepository<Alumnos, Integer>{
	@Query(value = "SELECT c FROM Alumnos c WHERE c.NOMBRES = ?1")
	public List<Alumnos> buscarCursosPorNombre(String NOMBRES);

	@Query(value = "SELECT c FROM Alumnos c WHERE c.NOMBRES like CONCAT(?1, '%')")
	public List<Alumnos> buscarCursosLikeNombre(String NOMBRES);
}
