package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;









import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;







import pe.gob.oefa.efa.dao.UnidadMineraDao;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.model.UnidadMinera;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.UnidadMineraService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;

@Service
public class UnidadMineraServiceImpl implements UnidadMineraService {

	@Autowired
	private UnidadMineraDao unidadMineraDao;
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional
	public void saveUnidadMinera(UnidadMinera unidadMinera, HttpSession session) {	
		unidadMineraDao.saveUnidadMinera(unidadMinera);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				unidadMinera.getIdunidadminera() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar, 
				ConstantAuditoria.Table_Supervision_TUnidadMinera, unidadMinera.getIdunidadminera() != null ? unidadMinera.getIdunidadminera().toString() : "");
	}	
	
	@Transactional(readOnly = true)
	public List<UnidadMinera> listUnidadMineras() {
		return unidadMineraDao.listUnidadMineras();
	}

	@Transactional(readOnly = true)
	public List<UnidadMinera> listUnidadMineras_by_ID(BigDecimal id) {
		return unidadMineraDao.listUnidadMineras_by_ID(id);
	}	
	
	@Transactional(readOnly = true)
	public UnidadMinera getUnidadMinera(BigDecimal id) {
		return unidadMineraDao.getUnidadMinera(id);
	}

	@Transactional
	public void deleteUnidadMinera(BigDecimal id, HttpSession session) {
		unidadMineraDao.deleteUnidadMinera(id);;

		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervision_TUnidadMinera, id.toString());
	}

	public void deleteUnidadMineras_by_AdmID(BigDecimal id, HttpSession session) {
		unidadMineraDao.deleteUnidadMineras_by_AdmID(id);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervision_TUnidadMinera, id.toString());
	}
	


}
