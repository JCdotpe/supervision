package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.EjecucionFile;

public interface EjecucionFileService {
	/*
	 * CREATE and UPDATE
	 */
	public void saveEjecucionFile(EjecucionFile ejecucionFile, HttpSession session); // create and update

	/*
	 * READ
	 */
	public List<EjecucionFile> listEjecucionFile();
	public EjecucionFile getEjecucionFile(BigDecimal id);

	/*
	 * DELETE
	 */
	public void deleteEjecucionFile(BigDecimal id, HttpSession session);
}
