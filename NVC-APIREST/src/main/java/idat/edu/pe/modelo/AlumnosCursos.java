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
@Table(name = "alumno_cursos")
@XmlRootElement
@NamedQueries({@NamedQuery(name="AlumnosCursos.findAll", query= "SELECT c FROM AlumnosCursos c")
			,@NamedQuery(name = "AlumnosCursos.findByIdAlumnosCusos", query = "SELECT c FROM AlumnosCursos c WHERE c.ID_ALUMNO_CURSOS = :ID_ALUMNO_CURSOS")				
			,@NamedQuery(name = "AlumnosCursos.findByEstado", query = "SELECT c FROM AlumnosCursos c WHERE c.ESTADO = :ESTADO")})
public class AlumnosCursos implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ALUMNO_CURSOS")
    private Integer ID_ALUMNO_CURSOS;
		 @JoinColumn(name = "ID_CURSOS", referencedColumnName="ID_CURSOS")
		 @ManyToOne(optional = false)
		 private Cursos ID_CURSOS;
		 @JoinColumn(name = "ID_ALUMNO", referencedColumnName="ID_ALUMNO")
		 @ManyToOne(optional = false)		 
		 private Alumnos IDALUMNO;
	@Basic(optional = false)
	@Column(name = "ESTADO")
	private String ESTADO;
	   
		public AlumnosCursos() {

		}
		
		public AlumnosCursos(Integer iD_ALUMNO_CURSOS) {
			super();
			ID_ALUMNO_CURSOS = iD_ALUMNO_CURSOS;
		}


		
		public AlumnosCursos(Integer iD_ALUMNO_CURSOS, String eSTADO) {
			super();
			ID_ALUMNO_CURSOS = iD_ALUMNO_CURSOS;
			ESTADO = eSTADO;
		}
		

		public Integer getID_ALUMNO_CURSOS() {
			return ID_ALUMNO_CURSOS;
		}


		public void setID_ALUMNO_CURSOS(Integer iD_ALUMNO_CURSOS) {
			ID_ALUMNO_CURSOS = iD_ALUMNO_CURSOS;
		}


		public Cursos getID_CURSOS() {
			return ID_CURSOS;
		}


		public void setID_CURSOS(Cursos iD_CURSOS) {
			ID_CURSOS = iD_CURSOS;
		}


		public Alumnos getIDALUMNO() {
			return IDALUMNO;
		}


		public void setIDALUMNO(Alumnos iDALUMNO) {
			IDALUMNO = iDALUMNO;
		}


		public String getESTADO() {
			return ESTADO;
		}


		public void setESTADO(String eSTADO) {
			ESTADO = eSTADO;
		}


		@Override
		public int hashCode() {
			return Objects.hash(ID_ALUMNO_CURSOS);
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AlumnosCursos other = (AlumnosCursos) obj;
			return Objects.equals(ID_ALUMNO_CURSOS, other.ID_ALUMNO_CURSOS);
		}


		@Override
		public String toString() {
			return "AlumnosCursos [ID_ALUMNO_CURSOS=" + ID_ALUMNO_CURSOS + "]";
		}
		

}
