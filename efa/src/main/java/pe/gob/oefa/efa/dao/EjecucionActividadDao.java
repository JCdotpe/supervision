package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import pe.gob.oefa.efa.model.EjecucionActividad;

public interface EjecucionActividadDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveEjecucionActividad(EjecucionActividad ejecucionActividad); // create and update
	
	/*
	 * READ
	 */
	public EjecucionActividad getEjecucionActividad(BigDecimal id);
	public EjecucionActividad getEjecucionActividad_BY(BigDecimal id);
	/*
	 * DELETE
	 */
}
