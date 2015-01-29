package pe.gob.oefa.efa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "INDICADORES_FUNCION")
public class IndicadoresFuncion implements java.io.Serializable{

	private int idindicador;
	private String descripcionindicador;
	private String estadoindicador;
	private int idfuncion;
	
	public IndicadoresFuncion() {
	}
	
	public IndicadoresFuncion(int idindicador, String descripcionindicador,
			String estadoindicador, int idfuncion) {
		this.idindicador = idindicador;
		this.descripcionindicador = descripcionindicador;
		this.estadoindicador = estadoindicador;
		this.idfuncion = idfuncion;
	}

	@Id
	@Column(name = "IDINDICADOR")
	public int getIdindicador() {
		return idindicador;
	}
	public void setIdindicador(int idindicador) {
		this.idindicador = idindicador;
	}

	@Column(name = "DESCRIPCIONINDICADOR")
	public String getDescripcionindicador() {
		return descripcionindicador;
	}
	public void setDescripcionindicador(String descripcionindicador) {
		this.descripcionindicador = descripcionindicador;
	}

	@Column(name = "ESTADOFUNCION")
	public String getEstadoindicador() {
		return estadoindicador;
	}
	public void setEstadoindicador(String estadoindicador) {
		this.estadoindicador = estadoindicador;
	}

	@Column(name = "IDFUNCION")
	public int getIdfuncion() {
		return idfuncion;
	}
	public void setIdfuncion(int idfuncion) {
		this.idfuncion = idfuncion;
	}
	
	
}
