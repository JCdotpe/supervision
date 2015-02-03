package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.ActividadDao;
import pe.gob.oefa.efa.dao.AdministradoDao;
import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;

import pe.gob.oefa.efa.model.Administrado;
import pe.gob.oefa.efa.service.ActividadService;
import pe.gob.oefa.efa.service.AdministradoService;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;


@Service
public class AdministradoServiceImpl implements AdministradoService {
	
	@Autowired
	private AdministradoDao administradodDao;
	@Autowired
	private AuditoriaService auditoriaService;
	
	@Transactional
	public void saveAdministrado(Administrado administrado, HttpSession session) {
		administradodDao.saveAdministrado(administrado);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				administrado.getIdadministrados() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
						ConstantAuditoria.Table_Supervision_TAdministrados, administrado.getIdadministrados() != null ? administrado.getIdadministrados().toString() : "");
	}

	@Transactional(readOnly = true)
	public List<Administrado> listAdministrados() {
		return administradodDao.listAdministrados();
	}

	@Transactional(readOnly = true)
	public Administrado getAdministrado(BigDecimal id) {
		return administradodDao.getAdministrado(id);
	}
	
//	@Transactional(readOnly = true)
//	public List<ActividadResponsable> listActResponsables_by_ID(BigDecimal id) {
//		return actividadDao.listActResponsables_by_ID(id);
//	}	
	
	@Transactional
	public void deleteAdministrado(BigDecimal id, HttpSession session) {
		administradodDao.deleteAdministrado(id);
		
		auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
				ConstantAuditoria.Acc_Eliminar, ConstantAuditoria.Table_Supervision_TAdministrados, id.toString());
	}
	
	
}
