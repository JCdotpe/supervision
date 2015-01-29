package pe.gob.oefa.efa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FUNCIONES_COMPONENTE")
public class FuncionesComponente implements java.io.Serializable{
	private int idfuncion;
	private String descripcionfuncion;
	private String baselegal;
	private String verificable;
	private String estadofuncion;
	private int idcomponente;
	
	public FuncionesComponente() {
		
	}

	public FuncionesComponente(int idfuncion, String descripcionfuncion,
			String baselegal, String verificable, String estadofuncion,
			int idcomponente) {
		this.idfuncion = idfuncion;
		this.descripcionfuncion = descripcionfuncion;
		this.baselegal = baselegal;
		this.verificable = verificable;
		this.estadofuncion = estadofuncion;
		this.idcomponente = idcomponente;
	}


	@Id
	@Column(name = "idfuncion")
	public int getIdfuncion() {
		return idfuncion;
	}

	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}

	
	@Column(name = "DESCRIPCIONFUNCION")
	public String getDescripcionfuncion() {
		return descripcionfuncion;
	}

	public void setDescripcionfuncion(String descripcionfuncion) {
		this.descripcionfuncion = descripcionfuncion;
	}

	
	@Column(name = "BASELEGAL")
	public String getBaselegal() {
		return baselegal;
	}

	public void setBaselegal(String baselegal) {
		this.baselegal = baselegal;
	}

	
	@Column(name = "VERIFICABLE")
	public String getVerificable() {
		return verificable;
	}

	public void setVerificable(String verificable) {
		this.verificable = verificable;
	}

	
	@Column(name = "ESTADOFUNCION")
	public String getEstadofuncion() {
		return estadofuncion;
	}

	public void setEstadofuncion(String estadofuncion) {
		this.estadofuncion = estadofuncion;
	}

	
	@Column(name = "IDCOMPONENTE")
	public int getIdcomponente() {
		return idcomponente;
	}

	public void setIdcomponente(int idcomponente) {
		this.idcomponente = idcomponente;
	}
	
	
}
