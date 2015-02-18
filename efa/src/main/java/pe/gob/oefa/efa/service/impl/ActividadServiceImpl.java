package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import java.sql.CallableStatement;
import java.sql.Connection;
import pe.gob.oefa.efa.utils.ConnectionManager;
import pe.gob.oefa.efa.utils.LabelValue;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.ActividadDao;
import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;

import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.service.ActividadService;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;


@Service
public class ActividadServiceImpl implements ActividadService {
	
	@Autowired
	private ActividadDao actividadDao;
	
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional
	public void saveActividad(Actividad actividad,HttpSession session) {
	     actividad.setFlgactivo("1"); //modificado
		 actividadDao.saveActividad(actividad);
		 
		 auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				 actividad.getId() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
							ConstantAuditoria.Table_Supervicion_Efa_Actividad, actividad.getId() != null ? actividad.getId().toString() : "");
		 
	}

	@Transactional(readOnly = true)
	public List<Actividad> listActividades(String usuario,String perfil) {
		return actividadDao.listActividades(usuario,perfil); //modificado
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
	public void deleteActividad(BigDecimal id,HttpSession session) {
		actividadDao.deleteActividad(id);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervicion_Efa_Actividad, id.toString());
		
	}
	
	@Transactional
	public void deleteActResponsable(BigDecimal actid, BigDecimal resid,HttpSession session) {
		actividadDao.deleteActResponsable(actid, resid);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervicion_Efa_Actividad_Responsable, actid.toString());
		
	}
	
	@Transactional
	public void deleteActSupervisor(BigDecimal actid, BigDecimal supid,HttpSession session) {
		actividadDao.deleteActSupervisor(actid, supid);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervicion_Efa_Actividad_Supervisor, actid.toString());
		
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
			/*String cod = ("000000" + idact.toString()).substring(idact.toString().length());
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
				}*/
				
				
		        CallableStatement callableStatement = null;
		        Connection connection = null;			
				
				try{
		    	connection = ConnectionManager.getConnection();
			    
			    
			    String storeProcedure = "{ CALL supervision.get_codactividad(?,?) }";
			    
		        connection = ConnectionManager.getConnection();
		      
		        callableStatement = connection.prepareCall(storeProcedure);	    
			    
		        callableStatement.setBigDecimal(1, idact);
		        callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			  
		        callableStatement.execute();
		        


				} catch (SQLException e) { e.printStackTrace(); }		
				finally {
					try{
						if (callableStatement != null) {
							callableStatement.close();
						}
				
						if (connection != null) {
							connection.close();
						}
					}catch (SQLException e) { e.printStackTrace(); }

				}				
				
				
				
				
		}
	
		//actividad.setEstado(estado);
		//actividadDao.saveActividad(actividad);

	}
	
	@Transactional
	public void saveActividadMatriz(MatrizActividad matrizactividad,HttpSession session) {
		 actividadDao.saveActividadMatriz(matrizactividad);
		 
		 auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				 matrizactividad.getIdmatrizactividad() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
							ConstantAuditoria.Table_Supervicion_MatrizActividad, matrizactividad.getIdmatrizactividad() != null ? matrizactividad.getIdmatrizactividad().toString() : "");
	}	
	

}
