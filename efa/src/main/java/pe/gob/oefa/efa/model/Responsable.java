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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "efa_responsable")
public class Responsable implements java.io.Serializable {

	private BigDecimal idresponsable;
	private Efa efa;
	private String sector;
	private String appaterno;
	private String apmaterno;
	private String nombre;
	private String cargo;
	private Date fecha;
	private String correo;
	private String telefono;
	private String fax;
	private String direccion;
	private String tipo;
	private String celular;
	private Set<Actividad> actividades = new HashSet<Actividad>(0);
	
	public Responsable() {
	}

	public Responsable(BigDecimal idresponsable) {
		this.idresponsable = idresponsable;
	}

	public Responsable(BigDecimal idresponsable, Efa efa, String sector,
			String appaterno, String apmaterno, String nombre, String cargo,
			Date fecha, String correo, String telefono, String fax,
			String direccion,String tipo,String celular, Set<Actividad> actividades) {
		this.idresponsable = idresponsable;
		this.efa = efa;
		this.sector = sector;
		this.appaterno = appaterno;
		this.apmaterno = apmaterno;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fecha = fecha;
		this.correo = correo;
		this.telefono = telefono;
		this.fax = fax;
		this.direccion = direccion;
		this.tipo = tipo;
		this.actividades = actividades;
		this.celular = celular;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDRESPONSABLE")
	public BigDecimal getIdresponsable() {
		return this.idresponsable;
	}

	public void setIdresponsable(BigDecimal idresponsable) {
		this.idresponsable = idresponsable;
	}
	@ManyToOne  
	@JoinColumn(name = "IDEFA")  
	public Efa getEfa() {
		return this.efa;
	}

	public void setEfa(Efa efa) {
		this.efa = efa;
	}
//	@NotEmpty
	@Column
	public String getSector() {
		return this.sector;
	}

	public void setSector(String sector) {
		this.sector = sector.toUpperCase();
	}
	@Column
	public String getAppaterno() {
		return this.appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno.toUpperCase();
	}
	@Column
	public String getApmaterno() {
		return this.apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno.toUpperCase();
	}
	@Column
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}
	@Column
	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column
	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Column
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Column
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Column
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	@Column
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Column
	public String getTipo() {
		return this.tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column
	public String getCelular() {
		return this.celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "responsables")
	public Set<Actividad> getActividades() {
		return this.actividades;
	}
 
	public void setActividades(Set<Actividad> actividades) {
		this.actividades = actividades;
	}

}
