package pe.gob.oefa.efa.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;


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

import pe.gob.oefa.efa.model.Padron;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.service.PadronService;
import pe.gob.oefa.efa.service.SupervisorEmergenciaService;
import pe.gob.oefa.efa.service.SupervisorFileService;
import pe.gob.oefa.efa.service.SupervisorService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private SupervisorService supervisorService;	
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private PadronService padronService;
	
	@Autowired
	private SupervisorFileService supervisorFileService;	
	
	@Autowired
	private SupervisorEmergenciaService supervisorEmergenciaService;	
		
	@ModelAttribute("listDep")
	public List<LabelValue> getDeps(){
	    return ubigeoService.listDep();
	}	

	 @ModelAttribute("listEstadoCivil")
     public List<LabelValue> getEstadoCivil() {
		    return utilService.listEstadoCivil();
	 }		

	 @ModelAttribute("listMcontrato")
     public List<LabelValue> getMcontrato() {
		    return utilService.listMcontrato();
	 }		 
	 @ModelAttribute("listBanco")
     public List<LabelValue> getBanco() {
		    return utilService.listBanco();
	 }	 
//	 @ModelAttribute("listCargos")
//     public List<LabelValue> getCargos() {
//		    return utilService.listCargos();
//	 }	 
	 @ModelAttribute("listSexo")
     public List<LabelValue> getSexo() {
		    return utilService.listSexo();
	 }		 
	 @ModelAttribute("listSupfiles")
     public List<LabelValue> getSupfiles() {
		    return utilService.listSupfiles();
	 }		 
	 
	/**/
	@RequestMapping(value = { "/", "/listSupervisores" })
	public String listSupervisores(Map<String, Object> map, HttpSession session) {
		session.removeAttribute("actEfa");
		map.put("supervisor", new Supervisor());
		map.put("supList", supervisorService.listSupervisores());
		return "/supervisor/listSupervisores";
	}

	/**/ /*regreso x actividad*/
	@RequestMapping(value = { "/{actId}" })
	public String listSupervisoresAct(@PathVariable("actId") BigDecimal actId, Map<String, Object> map, HttpSession session) {
		session.setAttribute("actEfa", actId);
		map.put("supervisor", new Supervisor());
		map.put("supList", supervisorService.listSupervisores());
		return "/supervisor/listSupervisores";
	}	
	
	
	@RequestMapping(value = "/edit/{suid}", method = RequestMethod.GET)
	public String edit(@PathVariable("suid") BigDecimal suid, Map<String, Object> map) {
	    Supervisor supervisor = supervisorService.getSupervisor(suid);
	    map.put("edit", 1);
	    map.put("supervisor", supervisor);
	    map.put("listProv", ubigeoService.listProv(supervisor.getDepartamento()));
	    map.put("listDis", ubigeoService.listDist(supervisor.getDepartamento(),supervisor.getProvincia()));    
	    return ("/supervisor/listSupervisores");
	}		
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSupervisor(@ModelAttribute("supervisor") Supervisor supervisor,
			BindingResult result, HttpSession session) {
		
		Map<String, String> sf = supervisorService.getDni(supervisor.getDni());
		if(sf.get("APEPAT") == "null"){
		Padron pad = new Padron();
		pad.setApemat(supervisor.getAppMaterno());
		pad.setApepat(supervisor.getAppPaterno());
		pad.setNombre(supervisor.getNombre());
		pad.setCodsex(supervisor.getSexo().charAt(0));
		DateFormat df = new SimpleDateFormat("ddMMyyyy");
		Date today = (Date) supervisor.getFechaNac();     
		String reportDate = df.format(today);
		pad.setFecnac(reportDate);
		pad.setApepat(supervisor.getAppPaterno());
		pad.setNumdle(supervisor.getDni());
		pad.setCoddep(supervisor.getDepartamento());
		pad.setCodpro(supervisor.getProvincia());
		pad.setCoddis(supervisor.getDistrito());
		padronService.savePadron(pad);
		}
		supervisorService.saveSupervisor(supervisor);
		
		String linkr = "redirect:/supervisor/";  
		if(session.getAttribute("actEfa") != null)
				linkr = "redirect:/supervisor/" + session.getAttribute("actEfa");		
					
		return linkr;			
	}


	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> pdeleteEfa(@RequestParam("id") BigDecimal id) {
		List<SupervisorFile> sf = supervisorService.listFiles_by_ID(id);
		List<SupervisorEmergencia> se = supervisorService.listEmergencias_by_ID(id);
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		if(sf.isEmpty() && se.isEmpty()){
			supervisorService.deleteSupervisor(id);
			selectItems.add(new LabelValue("success","1"));
		}else{
			selectItems.add(new LabelValue("success","0"));
		}
		return selectItems;
	}		
	
	

	@RequestMapping("/suparchivo/{supId}")
	public String getSupervisorFiles(@PathVariable BigDecimal supId, Map<String, Object> map, HttpSession session) {
		map.put("supfileList", supervisorService.listFiles_by_ID(supId));
		map.put("supfile", new SupervisorFile());
		Supervisor sup = supervisorService.getSupervisor(supId);
		map.put("supe", sup);
		return "/supervisor/listSuparchivos";
	}	
	
	@RequestMapping("/supemergencia/{supId}")
	public String getSupervisorEmergencias(@PathVariable BigDecimal supId, Map<String, Object> map, HttpSession session) {
		map.put("supemList", supervisorService.listEmergencias_by_ID(supId));
		map.put("supem", new SupervisorEmergencia());
		Supervisor sup = supervisorService.getSupervisor(supId);
		map.put("sup", sup);
		return "/supervisor/listSupemergencias";
	}		
	

	
	
	@RequestMapping(value = "/getdni", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Map<String, String> getDni(@RequestParam("dni") String dni) {
		Map<String, String> sf = supervisorService.getDni(dni);
		return sf;
	}		
	
	
}
