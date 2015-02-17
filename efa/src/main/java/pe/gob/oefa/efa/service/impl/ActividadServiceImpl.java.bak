package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.ActividadDao;
import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;

import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.service.ActividadService;


@Service
public class ActividadServiceImpl implements ActividadService {
	
	@Autowired
	private ActividadDao actividadDao;
	
	@Transactional
	public void saveActividad(Actividad actividad) {
		 actividadDao.saveActividad(actividad);
	}

	@Transactional(readOnly = true)
	public List<Actividad> listActividades() {
		return actividadDao.listActividades();
	}

	@Transactional(readOnly = true)
	public Actividad getActividad(BigDecimal id) {
		return actividadDao.getActividad(id);
	}
	
//	@Transactional(readOnly = true)
//	public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id) {
//		return actividadDao.listActResponsables_by_ID(id);
//	}	
	
	@Transactional
	public void deleteActividad(BigDecimal id) {
		actividadDao.deleteActividad(id);
	}
	
	@Transactional
	public void deleteActResponsable(BigDecimal actid, BigDecimal resid) {
		actividadDao.deleteActResponsable(actid, resid);
	}
	
	@Transactional
	public void deleteActSupervisor(BigDecimal actid, BigDecimal supid) {
		actividadDao.deleteActSupervisor(actid, supid);
		
	}
	
	@Transactional(readOnly = true)
	public List listActividades_by(String fechaini, String fechafin,
			String nombrefa, String nombresup, String nivel, String informe,
			String codsup, String estado, String estadomatriz, String estadoejec) {
//		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		
//		java.sql.Date fechainix = null;
//		java.sql.Date fechafinx= null;
//		try {
//			if(fechaini != null && fechaini!=""){
//			java.util.Date util_StartDate = format.parse(fechaini);
//			fechainix = new java.sql.Date( util_StartDate.getTime() );
//			}
//			if(fechafin != null && fechafin!=""){
//			java.util.Date util_EndDate = format.parse(fechafin);
//			fechafinx =  new java.sql.Date( util_EndDate.getTime() );
//			}
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		
		return actividadDao.listActividades_by(fechaini, fechafin, nombrefa, nombresup, nivel, informe, codsup, estado, estadomatriz, estadoejec);
	}
	
	@Transactional
	public void setEstadoAct(BigDecimal idact, String estado) {
		Actividad actividad = actividadDao.getActividad(idact);
		if(actividad.getEstado().compareTo("0") == 0){
			String cod = ("000000" + idact.toString()).substring(idact.toString().length());
			int year = Calendar.getInstance().get(Calendar.YEAR);
				switch ( Integer.parseInt(actividad.getNivel())) {
				case 1:
					actividad.setCodactividad( cod + "-" + year +"-ELOC");
					break;
				case 2:
					actividad.setCodactividad( cod + "-" + year +"-EREG");		
					break;
				case 3:
					actividad.setCodactividad( cod + "-" + year +"-ENAC");		
					break;				
				default:
					break;
				}	
		}
	
		actividad.setEstado(estado);
		actividadDao.saveActividad(actividad);

	}
	
	@Transactional
	public void saveActividadMatriz(MatrizActividad matrizactividad) {
		 actividadDao.saveActividadMatriz(matrizactividad);
	}	
	

}
