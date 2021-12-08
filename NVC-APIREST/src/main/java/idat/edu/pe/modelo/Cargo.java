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
@Table(name="cargo")
@XmlRootElement
@NamedQueries({@NamedQuery(name="Cargo.findAll", query = "SELECT c FROM Cargo c")
			,@NamedQuery(name = "Cargo.findByIdCargo", query = "SELECT c FROM Cargo c WHERE c.ID_CARGO = :ID_CARGO")
			,@NamedQuery(name = "Cargo.findByNombre", query = "SELECT c FROM Cargo c WHERE c.NOMBRE = :NOMBRE")
			,@NamedQuery(name = "Cargo.findByEstado", query = "SELECT c FROM Cargo c WHERE c.ESTADO = :ESTADO")})
public class Cargo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_CARGO")
	private Integer ID_CARGO;
	@Basic(optional = false)
    @Column(name = "NOMBRE")
    private String NOMBRE;
	@Basic(optional = false)
    @Column(name = "ESTADO")
    private String ESTADO;
	
	public Cargo() {

	}

	public Cargo(Integer iD_CARGO) {
		ID_CARGO = iD_CARGO;
	}

	public Cargo(Integer iD_CARGO, String nOMBRE, String eSTADO) {
		ID_CARGO = iD_CARGO;
		NOMBRE = nOMBRE;
		ESTADO = eSTADO;
	}

	public Integer getID_CARGO() {
		return ID_CARGO;
	}

	public void setID_CARGO(Integer iD_CARGO) {
		ID_CARGO = iD_CARGO;
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
		return Objects.hash(ID_CARGO);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cargo other = (Cargo) obj;
		return Objects.equals(ID_CARGO, other.ID_CARGO);
	}

	@Override
	public String toString() {
		return "Cargo [ID_CARGO=" + ID_CARGO + "]";
	}
	
	
	
	
	
	
	
	

}
