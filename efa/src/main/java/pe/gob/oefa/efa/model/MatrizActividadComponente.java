package pe.gob.oefa.efa.model;

import javax.persistence.Entity;
import javax.persistence.Table;

public class MatrizActividadComponente implements java.io.Serializable {
	private int idmatriz;
	private int idactividad;
	private int idcomponente;
	private String completado;
	
	
		public MatrizActividadComponente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MatrizActividadComponente(int idmatriz, int idactividad,
			int idcomponente, String completado) {
		super();
		this.idmatriz = idmatriz;
		this.idactividad = idactividad;
		this.idcomponente = idcomponente;
		this.completado = completado;
	}

	public int getIdmatriz() {
		return idmatriz;
	}

	public void setIdmatriz(int idmatriz) {
		this.idmatriz = idmatriz;
	}

	public int getIdactividad() {
		return idactividad;
	}

	public void setIdactividad(int idactividad) {
		this.idactividad = idactividad;
	}

	public int getIdcomponente() {
		return idcomponente;
	}

	public void setIdcomponente(int idcomponente) {
		this.idcomponente = idcomponente;
	}

	public String getCompletado() {
		return completado;
	}

	public void setCompletado(String completado) {
		this.completado = completado;
	}
	
	
	
	
}
