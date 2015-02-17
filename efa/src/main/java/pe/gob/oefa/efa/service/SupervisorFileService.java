package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.SupervisorFile;


public interface SupervisorFileService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveSupervisorFile(SupervisorFile supervisorFile, HttpSession session);

	/*
	 * READ
	 */
	public List<SupervisorFile> listSupervisorFile();
	public SupervisorFile getSupervisorFile(BigDecimal id, HttpSession session);

	/*
	 * DELETE
	 */
	public void deleteSupervisorFile(BigDecimal id,HttpSession session);

}
