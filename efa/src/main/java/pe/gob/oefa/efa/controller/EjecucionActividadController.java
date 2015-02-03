package pe.gob.oefa.efa.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.Administrado;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.EjecucionActividad;
import pe.gob.oefa.efa.model.EjecucionFile;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.UnidadMinera;
import pe.gob.oefa.efa.service.ActividadService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.EjecucionActividadService;
import pe.gob.oefa.efa.service.EjecucionFileService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;
@Controller
@RequestMapping("/ejeact")
public class EjecucionActividadController {
	
	@Autowired
	private EjecucionActividadService ejecucionActividadService;	
	
	@Autowired
	private EjecucionFileService ejecucionFileService;	
	
	@Autowired
	private ActividadService actividadService;		
	@Autowired
	private EfaService efaService;		
	
	@Autowired
	private UtilService utilService;	
	
	@ModelAttribute("listUMestado")
	public List<LabelValue> listUM_estado(){
	    return utilService.listEstadoEjecucion();
	}		
	@ModelAttribute("listTiposejecfile")
	public List<LabelValue> listTiposejecfile(){
	    return utilService.listTipos_ejecfile();
	}	
	@RequestMapping(value = "/{actId}", method = RequestMethod.GET)
	public String getResponsables(@PathVariable BigDecimal actId, Map<String, Object> map, HttpSession session) {
		EjecucionActividad eje = ejecucionActividadService.getEjecucionActividad_BY(actId);
		if(eje.getIdejecucion() == null){
			EjecucionActividad ejeact = new EjecucionActividad();
			ejeact.setActividad(actividadService.getActividad(actId));
			ejecucionActividadService.saveEjecucionActividad(ejeact,session);
		}
		Actividad act = actividadService.getActividad(actId);
		Efa efa = efaService.getEfa(act.getIdefa());
		EjecucionActividad peje = ejecucionActividadService.getEjecucionActividad_BY(actId);
		EjecucionActividad ppeje = ejecucionActividadService.getEjecucionActividad(peje.getIdejecucion());
		map.put("efa", efa);
		map.put("act", act);
		map.put("actId", actId);
		map.put("eje", ppeje);
		map.put("ejecfile", new EjecucionFile());
		map.put("listEfiles", ppeje.getEjecfiles());
		return "/ejecucion/ejecucionActividad";
	}		
	
	
	@RequestMapping(value="/addejeact", method = RequestMethod.POST)
	public String getResponsablesdsa(@RequestParam("id") BigDecimal actId, @ModelAttribute("eje") EjecucionActividad ejecucionActividad, HttpSession session) {
		Actividad actividad = actividadService.getActividad(actId);
		
		actividad.setSupervision(ejecucionActividad.getSupespecial());
		actividad.setHallazgo(ejecucionActividad.getHallazgos());
		actividadService.saveActividad(actividad,session);
//		EjecucionActividad peje = ejecucionActividadService.getEjecucionActividad(ideje);
		ejecucionActividad.setActividad(actividad);
//		peje.setEstado(ejecucionActividad.getEstado());
//		peje.setFecha(ejecucionActividad.getFecha());
//		peje.setFechaejec(ejecucionActividad.getFechaejec());
//		peje.setHallazgos(ejecucionActividad.getHallazgos());
//		peje.setSupespecial(ejecucionActividad.getSupespecial());
//		peje.setObservacion(ejecucionActividad.getObservacion());
		ejecucionActividadService.saveEjecucionActividad(ejecucionActividad,session);
		
		String linkr = "redirect:/ejeact/" + actId;  
					
		return linkr;
	}
	
}
