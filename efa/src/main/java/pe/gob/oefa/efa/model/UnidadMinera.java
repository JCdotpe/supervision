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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "tunidadminera")
public class UnidadMinera implements java.io.Serializable {
	
	private BigDecimal idunidadminera;
	private Administrado administrado;
	private String sector;
	private String actividad;
	private String categoria;
	private String tipodm;
	private String nombredm;
	private String codinacc;
	private String departamento;
	private String departamentodes;
	private String provincia;
	private String provinciades;
	private String distrito;
	private String distritodes;
	private String cuenca;
	private String direccion;
	private String estado;	
	private String norte;	
	private String este;	
	private String zona;	
	private String direccionunidad;	
	private String nombreunidad;
	private String flgactivo;

	public UnidadMinera() {
	}

	public UnidadMinera(BigDecimal idunidadminera) {
		this.idunidadminera = idunidadminera;
	}

	public UnidadMinera(BigDecimal idunidadminera, Administrado administrado, String sector,
			String actividad, String categoria, String tipodm, String nombredm,
			String codinacc, String departamento, String departamentodes, String provincia,
			String provinciades, String distrito, String distritodes, String cuenca,
			String direccion, String estado, String norte, String este, String zona, String direccionunidad,
			String nombreunidad, String flgactivo) {
		this.idunidadminera = idunidadminera;
		this.administrado = administrado;
		this.sector = sector;
		this.actividad = actividad;
		this.categoria = categoria;
		this.tipodm = tipodm;
		this.nombredm = nombredm;
		this.codinacc = codinacc;
		this.departamento = departamento;
		this.departamentodes = departamentodes;
		this.provincia = provincia;
		this.provinciades = provinciades;
		this.distrito = distrito;
		this.distritodes = distritodes;
		this.cuenca = cuenca;
		this.direccion = direccion;
		this.estado = estado;
		this.norte = norte;
		this.este = este;
		this.zona = zona;
		this.direccionunidad = direccionunidad;
		this.nombreunidad = nombreunidad;
		this.flgactivo = flgactivo;
	}	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDUNIDADMINERA")
	public BigDecimal getIdunidadminera() {
		return idunidadminera;
	}
	public void setIdunidadminera(BigDecimal idunidadminera) {
		this.idunidadminera = idunidadminera;
	}
	@ManyToOne
	@JoinColumn(name = "IDADMINISTRADOS")  
	public Administrado getAdministrado() {
		return administrado;
	}
	public void setAdministrado(Administrado administrado) {
		this.administrado = administrado;
	}
	@Column	
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	@Column	
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	@Column	
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	@Column	
	public String getTipodm() {
		return tipodm;
	}
	public void setTipodm(String tipodm) {
		this.tipodm = tipodm;
	}
	@Column	
	public String getNombredm() {
		return nombredm;
	}
	public void setNombredm(String nombredm) {
		this.nombredm = nombredm;
	}
	@Column	
	public String getCodinacc() {
		return codinacc;
	}
	public void setCodinacc(String codinacc) {
		this.codinacc = codinacc;
	}
	@Column	
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	@Column	
	public String getDepartamentodes() {
		return departamentodes;
	}
	public void setDepartamentodes(String departamentodes) {
		this.departamentodes = departamentodes;
	}
	@Column	
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Column	
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	@Column	
	public String getProvinciades() {
		return provinciades;
	}
	public void setProvinciades(String provinciades) {
		this.provinciades = provinciades;
	}
	@Column	
	public String getDistritodes() {
		return distritodes;
	}
	public void setDistritodes(String distritodes) {
		this.distritodes = distritodes;
	}
	@Column	
	public String getCuenca() {
		return cuenca;
	}
	public void setCuenca(String cuenca) {
		this.cuenca = cuenca;
	}
	@Column	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Column	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Column	
	public String getNorte() {
		return norte;
	}
	public void setNorte(String norte) {
		this.norte = norte;
	}
	@Column	
	public String getEste() {
		return este;
	}
	public void setEste(String este) {
		this.este = este;
	}
	@Column	
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
	@Column	
	public String getDireccionunidad() {
		return direccionunidad;
	}
	public void setDireccionunidad(String direccionunidad) {
		this.direccionunidad = direccionunidad;
	}
	@Column	
	public String getNombreunidad() {
		return nombreunidad;
	}
	public void setNombreunidad(String nombreunidad) {
		this.nombreunidad = nombreunidad;
	}
	@Column
	public String getFlgactivo() {
		return flgactivo;
	}

	public void setFlgactivo(String flgactivo) {
		this.flgactivo = flgactivo;
	}
	
}
