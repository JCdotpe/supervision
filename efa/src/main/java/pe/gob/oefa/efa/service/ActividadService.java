package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;
import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.seguridad.Usuario;
import pe.gob.oefa.efa.utils.LabelValue;


public interface ActividadService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveActividad(Actividad actividad,HttpSession session);
	public void saveActividadMatriz(MatrizActividad matrizactividad,HttpSession session);

	/*
	 * READ
	 */
	public List<Actividad> listActividades(String usuario,String perfil);
	public List listActividades_by(String fechaini, String fechafin, String nombrefa, String nombresup, String nivel, String informe, String codact, String estado, String estadomatriz, String estadoejec,Usuario usuario);
	public Actividad getActividad(BigDecimal id);
//	public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id);
	/*
	 * DELETE
	 */
	public void setEstadoAct(BigDecimal idact, String estado);
	public void deleteActResponsable(BigDecimal actid, BigDecimal resid,HttpSession session);
	public void deleteActSupervisor(BigDecimal actid, BigDecimal supid,HttpSession session );
	public void deleteActividad(BigDecimal id,HttpSession session);
	
	public void updateActividad(Actividad actividad);
}
