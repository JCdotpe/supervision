package pe.gob.oefa.efa.model;
// Generated 14-oct-2014 7:05:40 by Hibernate Tools 3.3.0.GA

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Ubigeo generated by hbm2java
 */
@Entity
@Table(name = "ubigeo")
public class Ubigeo implements java.io.Serializable {

	private BigDecimal idubigeo;
	private BigDecimal idDepartamento;
	private BigDecimal idProvincia;
	private BigDecimal idDistrito;
	private String codDepartamento;
	private String codProvincia;
	private String codDistrito;
	private String desDistrito;

	public Ubigeo() {
	}

	public Ubigeo(BigDecimal idubigeo) {
		this.idubigeo = idubigeo;
	}

	public Ubigeo(BigDecimal idubigeo, BigDecimal idDepartamento,
			BigDecimal idProvincia, BigDecimal idDistrito,
			String codDepartamento, String codProvincia, String codDistrito,
			String desDistrito) {
		this.idubigeo = idubigeo;
		this.idDepartamento = idDepartamento;
		this.idProvincia = idProvincia;
		this.idDistrito = idDistrito;
		this.codDepartamento = codDepartamento;
		this.codProvincia = codProvincia;
		this.codDistrito = codDistrito;
		this.desDistrito = desDistrito;
	}
	@Id
	public BigDecimal getIdubigeo() {
		return this.idubigeo;
	}

	public void setIdubigeo(BigDecimal idubigeo) {
		this.idubigeo = idubigeo;
	}
	@Column(name = "ID_DEPARTAMENTO")
	public BigDecimal getIdDepartamento() {
		return this.idDepartamento;
	}

	public void setIdDepartamento(BigDecimal idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	@Column(name = "ID_PROVINCIA")
	public BigDecimal getIdProvincia() {
		return this.idProvincia;
	}
	
	public void setIdProvincia(BigDecimal idProvincia) {
		this.idProvincia = idProvincia;
	}
	@Column(name = "ID_DISTRITO")
	public BigDecimal getIdDistrito() {
		return this.idDistrito;
	}

	public void setIdDistrito(BigDecimal idDistrito) {
		this.idDistrito = idDistrito;
	}
	@Column(name = "COD_DEPARTAMENTO")
	public String getCodDepartamento() {
		return this.codDepartamento;
	}
	
	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}
	@Column(name = "COD_PROVINCIA")
	public String getCodProvincia() {
		return this.codProvincia;
	}

	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}
	@Column(name = "COD_DISTRITO")
	public String getCodDistrito() {
		return this.codDistrito;
	}

	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}
	@Column(name = "DES_DISTRITO")
	public String getDesDistrito() {
		return this.desDistrito;
	}

	public void setDesDistrito(String desDistrito) {
		this.desDistrito = desDistrito;
	}

}
