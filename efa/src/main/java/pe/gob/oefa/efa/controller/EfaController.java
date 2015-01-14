package pe.gob.oefa.efa.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Ubigeo;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.ResponsableService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/efa")
public class EfaController {

	@Autowired
	private EfaService efaService;
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private ResponsableService responsableService;	
	
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

	 @ModelAttribute("listTipos")
     public List<LabelValue> getTipos() {
		    return utilService.listTipos_contacto();
	 }		 
	 
	@ModelAttribute("listSectores")
	    public List<LabelValue> getSectores() {
			    return utilService.listSector_contacto();
	}		 
	
	@RequestMapping(value = { "/", "/listEfas" })
	public String listEfas(Map<String, Object> map) {

		map.put("efa", new Efa());
		map.put("efaList", efaService.listEfas());
		return "/efa/listEfas";
	}

//	@RequestMapping(value = "/edit/{efaId}", method = RequestMethod.GET)
//	public ModelAndView edit(@PathVariable("efaId") BigDecimal efaId) {
//	    Efa efa = efaService.getEfa(efaId);
//	    return new ModelAndView("/efa/listEfas","efa", efa);
//	}	
	
	@RequestMapping(value = "/edit/{efaId}", method = RequestMethod.GET)
	public String edit(@PathVariable("efaId") BigDecimal efaId, Map<String, Object> map) {
	    Efa efa = efaService.getEfa(efaId);
	    map.put("efa", efa);
	    map.put("listProv", ubigeoService.listProv(efa.getDepartamento()));
	    map.put("listDis", ubigeoService.listDist(efa.getDepartamento(),efa.getProvincia()));
	    return ("/efa/listEfas");
	}		

	@RequestMapping("/get/{efaId}")
	public String getEfa(@PathVariable BigDecimal efaId, Map<String, Object> map) {
		Efa efa = efaService.getEfa(efaId);
		map.put("efa", efa);
		return "/efa/listEfas";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEfa(@ModelAttribute("efa") Efa efa, BindingResult result, HttpSession session) {
		efaService.saveEfa(efa);
		return "redirect:listEfas";
	}

//	@RequestMapping("/delete/{efaId}")
//	public String deleteEfa(@PathVariable("efaId") BigDecimal id) {
//		efaService.deleteEfa(id);
//		return "redirect:/efa/listEfas";
//	}

	@RequestMapping(value = "/pdelete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> pdeleteEfa(@RequestParam("id") BigDecimal id) {
		List<Responsable> asd = responsableService.listResponsables_by_ID(id);
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		if(asd.isEmpty()){
			efaService.deleteEfa(id);
			selectItems.add(new LabelValue("success","1"));
		}else{
			selectItems.add(new LabelValue("success","0"));
		}
		return selectItems;
	}		

	
	/**/
	@RequestMapping({"/detail/{efaId}"})
	public String getResponsables(@PathVariable BigDecimal efaId, Map<String, Object> map, HttpSession session) {
		session.removeAttribute("actEfa");
		map.put("respList", responsableService.listResponsables_by_ID(efaId));
		Efa efa = efaService.getEfa(efaId);
		map.put("responsable", new Responsable());
		map.put("efa", efa);
		return "/efa/listResponsables";
	}	
	
	/**/ /*actividad return*/ 
	@RequestMapping({"/detail/{efaId}/{actId}" })
	public String getResponsables(@PathVariable BigDecimal efaId,@PathVariable BigDecimal actId, Map<String, Object> map, HttpSession session) {
		session.setAttribute("actEfa", actId);
		map.put("actlink", actId);
		map.put("respList", responsableService.listResponsables_by_ID(efaId));
		Efa efa = efaService.getEfa(efaId);
		map.put("responsable", new Responsable());
		map.put("efa", efa);
		return "/efa/listResponsables";
	}	


	@RequestMapping(value = "/gett", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody	
	public Map<String, String> gettEfa(@RequestParam("id") BigDecimal id, Map<String, Object> map, HttpSession session) {
		Efa efa = efaService.getEfa(id);
		Map<String, String> selectItems =   new HashMap<String, String>();
		selectItems.put("direccion",efa.getDireccion());
		selectItems.put("nombre",efa.getTnombre() + " " + efa.getTapp() + " " + efa.getTapm());
		selectItems.put("webi",efa.getWebi());
		return selectItems;
	}	
	
	
	@RequestMapping(value = "/getby", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody	
	public List<LabelValue> getbyEfa(@RequestParam("coddep") String coddep, @RequestParam("codprov") String codprov, @RequestParam("coddist") String coddist, @RequestParam("nivel") String nivel, Map<String, Object> map) {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    List<Efa> efaList = efaService.listEfas_by_NIVEL(coddep, codprov, coddist, nivel);
	    if(efaList.isEmpty()){
	    	
	    }else{
		    for (Efa efa : efaList) {
		    	selectItems.add(new LabelValue(efa.getNombre(),efa.getId().toString()));		
		    }
	    }
	    return selectItems;
	}		
	
	@RequestMapping(value = "/getbydep", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody	
	public List<LabelValue> getbyEfadep(@RequestParam("coddep") String coddep, @RequestParam("nivel") String nivel, Map<String, Object> map) {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
	    List<Efa> efaList = efaService.listEfas_by_NIVELDEP(coddep, nivel);
	    if(efaList.isEmpty()){
	    	
	    }else{
		    for (Efa efa : efaList) {
		    	selectItems.add(new LabelValue(efa.getNombre(),efa.getId().toString()));		
		    }
	    }
	    return selectItems;
	}		
}
