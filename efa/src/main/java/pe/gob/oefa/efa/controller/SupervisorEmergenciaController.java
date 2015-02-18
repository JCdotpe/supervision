package pe.gob.oefa.efa.controller;

import java.math.BigDecimal;
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

import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.service.SupervisorEmergenciaService;
import pe.gob.oefa.efa.service.SupervisorFileService;
import pe.gob.oefa.efa.service.SupervisorService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/supemergencia")
public class SupervisorEmergenciaController {

	@Autowired
	private SupervisorService supervisorService;	
	
	@Autowired
	private UtilService utilService;
	
	@Autowired
	private SupervisorEmergenciaService supervisorEmergenciaService;	
		 

	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String getResponsablesdsa(@RequestParam("id") BigDecimal efaId,@ModelAttribute("responsable") SupervisorEmergencia supervisorEmergencia, HttpSession session) {
		Supervisor supervisor = supervisorService.getSupervisor(efaId);
		supervisorEmergencia.setSupervisor(supervisor);
		supervisorEmergenciaService.saveSupervisorEmergencia(supervisorEmergencia,session);
		return "redirect:/supervisor/supemergencia/" + efaId;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> pdeleteEfa(@RequestParam("id") BigDecimal id, HttpSession session) {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		supervisorEmergenciaService.deleteSupervisorEmergencia(id,session);
		selectItems.add(new LabelValue("success","1"));
		return selectItems;
	}		

}
