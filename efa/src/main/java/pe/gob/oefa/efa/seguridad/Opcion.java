package pe.gob.oefa.efa.seguridad;

import org.debugsac.oefa.model.Pagina;

public class Opcion {

	private Pagina opcion;
	
	public Opcion() {
		opcion = new Pagina();
	}
	
	public void setOpcion(Pagina opcion) {
		this.opcion = opcion;
	}
	public Pagina getOpcion() {
		return opcion;
	}
	
	
}
