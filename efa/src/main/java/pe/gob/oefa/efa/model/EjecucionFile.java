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
@Table(name = "tejecucion_file")
public class EjecucionFile implements java.io.Serializable {

	private BigDecimal idejecfile;
	private EjecucionActividad ejecucionActividad;
	private String tipo;
	private String nombre;
	private String archivo;
	
	public EjecucionFile() {
	}

	public EjecucionFile(BigDecimal idejecfile) {
		this.setIdejecfile(idejecfile);
	}

	public EjecucionFile(BigDecimal idejecfile, EjecucionActividad ejecucionActividad, String tipo, String nombre, String archivo) {
		this.setIdejecfile(idejecfile);
		this.setEjecucionActividad(ejecucionActividad);
		this.setTipo(tipo);
		this.setNombre(nombre);
		this.setArchivo(archivo);
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDEJECFILE")
	public BigDecimal getIdejecfile() {
		return idejecfile;
	}

	public void setIdejecfile(BigDecimal idejecfile) {
		this.idejecfile = idejecfile;
	}
	@ManyToOne  
	@JoinColumn(name = "IDEJECUCION")  
	public EjecucionActividad getEjecucionActividad() {
		return ejecucionActividad;
	}

	public void setEjecucionActividad(EjecucionActividad ejecucionActividad) {
		this.ejecucionActividad = ejecucionActividad;
	}
	@Column
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Column
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Column
	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

}
