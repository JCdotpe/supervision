package pe.gob.oefa.efa.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TAuditoria")
public class Auditoria implements java.io.Serializable{
	
	private BigDecimal id;
    private BigDecimal idTablaReferencia;
    private BigDecimal idTipoAccion;
    private String idReferencia;
    private Date fecha;
    private String userName;
    private String hostName;
    private String ip;
    private String observaciones;
    private String hora;
    
    public Auditoria(){}
    			
	public Auditoria(BigDecimal id) {
		this.setId(id);
	}
	
	public Auditoria(
			BigDecimal id,
			BigDecimal idTablaReferencia,
			BigDecimal idTipoAccion,
			String idReferencia,
			Date fecha,
			String userName,
			String hostName,
			String ip,
			String observaciones,
			String hora) {
		this.id = id;
		this.idTablaReferencia = idTablaReferencia;
		this.idTipoAccion = idTipoAccion;
		this.idReferencia = idReferencia;
		this.fecha = fecha;
		this.userName = userName;
		this.hostName = hostName;
		this.ip = ip;
		this.observaciones = observaciones;
		this.hora = hora;
	}
	
	
	@Id
	//@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	

	@Column(name = "ID_TABLA_REFERENCIA")
	public BigDecimal getIdTablaReferencia() {
		return idTablaReferencia;
	}
	public void setIdTablaReferencia(BigDecimal idTablaReferencia) {
		this.idTablaReferencia = idTablaReferencia;
	}
	
	
	@Column(name = "ID_TIPO_ACCION")
	public BigDecimal getIdTipoAccion() {
		return idTipoAccion;
	}
	public void setIdTipoAccion(BigDecimal idTipoAccion) {
		this.idTipoAccion = idTipoAccion;
	}
	
	@Column(name = "ID_REFERENCIA")
	public String getIdReferencia() {
		return idReferencia;
	}
	public void setIdReferencia(String idReferencia) {
		this.idReferencia = idReferencia;
	}
	
	@Column(name = "FECHA")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	@Column(name = "USERNAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Column(name = "HOSTNAME")
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	@Column(name = "IP")
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	@Column(name = "OBSERVACIONES")
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@Column(name = "HORA")
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}
