package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.Efa;

public interface EfaDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveEfa(Efa efa); // create and update

	/*
	 * READ
	 */
	public List<Efa> listEfas();
	public Efa getEfa(BigDecimal id);
	public List<Efa> listEfas_by_NIVEL(String coddep, String codprov, String coddist, String nivel);
	public List<Efa> listEfas_by_NIVELDEP(String coddep, String nivel);
	/*
	 * DELETE
	 */
	public void deleteEfa(BigDecimal id);
}
