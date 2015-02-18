package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.Actividad;
import pe.gob.oefa.efa.model.Administrado;
//import pe.gob.oefa.efa.model.ActividadResponsable;
import pe.gob.oefa.efa.utils.LabelValue;


public interface AdministradoService {

	public void saveAdministrado(Administrado administrado,HttpSession session); // create and update
	
	/*
	 * READ
	 */
	public List<Administrado> listAdministrados();
//	public List listAdministrados_by(String fechaini, String fechafin, String nombrefa, String nombresup, String nivel, String informe, String codact, String estado, String estadomatriz, String estadoejec );
	public Administrado getAdministrado(BigDecimal id);
//	public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id);
	/*
	 * DELETE
*/
	public void deleteAdministrado(BigDecimal id,HttpSession session);
}
