package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import idat.edu.pe.modelo.Alumnos;
import idat.edu.pe.service.AlumnosServicio;

@Controller
@RequestMapping("/alumnos")
public class AlumnosWebController {
	@Autowired
	private AlumnosServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarAlumnos(Model model) {
		List<Alumnos> listaAlumnos = servicio.buscarTodo();
		model.addAttribute("listaAlumnos", listaAlumnos);
		
		return "/moduloAlumnos/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoAlumno(Model model) {
		Alumnos alumnos = new Alumnos();
		model.addAttribute("alumnos", alumnos);
		return "/moduloAlumnos/nuevoAlumno";
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearAlumno(@ModelAttribute("alumnos") Alumnos alumnos) {
		 servicio.crear(alumnos);
	    return "redirect:/alumnos/listarTodo";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarAlumno(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAlumnos/editarAlumno");
	    Alumnos alumnos = servicio.buscarPorID(id);
	    mav.addObject("alumnos", alumnos);
	    return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarAlumnos(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
	    return "redirect:/alumnos/listarTodo";       
	}
}
