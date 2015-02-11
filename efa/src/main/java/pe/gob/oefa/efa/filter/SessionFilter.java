package pe.gob.oefa.efa.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter{

	
	public void destroy() {
		System.out.println("se destruyó el filtro");
	}
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try{
			HttpServletRequest req = (HttpServletRequest) request;
			HttpServletResponse res = (HttpServletResponse) response;
			HttpSession session = req.getSession(false);

			if(session == null){
				session = req.getSession(true);
				res.sendRedirect(req.getContextPath()+"/");
			}else{
				chain.doFilter(req, res);				
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("se inicializó el filtro");
		
	}
}