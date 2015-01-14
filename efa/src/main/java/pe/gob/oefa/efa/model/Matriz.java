package pe.gob.oefa.efa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "matriz")
public class Matriz implements java.io.Serializable {
	private int idmatriz;
	private String nombrematriz;
	private String sector;
	private int nivel;
	private String estadomatriz;
	private String nombrenivel;
	
	
	
	public Matriz() {
	}
	
	
	
	public Matriz(int idmatriz, String nombrematriz, String sector, int nivel,
			String estadomatriz, String nombrenivel) {
		this.idmatriz = idmatriz;
		this.nombrematriz = nombrematriz;
		this.sector = sector;
		this.nivel = nivel;
		this.estadomatriz = estadomatriz;
		this.nombrenivel = nombrenivel;
	}



	@Id
	@Column(name = "IDMATRIZ")
	public int getIdmatriz() {
		return idmatriz;
	}
	public void setIdmatriz(int idmatriz) {
		this.idmatriz = idmatriz;
	}
	@Column(name = "NOMBREMATRIZ")
	public String getNombrematriz() {
		return nombrematriz;
	}
	public void setNombrematriz(String nombrematriz) {
		this.nombrematriz = nombrematriz;
	}
	@Column(name = "SECTOR")
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	@Column(name = "NIVEL")
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	@Column(name = "ESTADOMATRIZ")
	public String getEstadomatriz() {
		return estadomatriz;
	}
	public void setEstadomatriz(String estadomatriz) {
		this.estadomatriz = estadomatriz;
	}
	@Column(name = "NOMBRENIVEL")
	public String getNombrenivel() {
		return nombrenivel;
	}
	public void setNombrenivel(String nombrenivel) {
		this.nombrenivel = nombrenivel;
	}
	
	
	
}
