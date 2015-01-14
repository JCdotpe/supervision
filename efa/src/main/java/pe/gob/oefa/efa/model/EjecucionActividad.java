package pe.gob.oefa.efa.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tejecucion")
public class EjecucionActividad implements java.io.Serializable {

	private BigDecimal idejecucion;
	private Actividad actividad;
	private Date fechaejec;
	private String supespecial;
	private String hallazgos;
	private Date fecha;
	private String estado;
	private String observacion;
	private Set<EjecucionFile> ejecfiles = new HashSet<EjecucionFile>(0);
	
	public EjecucionActividad() {
	}

	public EjecucionActividad(BigDecimal idejecucion) {
		this.setIdejecucion(idejecucion);
	}

	public EjecucionActividad(BigDecimal idejecucion, Actividad actividad, Date fechaejec,
			String supespecial, String hallazgos, Date fecha, String estado,
			String observacion) {
		this.setIdejecucion(idejecucion);
		this.setActividad(actividad);
		this.setFechaejec(fechaejec);
		this.setSupespecial(supespecial);
		this.setHallazgos(hallazgos);
		this.setFecha(fecha);
		this.setEstado(estado);
		this.setObservacion(observacion);
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDEJECUCION")
	public BigDecimal getIdejecucion() {
		return idejecucion;
	}

	public void setIdejecucion(BigDecimal idejecucion) {
		this.idejecucion = idejecucion;
	}
	@ManyToOne  
	@JoinColumn(name = "IDACTIVIDAD")  
	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	public Date getFechaejec() {
		return fechaejec;
	}

	public void setFechaejec(Date fechaejec) {
		this.fechaejec = fechaejec;
	}
	@Column
	public String getSupespecial() {
		return supespecial;
	}

	public void setSupespecial(String supespecial) {
		this.supespecial = supespecial;
	}
	@Column
	public String getHallazgos() {
		return hallazgos;
	}

	public void setHallazgos(String hallazgos) {
		this.hallazgos = hallazgos;
	}
	@Column
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Column
	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	@OneToMany(mappedBy = "ejecucionActividad",fetch = FetchType.EAGER, cascade = CascadeType.ALL)  	
	public Set<EjecucionFile> getEjecfiles() {
		return ejecfiles;
	}

	public void setEjecfiles(Set<EjecucionFile> ejecfiles) {
		this.ejecfiles = ejecfiles;
	}

	

}
