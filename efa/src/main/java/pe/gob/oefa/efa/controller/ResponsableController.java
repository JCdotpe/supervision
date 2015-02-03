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

import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Ubigeo;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.ResponsableService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/responsable")
public class ResponsableController {
	
	@Autowired
	private ResponsableService responsableService;	
	
	@Autowired
	private EfaService efaService;	
	
	@Autowired
	private UtilService utilService;	
	
	@ModelAttribute("listTipos")
    public List<LabelValue> getTipos() {
		    return utilService.listTipos_contacto();
	 }	
	
	@ModelAttribute("listSectores")
    public List<LabelValue> getSectores() {
		    return utilService.listSector_contacto();
	 }	
	
	
	@RequestMapping(value="/addres", method = RequestMethod.POST)
	public String getResponsablesdsa(@RequestParam("id") BigDecimal efaId,@ModelAttribute("responsable") Responsable responsable, HttpSession session) {
		Efa efa = efaService.getEfa(efaId);
		responsable.setEfa(efa);		
		responsableService.saveResponsable2(responsable,session);
		
		String linkr = "redirect:/efa/detail/" + efaId;  
		if(session.getAttribute("actEfa") != null)
				linkr = "redirect:/efa/detail/" + efaId + "/" + session.getAttribute("actEfa");		
					
		return linkr;
	}			
		
	@RequestMapping("/deleteres/{responsableId}")
	public String deleteResponsable(@PathVariable("responsableId") BigDecimal id, HttpSession session) {
		Responsable responsable = responsableService.getResponsable(id);
		responsableService.deleteResponsable(id,session);
		String asd = responsable.getEfa().getId().toString();
		
		String linkr = "redirect:/efa/detail/" + asd;  
		if(session.getAttribute("actEfa") != null)
				linkr = "redirect:/efa/detail/" + asd + "/" + session.getAttribute("actEfa");
		
		return linkr;
	}	
	

	@RequestMapping(value = "/edit/{efaId}/{respId}", method = RequestMethod.GET)
	public String edit(@PathVariable("efaId") BigDecimal efaId, @PathVariable("respId") BigDecimal respId, Map<String, Object> map, HttpSession session) {
	    Responsable responsable = responsableService.getResponsable(respId);

		Efa efa = efaService.getEfa(efaId);
		map.put("responsable", responsable);
		map.put("efa", efa);

		return "/efa/listResponsables";
	}		
	
	
	
}
