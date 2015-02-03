package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.Responsable;


public interface ResponsableService {

	/*
	 * CREATE and UPDATE 
	 */
//	public void saveResponsable(Responsable responsable, BigDecimal efaId);
	public void saveResponsable2(Responsable responsable, HttpSession session);
	/*
	 * READ
	 */
	public List<Responsable> listResponsables();
	public List<Responsable> listResponsables_by_ID(BigDecimal id);
	public Responsable getResponsable(BigDecimal id);

	/*
	 * DELETE
	 */
	public void deleteResponsable(BigDecimal id,HttpSession session);

}
