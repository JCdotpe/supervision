package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;

public interface SupervisorDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveSupervisor(Supervisor supervisor); // create and update

	/*
	 * READ
	 */
	public List<Supervisor> listSupervisores();
	public Supervisor getSupervisor(BigDecimal id);
	public List<SupervisorFile> listFiles_by_ID(BigDecimal id);
	public List<SupervisorEmergencia> listEmergencias_by_ID(BigDecimal id);
	/*
	 * DELETE
	 */
	public void deleteSupervisor(BigDecimal id);
}
