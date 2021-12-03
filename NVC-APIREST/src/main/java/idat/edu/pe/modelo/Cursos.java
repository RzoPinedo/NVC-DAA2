package idat.edu.pe.modelo;


import java.io.Serializable;
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



@Entity
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({@NamedQuery(name= "Cursos.findAll", query= "SELECT c FROM Cursos c")
			,@NamedQuery(name = "Cursos.findByIdCursos", query = "SELECT c FROM Cursos c WHERE c.ID_CURSOS = :ID_CURSOS")
			,@NamedQuery(name = "Cursos.findByNombre", query = "SELECT c FROM Cursos c WHERE c.NOMBRE = :NOMBRE")
			,@NamedQuery(name = "Cursos.findByNroHoras", query = "SELECT c FROM Cursos c WHERE c.NRO_HORAS = :NRO_HORAS")
			,@NamedQuery(name = "Cursos.findByFechaInicio", query = "SELECT c FROM Cursos c WHERE c.FECHA_INICIO = :FECHA_INICIO")
			,@NamedQuery(name = "Cursos.findByFechaFin", query = "SELECT c FROM Cursos c WHERE c.FECHA_FIN = :FECHA_FIN")
			,@NamedQuery(name = "Cursos.findByPrecioCurso", query = "SELECT c FROM Cursos c WHERE c.PRECIO_CURSO = :PRECIO_CURSO")
			,@NamedQuery(name = "Cursos.findByEstado", query = "SELECT c FROM Cursos c WHERE c.ESTADO = :ESTADO")})
public class Cursos implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CURSOS")
    private Integer ID_CURSOS;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String NOMBRE;
    @Basic(optional = false)
    @Column(name = "NRO_HORAS")
    private Integer NRO_HORAS;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    private String FECHA_INICIO;
    @Basic(optional = false)
    @Column(name = "FECHA_FIN")
    private String FECHA_FIN;
    @Basic(optional = false)
    @Column(name = "PRECIO_CURSO")
    private Integer PRECIO_CURSO;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String ESTADO;
    @JoinColumn(name = "ID_EMPLEADOS", referencedColumnName="ID_EMPLEADOS")
    @ManyToOne(optional = false)
    private Empleados ID_EMPLEADOS;
    
    
    
	public Cursos() {

	}


	public Cursos(Integer iD_CURSOS) {
		ID_CURSOS = iD_CURSOS;
	}


	public Cursos(Integer iD_CURSOS, String nOMBRE, Integer nRO_HORAS, String fECHA_INICIO, String fECHA_FIN,
			Integer pRECIO_CURSO, String eSTADO) {
		ID_CURSOS = iD_CURSOS;
		NOMBRE = nOMBRE;
		NRO_HORAS = nRO_HORAS;
		FECHA_INICIO = fECHA_INICIO;
		FECHA_FIN = fECHA_FIN;
		PRECIO_CURSO = pRECIO_CURSO;
		ESTADO = eSTADO;
	}


	public Integer getID_CURSOS() {
		return ID_CURSOS;
	}


	public void setID_CURSOS(Integer iD_CURSOS) {
		ID_CURSOS = iD_CURSOS;
	}


	public String getNOMBRE() {
		return NOMBRE;
	}


	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}


	public Integer getNRO_HORAS() {
		return NRO_HORAS;
	}


	public void setNRO_HORAS(Integer nRO_HORAS) {
		NRO_HORAS = nRO_HORAS;
	}


	public String getFECHA_INICIO() {
		return FECHA_INICIO;
	}


	public void setFECHA_INICIO(String fECHA_INICIO) {
		FECHA_INICIO = fECHA_INICIO;
	}


	public String getFECHA_FIN() {
		return FECHA_FIN;
	}


	public void setFECHA_FIN(String fECHA_FIN) {
		FECHA_FIN = fECHA_FIN;
	}


	public Integer getPRECIO_CURSO() {
		return PRECIO_CURSO;
	}


	public void setPRECIO_CURSO(Integer pRECIO_CURSO) {
		PRECIO_CURSO = pRECIO_CURSO;
	}


	public String getESTADO() {
		return ESTADO;
	}


	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}


	public Empleados getID_EMPLEADOS() {
		return ID_EMPLEADOS;
	}


	public void setID_EMPLEADOS(Empleados iD_EMPLEADOS) {
		ID_EMPLEADOS = iD_EMPLEADOS;
	}


	@Override
	public int hashCode() {
		return Objects.hash(ID_CURSOS);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cursos other = (Cursos) obj;
		return Objects.equals(ID_CURSOS, other.ID_CURSOS);
	}


	@Override
	public String toString() {
		return "Cursos [ID_CURSOS=" + ID_CURSOS + "]";
	}
	
	
	
    
    
    
	
	
	
    
    



}
