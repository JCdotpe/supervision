package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;
import pe.gob.oefa.efa.model.MatrizActividad;
import pe.gob.oefa.efa.seguridad.Usuario;

public interface ActividadDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveActividad(Actividad actividad); // create and update
	public void saveActividadMatriz(MatrizActividad matrizactividad);	
	
	/*
	 * READ
	 */
	public List<Actividad> listActividades(String usuario,String perfil);
	public List listActividades_by(String fechaini, String fechafin, String nombrefa, String nombresup, String nivel, String informe, String codact, String estado, String estadomatriz, String estadoejec,Usuario usuario );
	public Actividad getActividad(BigDecimal id);
//	public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id);
	/*
	 * DELETE
	 */
	public void deleteActResponsable(BigDecimal actid, BigDecimal resid );
	public void deleteActSupervisor(BigDecimal actid, BigDecimal supid );
	public void deleteActividad(BigDecimal id);
	
	public void updateActividad(Actividad actividad);
}
