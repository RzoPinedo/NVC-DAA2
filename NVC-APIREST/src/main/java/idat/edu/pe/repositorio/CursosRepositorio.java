package idat.edu.pe.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import idat.edu.pe.modelo.Cursos;



public interface CursosRepositorio extends CrudRepository<Cursos, Integer> {
	
	@Query(value = "SELECT c FROM Cursos c WHERE c.NOMBRE = ?1")
	public List<Cursos> buscarCursosPorNombre(String NOMBRE);

	@Query(value = "SELECT c FROM Cursos c WHERE c.NOMBRE like CONCAT(?1, '%')")
	public List<Cursos> buscarCursosLikeNombre(String NOMBRE);

}
