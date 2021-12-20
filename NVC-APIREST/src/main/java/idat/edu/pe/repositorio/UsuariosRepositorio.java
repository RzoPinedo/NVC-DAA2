package idat.edu.pe.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.modelo.Usuarios;



@Repository
public interface UsuariosRepositorio extends CrudRepository<Usuarios, Integer> {
	
 }
