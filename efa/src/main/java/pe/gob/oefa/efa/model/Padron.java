package pe.gob.oefa.efa.model;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "efa_padron")
public class Padron implements java.io.Serializable {

	private String numdle;
	private Character digver;
	private String numlib;
	private String apepat;
	private String apemat;
	private String nombre;
	private String fecnac;
	private Character codsex;
	private String codgri;
	private Character codstr;
	private Character tipdoc;
	private String coddep;
	private String codpro;
	private String coddis;
	private Character indis;

	public Padron() {
	}

	public Padron(String numdle) {
		this.numdle = numdle;
	}

	public Padron(String numdle, Character digver, String numlib,
			String apepat, String apemat, String nombre, String fecnac,
			Character codsex, String codgri, Character codstr,
			Character tipdoc, String coddep, String codpro, String coddis,
			Character indis) {
		this.numdle = numdle;
		this.digver = digver;
		this.numlib = numlib;
		this.apepat = apepat;
		this.apemat = apemat;
		this.nombre = nombre;
		this.fecnac = fecnac;
		this.codsex = codsex;
		this.codgri = codgri;
		this.codstr = codstr;
		this.tipdoc = tipdoc;
		this.coddep = coddep;
		this.codpro = codpro;
		this.coddis = coddis;
		this.indis = indis;
	}
	
	@Id
	@Column
	public String getNumdle() {
		return this.numdle;
	}

	public void setNumdle(String numdle) {
		this.numdle = numdle;
	}
	@Column
	public Character getDigver() {
		return this.digver;
	}

	public void setDigver(Character digver) {
		this.digver = digver;
	}
	@Column
	public String getNumlib() {
		return this.numlib;
	}

	public void setNumlib(String numlib) {
		this.numlib = numlib;
	}
	@Column
	public String getApepat() {
		return this.apepat;
	}

	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	@Column
	public String getApemat() {
		return this.apemat;
	}

	public void setApemat(String apemat) {
		this.apemat = apemat;
	}
	@Column
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column
	public String getFecnac() {
		return this.fecnac;
	}

	public void setFecnac(String fecnac) {
		this.fecnac = fecnac;
	}
	@Column
	public Character getCodsex() {
		return this.codsex;
	}

	public void setCodsex(Character codsex) {
		this.codsex = codsex;
	}
	@Column
	public String getCodgri() {
		return this.codgri;
	}

	public void setCodgri(String codgri) {
		this.codgri = codgri;
	}
	@Column
	public Character getCodstr() {
		return this.codstr;
	}

	public void setCodstr(Character codstr) {
		this.codstr = codstr;
	}
	@Column
	public Character getTipdoc() {
		return this.tipdoc;
	}

	public void setTipdoc(Character tipdoc) {
		this.tipdoc = tipdoc;
	}
	@Column
	public String getCoddep() {
		return this.coddep;
	}

	public void setCoddep(String coddep) {
		this.coddep = coddep;
	}
	@Column
	public String getCodpro() {
		return this.codpro;
	}

	public void setCodpro(String codpro) {
		this.codpro = codpro;
	}
	@Column
	public String getCoddis() {
		return this.coddis;
	}

	public void setCoddis(String coddis) {
		this.coddis = coddis;
	}
	@Column
	public Character getIndis() {
		return this.indis;
	}

	public void setIndis(Character indis) {
		this.indis = indis;
	}

}
