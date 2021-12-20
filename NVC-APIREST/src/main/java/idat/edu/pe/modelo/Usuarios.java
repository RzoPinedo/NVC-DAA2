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

import idat.edu.pe.modelo.Usuarios;

@Entity
@Table(name="usuarios")
@XmlRootElement
@NamedQueries({@NamedQuery(name="Usuarios.findAll", query = "SELECT e FROM Usuarios e")
			,@NamedQuery(name = "Usuarios.findByIdUsuarios", query = "SELECT e FROM Usuarios e WHERE e.ID_USUARIOS = :ID_USUARIOS")
			,@NamedQuery(name = "Usuarios.findByUsername", query = "SELECT e FROM Usuarios e WHERE e.USERNAME= :USERNAME")
			,@NamedQuery(name = "Usuarios.findByPassword", query = "SELECT e FROM Usuarios e WHERE e.PASSWORD = :PASSWORD")			
			,@NamedQuery(name = "Usuarios.findByEstado", query = "SELECT e FROM Usuarios e WHERE e.ESTADO = :ESTADO")
			,@NamedQuery(name = "Usuarios.findByObservacion", query = "SELECT e FROM Usuarios e WHERE e.OBSERVACION = :OBSERVACION")})
public class Usuarios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_USUARIOS")
	private Integer ID_USUARIOS;
	@Basic(optional = false)
    @Column(name = "USERNAME")
    private String USERNAME;
	@Basic(optional = false)
    @Column(name = "PASSWORD")
    private String PASSWORD;
	@JoinColumn(name = "ID_EMPLEADOS", referencedColumnName="ID_EMPLEADOS")
    @ManyToOne(optional = false)
    private Empleados ID_EMPLEADOS;
	@JoinColumn(name = "ID_ALUMNO", referencedColumnName="ID_ALUMNO")
    @ManyToOne(optional = false)
    private Alumnos ID_ALUMNO;
	@JoinColumn(name = "ID_ROL", referencedColumnName="ID_ROL")
    @ManyToOne(optional = false)
    private Rol ID_ROL;
	@Basic(optional = false)
    @Column(name = "ESTADO")
    private String ESTADO;
	@Basic(optional = false)
    @Column(name = "OBSERVACION")
    private String OBSERVACION;
	
	
	public Usuarios() {

	}

	public Usuarios(Integer iD_USUARIOS) {
		ID_USUARIOS = iD_USUARIOS;
	}

	public Usuarios(Integer iD_USUARIOS, String uSERNAME, String pASSWORD, String eSTADO, String oBSERVACION) {
		ID_USUARIOS = iD_USUARIOS;
		USERNAME = uSERNAME;
		PASSWORD = pASSWORD;		
		ESTADO = eSTADO;
		OBSERVACION = oBSERVACION;
	}

	public Integer getID_USUARIOS() {
		return ID_USUARIOS;
	}

	public void setID_USUARIOS(Integer iD_USUARIOS) {
		ID_USUARIOS = iD_USUARIOS;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	
	public Empleados getID_EMPLEADOS() {
		return ID_EMPLEADOS;
	}

	public void setID_EMPLEADOS(Empleados iD_EMPLEADOS) {
		ID_EMPLEADOS = iD_EMPLEADOS;
	}
	
	public Alumnos getID_ALUMNO() {
		return ID_ALUMNO;
	}

	public void setID_ALUMNO(Alumnos iD_ALUMNO) {
		ID_ALUMNO = iD_ALUMNO;
	}
	
	public Rol getID_ROL() {
		return ID_ROL;
	}

	public void setID_ROL(Rol iD_ROL) {
		ID_ROL = iD_ROL;
	}
	
	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}
	
	public String getOBSERVACION() {
		return OBSERVACION;
	}

	public void setOBSERVACION(String oBSERVACION) {
		OBSERVACION = oBSERVACION;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(ID_USUARIOS);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuarios other = (Usuarios) obj;
		return Objects.equals(ID_USUARIOS, other.ID_USUARIOS);
	}

	@Override
	public String toString() {
		return "Usuarios [ID_USUARIOS=" + ID_USUARIOS + "]";
	}
	
	
	
	
	
	
	
	
	

}
