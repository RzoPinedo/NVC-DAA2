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

import idat.edu.pe.modelo.Rol;

@Entity
@Table(name="rol")
@XmlRootElement
@NamedQueries({@NamedQuery(name="Rol.findAll", query = "SELECT e FROM Rol e")
			,@NamedQuery(name = "Rol.findByIdRol", query = "SELECT e FROM Rol e WHERE e.ID_ROL = :ID_ROL")
			,@NamedQuery(name = "Rol.findByNombre", query = "SELECT e FROM Rol e WHERE e.NOMBRE= :NOMBRE")						
			,@NamedQuery(name = "Rol.findByEstado", query = "SELECT e FROM Rol e WHERE e.ESTADO = :ESTADO")	})

public class Rol implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_ROL")
	private Integer ID_ROL;
	@Basic(optional = false)
    @Column(name = "NOMBRE")
    private String NOMBRE;	
	@Basic(optional = false)
    @Column(name = "ESTADO")
    private String ESTADO;
	
	
	public Rol() {

	}

	public Rol(Integer iD_ROL) {
		ID_ROL = iD_ROL;
	}

	public Rol(Integer iD_ROL, String nOMBRE, String eSTADO) {
		ID_ROL = iD_ROL;
		NOMBRE = nOMBRE;				
		ESTADO = eSTADO;		
	}

	public Integer getID_ROL() {
		return ID_ROL;
	}

	public void setID_ROL(Integer iD_ROL) {
		ID_ROL = iD_ROL;
	}

	public String getNOMBRE() {
		return NOMBRE;
	}

	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}

	
	public String getESTADO() {
		return ESTADO;
	}

	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}	

	@Override
	public int hashCode() {
		return Objects.hash(ID_ROL);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rol other = (Rol) obj;
		return Objects.equals(ID_ROL, other.ID_ROL);
	}

	@Override
	public String toString() {
		return "Rol [ID_ROL=" + ID_ROL + "]";
	}
	
	
	
	
	
	
	
	
	

}
