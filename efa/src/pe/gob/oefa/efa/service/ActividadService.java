package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;
import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.utils.LabelValue;


public interface ActividadService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveActividad(Actividad actividad);
	public void saveActividadMatriz(MatrizActividad matrizactividad);

	/*
	 * READ
	 */
	public List<Actividad> listActividades();
	public List listActividades_by(String fechaini, String fechafin, String nombrefa, String nombresup, String nivel, String informe, String codact, String estado, String estadomatriz, String estadoejec );
	public Actividad getActividad(BigDecimal id);
//	public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id);
	/*
	 * DELETE
	 */
	public void setEstadoAct(BigDecimal idact, String estado);
	public void deleteActResponsable(BigDecimal actid, BigDecimal resid );
	public void deleteActSupervisor(BigDecimal actid, BigDecimal supid );
	public void deleteActividad(BigDecimal id);
}
