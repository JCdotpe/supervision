package pe.gob.oefa.efa.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.seguridad.Menu;
import pe.gob.oefa.efa.seguridad.Opcion;

public class SessionFilter implements Filter{

	
	public void destroy() {
		System.out.println("se destruyó el filtro");
	}
	
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try{
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession(false);

			String uri = req.getRequestURI().toString();
			String cpath = req.getContextPath();
			
			if(uri.indexOf("resources")== -1){
				if((session == null || session.getAttribute("usuario") == null) &&
						!uri.equals(cpath+"/") &&
						!uri.equals(cpath+"/login") &&
						!uri.equals(cpath+"/logout")){
					res.sendRedirect(cpath+"/");
				}else{
					String url = req.getParameter("u")==null?"":req.getParameter("u").toString();
					if(session != null && session.getAttribute("menuList")!=null && url.equals("url")){
						
						System.out.println("url : "+url);
						List<Menu> listaMenu = (ArrayList<Menu>)session.getAttribute("menuList");
						int contadorMenuPermitido = 0;
						fm:
						for(Menu m: listaMenu){
							for(Opcion o : m.getOpciones()){
								if(uri.equals(o.getOpcion().getUrl())){
									contadorMenuPermitido++;
									break fm;
								}
								
								System.out.println("uri : "+uri);
								System.out.println("Menu : "+o.getOpcion().getUrl()+" - url : "+url);
							}
						}
						
						if(contadorMenuPermitido!=0){
							chain.doFilter(req, res);	
						}else{
							req.getRequestDispatcher("/notAllowed").forward(req, res);;
						}
					}else{
						chain.doFilter(req, res);	
					}
				}
			}else{
				chain.doFilter(req, res);
			}
			
			
			/*if(session == null){
				session = req.getSession(true);
				res.sendRedirect(req.getContextPath()+"/");
			}else{
				chain.doFilter(req, res);				
			}*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("se inicializó el filtro");
		
	}
}