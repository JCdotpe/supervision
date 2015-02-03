package pe.gob.oefa.efa.controller;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pe.gob.oefa.efa.model.EjecucionActividad;
import pe.gob.oefa.efa.model.EjecucionFile;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.FileUploadForm;
import pe.gob.oefa.efa.service.EjecucionActividadService;
import pe.gob.oefa.efa.service.EjecucionFileService;
import pe.gob.oefa.efa.service.SupervisorFileService;
import pe.gob.oefa.efa.service.SupervisorService;	
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/ejecarchivo")
public class EjecucionFileController {
	
	@Autowired
	private EjecucionActividadService ejecucionActividadService;	
	
	@Autowired
	private EjecucionFileService ejecucionFileService;	
	
	@Autowired
	private UtilService utilService;
		
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	    public String save(@RequestParam("id") BigDecimal actId, @RequestParam("file") MultipartFile file,
	    		@RequestParam("tipo") String tipo,@RequestParam("nombre") String nombre, Model map, HttpSession session) throws IllegalStateException, IOException {
		
		new File("C:/Desarrollo_App/SISEFA/").mkdirs();	
		String saveDirectory = "C:/Desarrollo_App/SISEFA/";  
//			String saveDirectory = "c:/upload-efa/ejecucion/";    
			Integer max = 10 * 1024 * 1024; // 10MB
	                String fileName = file.getOriginalFilename();
	                
	                String filexname = utilService.createNewFileName(fileName);
	                
	                String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|doc|docx))$)";		
	                Pattern pattern = Pattern.compile(IMAGE_PATTERN);
	                Matcher matcher = pattern.matcher(filexname.toLowerCase().replaceAll("\\s",""));
	                
	                if (file.getSize() > max || file.getSize() == 0) {
	                	JOptionPane.showMessageDialog(null, "El tamaño del archivo no es el permitido", "Error",
                                JOptionPane.ERROR_MESSAGE);
	                }else{            
		                if(matcher.matches()){
			                file.transferTo(new File(saveDirectory + filexname));
			                EjecucionFile ejecucionFile = new EjecucionFile();
			                EjecucionActividad ejecucionActividad = ejecucionActividadService.getEjecucionActividad_BY(actId);
			                ejecucionFile.setEjecucionActividad(ejecucionActividad);
			                ejecucionFile.setNombre(nombre);
			                ejecucionFile.setArchivo(filexname);
			                ejecucionFile.setTipo(tipo);
			                ejecucionFileService.saveEjecucionFile(ejecucionFile,session);
		                }else{
		                	JOptionPane.showMessageDialog(null, "La extensión del archivo no esta permitida", "Error",
	                                JOptionPane.ERROR_MESSAGE);
		                }
	                }
	        return "redirect:/ejeact/" + actId;
	    }	

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> pdeleteEfa(@RequestParam("id") BigDecimal id, HttpSession session) {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		ejecucionFileService.deleteEjecucionFile(id,session);
		selectItems.add(new LabelValue("success","1"));
		return selectItems;
	}		
		
}

