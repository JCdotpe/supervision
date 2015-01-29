package pe.gob.oefa.efa.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.debugsac.oefa.model.Pagina;

public class Menu {

	private Pagina menu;
	private List<Opcion> opciones;
	
	public Menu(){
		menu = new Pagina();
		opciones = new ArrayList<Opcion>();
	}
	
	public void setMenu(Pagina menu) {
		this.menu = menu;
	}
	public void setOpciones(List<Opcion> opciones) {
		this.opciones = opciones;
	}
	
	public Pagina getMenu() {
		return menu;
	}
	public List<Opcion> getOpciones() {
		return opciones;
	}
	
}
