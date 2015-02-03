package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;







import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.EjecucionFileDao;
import pe.gob.oefa.efa.model.EjecucionFile;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.EjecucionFileService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;

@Service
public class EjecucionFileServiceImpl implements EjecucionFileService {
	
	@Autowired
	private EjecucionFileDao ejecucionFileDao;
	@Autowired
	private AuditoriaService auditoriaService;
	@Transactional
	public void saveEjecucionFile(EjecucionFile ejecucionFile, HttpSession session) {
		ejecucionFileDao.saveEjecucionFile(ejecucionFile);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ejecucionFile.getIdejecfile() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervision_TEjecucion_File, ejecucionFile.getIdejecfile() != null ? ejecucionFile.getIdejecfile().toString() : "");
	}

	@Transactional(readOnly = true)
	public List<EjecucionFile> listEjecucionFile() {
		return ejecucionFileDao.listEjecucionFile();
	}

	@Transactional(readOnly = true)
	public EjecucionFile getEjecucionFile(BigDecimal id) {
		return ejecucionFileDao.getEjecucionFile(id);
	}

	@Transactional
	public void deleteEjecucionFile(BigDecimal id, HttpSession session) {
		ejecucionFileDao.deleteEjecucionFile(id);;
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervision_TEjecucion_File, id.toString());
	}

}
