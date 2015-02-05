package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.EfaDao;
import pe.gob.oefa.efa.dao.ResponsableDao;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.service.EfaService;

@Service
public class EfaServiceImpl implements EfaService {

	@Autowired
	private EfaDao efaDao;
	@Autowired
	private ResponsableDao responsableDao;
	
	@Transactional
	public void saveEfa(Efa efa) {
		efaDao.saveEfa(efa);
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
	public void deleteEfa(BigDecimal id) {
		//responsableDao.deleteResponsables_by_EFAID(id);
		efaDao.deleteEfa(id);
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
