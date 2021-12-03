package idat.edu.pe.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({@NamedQuery(name="Alumnos.findAll", query= "SELECT a FROM Alumnos a")
			,@NamedQuery(name = "Alumnos.findByIdAlumno", query = "SELECT a FROM Alumnos a WHERE a.ID_ALUMNO = :ID_ALUMNO")
			,@NamedQuery(name = "Alumnos.findByNombres", query = "SELECT a FROM Alumnos a WHERE a.NOMBRES = :NOMBRES")
			,@NamedQuery(name = "Alumnos.findByApellidos", query = "SELECT a FROM Alumnos a WHERE a.APELLIDOS = :APELLIDOS")
			,@NamedQuery(name = "Alumnos.findByDni", query = "SELECT a FROM Alumnos a WHERE a.DNI = :DNI")
			,@NamedQuery(name = "Alumnos.findByCorreo", query = "SELECT a FROM Alumnos a WHERE a.CORREO = :CORREO")
			,@NamedQuery(name = "Alumnos.findByTelefono", query = "SELECT a FROM Alumnos a WHERE a.TELEFONO = :TELEFONO")
			,@NamedQuery(name = "Alumnos.findByDireccion", query = "SELECT a FROM Alumnos a WHERE a.DIRECCION = :DIRECCION")
			,@NamedQuery(name = "Alumnos.findByEstado", query = "SELECT a FROM Alumnos a WHERE a.ESTADO = :ESTADO")})

public class Alumnos  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ALUMNO")
    private Integer ID_ALUMNO;
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
    private Integer ESTADO;
	
	public Alumnos() {

	}

	public Alumnos(Integer iD_ALUMNO, String nOMBRES, String aPELLIDOS, String dNI, String cORREO, String tELEFONO,
			String dIRECCION, Integer eSTADO) {
		super();
		ID_ALUMNO = iD_ALUMNO;
		NOMBRES = nOMBRES;
		APELLIDOS = aPELLIDOS;
		DNI = dNI;
		CORREO = cORREO;
		TELEFONO = tELEFONO;
		DIRECCION = dIRECCION;
		ESTADO = eSTADO;
	}

	public Integer getID_ALUMNO() {
		return ID_ALUMNO;
	}

	public void setID_ALUMNO(Integer iD_ALUMNO) {
		ID_ALUMNO = iD_ALUMNO;
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

	public Integer getESTADO() {
		return ESTADO;
	}

	public void setESTADO(Integer eSTADO) {
		ESTADO = eSTADO;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(ID_ALUMNO);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumnos other = (Alumnos) obj;
		return Objects.equals(ID_ALUMNO, other.ID_ALUMNO);
	}


	@Override
	public String toString() {
		return "Alumnos [ID_ALUMNO=" + ID_ALUMNO + "]";
	}
	
	
}
