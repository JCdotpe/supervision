package pe.gob.oefa.efa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.Supervisor;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.utils.LabelValue;


public interface SupervisorService {

	/*
	 * CREATE and UPDATE 
	 */
	public void saveSupervisor(Supervisor supervisor,HttpSession session);

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
	public void deleteSupervisor(BigDecimal id,HttpSession session);
	public Map<String, String> getDni(String dni);
	
	public List<Supervisor> getSupervisorByDNI(String dni);
	public void updateSupervisorDNI(Supervisor oSupervisor);
}
