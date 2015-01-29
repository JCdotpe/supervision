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
import pe.gob.oefa.efa.dao.AdministradoDao;
import pe.gob.oefa.efa.model.Actividad;
//import pe.gob.oefa.efa.model.ActividadResponsable;

import pe.gob.oefa.efa.model.Administrado;
import pe.gob.oefa.efa.service.ActividadService;
import pe.gob.oefa.efa.service.AdministradoService;


@Service
public class AdministradoServiceImpl implements AdministradoService {
	
	@Autowired
	private AdministradoDao administradodDao;
	
	@Transactional
	public void saveAdministrado(Administrado administrado) {
		administradodDao.saveAdministrado(administrado);;
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
	public void deleteAdministrado(BigDecimal id) {
		administradodDao.deleteAdministrado(id);;
	}
	
	
}
