package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.ActividadDao;
import pe.gob.oefa.efa.dao.EjecucionActividadDao;
import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;

import pe.gob.oefa.efa.model.EjecucionActividad;
import pe.gob.oefa.efa.service.EjecucionActividadService;

	@Service
	public class EjecucionActividadServiceImpl implements EjecucionActividadService {
		
		@Autowired
		private EjecucionActividadDao ejecucionActividadDao;
		
		@Transactional
		public void saveEjecucionActividad(EjecucionActividad ejecucionActividad) {
			ejecucionActividadDao.saveEjecucionActividad(ejecucionActividad);;
		}


		@Transactional(readOnly = true)
		public EjecucionActividad getEjecucionActividad(BigDecimal id) {
			return ejecucionActividadDao.getEjecucionActividad(id);
		}


		public EjecucionActividad getEjecucionActividad_BY(BigDecimal id) {
			return ejecucionActividadDao.getEjecucionActividad_BY(id);
		}
}
