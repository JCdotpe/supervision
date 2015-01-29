package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.SupervisorFile;


public interface SupervisorFileDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveSupervisorFile(SupervisorFile supervisorFile); // create and update

	/*
	 * READ
	 */
	public List<SupervisorFile> listSupervisorFile();
	public SupervisorFile getSupervisorFile(BigDecimal id);

	/*
	 * DELETE
	 */
	public void deleteSupervisorFile(BigDecimal id);
}
