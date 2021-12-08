package idat.edu.pe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JacksonInject.Value;

import idat.edu.pe.modelo.Alumnos;
import idat.edu.pe.modelo.AlumnosCursos;
import idat.edu.pe.modelo.Cursos;
import idat.edu.pe.service.AlumnosCursosServicio;

@Controller
@RequestMapping("/alumnosCursos")
public class AlumnosCursosWebController {
	@Autowired
	private AlumnosCursosServicio servicio;
	
	@RequestMapping("/listarTodo")
	public String listarAlumnosCursos(Model model) {
		List<AlumnosCursos> listaAlumnosCursos = servicio.buscarTodo();		
		model.addAttribute("listaAlumnosCursos", listaAlumnosCursos);		
		return "/moduloAlumnosCursos/listarTodo";
	}
	
	/*@RequestMapping(value = "/listar/{id}")
	public ModelAndView listarTodo(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAlumnosCursos/listarTodo");
	    AlumnosCursos alumnosCursos = servicio.buscarPorID(id);
	    mav.addObject("alumnosCursos", alumnosCursos);
	    return mav;
	}*/


	
	/*@RequestMapping(value = {"/buscarCursosAlumno/{id}"}, method = RequestMethod.GET)
	public ModelAndView editarCurso(@PathVariable( name="id") int id) {
	    ModelAndView mav = new ModelAndView("/moduloAlumnosCursos/listarAlumnoCurso");	    
	   List<AlumnosCursos> AL = servicio.findByIDALUMNO(id);
	    mav.addObject("alumnoCursos", AL);
	    return mav;
	}*/
	@RequestMapping(value = {"/buscarCursosAlumno/{id}"}, method = RequestMethod.GET)
	public String listar(Model model,@PathVariable( value="id",required=false) Integer id) 
	{
		List<AlumnosCursos> listaAlumnosCursos=null;
		if(id!=null) 
		{
			 listaAlumnosCursos = servicio.findByIDALUMNO(id);	
		}else {
			 listaAlumnosCursos = servicio.buscarTodo();
		}
		model.addAttribute("alumnoCursos", listaAlumnosCursos);
		return ("/moduloAlumnosCursos/listarAlumnoCurso");
	}
	
}
	
