package idat.edu.pe.repositorio;

import java.util.List;

import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

import idat.edu.pe.modelo.AlumnosCursos;

@Repository
public interface ICursosAlumnosDAO extends JpaAttributeConverter<AlumnosCursos, Integer>{
	List<AlumnosCursos> findByIdID_ALUMNO(int idAlumno);
}
