package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.Responsable;


public interface ResponsableDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveResponsable(Responsable responsable); // create and update

	/*
	 * READ
	 */
	public List<Responsable> listResponsables();
	public List<Responsable> listResponsables_by_ID(BigDecimal id);
	public Responsable getResponsable(BigDecimal id);

	/*
	 * DELETE
	 */
	public void setResponsable(BigDecimal id );
	public void deleteResponsable(BigDecimal id);
	public void deleteResponsables_by_EFAID(BigDecimal id);
}
