package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.PadronDao;
import pe.gob.oefa.efa.model.Padron;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.PadronService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;

@Service
public class PadronServiceImpl implements PadronService {

	@Autowired
	private PadronDao padronDao;
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional
	public void savePadron(Padron padron, HttpSession session) {
		padronDao.savePadron(padron);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				padron.getNumdle() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervision_Efa_Padron, padron.getNumdle() != null ?  padron.getNumdle().toString() : "");
	}


}
