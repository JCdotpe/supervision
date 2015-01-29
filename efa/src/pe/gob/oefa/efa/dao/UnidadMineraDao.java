package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.UnidadMinera;


public interface UnidadMineraDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveUnidadMinera(UnidadMinera unidadMinera); // create and update

	/*
	 * READ
	 */
	public List<UnidadMinera> listUnidadMineras();
	public List<UnidadMinera> listUnidadMineras_by_ID(BigDecimal id);
	public UnidadMinera getUnidadMinera(BigDecimal id);

	/*
	 * DELETE
	 */
	public void deleteUnidadMinera(BigDecimal id);
	public void deleteUnidadMineras_by_AdmID(BigDecimal id);
}
