package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.EjecucionActividad;

public interface EjecucionActividadService {

	/*
	 * CREATE and UPDATE
	 */
	public void saveEjecucionActividad(EjecucionActividad ejecucionActividad,HttpSession session); // create and update
	
	/*
	 * READ
	 */
	public EjecucionActividad getEjecucionActividad(BigDecimal id);
//	public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id);
	public EjecucionActividad getEjecucionActividad_BY(BigDecimal id);
	/*
	 * DELETE
	 */
}
