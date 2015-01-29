package pe.gob.oefa.efa.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;







import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import pe.gob.oefa.efa.model.Administrado;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Ubigeo;
import pe.gob.oefa.efa.model.UnidadMinera;
import pe.gob.oefa.efa.service.AdministradoService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.ResponsableService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.service.UnidadMineraService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/uminera")
public class UnidadMineraController {
	
	@Autowired
	private UnidadMineraService unidadMineraService;	
	
	@Autowired
	private AdministradoService administradoService;	
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private UbigeoService ubigeoService;
		
	@ModelAttribute("listTipos")
    public List<LabelValue> getTipos() {
		    return utilService.listTipos_contacto();
	 }	
	@ModelAttribute("listDep")
	public List<LabelValue> getDeps(){
	    return ubigeoService.listDep();
	}		
	@ModelAttribute("listSector")
	public List<LabelValue> getSector(){
	    return utilService.listUMSector();
	}
	@ModelAttribute("listUMestado")
	public List<LabelValue> listUM_estado(){
	    return utilService.listUM_estado();
	}	
	@ModelAttribute("listZonaGeografica")
	public List<LabelValue> listZonaGeografica(){
	    return utilService.listZonaGeografica();
	}		
	@ModelAttribute("listUMcuenca")
	public List<LabelValue> listUMcuenca(){
	    return utilService.listUM_cuenca();
	}	
		
	@ModelAttribute("listTiposDerechoM")
    public List<LabelValue> listTipos_DerechoM() {
		    return utilService.listTipos_DerechoM();
	}	
	@RequestMapping(value="/addum", method = RequestMethod.POST)
	public String getResponsablesdsa(@RequestParam("id") BigDecimal admId,@ModelAttribute("unidadm") UnidadMinera unidadMinera, HttpSession session) {
		Administrado adm = administradoService.getAdministrado(admId);
		unidadMinera.setAdministrado(adm);
		unidadMineraService.saveUnidadMinera(unidadMinera);
		String linkr = "redirect:/administrados/um/" + admId;  
					
		return linkr;
	}			
		
	@RequestMapping(value = "/deleteum", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> pdeleteAct(@RequestParam("id") BigDecimal id) {
		UnidadMinera unidadMinera = unidadMineraService.getUnidadMinera(id);
		
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		unidadMineraService.deleteUnidadMinera(id);;
		selectItems.add(new LabelValue("success","1"));
		return selectItems;
	}			

	@RequestMapping(value = "/editum/{umId}", method = RequestMethod.GET)
	public String edit(@PathVariable("umId") BigDecimal umId, Map<String, Object> map) {
		UnidadMinera unidadMinera = unidadMineraService.getUnidadMinera(umId);
		 map.put("edit", 1);
	    map.put("unidadM", unidadMinera);
	    map.put("listProv", ubigeoService.listProv(unidadMinera.getDepartamento()));
	    map.put("listDis", ubigeoService.listDist(unidadMinera.getDepartamento(),unidadMinera.getProvincia()));	  
	    map.put("listUMAct", utilService.listUMAct(unidadMinera.getSector().toString()));
	    map.put("listUMCat", utilService.listUMCat(unidadMinera.getSector().toString(), unidadMinera.getActividad().toString()));
	    map.put("adm", administradoService.getAdministrado(unidadMinera.getAdministrado().getIdadministrados()));
	    return ("/administrados/listUnidadesMineras");
	}		
	
	
	
}
