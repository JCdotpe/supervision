package pe.gob.oefa.efa.service.impl;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.gob.oefa.efa.dao.ResponsableDao;
import pe.gob.oefa.efa.model.Efa;
import pe.gob.oefa.efa.model.Responsable;
import pe.gob.oefa.efa.service.EfaService;
import pe.gob.oefa.efa.service.ResponsableService;

@Service
public class ResponsableServiceImpl implements ResponsableService {

	@Autowired
	private ResponsableDao responsableDao;
	@Autowired
	private EfaService efaService;

//	@Transactional
//	public void saveResponsable(Responsable responsable, BigDecimal efaId) {
//		Efa efa = efaService.getEfa(efaId);
//		responsable.setEfa(efa);		
//		responsableDao.saveResponsable(responsable);
//	}

	@Transactional
	public void saveResponsable2(Responsable responsable) {	
		if(responsable.getTipo().equals("1"))
		responsableDao.setResponsable(responsable.getEfa().getId());	
			
		responsableDao.saveResponsable(responsable);
	}	
	
	@Transactional(readOnly = true)
	public List<Responsable> listResponsables() {
		return responsableDao.listResponsables();
	}

	@Transactional(readOnly = true)
	public List<Responsable> listResponsables_by_ID(BigDecimal id) {
		return responsableDao.listResponsables_by_ID(id);
	}	
	
	@Transactional(readOnly = true)
	public Responsable getResponsable(BigDecimal id) {
		return responsableDao.getResponsable(id);
	}

	@Transactional
	public void deleteResponsable(BigDecimal id) {
		responsableDao.deleteResponsable(id);

	}

}
