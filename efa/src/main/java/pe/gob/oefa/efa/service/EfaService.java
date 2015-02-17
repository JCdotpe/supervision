package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.Efa;


public interface EfaService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveEfa(Efa efa,HttpSession session);

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
	public void deleteEfa(BigDecimal id,HttpSession session);

}
