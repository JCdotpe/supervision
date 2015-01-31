package pe.gob.oefa.efa.form;
/**
 * Created by Manuel Ochoa 987268620
 */
public class LoginForm {
	
	private String usuario;
	private String contrasena;
	
	public LoginForm() {
		this.usuario = "";
		this.contrasena ="";
	}
	
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
