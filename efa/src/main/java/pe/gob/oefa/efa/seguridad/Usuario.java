package pe.gob.oefa.efa.seguridad;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable{

	private String usuario;
	
	private String nombre;
	private String apepat;
	private String apemat;

	private Integer codArea;
	private String area;
	
	private Integer codPerfil;
	private String perfil;
	
	public Usuario() {
		this.usuario = "";
		this.nombre = "";
		this.apepat = "";
		this.apemat = "";
		this.codArea = -1;
		this.area = "";
		
		this.codPerfil = -1;
		this.perfil = "";
	}
	
	public String getApemat() {
		return apemat;
	}
	public String getApepat() {
		return apepat;
	}
	public String getArea() {
		return area;
	}
	public Integer getCodArea() {
		return codArea;
	}
	public Integer getCodPerfil() {
		return codPerfil;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPerfil() {
		return perfil;
	}
	public String getUsuario() {
		return usuario;
	}
	
	public void setApemat(String apemat) {
		this.apemat = apemat;
	}
	public void setApepat(String apepat) {
		this.apepat = apepat;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public void setCodArea(Integer codArea) {
		this.codArea = codArea;
	}
	public void setCodPerfil(Integer codPerfil) {
		this.codPerfil = codPerfil;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	

	
}
