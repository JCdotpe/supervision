package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.SupervisorEmergenciaDao;
import pe.gob.oefa.efa.model.SupervisorEmergencia;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.SupervisorEmergenciaService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;

@Service
public class SupervisorEmergenciaServiceImpl implements SupervisorEmergenciaService {

	@Autowired
	private SupervisorEmergenciaDao supervisorEmergenciaDao;
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional
	public void saveSupervisorEmergencia(SupervisorEmergencia supervisorEmergencia, HttpSession session) {
		supervisorEmergenciaDao.saveSupervisorEmergencia(supervisorEmergencia);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Registrar,ConstantAuditoria.Table_Supervicion_Efa_Supervisor_Emergencia,"");
	}

	@Transactional(readOnly = true)
	public List<SupervisorEmergencia> listSupervisorEmergencia() {
		return supervisorEmergenciaDao.listSupervisorEmergencia();
	}

	@Transactional(readOnly = true)
	public SupervisorEmergencia getSupervisorEmergencia(BigDecimal id) {
		return supervisorEmergenciaDao.getSupervisorEmergencia(id);
	}


	@Transactional
	public void deleteSupervisorEmergencia(BigDecimal id, HttpSession session) {
		supervisorEmergenciaDao.deleteSupervisorEmergencia(id);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervicion_Efa_Supervisor_Emergencia, id.toString());
	}

}
