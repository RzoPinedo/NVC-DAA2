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

import idat.edu.pe.modelo.Cursos;
import idat.edu.pe.modelo.Empleados;
import idat.edu.pe.service.CursosServicio;
import idat.edu.pe.service.EmpleadosServicio;



@Controller
@RequestMapping("/cursos")
public class CursosWebController {
	
	@Autowired
	private CursosServicio servicio;
	
	@Autowired
	private EmpleadosServicio Eservicio;
	
	@RequestMapping("/listarTodo")
	public String listarCursos(Model model) {
		List<Cursos> listaCursos = servicio.buscarTodo();
		model.addAttribute("listaCursos", listaCursos);
		
		return "/moduloCursos/listarTodo";
	}
	
	@RequestMapping("/nuevo")
	public String nuevoCurso(Model model) {
		Cursos cursos = new Cursos();
		List<Empleados> listEmpleados = Eservicio.buscarTodo();
		model.addAttribute("cursos", cursos);
		model.addAttribute("empleados", listEmpleados);
		return "/moduloCursos/nuevoCurso";
	}
	
	@RequestMapping(value = "/guardar" , method = RequestMethod.POST)
	public String crearCurso(@ModelAttribute("cursos") Cursos cursos) {
		 servicio.crear(cursos);
	    return "redirect:/cursos/listarTodo";
	}
	
	@RequestMapping(value = "/actualizar/{id}")
	public ModelAndView editarCurso(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloCursos/editarCurso");
	    Cursos cursos = servicio.buscarPorID(id);
	    mav.addObject("cursos", cursos);
	    return mav;
	}
	
	@RequestMapping(value = "/eliminar/{id}")
	public String eliminarCurso(@PathVariable(name = "id") int id) {
		servicio.borrarPorID(id);
	    return "redirect:/cursos/listarTodo";       
	}

}
