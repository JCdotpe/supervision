package pe.gob.oefa.efa.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.seguridad.Usuario;
import pe.gob.oefa.efa.service.ActividadService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.ResponsableService;
import pe.gob.oefa.efa.service.SupervisorEmergenciaService;
import pe.gob.oefa.efa.service.SupervisorFileService;
import pe.gob.oefa.efa.service.SupervisorService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/actsupervision")
public class ActSupervisionController {
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private EfaService efaService;	
	
	@Autowired
	private ResponsableService responsableService;

	@Autowired
	private SupervisorService supervisorService;
	
	@Autowired
	private UtilService utilService;
	
	@ModelAttribute("listDep")
	public List<LabelValue> getDeps(){
	    return ubigeoService.listDep();
	}	
	
	@ModelAttribute("listNivel")
     public List<LabelValue> getNiveles() {
		    return utilService.listNiveles_efa();
	}	

	@ModelAttribute("listTipoAct")
    public List<LabelValue> getTipoAct() {
		    return utilService.listTipoActividad();
	}		
	
	@ModelAttribute("listEstadoAct")
    public List<LabelValue> getEstadoAct() {
		    return utilService.listEstadoActividad();
	}		

	@ModelAttribute("listEstadoMatriz")
    public List<LabelValue> getEstadoMatriz() {
		    return utilService.listEstadoMatriz();
	}			
	
	@ModelAttribute("listEstadoEjecucion")
    public List<LabelValue> getEstadoEjecucion() {
		    return utilService.listEstadoEjecucion();
	}		
	
	@RequestMapping(value = { "/", "/listActSupervision" } , method = RequestMethod.GET)
	public String listSupervisores(Map<String, Object> map) {			
		map.put("actList", null);
		return "/actsupervision/listActSupervision";
	}
	
	@RequestMapping(value = { "/", "/listActSupervision" }, method = RequestMethod.POST)
	public String getResponsablesdsa(HttpServletRequest request, Map<String, Object> map,HttpSession session) {
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		List as = actividadService.listActividades_by(request.getParameter("fechaini"),request.getParameter("fechafin") ,request.getParameter("nombrefa") ,request.getParameter("nombresup")  , request.getParameter("nivel"), request.getParameter("informe"), request.getParameter("codact"), request.getParameter("estado"), request.getParameter("estadomatriz"), request.getParameter("estadoejec"),usuario);
		map.put("fechaini", request.getParameter("fechaini"));
		map.put("fechafin", request.getParameter("fechafin"));
		map.put("nombrefa", request.getParameter("nombrefa"));
		map.put("nombresup", request.getParameter("nombresup"));
		map.put("xnivel", request.getParameter("nivel"));
		map.put("informe", request.getParameter("informe"));
		map.put("codact", request.getParameter("codact"));
		map.put("xestado", request.getParameter("estado"));
		map.put("xestadomatriz", request.getParameter("estadomatriz"));
		map.put("xestadoejec", request.getParameter("estadoejec"));
		map.put("actList", as);
		return "/actsupervision/listActSupervision";
	}			

	
}
