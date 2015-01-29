package pe.gob.oefa.efa.service;

import org.debugsac.oefa.model.Pagina;
import org.debugsac.oefa.model.PaginaAccion;

import com.debugsac.bean.Usuario;

public interface SeguridadService {

	public Integer modoUsuario(Usuario usuario) throws Exception;
	public Usuario autenticarUsuario(Usuario usuario) throws Exception;
	public Usuario autenticarUsuario_Modo(Usuario usuario, String contrasena) throws Exception;
	public Pagina[] obtenerSitemapPorUsuario(String nombreUsuario, Integer idAplicacion) throws Exception;
	public PaginaAccion[] obtenerPermisoPerfilPorGrupo(Integer idUsuario, String idsGrupo) throws Exception;
	
}
