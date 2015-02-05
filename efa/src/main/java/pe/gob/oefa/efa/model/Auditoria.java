package pe.gob.oefa.efa.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Auditoria")
public class Auditoria implements java.io.Serializable{
	
	private BigDecimal idAuditoria;
    private String descripcion;
    
    public Auditoria(){}
    		
    		
	public Auditoria(BigDecimal idAuditoria) {
		this.setidAuditoria(idAuditoria);
	}
	
	public Auditoria(BigDecimal idAuditoria,String descripcion) {
		this.idAuditoria = idAuditoria;
		this.descripcion = descripcion;
	}
	
	
	@Id
	@Column(name = "ID_AUDITORIA")
	public BigDecimal getidAuditoria() {
		return idAuditoria;
	}
	public void setidAuditoria(BigDecimal idAuditoria) {
		this.idAuditoria = idAuditoria;
	}
	

	@Column(name = "DESCRIPCION")
	public String getdescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
