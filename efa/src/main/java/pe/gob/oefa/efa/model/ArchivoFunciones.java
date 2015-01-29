package pe.gob.oefa.efa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ARCHIVO_FUNCIONES")
public class ArchivoFunciones {
	private int idarchivofunciones;
	private String tipo;
	private String nombrearchivo;
	private String arhivo;
	private String estadoarchivo;
	private int idmatrizactividadfunciones;
	
	public ArchivoFunciones() {
		// TODO Auto-generated constructor stub
	}

	public ArchivoFunciones(int idarchivofunciones, String tipo,
			String nombrearchivo, String arhivo, String estadoarchivo,
			int idmatrizactividadfunciones) {
		this.idarchivofunciones = idarchivofunciones;
		this.tipo = tipo;
		this.nombrearchivo = nombrearchivo;
		this.arhivo = arhivo;
		this.estadoarchivo = estadoarchivo;
		this.idmatrizactividadfunciones = idmatrizactividadfunciones;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDARCHIVOFUNCIONES")
	public int getIdarchivofunciones() {
		return idarchivofunciones;
	}

	public void setIdarchivofunciones(int idarchivofunciones) {
		this.idarchivofunciones = idarchivofunciones;
	}

	@Column(name = "TIPO")
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Column(name = "NOMBREARCHIVO")
	public String getNombrearchivo() {
		return nombrearchivo;
	}

	public void setNombrearchivo(String nombrearchivo) {
		this.nombrearchivo = nombrearchivo;
	}

	@Column(name = "ARCHIVO")
	public String getArhivo() {
		return arhivo;
	}

	public void setArhivo(String arhivo) {
		this.arhivo = arhivo;
	}

	@Column(name = "ESTADOARCHIVO")
	public String getEstadoarchivo() {
		return estadoarchivo;
	}

	public void setEstadoarchivo(String estadoarchivo) {
		this.estadoarchivo = estadoarchivo;
	}

	@Column(name = "IDMATRIZACTIVIDADFUNCIONES")
	public int getIdmatrizactividadfunciones() {
		return idmatrizactividadfunciones;
	}

	public void setIdmatrizactividadfunciones(int idmatrizactividadfunciones) {
		this.idmatrizactividadfunciones = idmatrizactividadfunciones;
	}
	
	
	
	
	
}
