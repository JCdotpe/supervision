package pe.gob.oefa.efa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATRIZ_ACTIVIDAD_FUNCIONES")
public class MatrizActividadFuncion {
	private int idmatrizactividadfunciones;
	private int idmatrizactividad;
	private int idfuncion;
	private String estadomatrizactividadfunciones;
	private String observaciones;
	
	public MatrizActividadFuncion() {
	}
	
	public MatrizActividadFuncion(int idmatrizactividadfunciones,
			int idmatrizactividad, int idfuncion,
			String estadomatrizactividadfunciones, String observaciones) {
		this.idmatrizactividadfunciones = idmatrizactividadfunciones;
		this.idmatrizactividad = idmatrizactividad;
		this.idfuncion = idfuncion;
		this.estadomatrizactividadfunciones = estadomatrizactividadfunciones;
		this.observaciones = observaciones;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDMATRIZACTIVIDADFUNCIONES")
	public int getIdmatrizactividadfunciones() {
		return idmatrizactividadfunciones;
	}
	public void setIdmatrizactividadfunciones(int idmatrizactividadfunciones) {
		this.idmatrizactividadfunciones = idmatrizactividadfunciones;
	}
	
	@Column(name = "IDMATRIZACTIVIDAD")
	public int getIdmatrizactividad() {
		return idmatrizactividad;
	}
	public void setIdmatrizactividad(int idmatrizactividad) {
		this.idmatrizactividad = idmatrizactividad;
	}
	
	@Column(name = "IDFUNCION")
	public int getIdfuncion() {
		return idfuncion;
	}
	public void setIdfuncion(int idfunciones) {
		this.idfuncion = idfunciones;
		
	}
	
	@Column(name = "ESTADOMATRIZACTIVIDADFUNCIONES")
	public String getEstadomatrizactividadfunciones() {
		return estadomatrizactividadfunciones;
	}
	public void setEstadomatrizactividadfunciones(
			String estadomatrizactividadfunciones) {
		this.estadomatrizactividadfunciones = estadomatrizactividadfunciones;
	}
	
	@Column(name = "OBSERVACIONES")
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
}
