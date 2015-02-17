package pe.gob.oefa.efa.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "efa_efa")
public class Efa implements java.io.Serializable {

	private BigDecimal id;
	private String correo;
	private String departamento;
	private String direccion;
	private String distrito;
	private String fax;
	private String nivel;
	private String nombre;
	private String provincia;
	private String tapm;
	private String tapp;
	private String tcargo;
	private String telefono;
	private String tnombre;
	private String webi;
	private String celular;
	private Set<Responsable> responsables = new HashSet<Responsable>(0);
	
	private String flgactivo;
	
	public Efa() {
	}

	public Efa(BigDecimal id) {
		this.id = id;
	}

	public Efa(BigDecimal id, String correo, String departamento,
			String direccion, String distrito, String fax, String nivel,
			String nombre, String provincia, String tapm, String tapp,
			String tcargo, String telefono, String tnombre, String webi,String celular,
			Set<Responsable> responsables) {
		this.id = id;
		this.correo = correo;
		this.departamento = departamento;
		this.direccion = direccion;
		this.distrito = distrito;
		this.fax = fax;
		this.nivel = nivel;
		this.nombre = nombre;
		this.provincia = provincia;
		this.tapm = tapm;
		this.tapp = tapp;
		this.tcargo = tcargo;
		this.telefono = telefono;
		this.tnombre = tnombre;
		this.webi = webi;
		this.celular = celular;
		this.responsables = responsables;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	@Column
	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
	@Column
	public String getDepartamento() {
		return this.departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	@Column
	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Column
	public String getDistrito() {
		return this.distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	@Column
	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}
	@Column
	public String getNivel() {
		return this.nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	@Column
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column
	public String getProvincia() {
		return this.provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Column
	public String getTapm() {
		return this.tapm;
	}
	
	public void setTapm(String tapm) {
		this.tapm = tapm;
	}
	@Column
	public String getTapp() {
		return this.tapp;
	}
	
	public void setTapp(String tapp) {
		this.tapp = tapp;
	}
	@Column
	public String getTcargo() {
		return this.tcargo;
	}
	
	public void setTcargo(String tcargo) {
		this.tcargo = tcargo;
	}
	@Column
	public String getTelefono() {
		return this.telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Column
	public String getTnombre() {
		return this.tnombre;
	}
	
	public void setTnombre(String tnombre) {
		this.tnombre = tnombre;
	}
	@Column
	public String getWebi() {
		return this.webi;
	}
	
	public void setWebi(String webi) {
		this.webi = webi;
	}
	@Column
	public String getCelular() {
		return this.celular;
	}
	
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	@OneToMany(mappedBy = "efa")  	
	public Set<Responsable> getResponsables() {
		return this.responsables;
	}
	
	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}
	
	@Column
	public String getFlgactivo() {
		return flgactivo;
	}

	public void setFlgactivo(String flgactivo) {
		this.flgactivo = flgactivo;
	}
	
	

}
