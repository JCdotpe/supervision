package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;






import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.SupervisorFileDao;
import pe.gob.oefa.efa.model.SupervisorFile;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.SupervisorFileService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;

@Service
public class SupervisorFileServiceImpl implements SupervisorFileService {

	@Autowired
	private SupervisorFileDao supervisorFileDao;
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional
	public void saveSupervisorFile(SupervisorFile supervisorFile, HttpSession session) {
		supervisorFileDao.saveSupervisorFile(supervisorFile);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Registrar, ConstantAuditoria.Table_Supervicion_Efa_Supervisor_File, supervisorFile.getId() != null ? supervisorFile.getId().toString() : "");
	}

	@Transactional(readOnly = true)
	public List<SupervisorFile> listSupervisorFile() {
		return supervisorFileDao.listSupervisorFile();
	}

	@Transactional(readOnly = true)
	public SupervisorFile getSupervisorFile(BigDecimal id, HttpSession session) {
		return supervisorFileDao.getSupervisorFile(id);
	}


	@Transactional
	public void deleteSupervisorFile(BigDecimal id, HttpSession session) {
		supervisorFileDao.deleteSupervisorFile(id);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervicion_Efa_Supervisor_File, id.toString());
	}

}
