package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.SupervisorEmergencia;


public interface SupervisorEmergenciaService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveSupervisorEmergencia(SupervisorEmergencia supervisorEmergencia, HttpSession session);

	/*
	 * READ
	 */
	public List<SupervisorEmergencia> listSupervisorEmergencia();
	public SupervisorEmergencia getSupervisorEmergencia(BigDecimal id);

	/*
	 * DELETE
	 */
	public void deleteSupervisorEmergencia(BigDecimal id, HttpSession session);

}
