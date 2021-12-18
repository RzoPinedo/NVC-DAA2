package idat.edu.pe.modelo;

import java.util.List;

public class CarritoCompraCursos {
    private String Nombres;
    private String Apellidos;
    private String Dni;
    private String Correo;
    private String Telefono;
    private String Direccion;
    private List<Integer> Cursos;
    
	public CarritoCompraCursos() {
		
	}
	public String getNombres() {
		return Nombres;
	}
	public void setNombres(String nombres) {
		Nombres = nombres;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getDni() {
		return Dni;
	}
	public void setDni(String dni) {
		Dni = dni;
	}
	public String getCorreo() {
		return Correo;
	}
	public void setCorreo(String correo) {
		Correo = correo;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public List<Integer> getCursos() {
		return Cursos;
	}
	public void setCursos(List<Integer> cursos) {
		Cursos = cursos;
	}
    
}

