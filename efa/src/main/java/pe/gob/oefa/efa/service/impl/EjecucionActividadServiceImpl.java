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
import pe.gob.oefa.efa.dao.EjecucionActividadDao;
import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;

import pe.gob.oefa.efa.model.EjecucionActividad;
import pe.gob.oefa.efa.service.AuditoriaService;
import pe.gob.oefa.efa.service.EjecucionActividadService;
import pe.gob.oefa.efa.utils.ConstantAuditoria;

	@Service
	public class EjecucionActividadServiceImpl implements EjecucionActividadService {
		
		@Autowired
		private EjecucionActividadDao ejecucionActividadDao;
		@Autowired
		private AuditoriaService auditoriaService;
		
		@Transactional
		public void saveEjecucionActividad(EjecucionActividad ejecucionActividad,HttpSession session) {
			ejecucionActividadDao.saveEjecucionActividad(ejecucionActividad);
			
			auditoriaService.saveAuditoria(((pe.gob.oefa.efa.seguridad.Usuario)session.getAttribute("usuario")).getUsuario(), 
					ejecucionActividad.getIdejecucion() != null ? ConstantAuditoria.Acc_Modificar : ConstantAuditoria.Acc_Registrar,
							ConstantAuditoria.Table_Supervision_TEjecucion, ejecucionActividad.getIdejecucion() != null ? ejecucionActividad.getIdejecucion().toString() : "");
		}


		@Transactional(readOnly = true)
		public EjecucionActividad getEjecucionActividad(BigDecimal id) {
			return ejecucionActividadDao.getEjecucionActividad(id);
		}


		public EjecucionActividad getEjecucionActividad_BY(BigDecimal id) {
			return ejecucionActividadDao.getEjecucionActividad_BY(id);
		}
}
