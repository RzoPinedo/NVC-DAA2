package idat.edu.pe.service;

import javax.validation.Valid;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import idat.edu.pe.dto.ChangePasswordForm;
import idat.edu.pe.exception.UsernameOrIdNotFound;
import idat.edu.pe.modelo.User;


public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;

	public User getUserById(Integer id) throws Exception;
	
	public User updateUser(User user) throws Exception;
	
	public void deleteUser(Integer id) throws UsernameOrIdNotFound;
	
	public User changePassword(ChangePasswordForm form) throws Exception;
}
