package pe.gob.oefa.efa.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COMPONENTE_MATRIZ")
public class ComponenteMatriz implements java.io.Serializable{
	private int idcomponente;
	private String descripcioncomponente;
	private String estadocomponente;
	private int idmatriz;
	private String item;
	private String subitem;
	private String descripcionsubitem;
	private String completado;
	
	public ComponenteMatriz() {
		this.completado = "NO";
	}
	
	public ComponenteMatriz(int idcomponente,
			String descripcioncomponente, String estadocomponente,
			int idmatriz, String item, String subitem, String descripcionsubitem) {
		this.idcomponente = idcomponente;
		this.descripcioncomponente = descripcioncomponente;
		this.estadocomponente = estadocomponente;
		this.idmatriz = idmatriz;
		this.item = item;
		this.subitem = subitem;
		this.descripcionsubitem = descripcionsubitem;
	}
	
	@Id
	@Column(name = "IDCOMPONENTE")
	public int getIdcomponente() {
		return idcomponente;
	}
	public void setIdcomponente(int idcomponente) {
		this.idcomponente = idcomponente;
	}
	
	@Column(name = "DESCRIPCIONCOMPONENTE")
	public String getDescripcioncomponente() {
		return descripcioncomponente;
	}
	public void setDescripcioncomponente(String descripcioncomponente) {
		this.descripcioncomponente = descripcioncomponente;
	}
	
	@Column(name = "ESTADOCOMPONENTE")
	public String getEstadocomponente() {
		return estadocomponente;
	}
	public void setEstadocomponente(String estadocomponente) {
		this.estadocomponente = estadocomponente;
	}
	
	@Column(name = "IDMATRIZ")
	public int getIdmatriz() {
		return idmatriz;
	}
	public void setIdmatriz(int idmatriz) {
		this.idmatriz = idmatriz;
	}
	
	@Column(name = "ITEM")
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	
	@Column(name = "SUBITEM")
	public String getSubitem() {
		return subitem;
	}
	public void setSubitem(String subitem) {
		this.subitem = subitem;
	}
	
	@Column(name = "DESCRIPCIONSUBITEM")
	public String getDescripcionsubitem() {
		return descripcionsubitem;
	}
	public void setDescripcionsubitem(String descripcionsubitem) {
		this.descripcionsubitem = descripcionsubitem;
	}
	
	@Column(name = "COMPLETADO")
	public String getCompletado() {
		return completado;
	}
	public void setCompletado(String completadoItem) {
		this.completado = completadoItem;
	}
	
	
}
