package idat.edu.pe.modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;

import idat.edu.pe.modelo.Empleados;

@Entity
@Table(name="empleados")
@XmlRootElement
@NamedQueries({@NamedQuery(name="Empleados.findAll", query = "SELECT e FROM Empleados e")
			,@NamedQuery(name = "Empleados.findByIdEmpleados", query = "SELECT e FROM Empleados e WHERE e.ID_EMPLEADOS = :ID_EMPLEADOS")
			,@NamedQuery(name = "Empleados.findByNombres", query = "SELECT e FROM Empleados e WHERE e.NOMBRES = :NOMBRES")
			,@NamedQuery(name = "Empleados.findByApellidos", query = "SELECT e FROM Empleados e WHERE e.APELLIDOS = :APELLIDOS")
			,@NamedQuery(name = "Empleados.findByDni", query = "SELECT e FROM Empleados e WHERE e.DNI = :DNI")
			,@NamedQuery(name = "Empleados.findByCorreo", query = "SELECT e FROM Empleados e WHERE e.CORREO = :CORREO")
			,@NamedQuery(name = "Empleados.findByTelefono", query = "SELECT e FROM Empleados e WHERE e.TELEFONO = :TELEFONO")
			,@NamedQuery(name = "Empleados.findByDireccion", query = "SELECT e FROM Empleados e WHERE e.DIRECCION = :DIRECCION")
			,@NamedQuery(name = "Empleados.findByEstado", query = "SELECT e FROM Empleados e WHERE e.ESTADO = :ESTADO")})
public class Empleados implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_EMPLEADOS")
	private Integer ID_EMPLEADOS;
	@Basic(optional = false)
    @Column(name = "NOMBRES")
    private String NOMBRES;
	@Basic(optional = false)
    @Column(name = "APELLIDOS")
    private String APELLIDOS;
	@Basic(optional = false)
    @Column(name = "DNI")
    private String DNI;
	@Basic(optional = false)
    @Column(name = "CORREO")
    private String CORREO;
	@Basic(optional = false)
    @Column(name = "TELEFONO")
    private String TELEFONO;
	@Basic(optional = false)
    @Column(name = "DIRECCION")
    private String DIRECCION;
	@Basic(optional = false)
    @Column(name = "ESTADO")
    private String ESTADO;
	@JoinColumn(name = "ID_CARGO", referencedColumnName="ID_CARGO")
    @ManyToOne(optional = false)
    private Cargo ID_CARGO;
	
	public Empleados() {

	}

	public Empleados(Integer iD_EMPLEADOS) {
		ID_EMPLEADOS = iD_EMPLEADOS;
	}

	public Empleados(Integer iD_EMPLEADOS, String nOMBRES, String aPELLIDOS, String dNI, String cORREO, String tELEFONO,
			String dIRECCION, String eSTADO) {
		ID_EMPLEADOS = iD_EMPLEADOS;
		NOMBRES = nOMBRES;
		APELLIDOS = aPELLIDOS;
		DNI = dNI;
		CORREO = cORREO;
		TELEFONO = tELEFONO;
		DIRECCION = dIRECCION;
		ESTADO = eSTADO;
	}

	public Integer getID_EMPLEADOS() {
		return ID_EMPLEADOS;
	}

	public void setID_EMPLEADOS(Integer iD_EMPLEADOS) {
		ID_EMPLEADOS = iD_EMPLEADOS;
	}

	public String getNOMBRES() {
		return NOMBRES;
	}

	public void setNOMBRES(String nOMBRES) {
		NOMBRES = nOMBRES;
	}

	public String getAPELLIDOS() {
		return APELLIDOS;
	}

	public void setAPELLIDOS(String aPELLIDOS) {
		APELLIDOS = aPELLIDOS;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getCORREO() {
		return CORREO;
	}

	public void setCORREO(String cORREO) {
		CORREO = cORREO;
	}

	public String getTELEFONO() {
		return TELEFONO;
	}

	public void setTELEFONO(String tELEFONO) {
		TELEFONO = tELEFONO;
	}

	public String getDIRECCION() {
		return DIRECCION;
	}

	public void setDIRECCION(String dIRECCION) {
		DIRECCION = dIRECCION;
	}

	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}

	public Cargo getID_CARGO() {
		return ID_CARGO;
	}

	public void setID_CARGO(Cargo iD_CARGO) {
		ID_CARGO = iD_CARGO;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ID_EMPLEADOS);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleados other = (Empleados) obj;
		return Objects.equals(ID_EMPLEADOS, other.ID_EMPLEADOS);
	}

	@Override
	public String toString() {
		return "Empleados [ID_EMPLEADOS=" + ID_EMPLEADOS + "]";
	}
	
	
	
	
	
	
	
	
	

}
