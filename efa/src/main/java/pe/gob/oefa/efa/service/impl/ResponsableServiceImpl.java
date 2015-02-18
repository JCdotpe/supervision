package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.ResponsableDao;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.ResponsableService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;

@Service
public class ResponsableServiceImpl implements ResponsableService {

	@Autowired
	private ResponsableDao responsableDao;
	@Autowired
	private EfaService efaService;
	@Autowired
	private AuditoriaService auditoriaService;

//	@Transactional
//	public void saveResponsable(Responsable responsable, BigDecimal efaId) {
//		Efa efa = efaService.getEfa(efaId);
//		responsable.setEfa(efa);		
//		responsableDao.saveResponsable(responsable);
//	}

	@Transactional
	public void saveResponsable2(Responsable responsable,HttpSession session) {	
		if(responsable.getTipo().equals("1"))
		responsableDao.setResponsable(responsable.getEfa().getId());	
			
		responsableDao.saveResponsable(responsable);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				responsable.getIdresponsable() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervicion_Efa_Responble, responsable.getIdresponsable() != null ? responsable.getIdresponsable().toString() : "");
	}	
	
	@Transactional(readOnly = true)
	public List<Responsable> listResponsables() {
		return responsableDao.listResponsables();
	}

	@Transactional(readOnly = true)
	public List<Responsable> listResponsables_by_ID(BigDecimal id,HttpSession session) {
		return responsableDao.listResponsables_by_ID(id);
	}	
	
	@Transactional(readOnly = true)
	public Responsable getResponsable(BigDecimal id,HttpSession session) {
		return responsableDao.getResponsable(id);
	}

	@Transactional
	public void deleteResponsable(BigDecimal id,HttpSession session) {
		responsableDao.deleteResponsable(id);
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervicion_Efa_Responble, id.toString());
	}

}
