package idat.edu.pe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.edu.pe.modelo.Usuarios;
import idat.edu.pe.repositorio.UsuariosRepositorio;



@Service
@Transactional
public class UsuariosServicio {
	
	@Autowired
	private UsuariosRepositorio repositorio;
	
	public UsuariosServicio(){
		
	}
	
	public List<Usuarios> buscarTodo(){
		return(List<Usuarios>) repositorio.findAll();
	}
	
	public Usuarios crear(Usuarios usuarios) {
		return repositorio.save(usuarios);
	}
	
	public Usuarios actualizar(Usuarios usuariosActualizar) {
		Usuarios usuariosActual = repositorio.findById(usuariosActualizar.getID_USUARIOS()).get();
		usuariosActual.setID_USUARIOS(usuariosActualizar.getID_USUARIOS());
		usuariosActual.setUSERNAME(usuariosActualizar.getUSERNAME());
		usuariosActual.setPASSWORD(usuariosActualizar.getPASSWORD());
		usuariosActual.setID_EMPLEADOS(usuariosActualizar.getID_EMPLEADOS());
		usuariosActual.setID_ALUMNO(usuariosActualizar.getID_ALUMNO());
		usuariosActual.setID_ROL(usuariosActualizar.getID_ROL());
		usuariosActual.setESTADO(usuariosActualizar.getESTADO());
		usuariosActual.setOBSERVACION(usuariosActualizar.getOBSERVACION());
		
		
		Usuarios usuariosActualizado = repositorio.save(usuariosActual);
		return usuariosActualizado;
	}
	
	public Usuarios buscarPorID(Integer id) {
		return repositorio.findById(id).get();
	}
	
	public void borrarPorID(Integer id) {
		repositorio.deleteById(id);
	}

}
