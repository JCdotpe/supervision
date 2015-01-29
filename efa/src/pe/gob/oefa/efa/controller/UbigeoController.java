package pe.gob.oefa.efa.controller;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.swing.text.Document;


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

import pe.gob.oefa.efa.dao.UbigeoDao;
import pe.gob.oefa.efa.model.Distrito;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Provincia;
import pe.gob.oefa.efa.model.Ubigeo;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.UbigeoService;
import pe.gob.oefa.efa.utils.LabelValue;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@Controller
@RequestMapping("/ubigeo")
public class UbigeoController {

	@Autowired
	private UbigeoService ubigeoService;
	
	@ModelAttribute("listDep")
	public List<LabelValue> getDep(){
	    return ubigeoService.listDep();
	}
	
	@RequestMapping(value="/prov", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<LabelValue> getProv(@RequestParam("depId") String depId){
	    return ubigeoService.listProv(depId);
	}

	@RequestMapping(value="/dist", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<LabelValue> getDist(@RequestParam("depId") String depId,@RequestParam("provId") String provId){
	    return ubigeoService.listDist(depId,provId);
	}

	@RequestMapping(value = "/provincia", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Provincia> obtenerProvincias(@RequestParam("ccdd") String ccdd) {
		return ubigeoService.obtenerProvincias(ccdd);
	}

	@RequestMapping(value = "/distrito", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<Distrito> obtenerDistritos(@RequestParam("ccdd") String ccdd, @RequestParam("ccpp") String ccpp) {
		return ubigeoService.obtenerDistritos(ccdd, ccpp);
	}
}
