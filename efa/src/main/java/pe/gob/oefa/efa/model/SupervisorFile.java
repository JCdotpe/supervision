package pe.gob.oefa.efa.model;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "efa_supervisor_file")
public class SupervisorFile implements java.io.Serializable {

	private BigDecimal id;
	private Supervisor supervisor;
	private String nombre;
	private String tipo;
	
	public SupervisorFile() {
	}

	public SupervisorFile(BigDecimal id) {
		this.id = id;
	}

	public SupervisorFile(BigDecimal id, Supervisor supervisor, String nombre, String tipo) {
		this.id = id;
		this.supervisor = supervisor;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}
	@ManyToOne  
	@JoinColumn(name = "IDSUPERVISOR")  
	public Supervisor getSupervisor() {
		return this.supervisor;
	}

	public void setSupervisor(Supervisor supervisor) {
		this.supervisor = supervisor;
	}
	@Column
	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column
	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
