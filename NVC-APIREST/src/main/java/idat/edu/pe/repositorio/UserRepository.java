package idat.edu.pe.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import idat.edu.pe.modelo.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public Optional<User> findByUsername(String username);
 }
