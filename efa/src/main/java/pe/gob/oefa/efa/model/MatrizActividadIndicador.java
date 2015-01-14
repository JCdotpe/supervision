package pe.gob.oefa.efa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MATRIZ_ACTIVIDAD_INDICADOR")
public class MatrizActividadIndicador {
	private int idmatrizactividadindicador;
	private int idmatrizactividadfunciones;
	private int idindicador;
	
	public MatrizActividadIndicador(int idmatrizactividadindicador,
			int idmatrizactividadfunciones, int idindicador) {
		this.idmatrizactividadindicador = idmatrizactividadindicador;
		this.idmatrizactividadfunciones = idmatrizactividadfunciones;
		this.idindicador = idindicador;
	}
	
	public MatrizActividadIndicador() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDMATRIZACTIVIDADINDICADOR")
	public int getIdmatrizactividadindicador() {
		return idmatrizactividadindicador;
	}
	public void setIdmatrizactividadindicador(int idmatrizactividadindicador) {
		this.idmatrizactividadindicador = idmatrizactividadindicador;
	}
	
	@Column(name = "IDMATRIZACTIVIDADFUNCIONES")
	public int getIdmatrizactividadfunciones() {
		return idmatrizactividadfunciones;
	}
	
	public void setIdmatrizactividadfunciones(int idmatrizactividadfunciones) {
		this.idmatrizactividadfunciones = idmatrizactividadfunciones;
	}

	@Column(name = "IDINDICADOR")
	public int getIdindicador() {
		return idindicador;
	}
	public void setIdindicador(int idindicador) {
		this.idindicador = idindicador;
	}
	
	
}
