package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.List;

import pe.gob.oefa.efa.model.SupervisorEmergencia;


public interface SupervisorEmergenciaService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveSupervisorEmergencia(SupervisorEmergencia supervisorEmergencia);

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
