package pe.gob.oefa.efa.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;


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
@RequestMapping("/actividad")
public class ActividadController {
	
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
	
	@RequestMapping(value = { "/", "/listActividades" })
	public String listSupervisores(Map<String, Object> map) {
		map.put("efas",efaService.listEfas());					;
		map.put("actividad", new Actividad());
		map.put("actList", actividadService.listActividades());
		return "/actividad/listActividades";
	}
	
	@RequestMapping(value = "/edit/{actid}", method = RequestMethod.GET)
	public String edit(@PathVariable("actid") BigDecimal actid, Map<String, Object> map) {
		Actividad actividad = actividadService.getActividad(actid);	
		if(actividad.getNivel().compareTo("2") == 0 || actividad.getNivel().compareTo("3") == 0 ){
			map.put("efasn",efaService.listEfas_by_NIVEL(actividad.getDepartamento(), actividad.getProvincia(), actividad.getDistrito(), actividad.getNivel()));		
		}else if(actividad.getNivel().compareTo("1") == 0){
			map.put("efasn",efaService.listEfas_by_NIVELDEP(actividad.getDepartamento(), actividad.getNivel()));		
		}

	    map.put("actividad", actividad);
	    map.put("listProv", ubigeoService.listProv(actividad.getDepartamento()));
	    map.put("listDis", ubigeoService.listDist(actividad.getDepartamento(),actividad.getProvincia()));
	    return ("/actividad/listActividades");
	}		
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSupervisor(@ModelAttribute("actividad") Actividad actividad,
			BindingResult result) {
		//edicion
		if(actividad.getId() != null){
			Actividad preact = actividadService.getActividad(actividad.getId());
			//sup
			actividad.setIdsupres(preact.getIdsupres());
			//estados				
			actividad.setEstado(preact.getEstado());
			actividad.setEstadomatriz(preact.getEstadomatriz());
			actividad.setEstadoejec(preact.getEstadoejec());
			actividad.setIdsupres(preact.getIdsupres());
			//
			actividad.setSupervisores(preact.getSupervisores());
			actividad.setResponsables(preact.getResponsables());
		}else{
			actividad.setEstado("0");
		}
		actividadService.saveActividad(actividad);
		return "redirect:listActividades";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> pdeleteAct(@RequestParam("id") BigDecimal id) {
		Actividad act = actividadService.getActividad(id);
		
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		if(act.getSupervisores().size() == 0 || act.getResponsables().size() == 0){
			actividadService.deleteActividad(id);
			selectItems.add(new LabelValue("success","1"));
		}else{
			selectItems.add(new LabelValue("success","0"));
		}
		return selectItems;
	}		
	
	
	
	@RequestMapping("/contactos/{supId}")
	public String getContactos(@PathVariable BigDecimal supId, Map<String, Object> map) {
		Actividad act = actividadService.getActividad(supId);
		map.put("respSector",utilService.listSector_contacto());
		map.put("respTipos",utilService.listTipos_contacto());
		map.put("respList", responsableService.listResponsables_by_ID(act.getIdefa()));
		map.put("efa", efaService.getEfa(act.getIdefa()));
		map.put("act",act);
		map.put("listActres", act.getResponsables());
		return "/actividad/listActividadesContactos";
	}		

	
	@RequestMapping("/addcon/{actid}/{resid}")
	public String saveActContactos(@PathVariable("actid") BigDecimal actid, @PathVariable("resid") BigDecimal resid) {
		Actividad act = actividadService.getActividad(actid);
		Set<Responsable> responsables = act.getResponsables();
		
		Responsable res = responsableService.getResponsable(resid);
	
		Boolean flag = false;
		for(Responsable r : responsables){
			BigDecimal a = r.getIdresponsable();
			if(a.equals(resid) )
				flag = true;
		}
		
		if(!flag){
			responsables.add(res);	
		}
		act.setResponsables(responsables);
		actividadService.saveActividad(act);	
		
		return "redirect:/actividad/contactos/" + actid ;
	}		

	@RequestMapping("/delcon/{actid}/{resid}")
	public String delActContactos(@PathVariable("actid") BigDecimal actid, @PathVariable("resid") BigDecimal resid) {
		actividadService.deleteActResponsable(actid, resid);
		return "redirect:/actividad/contactos/" + actid ;
	}			
	
	@RequestMapping("/supervisores/{supId}")
	public String getSupervisores(@PathVariable BigDecimal supId, Map<String, Object> map) {

		Actividad act = actividadService.getActividad(supId);
		map.put("listMcontrato",utilService.listMcontrato());	
		map.put("listSexo",utilService.listSexo());
		map.put("supList", supervisorService.listSupervisores());
		map.put("act",act);
		map.put("listActsup", act.getSupervisores());
		return "/actividad/listActividadesSupervisores";
	}	
	
	@RequestMapping("/addsup/{actid}/{supid}")
	public String saveActSupervisores(@PathVariable("actid") BigDecimal actid, @PathVariable("supid") BigDecimal supid) {
		Actividad act = actividadService.getActividad(actid);
		Set<Supervisor> supervisores = act.getSupervisores();
		Supervisor sup = supervisorService.getSupervisor(supid);
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();	
		
		Boolean flag = false;
		for(Supervisor s : supervisores){
			BigDecimal a = s.getId();
			if(a.equals(supid) )
				flag = true;
		}
		
		if(!flag && date.compareTo(sup.getFinLaboral()) < 0 ){
			supervisores.add(sup);
		}		
		
		act.setSupervisores(supervisores);
		actividadService.saveActividad(act);
		return "redirect:/actividad/supervisores/" + actid ;
	}		

	@RequestMapping("/delsup/{actid}/{supid}")
	public String delActSupervisores(@PathVariable("actid") BigDecimal actid, @PathVariable("supid") BigDecimal supid) {
		Actividad act = actividadService.getActividad(actid);
		if(act.getIdsupres().equals(supid) ){
			act.setIdsupres(null);
			actividadService.saveActividad(act);
		}
		actividadService.deleteActSupervisor(actid, supid);
		return "redirect:/actividad/supervisores/" + actid ;
	}		
	
	@RequestMapping(value = "/setsup", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody	
	public Map<String, String> setSup(@RequestParam("idact") BigDecimal idact, @RequestParam("idsupres") BigDecimal idsupres, Map<String, Object> map) {
		Actividad act = actividadService.getActividad(idact);
		act.setIdsupres(idsupres);
		actividadService.saveActividad(act);
		Map<String, String> selectItems =   new HashMap<String, String>();
		selectItems.put("success","1");
		return selectItems;
	}	
	

	@RequestMapping(value = "/setini", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> pdeleteEfa(@RequestParam("idact") BigDecimal idact) {
		
		Actividad act = actividadService.getActividad(idact);
		Map<String, String> selectItems =   new HashMap<String, String>();
		if(act.getSupervisores().size() == 0 || act.getResponsables().size() == 0 || act.getIdsupres() == null){
			selectItems.put("success","2");			
		}else{
			actividadService.setEstadoAct(idact, "1");
			selectItems.put("success","1");			
		}
		return selectItems;
	}			
}
