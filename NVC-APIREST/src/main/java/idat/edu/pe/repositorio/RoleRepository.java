package idat.edu.pe.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.modelo.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer>{

	public Role findByName(String role);
}
