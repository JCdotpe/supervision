package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.EfaDao;
import pe.gob.oefa.efa.dao.ResponsableDao;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;

@Service
public class EfaServiceImpl implements EfaService {

	@Autowired
	private EfaDao efaDao;
	@Autowired
	private ResponsableDao responsableDao;
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional
	public void saveEfa(Efa efa, HttpSession session) {
		efaDao.saveEfa(efa);	
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				efa.getId() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervicion_Efa_Efa, efa.getId() != null ? efa.getId().toString() : "");
	}

	@Transactional(readOnly = true)
	public List<Efa> listEfas() {
		return efaDao.listEfas();
	}

	@Transactional(readOnly = true)
	public Efa getEfa(BigDecimal id) {
		return efaDao.getEfa(id);
	}

	@Transactional
	public void deleteEfa(BigDecimal id, HttpSession session) {
		//responsableDao.deleteResponsables_by_EFAID(id);
		efaDao.deleteEfa(id);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervicion_Efa_Efa, id.toString());
	}
	
	@Transactional
	public List<Efa> listEfas_by_NIVEL(String coddep, String codprov, String coddist, String nivel) {
		return efaDao.listEfas_by_NIVEL(coddep, codprov, coddist, nivel);
	}
	
	@Transactional
	public List<Efa> listEfas_by_NIVELDEP(String coddep, String nivel) {
		return efaDao.listEfas_by_NIVELDEP(coddep, nivel);
	}

}
