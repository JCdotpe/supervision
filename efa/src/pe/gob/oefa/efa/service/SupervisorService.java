package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.utils.LabelValue;


public interface SupervisorService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveSupervisor(Supervisor supervisor);

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
	public Map<String, String> getDni(String dni);
}
