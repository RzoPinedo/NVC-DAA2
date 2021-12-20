package idat.edu.pe.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.modelo.Rol;


@Repository
public interface RolRepositorio extends CrudRepository<Rol, Integer>{
	
}
