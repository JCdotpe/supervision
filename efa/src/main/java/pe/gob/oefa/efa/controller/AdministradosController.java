package pe.gob.oefa.efa.controller;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;




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
import pe.gob.oefa.efa.model.Administrado;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.model.UnidadMinera;
import pe.gob.oefa.efa.service.ActividadService;
import pe.gob.oefa.efa.service.AdministradoService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.ResponsableService;
import pe.gob.oefa.efa.service.SupervisorEmergenciaService;
import pe.gob.oefa.efa.service.SupervisorFileService;
import pe.gob.oefa.efa.service.SupervisorService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/administrados")
public class AdministradosController {
	
	@Autowired
	private UbigeoService ubigeoService;
	
	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private AdministradoService administradoService;
		
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

	@ModelAttribute("listTipoDoc")
    public List<LabelValue> listTipoDoc() {
		    return utilService.listTipos_Documento();
	}		
	
	@ModelAttribute("listTipoAct")
    public List<LabelValue> getTipoAct() {
		    return utilService.listTipoActividad();
	}		
	
	@ModelAttribute("listTipoPersona")
    public List<LabelValue> listTipoPersona() {
		    return utilService.listTipos_Persona();
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
	@RequestMapping(value = { "/", "/listAdministrados" })
	public String listSupervisores(Map<String, Object> map) {
//		map.put("adms",efaService.listEfas());					;
		map.put("administrado", new Administrado());
		map.put("admList", administradoService.listAdministrados());
		return "/administrados/listAdministrados";
	}
	
	@RequestMapping(value = "/edit/{admid}", method = RequestMethod.GET)
	public String edit(@PathVariable("admid") BigDecimal admid, Map<String, Object> map) {
		Administrado administrado = administradoService.getAdministrado(admid);	
		 map.put("edit", 1);
	    map.put("administrado", administrado);
	    map.put("listProv", ubigeoService.listProv(administrado.getDepartamento()));
	    map.put("listDis", ubigeoService.listDist(administrado.getDepartamento(),administrado.getProvincia()));
	    return ("/administrados/listAdministrados");
	}		
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveSupervisor(@ModelAttribute("administrado") Administrado administrado,
			BindingResult result, HttpSession session) {
//		edicion
		if(administrado.getIdadministrados() != null){
			Administrado preadm = administradoService.getAdministrado(administrado.getIdadministrados());
			//sup
			administrado.setUnidadesm(preadm.getUnidadesm());
		}
		administrado.setFlgactivo("1");
		administradoService.saveAdministrado(administrado,session);;
		return "redirect:listAdministrados";
	}
	
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> pdeleteAct(@RequestParam("id") BigDecimal id,HttpSession session) {
		Administrado adm = administradoService.getAdministrado(id);
		
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		if(adm.getUnidadesm().size() == 0){
			administradoService.deleteAdministrado(id,session);
			selectItems.add(new LabelValue("success","1"));
		}else{
			selectItems.add(new LabelValue("success","2"));
		}
		return selectItems;
	}		
	
	@RequestMapping({"/um/{admId}"})
	public String getResponsables(@PathVariable BigDecimal admId, Map<String, Object> map, HttpSession session) {
		Administrado adm = administradoService.getAdministrado(admId);
		
		//Eliminar de la lista los inactivos para mostrar
		Iterator<UnidadMinera> iterator = adm.getUnidadesm().iterator();
		while(iterator.hasNext()) {
			UnidadMinera oUnidadMinera = iterator.next();
			if((oUnidadMinera.getFlgactivo()==null?"1":oUnidadMinera.getFlgactivo()).equals("0")){
				iterator.remove();
			}
		}		
		
	
		
		map.put("unidadM", new UnidadMinera());
		map.put("adm", adm);
		map.put("listUM", adm.getUnidadesm());
		
		
		
		return "/administrados/listUnidadesMineras";
	}		
	
}
