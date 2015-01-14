package pe.gob.oefa.efa.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tadministrados")
public class Administrado implements java.io.Serializable {

	private BigDecimal idadministrados;
	private String tipopersona;
	private String ruc;
	private String razonsocial;
	private String tipodoc;
	private String numerodoc;
	private String nombres;
	private String appaterno;
	private String apmaterno;
	private String departamento;
	private String departamentodes;
	private String provincia;
	private String provinciades;
	private String distrito;
	private String distritodes;
	private String direccion;
	private String telefono;
	private String reptipodoc;
	private String repnumdoc;
	private String repnombres;
	private String repappaterno;
	private String repapmaterno;
	private Set<UnidadMinera> unidadesm = new HashSet<UnidadMinera>(0);
	
	public Administrado() {
	}

	public Administrado(BigDecimal idadministrados) {
		this.setIdadministrados(idadministrados);
	}

	public Administrado(BigDecimal idadministrados, String tipopersona, String ruc,
			String razonsocial, String tipodoc, String numerodoc, String nombres,
			String appaterno, String apmaterno, String departamento, String departamentodes,
			String provincia, String provinciades, String distrito, String distritodes,String direccion,
			String telefono, String reptipodoc, String repnumdoc, String repnombres, String repappaterno, String repapmaterno,
			Set<UnidadMinera> unidadesm) {
		this.setIdadministrados(idadministrados);
		this.setTipopersona(tipopersona);
		this.setRuc(ruc);
		this.setRazonsocial(razonsocial);
		this.setTipodoc(tipodoc);
		this.setNumerodoc(numerodoc);
		this.setNombres(nombres);
		this.setAppaterno(appaterno);
		this.setApmaterno(apmaterno);
		this.setDepartamento(departamento);
		this.setDepartamentodes(departamentodes);
		this.setProvincia(provincia);
		this.setProvinciades(provinciades);
		this.setDistrito(distrito);
		this.setDistritodes(distritodes);
		this.setDireccion(direccion);
		this.setTelefono(telefono);
		this.setReptipodoc(reptipodoc);
		this.setRepnumdoc(repnumdoc);
		this.setRepnombres(repnombres);
		this.setRepappaterno(repappaterno);
		this.setRepapmaterno(repapmaterno);
		this.setUnidadesm(unidadesm);
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDADMINISTRADOS")
	public BigDecimal getIdadministrados() {
		return idadministrados;
	}

	public void setIdadministrados(BigDecimal idadministrados) {
		this.idadministrados = idadministrados;
	}
	@Column
	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	@Column
	public String getTipodoc() {
		return tipodoc;
	}
	
	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}	
	@Column	
	public String getRazonsocial() {
		return razonsocial;
	}

	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}

	@Column
	public String getAppaterno() {
		return appaterno;
	}

	public void setAppaterno(String appaterno) {
		this.appaterno = appaterno;
	}
	@Column
	public String getNumerodoc() {
		return numerodoc;
	}

	public void setNumerodoc(String numerodoc) {
		this.numerodoc = numerodoc;
	}
	@Column
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	@Column
	public String getApmaterno() {
		return apmaterno;
	}

	public void setApmaterno(String apmaterno) {
		this.apmaterno = apmaterno;
	}
	@Column
	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	@Column
	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	@Column
	public String getDepartamentodes() {
		return departamentodes;
	}

	public void setDepartamentodes(String departamentodes) {
		this.departamentodes = departamentodes;
	}
	@Column
	public String getProvinciades() {
		return provinciades;
	}

	public void setProvinciades(String provinciades) {
		this.provinciades = provinciades;
	}
	@Column
	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	@Column
	public String getDistritodes() {
		return distritodes;
	}

	public void setDistritodes(String distritodes) {
		this.distritodes = distritodes;
	}
	@Column
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Column
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	@Column
	public String getReptipodoc() {
		return reptipodoc;
	}

	public void setReptipodoc(String reptipodoc) {
		this.reptipodoc = reptipodoc;
	}
	@Column
	public String getRepnumdoc() {
		return repnumdoc;
	}

	public void setRepnumdoc(String repnumdoc) {
		this.repnumdoc = repnumdoc;
	}
	@Column
	public String getRepnombres() {
		return repnombres;
	}

	public void setRepnombres(String repnombres) {
		this.repnombres = repnombres;
	}
	@Column
	public String getRepappaterno() {
		return repappaterno;
	}

	public void setRepappaterno(String repappaterno) {
		this.repappaterno = repappaterno;
	}
	@Column
	public String getRepapmaterno() {
		return repapmaterno;
	}

	public void setRepapmaterno(String repapmaterno) {
		this.repapmaterno = repapmaterno;
	}

	@Column
	public String getTipopersona() {
		return tipopersona;
	}

	public void setTipopersona(String tipopersona) {
		this.tipopersona = tipopersona;
	}

	@OneToMany(mappedBy = "administrado",fetch = FetchType.EAGER, cascade = CascadeType.ALL)  	
	public Set<UnidadMinera> getUnidadesm() {
		return this.unidadesm;
	}

	public void setUnidadesm(Set<UnidadMinera> unidadesm) {
		this.unidadesm = unidadesm;
	}

}
