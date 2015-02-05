package pe.gob.oefa.efa.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;






import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import pe.gob.oefa.efa.dao.ActividadDao;
import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.ArchivoFunciones;
import pe.gob.oefa.efa.model.ComponenteMatriz;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.FuncionesComponente;
import pe.gob.oefa.efa.model.IndicadoresFuncion;
import pe.gob.oefa.efa.model.Matriz;
import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.model.MatrizActividadFuncion;
import pe.gob.oefa.efa.model.MatrizActividadIndicador;
import pe.gob.oefa.efa.service.ActividadService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.MatrizService;
import pe.gob.oefa.efa.service.UtilService;
import pe.gob.oefa.efa.service.impl.ActividadServiceImpl;
import pe.gob.oefa.efa.utils.LabelValue;


@Controller
@RequestMapping({"/matriz"})
public class MatrizController {
	
	@Autowired
	private MatrizService matrizservice;

	@Autowired
	private ActividadService actividadService;
	
	@Autowired
	private EfaService efaService;
	
	@Autowired
	private UtilService utilService;
	
	
	@RequestMapping(value = "/addIndicadoresbyFuncion", method = RequestMethod.POST)
	public String addIndicadoresbyFuncion(HttpServletRequest request, Map<String, Object> map) {
		String[] chk_indicador = request.getParameterValues("chk_indicador");
		int idmatrizactividad = Integer.parseInt(request.getParameter("idmatrizactividad"));
		int idfuncion = Integer.parseInt(request.getParameter("idfuncion"));
		String txtaObservacion  = request.getParameter("txtaObservacion");
		MatrizActividadFuncion ma = new MatrizActividadFuncion();
		
		List<MatrizActividadFuncion> listMaf = matrizservice.getListMatrizFuncion(idmatrizactividad, idfuncion);
		MatrizActividadFuncion maf = listMaf.get(0);
		
		ma.setIdmatrizactividadfunciones(maf.getIdmatrizactividadfunciones());
		ma.setEstadomatrizactividadfunciones("1");
		ma.setIdfuncion(maf.getIdfuncion());
		ma.setIdmatrizactividad(maf.getIdmatrizactividad());
		ma.setObservaciones(txtaObservacion);
		matrizservice.saveMatrizActividadFuncion(ma);
		for(int i =0; i<chk_indicador.length; i++){
			MatrizActividadIndicador mai = new MatrizActividadIndicador();
			mai.setIdmatrizactividadfunciones(maf.getIdmatrizactividadfunciones());
			mai.setIdindicador(Integer.parseInt(chk_indicador[i]));
			matrizservice.addMatrizactividadindicador(mai);
		}
		MatrizActividad mactividad = matrizservice.getMatrizAct(maf.getIdmatrizactividad());

		List<ComponenteMatriz> mlistComp = matrizservice.getComponente(mactividad.getIdmatriz());
		List<FuncionesComponente> lFunciones = new ArrayList<FuncionesComponente>();
		for (int i = 0; i < mlistComp.size(); i++) {
			List<FuncionesComponente> lf = matrizservice.getFunciones(mlistComp.get(i).getIdcomponente());
			for (int j = 0; j < lf.size(); j++) {
				FuncionesComponente fc = lf.get(j);
				lFunciones.add(fc);
			}
		}

		List<MatrizActividadFuncion> mlaf = matrizservice.getListMatrizFuncionByIdMa(mactividad.getIdmatrizactividad(), "1");		
		if (lFunciones.size() == mlaf.size()) {
			mactividad.setIdactividad(mactividad.getIdactividad());
			mactividad.setIdmatriz(mactividad.getIdmatriz());
			mactividad.setEstadomatrizactividad("2");
			actividadService.saveActividadMatriz(mactividad);
		}
		
		return "redirect:get/" + mactividad.getIdactividad();
	}
	
	@RequestMapping(value = { "/saveMatrizActividad" }, method = RequestMethod.POST)
	@ResponseBody
	public String saveMatrizActividad(HttpServletRequest request, Map<String, Object> map ){
		String chk_matriz = request.getParameter("idMatriz");
		String estado = request.getParameter("estado");	
		int codActividad = Integer.parseInt(request.getParameter("idactividad"));
		int codMatriz = Integer.parseInt(chk_matriz);
		List<MatrizActividad> ListMacti = matrizservice.getbyMatrizActividad(codActividad, codMatriz);
		if(ListMacti.size() == 0){
			MatrizActividad mact = new MatrizActividad();
			mact.setIdactividad(codActividad);
			mact.setIdmatriz(codMatriz);
			mact.setEstadomatrizactividad("1");
			actividadService.saveActividadMatriz(mact);
			List<ComponenteMatriz> mlistComp = matrizservice.getComponente(codMatriz);
			for (int k = 0; k < mlistComp.size(); k++) {
				List<FuncionesComponente> lf = matrizservice.getFunciones(mlistComp.get(k).getIdcomponente());
				for (int l = 0; l < lf.size(); l++) {
					List<MatrizActividad> ma = matrizservice.getMatrizActividad(codActividad, codMatriz); 
					MatrizActividadFuncion maf = new MatrizActividadFuncion();
					maf.setIdfuncion(lf.get(l).getIdfuncion());
					maf.setIdmatrizactividad(ma.get(0).getIdmatrizactividad().intValueExact());
					maf.setEstadomatrizactividadfunciones("0");
					maf.setObservaciones("");
					matrizservice.addMatrizActividadFuncion(maf);
				}
			}
		}
		else{
			MatrizActividad ma = ListMacti.get(0);
			ma.setEstadomatrizactividad(estado);
			matrizservice.updateMatrizActividad(ma);
		}
		return "redirect:get/"+codActividad;
		
	}
	
	@RequestMapping(value = "/get/{idactividad}", method = RequestMethod.GET)
	public String getByActividad(@PathVariable("idactividad") BigDecimal idactividad, Map<String, Object> map) {
		List<MatrizActividad> ma = matrizservice.listByActividad(idactividad);
		ArrayList<Matriz> mlist = new ArrayList<Matriz>();
		List<ComponenteMatriz> mlistComponente = new ArrayList<ComponenteMatriz>();
		List<FuncionesComponente> mlistFunciones = new ArrayList<FuncionesComponente>();
		List<IndicadoresFuncion> mlistIndicadores = new ArrayList<IndicadoresFuncion>();
		List<MatrizActividadFuncion> mListActividadFuncion = new ArrayList<MatrizActividadFuncion>();
		List<MatrizActividadIndicador> mListActividadIndicador = new ArrayList<MatrizActividadIndicador>();
		Actividad act = actividadService.getActividad(idactividad);
		Efa efa = efaService.getEfa(act.getIdefa());
		
		for (int i = 0; i < ma.size(); i++) {
			Matriz m = matrizservice.getMatriz(ma.get(i).getIdmatriz());
			List<ComponenteMatriz> mlistComp = matrizservice.getComponente(ma.get(i).getIdmatriz());
			List<MatrizActividadFuncion> mlaf = matrizservice.getListMatrizFuncionByIdMa(ma.get(i).getIdmatrizactividad(), "-1");
			mlist.add(m);
			for (int j = 0; j < mlistComp.size(); j++) {
				ComponenteMatriz cmz = mlistComp.get(j);
				mlistComponente.add(cmz);
			}
			for (int j = 0; j < mlaf.size(); j++) {
				System.out.println(mlaf.get(j).getEstadomatrizactividadfunciones());
				MatrizActividadFuncion mafuncion = mlaf.get(j);
				mListActividadFuncion.add(mafuncion);
			}
		}
		for (int i = 0; i < mlistComponente.size(); i++) {
			List<FuncionesComponente> lf = matrizservice.getFunciones(mlistComponente.get(i).getIdcomponente());
			for (int j = 0; j < lf.size(); j++) {
				FuncionesComponente fc = lf.get(j);
				mlistFunciones.add(fc);
			}
		}
		
		for (int i = 0; i < mlistFunciones.size(); i++) {
			List<IndicadoresFuncion> ifn = matrizservice.getIndicadores(mlistFunciones.get(i).getIdfuncion());
			for (int j = 0; j < ifn.size(); j++) {
				IndicadoresFuncion ifuncion = ifn.get(j);
				mlistIndicadores.add(ifuncion);
			}
		}
		
		for (int i = 0; i < mListActividadFuncion.size(); i++) {
			List<MatrizActividadIndicador> lmai = matrizservice.getIndicadoresActividad(mListActividadFuncion.get(i).getIdmatrizactividadfunciones());
			for (int j = 0; j < lmai.size(); j++) {
				MatrizActividadIndicador mactividadIndicador = lmai.get(j);
				mListActividadIndicador.add(mactividadIndicador);
			}
		}
		
		
		map.put("listMatrices", mlist);
		map.put("listMatrizActividad", ma);
		map.put("listComponentes", mlistComponente);
		map.put("listFunciones", mlistFunciones);
		map.put("mlistIndicadores", mlistIndicadores);
		map.put("mListActividadFuncion", mListActividadFuncion);
		map.put("mListActividadIndicador", mListActividadIndicador);
		map.put("actividad", act);
		map.put("nombreefa", efa.getNombre());
	    return ("/matriz/listMatriz");
	}
	

	@RequestMapping(value = "/getMatrices", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<LabelValue> getMatrices(@RequestParam("codActividad") String codActividad,
			@RequestParam("codNivel") int codNivel) {
			
		// return matrizservice.listMatrices(codNivel, codActividad);
		
		Actividad act = new Actividad();
		act = actividadService.getActividad(new BigDecimal(codActividad));	
		
		return matrizservice.listMatrices(codNivel, act.getIdefa());		
		
	}
	
	@RequestMapping(value = "/getMatricesActividadbyId", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<MatrizActividad> getMatricesActividadbyId(@RequestParam("idActividad") int idActividad,
			@RequestParam("idMatriz") int idMatriz) {
		
		return matrizservice.getbyMatrizActividad(idActividad, idMatriz);
		
	}
	

	@RequestMapping(value = "/saveArchive", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ArchivoFunciones> saveArchive(@RequestParam("idmatrizactividad") int idmatrizactividad, @RequestParam("idfuncion") int idfuncion,
			@RequestParam("tipo") String tipo, @RequestParam("nombrearchivo") String nombrearchivo,
            @RequestParam("archivo") MultipartFile file, Map<String, Object> map) {
		if (!file.isEmpty()) {
			try {

				String saveDirectory = "C:/Desarrollo_App/SISEFA/";
				Integer max = 5 * 1024 * 1024; // 10MB
                String fileName = file.getOriginalFilename();
                
                String filexname = utilService.createNewFileName(fileName);
                
                String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(pdf|doc|docx))$)";		
                Pattern pattern = Pattern.compile(IMAGE_PATTERN);
                Matcher matcher = pattern.matcher(filexname.toLowerCase().replaceAll("\\s",""));
                
                if (file.getSize() > max || file.getSize() == 0) {
                	JOptionPane.showMessageDialog(null, "El tamaño del archivo no es el permitido", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }else{            
	                if(matcher.matches()){
		                file.transferTo(new File(saveDirectory + filexname));
						List<MatrizActividadFuncion> listMaf = matrizservice.getListMatrizFuncion(idmatrizactividad, idfuncion);
						MatrizActividadFuncion maf = listMaf.get(0);
						ArchivoFunciones af = new ArchivoFunciones();
						af.setIdmatrizactividadfunciones(maf.getIdmatrizactividadfunciones());
						af.setEstadoarchivo("1");
						af.setNombrearchivo(nombrearchivo);
						af.setTipo(tipo);
						af.setArhivo(filexname);
						matrizservice.addArchiveFuncion(af);
	                }
	                else{
	                	JOptionPane.showMessageDialog(null, "La extension del archivo no esta permitida.", "Error",
                                JOptionPane.ERROR_MESSAGE);
	                }
	           }
				
			} catch (Exception e) {
				List<MatrizActividadFuncion> listMaf = matrizservice.getListMatrizFuncion(idmatrizactividad, idfuncion);
				return matrizservice.listArchives(listMaf.get(0).getIdmatrizactividadfunciones());
			}
		} else {
			List<MatrizActividadFuncion> listMaf = matrizservice.getListMatrizFuncion(idmatrizactividad, idfuncion);
			return matrizservice.listArchives(listMaf.get(0).getIdmatrizactividadfunciones());
		}
		List<MatrizActividadFuncion> listMaf = matrizservice.getListMatrizFuncion(idmatrizactividad, idfuncion);
		return matrizservice.listArchives(listMaf.get(0).getIdmatrizactividadfunciones());
		 
	}
	
	@RequestMapping(value = "/getArchivesFuncion", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public List<ArchivoFunciones> getArchivesFuncion(@RequestParam("idmatrizactividad") int idmatrizactividad,
			@RequestParam("idfuncion") int idfuncion) {
		List<MatrizActividadFuncion> listMaf = matrizservice.getListMatrizFuncion(idmatrizactividad, idfuncion);
		return matrizservice.listArchives(listMaf.get(0).getIdmatrizactividadfunciones());
	}
	

	@RequestMapping(value = "/checkArchive", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public int checkArchive(@RequestParam("idmatrizactividad") int idmatrizactividad,
			@RequestParam("idfuncion") int idfuncion) {
		List<MatrizActividadFuncion> listMaf = matrizservice.getListMatrizFuncion(idmatrizactividad, idfuncion);
		List<ArchivoFunciones> archives = matrizservice.listArchives(listMaf.get(0).getIdmatrizactividadfunciones());

		return archives.size();
	}
	
	@RequestMapping(value = "/deleteArchive", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public boolean deleteArchive(@RequestParam("idArchive") int idArchive) {
		matrizservice.deleteArchive(idArchive);

		return true;
	}
}
