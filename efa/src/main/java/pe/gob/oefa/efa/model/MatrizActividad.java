package pe.gob.oefa.efa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATRIZ_ACTIVIDAD")
public class MatrizActividad implements java.io.Serializable{
	private BigDecimal idmatrizactividad;
	private int idactividad;
	private int idmatriz;
	private String estadomatrizactividad;
	
	public MatrizActividad(BigDecimal idmatrizactividad, int idactividad,
			int idmatriz, String estadomatrizactividad) {
		this.idmatrizactividad = idmatrizactividad;
		this.idactividad = idactividad;
		this.idmatriz = idmatriz;
		this.estadomatrizactividad = estadomatrizactividad;
	}
	
	public MatrizActividad() {
	
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDMATRIZACTIVIDAD")
	public BigDecimal getIdmatrizactividad() {
		return idmatrizactividad;
	}
	public void setIdmatrizactividad(BigDecimal idmatrizactividad) {
		this.idmatrizactividad = idmatrizactividad;
	}
	
	@Column(name = "IDACTIVIDAD")
	public int getIdactividad() {
		return idactividad;
	}
	public void setIdactividad(int idactividad) {
		this.idactividad = idactividad;
	}
	
	@Column(name = "IDMATRIZ")
	public int getIdmatriz() {
		return idmatriz;
	}
	public void setIdmatriz(int idmatriz) {
		this.idmatriz = idmatriz;
	}
	
	@Column(name = "ESTADOMATRIZACTIVIDAD")
	public String getEstadomatrizactividad() {
		return estadomatrizactividad;
	}
	public void setEstadomatrizactividad(String estadomatrizactividad) {
		this.estadomatrizactividad = estadomatrizactividad;
	}
	
	
	
}
