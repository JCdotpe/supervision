package pe.gob.oefa.efa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.debugsac.oefa.model.Pagina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.debugsac.bean.Rol;

import pe.gob.oefa.efa.form.LoginForm;
import pe.gob.oefa.efa.seguridad.Menu;
import pe.gob.oefa.efa.seguridad.Opcion;
import pe.gob.oefa.efa.seguridad.Usuario;
import pe.gob.oefa.efa.service.SeguridadService;


@Controller
public class LoginController {
	
	@Autowired
	private SeguridadService seguridadService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home(HttpServletRequest request, HttpServletResponse response, ModelMap map){
		try{
			Usuario usuario = (Usuario)request.getSession(true).getAttribute("usuario");
			if(usuario!=null){
				
				request.getRequestDispatcher("/home").forward(request, response);
				return null;
				
			}else{
				
				map.addAttribute("msj", "Su sesión ha expirado.");
				map.addAttribute("loginForm", new LoginForm());
				return "login";
			}
		}catch(Exception e){
			
			map.addAttribute("loginForm", new LoginForm());
			return "login";
		}
	}
	
	@RequestMapping(value ="/home", method={RequestMethod.GET, RequestMethod.POST})
	public String home(){
		return "welcome";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String registrar(@ModelAttribute LoginForm loginForm, 
			HttpServletRequest request, HttpServletResponse response, ModelMap map, HttpSession session){
		try {
			
			com.debugsac.bean.Usuario u = new com.debugsac.bean.Usuario();
			//u.setIdUsuario(0);
			u.setCodigoEmp(loginForm.getContrasena());
			/*u.setEmailCoorporativo("0");
			u.setNombreApellido("0");
			u.setEstado(null);*/
			u.setUserName(loginForm.getUsuario());
			u.setIdComite(2);
			/*u.setUsuarioTipo(null);
			u.setListaRol(null);
			u.setContentStyle("0");
			u.setSexo("0");
			u.setCorreoBoleta("0");
			u.setDireccion("0");
			Calendar calendar = new GregorianCalendar();
			u.setFechaNacimiento(calendar.getInstance());
			u.setEmpresa(null);
			u.setDNI("0");
			u.setIdSociedad(0);
			u.setSociedadDescripcionCorta("0");
			u.setIdAreaBU(0);
			u.setAreaBUDescripcionCorta("0");
			u.setIdCargo(0);
			u.setCargoDescripcionCorta("0");
			
			u.setActivo(0);*/
			
			com.debugsac.bean.Usuario uv = null;
			uv = seguridadService.autenticarUsuario(u);
			
			if(uv!=null){
			
				if(uv.getUserName()!=null && !uv.getUserName().equals("")){
				
					Usuario usuario = new Usuario();
					usuario.setNombre(uv.getNombreApellido());
					usuario.setUsuario(u.getUserName());
					
					
					for(Rol rol : uv.getListaRol()){
						usuario.setPerfil(rol.getNombre());	
						usuario.setCodPerfil(rol.getIdRol());
					}
					/*usuario.setCodPerfil(uv.getListaRol()[0].getIdRol()+"");
					usuario.setIdUsuario(uv.getIdUsuario());
					
					usuario.setIdArea(uv.getIdAreaBU());
					usuario.setArea(uv.getAreaBUDescripcionCorta());
					
					usuario.setIdUnidadOrganica(uv.getIdSociedad());
					usuario.setUnidadOrganica(uv.getSociedadDescripcionCorta());*/
					
					Pagina paginas[] = seguridadService.obtenerSitemapPorUsuario(usuario.getUsuario(), 2);
					
					
					List<Menu> listaMenu = new ArrayList<Menu>();
					for(Pagina pag : paginas){
						if(pag.getIdPaginaPadre()==0 && pag.getVisible()==true){
							Menu menu = new Menu();
							menu.setMenu(pag);
							listaMenu.add(menu);
						}
					}
					
					for(int i = 0; i < listaMenu.size(); i ++){
						Menu menu = listaMenu.get(i);
						for(Pagina pag : paginas){
							int paginaPadre = pag.getIdPaginaPadre();
							int paginaMenu = menu.getMenu().getIdPagina();
							if(paginaPadre == paginaMenu){
								Opcion opcion = new Opcion();
								opcion.setOpcion(pag);
								listaMenu.get(i).getOpciones().add(opcion);
							}
						}
					}
					
					session.setAttribute("menuList", listaMenu);					
					session.setAttribute("usuario", usuario);
					return "redirect:/";
					
				}else{
					
					loginForm.setContrasena("");
					map.addAttribute("msj", "Usuario y/o Contraseña Incorrecta");
					map.addAttribute("loginForm", loginForm);
					return "login";					
				}

			}else{
				
				loginForm.setContrasena("");
				map.addAttribute("msj", "Usuario y/o Contraseña Incorrecta");
				map.addAttribute("loginForm", loginForm);
				return "login";
				
			}
			
		} catch (Exception e) {

			e.printStackTrace();
			map.addAttribute("msj", "Ocurrió un error, vuelve a intentarlo.");
			map.addAttribute("loginForm", new LoginForm());
			return "login";

		}
	}
	
	
	@RequestMapping(value="/logout", method={RequestMethod.GET,RequestMethod.POST})
	public String logout(HttpServletRequest request, ModelMap map, HttpSession session){
		String vista = "login";
		try{
			if(session != null){
				session.removeAttribute("usuario");
				session.invalidate();
			}			
			
			map.addAttribute("loginForm",new LoginForm());
			return vista;
			
		}catch(Exception e){
			
			map.addAttribute("loginForm",new LoginForm());
			return vista;
			
		}
	}
	
	
}
