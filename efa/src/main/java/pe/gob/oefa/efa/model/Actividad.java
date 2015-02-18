package pe.gob.oefa.efa.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;
import javax.persistence.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "efa_actividad")
public class Actividad implements java.io.Serializable {

	private BigDecimal id;
	private String nivel;
	private String departamento;
	private String departamentodes;
	private String provincia;
	private String provinciades;
	private String distrito;
	private String distritodes;
	private String tipo;
	private String analitica;
	private String descripcion;
	private String suelo;
	private String aire;
	private String agua;
	private String efluentes;
	private BigDecimal idefa;
	private Date fechaini;
	private Date fechafin;
	private String horaini;
	private String horafin;	
	private String estado;	
	private String supervision;	
	private String hallazgo;	
	private String codactividad;	
	private String estadomatriz;	
	private String estadoejec;		
	private BigDecimal idsupres;	
	private Set<Responsable> responsables = new HashSet<Responsable>(0);
	private Set<Supervisor> supervisores = new HashSet<Supervisor> (0);
	
	private String flgactivo;
	private String usuario;
	private String perfil;


	

	public Actividad() {
	}

	public Actividad(BigDecimal id) {
		this.id = id;
	}

	public Actividad(BigDecimal id, String nivel, String departamento,String departamentodes,
			String provincia, String provinciades, String distrito, String distritodes, String tipo, String analitica,
			String descripcion, String suelo, String aire,
			String agua, String efluentes, BigDecimal idefa,
			Date fechaini, Date fechafin, String horaini, String horafin, String estado, String supervision, String hallazgo, String codactividad, String estadomatriz, String estadoejec
			, BigDecimal idsupres,
			Set<Responsable> responsables, Set<Supervisor> supervisores) {
		this.id = id;
		this.nivel = nivel;
		this.departamento = departamento;
		this.departamentodes = departamentodes;
		this.provincia = provincia;
		this.provinciades = provinciades;
		this.distrito = distrito;
		this.distritodes = distritodes;
		this.tipo = tipo;
		this.analitica = analitica;
		this.descripcion = descripcion;
		this.suelo = suelo;
		this.aire = aire;
		this.agua = agua;
		this.efluentes = efluentes;
		this.idefa = idefa;
		this.fechaini = fechaini;
		this.fechafin = fechafin;
		this.horaini = horaini;
		this.horafin = horafin;
		this.idsupres = idsupres;
		this.estado = estado;
		this.supervision = supervision;
		this.hallazgo = hallazgo;
		this.codactividad = codactividad;
		this.estadomatriz = estadomatriz;
		this.estadoejec = estadoejec;		
		this.responsables = responsables;
		this.supervisores = supervisores;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDACTIVIDAD")
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	@Column
	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	@Column
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	@Column
	public String getDepartamentodes() {
		return this.departamentodes;
	}

	public void setDepartamentodes(String departamentodes) {
		this.departamentodes = departamentodes;
	}	
	@Column
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Column
	public String getProvinciades() {
		return this.provinciades;
	}

	public void setProvinciades(String provinciades) {
		this.provinciades = provinciades;
	}	
	@Column
	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	@Column
	public String getDistritodes() {
		return this.distritodes;
	}

	public void setDistritodes(String distritodes) {
		this.distritodes = distritodes;
	}	
	@Column
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column
	public String getAnalitica() {
		return this.analitica;
	}

	public void setAnalitica(String analitica) {
		this.analitica = analitica;
	}
	@Column
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Column
	public String getSuelo() {
		return this.suelo;
	}

	public void setSuelo(String suelo) {
		this.suelo = suelo;
	}
	@Column
	public String getAire() {
		return this.aire;
	}

	public void setAire(String aire) {
		this.aire = aire;
	}
	@Column
	public String getAgua() {
		return this.agua;
	}

	public void setAgua(String agua) {
		this.agua = agua;
	}
	@Column
	public String getEfluentes() {
		return this.efluentes;
	}

	public void setEfluentes(String efluentes) {
		this.efluentes = efluentes;
	}
	@Column
	public BigDecimal getIdefa() {
		return this.idefa;
	}

	public void setIdefa(BigDecimal idefa) {
		this.idefa = idefa;
	}
	@Column
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	public Date getFechaini() {
		return this.fechaini;
	}

	public void setFechaini(Date fechaini) {
		this.fechaini = fechaini;
	}
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	public Date getFechafin() {
		return this.fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}
	@Column
	public String getHoraini() {
		return this.horaini;
	}

	public void setHoraini(String horaini) {
		this.horaini = horaini;
	}
	@Column
	public String getHorafin() {
		return this.horafin;
	}

	public void setHorafin(String horafin) {
		this.horafin = horafin;
	}
	@Column
	public BigDecimal getIdsupres() {
		return this.idsupres;
	}

	public void setIdsupres(BigDecimal idsupres) {
		this.idsupres = idsupres;
	}	
	@Column
	public String getSupervision() {
		return this.supervision;
	}
	public void setSupervision(String supervision) {
		this.supervision = supervision;
	}	
	
	@Column
	public String getHallazgo() {
		return this.hallazgo;
	}
	public void setHallazgo(String hallazgo) {
		this.hallazgo = hallazgo;
	}		
	
	@Column
	public String getCodactividad() {
		return this.codactividad;
	}

	public void setCodactividad(String codactividad) {
		this.codactividad = codactividad;
	}	
	
	@Column
	public String getEstadomatriz() {
		return this.estadomatriz;
	}

	public void setEstadomatriz(String estadomatriz) {
		this.estadomatriz = estadomatriz;
	}		
	
	@Column
	public String getEstadoejec() {
		return this.estadoejec;
	}

	public void setEstadoejec(String estadoejec) {
		this.estadoejec = estadoejec;
	}		
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinTable(name = "efa_actividad_responsable", joinColumns = { 
			@JoinColumn(name = "IDACTIVIDAD", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "IDRESPONSABLE", 
					nullable = false, updatable = false) })
	public Set<Responsable> getResponsables() {
		return this.responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}
	
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@Cascade({CascadeType.SAVE_UPDATE})
	@JoinTable(name = "efa_actividad_supervisor", joinColumns = { 
			@JoinColumn(name = "IDACTIVIDAD", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "IDSUPERVISOR", 
					nullable = false, updatable = false) })
	public Set<Supervisor> getSupervisores() {
		return this.supervisores;
	}

	public void setSupervisores(Set<Supervisor> supervisores) {
		this.supervisores = supervisores;
	}

	
	@Column
	public String getFlgactivo() {
		return flgactivo;
	}

	public void setFlgactivo(String flgactivo) {
		this.flgactivo = flgactivo;
	}
	
	@Column
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	@Column
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	
	
	
}
