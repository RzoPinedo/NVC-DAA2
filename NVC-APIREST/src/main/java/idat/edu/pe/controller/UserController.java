/*package idat.edu.pe.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import idat.edu.pe.dto.ChangePasswordForm;
import idat.edu.pe.exception.CustomeFieldValidationException;
import idat.edu.pe.exception.UsernameOrIdNotFound;
import idat.edu.pe.modelo.Rol;
import idat.edu.pe.modelo.Usuarios;
import idat.edu.pe.repositorio.RolRepositorio;
import idat.edu.pe.service.UsuariosServicio;


@Controller
public class UserController {

	private final String TAB_FORM = "formTab";
	private final String TAB_LIST = "listTab";
	
	@Autowired
	UsuariosServicio usuarioServicio;
	
	@Autowired
	RolRepositorio rolRepositorio;
	
	@GetMapping({"/login"})
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/logout")
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		Rol userRole = rolRepositorio.findByName("USER");
		List<Rol> roles = Arrays.asList(userRole);
		
		model.addAttribute("signup",true);
		model.addAttribute("userForm", new Usuarios());
		model.addAttribute("roles",roles);
		return "user-form/user-signup";
	}
	
	@PostMapping("/signup")
	public String signupAction(@Valid @ModelAttribute("userForm")Usuarios user, BindingResult result, ModelMap model) {
		Rol userRole = rolRepositorio.findByName("USER");
		List<Rol> roles = Arrays.asList(userRole);
		model.addAttribute("userForm", user);
		model.addAttribute("roles",roles);
		model.addAttribute("signup",true);
		
		if(result.hasErrors()) {
			return "user-form/user-signup";
		}else {
			try {
				userService.createUser(user);
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
			}
		}
		return index();
	}
	
	private void baseAttributerForUserForm(Model model, Usuarios user,String activeTab) {
		model.addAttribute("userForm", user);
		model.addAttribute("userList", userService.getAllUsers());
		model.addAttribute("roles",roleRepository.findAll());
		model.addAttribute(activeTab,"active");
	}
	
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		baseAttributerForUserForm(model, new Usuarios(), TAB_LIST );
		return "user-form/user-view";
	}
	
	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm")Usuarios user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM);
		}else {
			try {
				userService.createUser(user);
				baseAttributerForUserForm(model, new Usuarios(), TAB_LIST );
				
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM );
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				baseAttributerForUserForm(model, user, TAB_FORM );
			}
		}
		return "user-form/user-view";
	}
	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name ="id")Integer id)throws Exception{
		Usuarios userToEdit = userService.getUserById(id);

		baseAttributerForUserForm(model, userToEdit, TAB_FORM );
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new ChangePasswordForm(id));
		
		return "user-form/user-view";
	}
	
	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm")Usuarios user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			baseAttributerForUserForm(model, user, TAB_FORM );
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new ChangePasswordForm(user.getID_USUARIOS()));
		}else {
			try {
				userService.updateUser(user);
				baseAttributerForUserForm(model, new Usuarios(), TAB_LIST );
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				
				baseAttributerForUserForm(model, user, TAB_FORM );
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getID_USUARIOS()));
			}
		}
		return "user-form/user-view";
		
	}
	
	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}
	
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")Integer id) {
		try {
			userService.deleteUser(id);
		} 
		catch (UsernameOrIdNotFound uoin) {
			model.addAttribute("listErrorMessage",uoin.getMessage());
		}
		return userForm(model);
	}
	
	@PostMapping("/editUser/changePassword")
	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
		try {
			if( errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

				throw new Exception(result);
			}
			userService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Success");
	}
	
}
*/

