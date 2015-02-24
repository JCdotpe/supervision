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

import org.apache.axis.session.Session;
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

import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.FileUploadForm;
import pe.gob.oefa.efa.service.SupervisorFileService;
import pe.gob.oefa.efa.service.SupervisorService;	
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.utils.LabelValue;

@Controller
@RequestMapping("/suparchivo")
public class SupervisorFileController {
	
	@Autowired
	private SupervisorService supervisorService;	
	
	@Autowired
	private SupervisorFileService supervisorFileService;	
	
	@Autowired
	private UtilService utilService;
		
	@RequestMapping(value = "/savefile", method = RequestMethod.POST)
	    public String save(@RequestParam("id") BigDecimal ciId, @RequestParam("file") MultipartFile file,
	    		@RequestParam("tipo") String tipo, Model map, HttpSession session) throws IllegalStateException, IOException {

		String basePath = System.getProperty("catalina.base")+"/webapps/efa/resources/Desarrollo_App/SISEFA/supervisor/";
		System.out.println(basePath);
		new File(basePath).mkdirs();		
		
		String saveDirectory = basePath;
		
   
			Integer max = 10 * 1024 * 1024; // 10MB
	                String fileName = file.getOriginalFilename();
	                
	                String filexname = utilService.createNewFileName(fileName);
	                
	                String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp|doc|docx|pdf))$)";		
	                Pattern pattern = Pattern.compile(IMAGE_PATTERN);
	                Matcher matcher = pattern.matcher(filexname.toLowerCase().replaceAll("\\s",""));
	                
	                if (file.getSize() > max || file.getSize() == 0) {
	                	JOptionPane.showMessageDialog(null, "El tamaño del archivo no es el permitido", "Error",
                                JOptionPane.ERROR_MESSAGE);
	                }else{            
		                if(matcher.matches()){
			                file.transferTo(new File(saveDirectory + filexname));
			                SupervisorFile supervisorFile = new SupervisorFile();
			                Supervisor supervisor = supervisorService.getSupervisor(ciId);
			                supervisorFile.setSupervisor(supervisor);
			                supervisorFile.setNombre(filexname);
			                supervisorFile.setTipo(tipo);
			                supervisorFileService.saveSupervisorFile(supervisorFile, session);
		                }else{
		                	JOptionPane.showMessageDialog(null, "La extension del archivo no esta permitida", "Error",
	                                JOptionPane.ERROR_MESSAGE);
		                }
	                }
	        return "redirect:/supervisor/suparchivo/" + ciId;
	    }	

	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> pdeleteEfa(@RequestParam("id") BigDecimal id, HttpSession session) {
		List<LabelValue> selectItems = new ArrayList<LabelValue>();
		supervisorFileService.deleteSupervisorFile(id,session);
		selectItems.add(new LabelValue("success","1"));
		return selectItems;
	}		
		
}

