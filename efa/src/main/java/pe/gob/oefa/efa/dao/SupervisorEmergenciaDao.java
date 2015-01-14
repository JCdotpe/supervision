
package pe.gob.oefa.efa.dao;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.SupervisorEmergencia;


public interface SupervisorEmergenciaDao {

	/*
	 * CREATE and UPDATE
	 */
	public void saveSupervisorEmergencia(SupervisorEmergencia supervisorEmergencia); // create and update

	/*
	 * READ
	 */
	public List<SupervisorEmergencia> listSupervisorEmergencia();
	public SupervisorEmergencia getSupervisorEmergencia(BigDecimal id);

	/*
	 * DELETE
	 */
	public void deleteSupervisorEmergencia(BigDecimal id);
}
